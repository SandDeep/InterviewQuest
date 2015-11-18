package com.mongo.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class DataArchive {

	public static MongoClient client = null;
	public static String OS = System.getProperty("os.name").toLowerCase();
	public static LoadProperty load = new LoadProperty();
	private static final Log log = LogFactory.getLog(DataArchive.class);

	public static void main(String[] args) {
		DataArchive archive = new DataArchive();
		
		try {
			client = MongoUtils.getInstance();

			archive.stopBalancer();
			archive.mongodump(load.getDbName());
			archive.dropDatabase(load.getDbName());
			archive.startBalancer();
			
		}catch (Exception e) {
			log.error(e.getMessage());
			archive.startBalancer();
		}
	}

	/* Stop Balancer and Verify */
	public void stopBalancer() {
		DB configDb = client.getDB("config");
		DBCollection settings = configDb.getCollection("settings");

		BasicDBObject query = new BasicDBObject("_id", "balancer");
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject(
				"stopped", true));

		/* stop the balancer */
		settings.update(query, update, true, false);

		/* wait for in-progress migrations to finish,this may take a few seconds */
		DBCollection locks = configDb.getCollection("locks");
		while (locks.find(new BasicDBObject("_id", "balancer").append("state",
				new BasicDBObject("$ne", 0))) == null) {
			try {
				Thread.sleep(1000);
				log.info("waiting to stop balancer...");
			} catch (InterruptedException e) {
				log.error(e.getMessage());
			}
		}

		log.info("Balancer Status : " + getBalancerState());

	}

	/**
	 * mongodump can read data from either mongod or mongos instances, in
	 * addition to reading directly from MongoDB data files without an active
	 * mongod.
	 * 
	 * @param dbName
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void mongodump(String dbName) throws IOException,
			InterruptedException {

		List<String> commands = new ArrayList<String>();
		ProcessBuilder processBuilder=null;

		if (DataArchive.isWindows()) {
			commands.add("CMD");
			commands.add("/C");
			commands.add("mongodump --db "+dbName+" --out " + load.dumpLocation);
			processBuilder = new ProcessBuilder(commands);
			processBuilder.directory(new File(load.getMongoLocation()));
		} else if (DataArchive.isUnix()) {
			commands.add("mongodump --db "+dbName+" --out " + load.dumpLocation);
			processBuilder = new ProcessBuilder(commands);
			processBuilder.directory(new File(load.getMongoLocation()));
		}

		Process process = processBuilder.start();

		/* Read out dir output */
		InputStream inputStream = process.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;

		while ((line = bufferedReader.readLine()) != null) {
			log.debug(line);
		}

		int exitValue = process.waitFor();
		log.info("\nExit Value is " + exitValue);

	}

	/* Delete Data */
	public void dropDatabase(String dbName) {
		DB db = client.getDB(dbName);
		db.requestStart();
		try {
			db.requestEnsureConnection();
			db.setWriteConcern(WriteConcern.ACKNOWLEDGED);
			db.dropDatabase();
			/*CommandResult result = db.getLastError();
			if (result.getBoolean("err") && result.getDouble("ok") != 1.0) {
				dropDatabase(dbName);
			} else {
				System.out.println("Database Dropped without errors.");
			}
			System.out.println(result);*/
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			db.requestDone();
		}
	}

	/* Balancer Start and Verify */
	public void startBalancer() {

		DB configDb = client.getDB("config");
		DBCollection settings = configDb.getCollection("settings");

		BasicDBObject query = new BasicDBObject("_id", "balancer");
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject(
				"stopped", false));

		/* start the balancer */
		settings.update(query, update, true, false);

		/* wait for balancer to start,this may take a few seconds */
		while (!getBalancerState()) {
			try {
				Thread.sleep(1000);
				settings.update(query, update, true, false);
				log.info("waiting to start balancer...");
			} catch (InterruptedException e) {
				log.error(e.getMessage());
			}
		}

		log.info("Balancer Status : " + getBalancerState());

	}

	/**
	 * sh.getBalancerState() returns true when the balancer is enabled and false
	 * if the balancer is disabled. This does not reflect the current state of
	 * balancing operations
	 * 
	 * @return true/false
	 */
	public boolean getBalancerState() {

		DB configDb = client.getDB("config");
		DBCollection settings = configDb.getCollection("settings");
		BasicDBObject state = (BasicDBObject) settings
				.findOne(new BasicDBObject("_id", "balancer"));

		if (state == null) {
			return true;
		} else {
			return !state.getBoolean("stopped");
		}
	}

	/**
	 * Returns true if the balancer process is currently running and migrating
	 * chunks and false if the balancer process is not running.
	 * 
	 * @return true/false
	 */
	public boolean isBalancerRunning() {
		DB configDb = client.getDB("config");
		DBCollection settings = configDb.getCollection("settings");
		BasicDBObject balancer = (BasicDBObject) settings
				.findOne(new BasicDBObject("_id", "balancer"));

		if (balancer == null) {
			log.info("config.locks collection empty or missing. Be sure you are connected to a mongos");
			return false;
		}
		return balancer.getInt("state") > 0;
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS
				.indexOf("aix") > 0);
	}

	public static boolean isSolaris() {
		return (OS.indexOf("sunos") >= 0);
	}
	
	/*
	 * 1. To flush writes to disk and to “lock” the database (to prevent
	 * further writes), issue the db.fsyncLock() method in the mongo
	 * shell.The database cannot be locked with db.fsyncLock() while
	 * profiling is enabled. You must disable profiling before locking the
	 * database with db.fsyncLock().
	 */
	
	/*
	 * 2. To unlock the database after the snapshot has completed, use the
	 * following command in the mongo shell
	 */
}
