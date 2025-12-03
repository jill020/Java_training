package com.bpi.hello;

import java.util.*;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System. in);
		
		System.out.print("Enter first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int num2 = scanner.nextInt();
        
        int sum = num1 + num2;
        int dif = num1 - num2;
        int prod = num1 * num2;
        
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + dif);
        System.out.println("Product: " + prod);

        scanner.close();
	}

}
