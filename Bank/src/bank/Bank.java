/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank;

/**
 *
 * @author brent
 */
public class Bank {
    private String accountNumber;
    private double balance;

    // Constructor
    public Bank(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit funds
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw funds
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

