package com.bpi.hello;

import java.util.*;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = scan.nextLine();

		System.out.println("Hello, " + name);

		scan.close();
	}

}
