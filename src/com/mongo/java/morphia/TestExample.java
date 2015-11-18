package com.mongo.java.morphia;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

public class TestExample {

	public static void main(String[] args) throws UnknownHostException {
		String dbName = new String("bank");
		MongoClient mongo = new MongoClient();
		Morphia morphia = new Morphia();

		Datastore datastore = morphia.createDatastore(mongo, dbName);
		morphia.mapPackage("com.mongo.java.morphia");

		Address address = new Address();
		address.setNumber("81");
		address.setStreet("Mongo Street");
		address.setTown("City");
		address.setPostcode("CT81 1DB");

		Account account = new Account();
		account.setName("Personal Account");

		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);

		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setName("Mr Bank Customer");
		customer.setAccounts(accounts);

		Key<Customer> savedCustomer = datastore.save(customer);
		System.out.println(savedCustomer.getId());
		System.out.println(savedCustomer.getKind());

		/* Second Form */
		CustomerDAO customerDAO = new CustomerDAO(mongo, morphia, dbName);
		//customerDAO.save(customer);

		Query<Customer> query = datastore.createQuery(Customer.class);
		query.and(query.criteria("accounts.name").equal("Personal Account"),
				query.criteria("address.number").equal("81"),
				query.criteria("name").contains("Bank"));

		QueryResults<Customer> retreivedCustomers = customerDAO.find(query);

		for (Customer retreivedCustomer : retreivedCustomers) {
			System.out.println(retreivedCustomer.getName());
			System.out.println(retreivedCustomer.getAddress().getPostcode());
			System.out.println(retreivedCustomer.getAccounts().get(0).getName());
			//customerDAO.delete(retreivedCustomer);
		}

	}

}
