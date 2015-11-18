package com.mongo.java;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class CreateData {
	/*private final Mongo mongo;
	private final Mongo mongo1;
	private DB db;*/

	public CreateData() {
/*		mongo = new Mongo("192.168.22.55");
		db = mongo.getDB("ibeatArticleDB");
		DBCollection artcileCount = db.getCollection("ArticleCount");*/
		/*
		 * "host" : { "$in" : [ "indiatimes.com" ,
		 * "timesofindia.indiatimes.com"]} , "publishTime" : { "$gt" :
		 * 1407090600000 , "$lte" : 1407393850636} , "count" : { "$gte" : 500}
		 */
		/*BasicDBObject bdb = new BasicDBObject("host", new BasicDBObject("$in",
				Arrays.asList("indiatimes.com", "timesofindia.indiatimes.com")))
				.append("publishTime",
						new BasicDBObject("$gt", 1407090600000l).append("$lte",
								1407393850636l)).append("count",
						new BasicDBObject("$gte", 500));
		DBCursor dbc = artcileCount.find(bdb);
		System.out.println(dbc.count());

		mongo1 = new Mongo();
		System.out.println(mongo1);*/

		/*db = mongo1.getDB("ibeatArticleDB");
		DBCollection artcileCount = db.getCollection("ArticleCount");
		
		DBObject match = null;
		DBObject group = null;
		DBObject fields = new BasicDBObject("count", 1);
		fields.put("articleId", 1);
		fields.put("host", 1);
		fields.put("_id", 0);
		DBObject project = new BasicDBObject("$project", fields);
		DBCollection articleCollHistory = db
				.getCollection(Config.ARTICLE_COUNT_COLLECTION);
		match = new BasicDBObject("$match", new BasicDBObject("host",
				new BasicDBObject("$in", Arrays.asList("indiatimes.com", "timesofindia.indiatimes.com"))).append(
				"publishTime",
				BasicDBObjectBuilder.start("$gt", 1407090600000l).add("$lte", 1407393850636l)
						.get()).append("count", new BasicDBObject("$gte",500)));
		//System.out.println(match);
		Map<String, Object> dbObjIdMap = new HashMap<String, Object>();
		dbObjIdMap.put("articleId", "$articleId");
		dbObjIdMap.put("host", "$host");

		DBObject groupFields = new BasicDBObject("_id", new BasicDBObject(
				dbObjIdMap));
		groupFields.put("count", new BasicDBObject("$first", "$count"));
		group = new BasicDBObject("$group", groupFields);

		AggregationOutput output = articleCollHistory.aggregate(match, project,
				group,sort ,limit );
		
		Map<String, List<String>> hostArticles = new LinkedHashMap<String, List<String>>();
		Iterable<DBObject> results = output.results();
		if (results != null) {
		//	List<String> articleIdList = new ArrayList<String>();
			Map<String, Long> dataMap = new LinkedHashMap<String, Long>();
			for (DBObject dbo : results) {
				System.out.println(dbo);
				DBObject id = (DBObject) dbo.get("_id");
				String articleId = (String) (id).get("articleId");
			//	articleIdList.add(articleId);
				String host = (String) (id).get("host");
				Long ct = ((Double) Double.parseDouble(dbo.get(
						"count").toString())).longValue();
				dataMap.put(host+articleId, ct);
				List<String> hostArtList = hostArticles.get(host);
				if(hostArtList != null){
					hostArtList.add(articleId);
				}else{
					hostArtList = new ArrayList<String>();
					hostArtList.add(articleId);
				}
				hostArticles.put(host, hostArtList);
			}
		}
		System.out.println(hostArticles);*/
		/*	artcileCount.insert(dbc.toArray());*/

	}

	public static void main(String[] args) throws UnknownHostException {
		new CreateData();
		
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("test");
		
		DBObject match = null;
		DBObject group = null;
		/*DBObject fields = new BasicDBObject("count", 1);
		fields.put("articleId", 1);
		fields.put("host", 1);
		fields.put("_id", 1);
		DBObject project = new BasicDBObject("$project", fields);*/
		
		DBObject unwind=new BasicDBObject("$unwind" , "$tags");
		
		DBCollection imageCollHistory = db.getCollection("images");
		
		match = new BasicDBObject("$match", new BasicDBObject("tags",
				new BasicDBObject("$in", Arrays.asList("vacation","travel","sunrises"))));
		
		//System.out.println(match);
		Map<String, Object> dbObjIdMap = new HashMap<String, Object>();
		dbObjIdMap.put("tags", "$tags");

		DBObject groupFields = new BasicDBObject("_id", new BasicDBObject(
				dbObjIdMap));
		groupFields.put("count", new BasicDBObject("$sum", 1));
		group = new BasicDBObject("$group", groupFields);

		AggregationOutput output = imageCollHistory.aggregate(unwind, match,
				group);
		
		Iterable<DBObject> results = output.results();
		
		if (results != null) {
			Map<String, Integer> dataMap = new LinkedHashMap<String, Integer>();
			for (DBObject dbo : results) {
				System.out.println(dbo);
				DBObject id = (DBObject) dbo.get("_id");
				String tagName = (String) (id).get("tags");
				int ct = (int) dbo.get("count");
				dataMap.put(tagName, ct);
			}
			System.out.println(dataMap);
		}
		
		
	}
}
