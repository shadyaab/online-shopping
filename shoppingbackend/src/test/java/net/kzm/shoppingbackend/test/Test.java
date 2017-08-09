package net.kzm.shoppingbackend.test;

import java.util.UUID;

public class Test {
	public static void main(String[] args) {
		int code= UUID.randomUUID().toString().toUpperCase().length();
		System.out.println(code);
	}
}
