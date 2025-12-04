package com.bpi.hello;

import java.util.*;


public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System. in);

		System.out.print("Enter your age: ");
		String ageStr = scan.nextLine();
		int ageInt = Integer.parseInt(ageStr);
		double ageDouble = (double) ageInt;

		System.out.println("Your age as int: " + ageInt);
		System.out.println("Your age as double: " + ageDouble);
		
		scan.close();
	}

}
