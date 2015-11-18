package com.mongo.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperty {

	String host;
	int port;
	String dbName;
	String dumpLocation;
	String mongoLocation;

	LoadProperty() {
		Properties prop = new Properties();
		InputStream inputStream = null;
		String propFileName = "config.properties";
		try {
			inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
			prop.load(inputStream);

			setHost(prop.getProperty("host"));
			setPort(Integer.parseInt(prop.getProperty("port")));
			setDbName(prop.getProperty("dbname"));
			setDumpLocation(prop.getProperty("dumplocation"));
			setMongoLocation(prop.getProperty("mongolocation"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDumpLocation() {
		return dumpLocation;
	}

	public void setDumpLocation(String dumpLocation) {
		this.dumpLocation = dumpLocation;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getMongoLocation() {
		return mongoLocation;
	}

	public void setMongoLocation(String mongoLocation) {
		this.mongoLocation = mongoLocation;
	}

	public static void main(String... strings) {
		LoadProperty loadProperty = new LoadProperty();
		System.out.println(loadProperty.getDbName());
	}
}
