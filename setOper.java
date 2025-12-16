package com.bpi.m3act2;

import java.util.HashSet;
import java.util.Scanner;

public class setOper {
	public static void main(String[] args) {
		HashSet<String> products = new HashSet<>();
		products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");

		Scanner sc = new Scanner(System.in);
		int choice = 0;

		while (choice != 4) {
			System.out.println("Select an option:");
			System.out.println("1. Search a product");
			System.out.println("2. Add a product");
			System.out.println("3. Print all products and count");
			System.out.println("4. Exit");
			System.out.print("> ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1: // Search
				System.out.print("Enter product name to search: ");
				String search = sc.nextLine();
				if (products.contains(search)) {
					System.out.println("Product found: " + search);
				} else {
					System.out.println("Product not found!");
				}
				break;

			case 2: // Add
				System.out.print("Enter product name to add: ");
				String addProduct = sc.nextLine();
				if (products.add(addProduct)) {
					System.out.println("Product added: " + addProduct);
				} else {
					System.out.println("Product already exists!");
				}
				break;

			case 3: // Print all
				System.out.println("\nAll products:");
				for (String p : products) {
					System.out.println(p);
				}
				System.out.println("Total unique products: " + products.size());
				break;

			case 4: // Exit
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
		sc.close();
	}
}
