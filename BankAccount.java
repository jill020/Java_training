package com.bpi.m4act8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class InvalidAmountException extends Exception {
    private static final long serialVersionUID = 1L;
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    private static final long serialVersionUID = 1L;
    private final double balance;
    private final double requestedAmount;

    public InsufficientFundsException(String message, double balance, double requestedAmount) {
        super(message + " | Balance: ₱" + balance + ", Requested: ₱" + requestedAmount);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }

    public double getBalance() { return balance; }
    public double getRequestedAmount() { return requestedAmount; }
}

@FunctionalInterface
interface BankTestOperation {
    void execute() throws InvalidAmountException, InsufficientFundsException;
}

public class BankAccount {
    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);
    private double balance = 10000.0; // Initial balance ₱10,000

    public double getBalance() { return balance; }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        logger.info("Withdrawal requested: ₱{}", amount);

        if (amount < 0) {
            logger.error("Invalid withdrawal amount: ₱{}", amount);
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            logger.warn("Insufficient funds: ₱{} available, Requested: ₱{}", balance, amount);
            throw new InsufficientFundsException("Insufficient funds for withdrawal", balance, amount);
        }

        balance -= amount;
        logger.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    public void deposit(double amount) throws InvalidAmountException {
        logger.info("Deposit requested: ₱{}", amount);

        if (amount <= 0) {
            logger.error("Invalid deposit amount: ₱{}", amount);
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        if (amount > 50000) {
            logger.warn("Large deposit detected: ₱{} - requires verification", amount);
        }

        balance += amount;
        logger.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    public static void runTest(BankTestOperation operation, String operationName) {
        try {
            operation.execute();
            logger.info("{} succeeded.", operationName);
        } catch (InvalidAmountException e) {
            logger.error("{} failed: {}", operationName, e.getMessage(), e);
        } catch (InsufficientFundsException e) {
            logger.error("{} failed: {}", operationName, e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        logger.info("Starting BankAccount test sequence...");
        BankAccount account = new BankAccount();

        runTest(() -> account.deposit(5000), "Deposit");
        runTest(() -> account.withdraw(3000), "Withdrawal");
        runTest(() -> account.deposit(-500), "Deposit");
        runTest(() -> account.withdraw(20000), "Withdrawal");
        runTest(() -> account.deposit(60000), "Deposit");

        logger.info("Final balance: ₱{}", account.getBalance());
    }
}
