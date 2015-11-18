package com.mongo.java.morphia;

import org.mongodb.morphia.annotations.Embedded;

/**
 * The @Embeddable annotation allows to specify a class whose instances are
 * stored as intrinsic part of the owning entity.
 * 
 * @author Deepesh.Maheshwari
 *
 */

@Embedded()
public class Address {
	private String number;
	private String street;
	private String town;
	private String postcode;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
