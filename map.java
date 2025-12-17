package com.bpi.m3act3;

import java.util.*;

public class map {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> products = new LinkedHashMap<>();
		products.put("Laptop", 50000);
		products.put("Monitor", 7000);
		products.put("Mouse", 500);
		products.put("Keyboard", 1000);
		products.put("Printer", 6000);

		int choice;
		do {
			System.out.println("\nSelect an option:");
			System.out.println("1. Search a product");
			System.out.println("2. Add a product");
			System.out.println("3. Print all products and prices");
			System.out.println("4. Find the cheapest product");
			System.out.println("5. Exit");
			System.out.print("> ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1: // Search
				System.out.print("Enter product name to search: ");
				String searchName = sc.nextLine();
				if (products.containsKey(searchName)) {
					System.out.println("Product found! Price: " + products.get(searchName));
				} else {
					System.out.println("Product not found!");
				}
				break;

			case 2:// Add
				System.out.print("Enter product name to add: ");
				String newProduct = sc.nextLine();
				System.out.print("Enter price: ");
				int price = sc.nextInt();
				sc.nextLine(); // consume newline
				products.put(newProduct, price);
				System.out.println("Product added: " + newProduct);
				break;

			case 3:// Print all
				System.out.println("\nAll products and prices:");
				List<Map.Entry<String, Integer>> productList = new ArrayList<>(products.entrySet());
				Collections.sort(productList, new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						return e2.getValue().compareTo(e1.getValue()); // descending
					}
				});

				for (Map.Entry<String, Integer> entry : productList) {
					System.out.println(entry.getKey() + " - " + entry.getValue());
				}

				System.out.println("Total products: " + products.size());
				break;

			case 4: // Find
				String cheapestProduct = null;
				int cheapestPrice = Integer.MAX_VALUE;
				for (Map.Entry<String, Integer> entry : products.entrySet()) {
					if (entry.getValue() < cheapestPrice) {
						cheapestPrice = entry.getValue();
						cheapestProduct = entry.getKey();
					}
				}
				System.out.println("Cheapest product: " + cheapestProduct + " - " + cheapestPrice);
				break;

			case 5:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid option! Please try again.");
			}
		} while (choice != 5);

		sc.close();
	}
}
