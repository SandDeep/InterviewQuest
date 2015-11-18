package com.mongo.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.jpountz.xxhash.StreamingXXHash64;
import net.jpountz.xxhash.XXHashFactory;

public class TestHash {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("37260271");
		list.add("Budget 2015");
		list.add("-2128958273");
		list.add("37260320");

		TestHash test = new TestHash();
		Long xxHash = test.getxxHash(list);
		System.out.println("xxHash Value : " + xxHash);
	}

	private Long getxxHash(List<String> list) {
		XXHashFactory factory = XXHashFactory.fastestJavaInstance();
		Long hash = 0L;
		try {
			byte[] data = list.toString().getBytes("UTF-8");
			ByteArrayInputStream in = new ByteArrayInputStream(data);

			int seed = 0x9747b28c;
			StreamingXXHash64 hash64=factory.newStreamingHash64(seed);

			byte[] buf = new byte[1024]; // for real-world usage, use a larger buffer, like 8192 bytes
			for (;;) {
				int read = in.read(buf);
				if (read == -1) {
					break;
				}
				hash64.update(buf, 0, read);
			}
			hash = hash64.getValue();

			System.out.println(hash);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hash;
	}
}
