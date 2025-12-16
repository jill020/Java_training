package com.bpi.m3act1;

import java.util.ArrayList;
import java.util.Scanner;

public class productlist {
	public static void main(String[] args) {
		ArrayList<String> products = new ArrayList<>();
		products.add("Laptop");
		products.add("Mouse");
		products.add("Keyboard");
		products.add("Monitor");
		products.add("Printer");

		System.out.println("All products:");
		for (int i = 0; i < products.size(); i++) {
			System.out.println((i + 1) + ". " + products.get(i));
		}

		products.remove(2);
		products.add("Webcam");

		System.out.println("\nAfter adding and removing products:");
		for (int i = 0; i < products.size(); i++) {
			System.out.println((i + 1) + ". " + products.get(i));
		}

		System.out.println(products);

		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter product name to search: ");
		String search = sc.nextLine();

		boolean found = false;
		for (String p : products) {
			if (p.equalsIgnoreCase(search)) {
				found = true;
				break;
			}
		}

		if (found || products.contains(search)) {
			System.out.println("Product found: " + search);
		} else {
			System.out.println("Product not found.");
		}

		sc.close();
	}
}
