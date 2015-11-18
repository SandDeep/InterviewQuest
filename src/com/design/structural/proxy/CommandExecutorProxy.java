package com.design.structural.proxy;

/**
 * <b>Proxy Class</b>
 * <p>
 * Now we want to provide only admin users to have full access of above class,
 * if the user is not admin then only limited commands will be allowed. Here is
 * our very simple proxy class implementation.
 * 
 * @author Deepesh
 * 
 */
public class CommandExecutorProxy implements CommandExecutor {

	private CommandExecutor executor;
	boolean isAdmin;

	public CommandExecutorProxy(String user, String pwd) {
		if ("root".equals(user) && "/home/tilsuper".equals(pwd)) {
			isAdmin = true;
		}
		executor = new CommandExecutorImpl();
	}

	@Override
	public void runCommand(String cmd) throws Exception {
		if (isAdmin) {
			executor.runCommand(cmd);
		} else {
			if (cmd.trim().startsWith("rm")) {
				throw new Exception(
						"rm command is not allowed for nonadmin	users.");
			} else {
				executor.runCommand(cmd);
			}
		}
	}

}
