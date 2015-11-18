package com.mongo.java;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class FindOrphanImage {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient();
		DB testDb = client.getDB("test");
		testDb.requestStart();
		Set<Integer> albumImageList = new HashSet<Integer>();
		Set<Integer> totalImageList = new HashSet<Integer>();

		DBCollection albums = testDb.getCollection("albums");
		DBCollection images = testDb.getCollection("images");

		DBCursor albumCursor = albums.find();

		while (albumCursor.hasNext()) {
			DBObject albumObject = albumCursor.next();
			System.out.println("Album : " + albumObject);

			BasicDBList list = (BasicDBList) albumObject.get("images");
			for (Object object : list) {
				albumImageList.add((Integer) object);
			}
		}

		System.out.println("Total Album Images : " + albumImageList.size());

		DBCursor imageCursor = images.find();
		while (imageCursor.hasNext()) {
			DBObject imageObject = imageCursor.next();
			totalImageList.add((Integer) imageObject.get("_id"));
		}

		/* Final Orphan Images */
		for (Integer imageId : albumImageList) {
			totalImageList.remove(imageId);
		}

		System.out.println("Total Orphan Images : " + totalImageList.size());

		for (Integer imageId : totalImageList) {
			images.remove(new BasicDBObject("_id", imageId));
		}
	}

}
