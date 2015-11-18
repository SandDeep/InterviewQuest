package com.mongo.java;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoCRUD {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB testDb = client.getDB("test");

		DBObject qdb = new BasicDBObject().append("timeStamp", "1405423800000")
				.append("articleId", "38369270").append("referer", "none")
				.append("host", "timesofindia.indiatimes.com");

		DBObject updateObj = new BasicDBObject("$set", new BasicDBObject("cat",
				"Sports")).append("$inc", new BasicDBObject("count", 1));

		testDb.requestStart();
		testDb.getCollection("dgrpCount").update(qdb, updateObj, true, false);
		testDb.requestDone();

	}

}
