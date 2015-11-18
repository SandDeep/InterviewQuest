package com.design.structural.adapter;

/**
 * Class Adapter Implementation : This form uses java inheritance and extends
 * the source interface, in our case Socket class
 * 
 * @author Deepesh
 * 
 */
public class SocketObjectAdapterImpl implements SocketAdapter {

	Socket socket=new Socket();
	
	@Override
	public Volt get120Volt() {
		return socket.getVolts();
	}

	@Override
	public Volt get12Volt() {
		Volt volt=socket.getVolts();
		return convertVolt(volt,10);
	}

	@Override
	public Volt get3Volt() {
		Volt volt=socket.getVolts();
		return convertVolt(volt, 30);
	}

	private Volt convertVolt(Volt volt, int i) {
		volt.setVolts(volt.getVolts() / i);
		return volt;
	}
}
