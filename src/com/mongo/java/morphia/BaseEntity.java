package com.mongo.java.morphia;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * *JPA would use @Column to rename the attribute, Morphia uses @Property.
 * *Another difference is that @Property needs to be on the variable whereas @Column
 * can be on the variable or the get method.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public abstract class BaseEntity {

	@Id
	protected ObjectId id;

	@Property("version")
	private Long version;

	public BaseEntity() {
		super();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
