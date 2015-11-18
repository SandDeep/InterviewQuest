package com.mongo.java;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class VerifySharding {

	public static void main(String[] args) throws UnknownHostException {
		// MongoClient client = new MongoClient("192.168.22.61", 27017);

		MongoClient client = new MongoClient();
		DB adminDb = client.getDB("admin");
		DB configDb = client.getDB("config");

		DBObject replSet = new BasicDBObject("replSetGetStatus", 1);
		CommandResult result = adminDb.command(replSet);
		// System.out.println(result);

		/*
		 * Object resultObject = adminDb.eval("db.printShardingStatus()", 1);
		 * System.out.println(resultObject);
		 */

		/* mongostat --> db.serverStatus() */
		DB testDb = client.getDB("test");
		CommandResult statResult = testDb.command(new BasicDBObject(
				"serverStatus", 1));
		// System.out.println(statResult);

		List<String> dbList = client.getDatabaseNames();
		Collections.sort(dbList);
		System.out.println(dbList);

		Object object = testDb.eval("sh.getBalancerState()");
		// Object object=testDb.eval("db.serverStatus()");
		// Object
		// object=testDb.eval("db.getSiblingDB('config').chunks.find({'ns' : 'test.images'})");
		System.out.println(object);
		// object=testDb.eval("sh.stopBalancer()");
		System.out.println(object);

		CommandResult cResult = testDb.command(BasicDBObjectBuilder.start()
				.add("$eval", "sh.getBalancerState()").get());
		System.out.println(cResult);

		CommandResult ShardDistribution = testDb
				.command(BasicDBObjectBuilder.start()
						.add("$eval", "db.images.getShardDistribution()").get());
		System.out.println("ShardDistribution : "+ShardDistribution);

		DBCursor cursor = configDb.getCollection("databases").find(
				new BasicDBObject("partitioned", true));
		while (cursor.hasNext()) {
			DBObject dbObject = (DBObject) cursor.next();
			System.out.println(dbObject);
		}
	}

}
