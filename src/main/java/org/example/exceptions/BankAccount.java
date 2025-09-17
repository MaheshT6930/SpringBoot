package org.example.exceptions;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(){
    }

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount >0){
            balance += amount;
            System.out.println("Deposited: Rs. " + amount);
            //return "Deposited: Rs. " + amount;

        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new InsufficientBalanceException("Entered amount is invalied");
            }
            else if ((balance - amount) < 1000) {
                throw new InsufficientBalanceException(
                        "Balance cannot go below Rs. 1000.");
            }
            else {
                balance -= amount;
                System.out.println("Withdrawn: Rs. " + amount);
            }
        } catch (InsufficientBalanceException e) {
            //System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void display() {
        System.out.println("---- Account Details ----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : Rs. " + balance);
        System.out.println("-------------------------");
    }



}
