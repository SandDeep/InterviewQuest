package com.mongo.java.morphia;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

public class CustomerDAO extends BasicDAO<Customer, String> {

	protected CustomerDAO(MongoClient mongoClient, Morphia morphia,
			String dbName) {
		super(mongoClient, morphia, dbName);
	}

}
