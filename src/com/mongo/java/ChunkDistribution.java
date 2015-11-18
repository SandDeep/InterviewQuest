package com.mongo.java;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ChunkDistribution {

	public static Map<String, HashMap<String, Integer>> chunkInfoMap = new HashMap<String, HashMap<String, Integer>>();
	public static Map<String, HashMap<String, Integer>> shardInfoMap = new HashMap<String, HashMap<String, Integer>>();
	private static final long  MEGABYTE = 1024L * 1024L;

	public static void main(String[] args) throws UnknownHostException {

		// MongoClient client = new MongoClient(new ServerAddress("192.168.22.61",27017));
		MongoClient client = new MongoClient();
		
		/*DB db = client.getDB("config");
		DBCollection partitionedDB = db.getCollection("databases");
		DBCursor dbCursor = partitionedDB.find(new BasicDBObject("partitioned",true));

		 for (DBObject cursorObject : dbCursor) {
		 DB shardedDB = client.getDB((String) cursorObject.get("_id")); */
		
		// DB shardedDB = client.getDB("ibeat20140722");
		DB shardedDB = client.getDB("test");
		Set<String> collectionName = shardedDB.getCollectionNames();
		
		/*
		 * Iterating over DB collections , checking for partitioned collections
		 * and run analysis.
		 */
		for (String cName : collectionName) {
			DBCollection shardedCollections = shardedDB.getCollection(cName);
			CommandResult commandResult = shardedCollections.getStats();
			Boolean shardStatus = (Boolean) commandResult.get("sharded");
			
			if (shardStatus) {
				
				String nameSpace = (String) commandResult.get("ns");
				System.out.println(nameSpace);
				
				ChunkDistribution distribution = new ChunkDistribution();
				//distribution.allChunkInfo(client,nameSpace, "true");
				
				distribution.getShardDistribution(client,shardedDB, shardedCollections);
			}
		}

		/* } */

		System.out.println(chunkInfoMap);
	}

	/*
	 * estimate:true - if it is not used, the all the data will need to be
	 * examined, and that means pulling it into memory, which will be expensive.
	 */
	public void allChunkInfo(MongoClient client, String namespace, String estimate)
			throws UnknownHostException {

		/* some counters for overall stats at the end */
		int totalChunks = 0;
		int totalSize = 0;
		int totalEmpty = 0;

		DB configDb = client.getDB("config");
		DBCollection chunksCollection = configDb.getCollection("chunks");

		DBCursor cursor = chunksCollection.find(
				new BasicDBObject("ns", namespace)).sort(
				new BasicDBObject("min", 1));
		
		System.out.println("ChunkID , Shard , ChunkSize , ObjectsInChunk");
		for (DBObject chunk : cursor) {
			// System.out.println(chunk);
			String dbName = null;

			if (namespace.contains(".")) {
				dbName = namespace.split("\\.")[0];
			} else {
				throw new IllegalArgumentException("String " + namespace
						+ " does not contain .");
			}

			/* will need this for the dataSize call */

			DBObject keyDbObject = configDb.getCollection("collections")
					.findOne(new BasicDBObject("_id", namespace));
			
			DBObject key = (DBObject) keyDbObject.get("key");

			CommandResult dataSizeResult = client.getDB(dbName).command(
					new BasicDBObject("datasize", namespace)
							.append("keyPattern", key)
							.append("min", chunk.get("min"))
							.append("max", chunk.get("max"))
							.append("estimate", estimate));

			// System.out.println(dataSizeResult);
	
			System.out.println(chunk.get("_id") + " , " + chunk.get("shard")
					+ " , " + dataSizeResult.getDouble("size") + " , "
					+ dataSizeResult.getDouble("numObjects"));
			

			Double chunkSize = (Double) dataSizeResult.get("size");
			int dataSize = chunkSize.intValue();

			String chunkSizeString = String.valueOf(chunkSize);

			/* Verifying and Converting Hexa-Decimal to Byte. */
			if (chunkSizeString.contains("E")) {
				String[] splitArray = chunkSizeString.split("E");
				Double exapandedValue = Double.parseDouble(splitArray[0])
						* Integer.parseInt(splitArray[1]);
				dataSize = exapandedValue.intValue();
			}

			totalSize += dataSize;
			totalChunks++;

			/* count empty chunks for summary */
			if (dataSize == 0) {
				totalEmpty++;
			}
		}

		/*
		 * System.out.println("***********Summary Chunk Information***********");
		 * System.out.println("Total Chunks Size (bytes): " + totalSize);
		 * System.out.println("Total Chunks: " + totalChunks);
		 * System.out.println("Average Chunk Size (bytes): " + (totalSize /
		 * totalChunks)); System.out.println("Empty Chunks: " + totalEmpty);
		 * System.out.println("Average Chunk Size (non-empty): " + (totalSize /
		 * (totalChunks - totalEmpty)));
		 */

		HashMap<String, Integer> collectionMap = new HashMap<String, Integer>();
		collectionMap.put("TotalChunksSize", totalSize);
		collectionMap.put("TotalChunks", totalChunks);
		collectionMap.put("AvgChunksSize", (totalSize / totalChunks));
		collectionMap.put("EmptyChunksSize", totalEmpty);

		chunkInfoMap.put(namespace, collectionMap);
	}

	public void getShardDistribution(MongoClient client,DB shardedDB,
			DBCollection shardedCollections) throws UnknownHostException {

		int numChunks=0;
		CommandResult stats = shardedCollections.getStats();
		
		DB configDb = client.getDB("config");

		BasicDBObject shardlistObject = (BasicDBObject) stats.get("shards");
		Iterator<Entry<String, Object>> iterator=shardlistObject.entrySet().iterator();
		
		/* Shard Wise Distribution */
		while(iterator.hasNext()){
			int numShardChunks = 0;
			
			Entry<String, Object> pairs=iterator.next();
			String shardName=pairs.getKey();
			
			DBObject shardDoc=configDb.getCollection("shards").findOne(new BasicDBObject("_id",shardName));
			System.out.println( "\nShard " + shardName + " at " + shardDoc.get("host") );
			
			DBObject shardStats=(DBObject) shardlistObject.get(shardName);
			
			numShardChunks = (int)configDb.getCollection("chunks").count(
					new BasicDBObject("_id",new BasicDBObject("$regex", "test.images-_id")).append(
							"shard", shardName));
			numChunks +=numShardChunks;
			
			int estChunkData = (int) shardStats.get("size") / numShardChunks;
			Double estChunkCount = Math.floor((int) shardStats.get("count")/ numShardChunks );
			
			System.out.println( " data : " +  (int) shardStats.get("size")+
		              " docs : " + (int) shardStats.get("count") +
		              " chunks : " +  numShardChunks );
		    System.out.println( " estimated data per chunk : " +  estChunkData );
			System.out.println( " estimated docs per chunk : " + estChunkCount );
		}
		
		/* Total Shard Distribution Stats */
		System.out.println( "\nTotals" );
		System.out.println( " data : " + stats.getInt("size") +
		          " docs : " + stats.getInt("count") +
		          " chunks : " +  numChunks );
		
		shardlistObject = (BasicDBObject) stats.get("shards");
		iterator=shardlistObject.entrySet().iterator();
		
		while(iterator.hasNext()){
			Entry<String, Object> pairs=iterator.next();
			String shardName=pairs.getKey();
			
			DBObject shardStats=(DBObject) shardlistObject.get(shardName);
			
			double shardsize=(double) shardStats.get("size");
			double totalshardsize=(double) stats.getInt("size");
			Double estDataPercent = Math.floor( (shardsize)/totalshardsize *100  ) / 100;
			Double estDocPercent = Math.floor( (int)shardStats.get("count") / stats.getInt("count") * 10000 ) / 100;
			
			System.out.println(" Shard " + shardName + " contains "
					+ estDataPercent + "% data, " + estDocPercent
					+ "% docs in cluster, ");
		}
	}
	
	public static long bytesToMeg(long bytes) {
		  return bytes / MEGABYTE ;
		 }
}
