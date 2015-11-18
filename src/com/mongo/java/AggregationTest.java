package com.mongo.java;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class AggregationTest {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB testDb = client.getDB("test");
		DBCollection collection = testDb.getCollection("images");

		for (int i = 100000; i < 150000; i++) {
			collection.insert(new BasicDBObject("_id", i)
					.append("height", (int) (Math.random() * 500))
					.append("width", (int) (Math.random() * 800))
					.append("tags", Arrays.asList("dogs", "work", "vacation")));
		}
		// List<DBObject> pipeline=new ArrayList<DBObject>();
		// DBObject unwind=new BasicDBObject("$unwind","$tags");
		// AggregationOutput output=collection.aggregate(pipeline);
	}

}
