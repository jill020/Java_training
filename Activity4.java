package com.bpi.hello;

import java.util.*;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int num1 = scanner.nextInt();
		
		if (num1 < 18) {
			System.out.println("Minor");
		} else if (num1 >= 18 && num1 <= 59) {
			System.out.println("Adult");
		} else {
			System.out.println("Senior");
		};
		
		scanner.close();
	}

}
