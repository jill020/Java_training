package com.bpi.m4act1;

public class BankAccount {

    public static String getAccountName(String accountNumber) {
        if ("ACC-001".equals(accountNumber)) return "Juan Dela Cruz";
        if ("ACC-002".equals(accountNumber)) return "Maria Santos";
        return null; 
    }

    // Test case method
    public static void testCase(String accountNumber) {
        System.out.println("Looking up account: " + accountNumber);
        try {
            String name = getAccountName(accountNumber);
            String upperName = name.toUpperCase(); 
            System.out.println("Account holder: " + upperName);
        } catch (NullPointerException e) {
            System.out.println("Error: Account not found!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Bank Account Name Display ===\n");

        testCase("ACC-001"); // valid 
        testCase("ACC-999"); // invalid 

        System.out.println("\n=== Program completed successfully! ===");
    }
}
