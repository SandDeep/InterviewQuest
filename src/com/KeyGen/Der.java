package com.KeyGen;

 class Base {

	public void x() {
		System.out.println("Base");
	}
}

 public class Der extends Base {
	public static void main(String[] args) {
		Base b = new Der();
		b.x();
		Der d = (Der) new Base();
		d.x();
	}
	
	public void x() {
		System.out.println("Derived");
	}
}