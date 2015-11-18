package com.design.structural.proxy;

/**
 * Proxy pattern common uses are to control access or to provide a wrapper
 * implementation for better performance.Java RMI whole package uses proxy
 * pattern.
 * 
 * @author Deepesh
 * 
 */
public class ProxyPatternTest {

	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("root1",
				"/home/tilsuper");

		try {
			executor.runCommand("ls -ltr");
			executor.runCommand("rm -rf xyz.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
