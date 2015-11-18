package com.pkgS;

public class Test {

	static int t = 10;

	public static void main(String[] args) {
		String s = "Dolly";
		String t = s.concat("Hello");
		System.out.println(s);
		System.out.println(t);

		StringBuffer sb1 = new StringBuffer("Amit");
		StringBuffer sb2 = new StringBuffer("Amit");

		String ss1 = "Amit";

		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2));
		System.out.println(sb1.equals(ss1));
		System.out.println("Poddar".substring(3));

		String k = new String("Offset");
		k.trim();
		StringBuffer sb = new StringBuffer();
		sb.append("dec");
		sb.insert(1, k);

	}
}
