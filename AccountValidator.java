package com.bpi.m4act5;

class InvalidAccountNumberException extends Exception {
	public InvalidAccountNumberException(String message) {
		super(message);
	}
}

class InvalidAccountFormatException extends RuntimeException {
	public InvalidAccountFormatException(String message) {
		super(message);
	}
}

public class AccountValidator {

	public static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
		if (accountNumber == null) {
			throw new NullPointerException("Account number cannot be null");
		}

		for (char c : accountNumber.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new InvalidAccountFormatException("Account number must contain only digits");
			}
		}

		if (accountNumber.length() != 10) {
			throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
		}

		System.out.println("Valid account number: " + accountNumber);
	}

	public static void testValidation(String testName, String accountNumber) {
		System.out.println(testName);
		try {
			validateAccountNumber(accountNumber);
		} catch (InvalidAccountNumberException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (InvalidAccountFormatException e) {
			System.out.println("Warning: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Warning: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		System.out.println("\n=== Account Number Validation Test ===");

		testValidation("\nTest 1: Valid account (1234567890)", "1234567890");
		testValidation("\nTest 2: Too short (123)", "123");
		testValidation("\nTest 3: Contains letters (12345ABC90)", "12345ABC90");
		testValidation("\nTest 4: Contains space (1234 567890)", "1234 567890");
		testValidation("\nTest 5: Null value", null);
	}
}
