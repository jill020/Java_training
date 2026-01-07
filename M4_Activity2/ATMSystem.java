package com.bpi.m4act2;

public class ATMSystem {

    static double[] accounts = {10000, 15000, 20000};

    public static void processWithdrawal(String accountIndex, String amountInput) {
        try {
            int index = Integer.parseInt(accountIndex); 
            double balance = accounts[index];           
            double amount = Double.parseDouble(amountInput);

            System.out.printf("Account=%s, Amount=%s%n", accountIndex, amountInput);
            System.out.printf("Current balance: ₱%.2f%n", balance);
            System.out.printf("Withdrawal: ₱%.2f%n", amount);

            if (amount > balance) {
                System.out.printf("Insufficient funds! Cannot withdraw ₱%.2f%n", amount);
            } else {
                accounts[index] = balance - amount;
                System.out.printf("New balance: ₱%.2f%n", accounts[index]);
                System.out.println("Withdrawal successful!");
            }
        } catch (NumberFormatException e) {
            System.out.printf("Account=%s, Amount=%s%n", accountIndex, amountInput);
            System.out.println("Error: Invalid input!");
            System.out.println("Please enter valid numbers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Account=%s, Amount=%s%n", accountIndex, amountInput);
            System.out.println("Error: Account not found!");
            System.out.println("Invalid account index.");
        } catch (Exception e) {
            System.out.printf("Account=%s, Amount=%s%n", accountIndex, amountInput);
            System.out.println("Transaction failed!");
        }
    }

    public static void main(String[] args) {
        System.out.println("\n=== ATM Withdrawal System ===");

        System.out.println("\n--- Test 1: Valid Withdrawal ---");
        processWithdrawal("1", "5000");

        System.out.println("\n--- Test 2: Invalid Account Index ---");
        processWithdrawal("abc", "5000");

        System.out.println("\n--- Test 3: Account Not Found ---");
        processWithdrawal("10", "5000");

        System.out.println("\n--- Test 4: Insufficient Funds ---");
        processWithdrawal("1", "20000");

        System.out.println("\n=== All tests completed! ===");
    }
}


