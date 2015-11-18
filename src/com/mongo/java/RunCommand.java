package com.mongo.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RunCommand {

	public static void main(String[] args) throws Exception {
		List<String> commands = new ArrayList<String>();
		ProcessBuilder processBuilder = null;
		String message = "Test Message";

		commands.add("CMD");
		commands.add("/C");
		commands.add("python yowsup-cli -c config.example -s 919810382858 "
				+ message);
		processBuilder = new ProcessBuilder(commands);
		processBuilder.directory(new File(
				"C:\\Users\\deepesh.maheswari\\yowsup-master\\src"));

		Process process = processBuilder.start();

		/* Read out dir output */
		InputStream inputStream = process.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;

		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		int exitValue = process.waitFor();
		System.out.println(exitValue);
	}
}
