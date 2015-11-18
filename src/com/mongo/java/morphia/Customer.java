package com.mongo.java.morphia;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;

/**
 * If you want to store your class instance in Mongo via Morphia, the first
 * thing you need to do is annotate your class as an @Entity:
 * 
 * @author Deepesh.Maheshwari
 *
 */
/* @Entity */
public class Customer extends BaseEntity {

	private String name;
	
	private List<Account> accounts;
	
	@Embedded("address_embed")
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
