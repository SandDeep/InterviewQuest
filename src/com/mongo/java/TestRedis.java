package com.mongo.java;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost");
		System.out.println("Server Ping "+jedis.ping());
		
		jedis.set("name", "Redis Test");
		System.out.println(jedis.get("name"));
		
		jedis.close();
	}
}
