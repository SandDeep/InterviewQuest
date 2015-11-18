package com.mongo.java;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoUtils {

	private static MongoClient instance = null;
	private static LoadProperty prop=new LoadProperty();

	private MongoUtils() {
	}

	public static DBCollection getCollection(String host, String dbName,
			String collectionName) throws UnknownHostException {
		MongoClient client = new MongoClient(new ServerAddress(host, 27017));
		DB db = client.getDB(dbName);
		DBCollection collection = db.getCollection(collectionName);

		return collection;
	}

	public static DBCollection getCollection(String host, int port,
			String dbName, String collectionName) throws UnknownHostException {
		MongoClient client = new MongoClient(new ServerAddress(host, port));
		DB db = client.getDB(dbName);
		DBCollection collection = db.getCollection(collectionName);

		return collection;
	}

	public static DB getDB(String host, String dbName)
			throws UnknownHostException {
		MongoClient client = new MongoClient(new ServerAddress(host, 27017));
		DB db = client.getDB(dbName);

		return db;
	}

	/** You should have one MongoClient instance for the entire JVM. */
	public static MongoClient getInstance() throws UnknownHostException {
		if(instance ==null){
			instance = new MongoClient(new ServerAddress(prop.getHost(),
					prop.getPort()));
		}
		return instance;
	}

}
