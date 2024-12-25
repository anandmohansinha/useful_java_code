package org.java.example.synchronization;

public class BankAccount {
    private int balance;

    public BankAccount(int balance){
        this.balance = balance;
    }

    public synchronized void withdraw(String threadName, int amount) {
        System.out.println(threadName + " us withdrawing "+ amount);
        if(balance >= amount){
            System.out.println("processing withdrawing");
            balance = balance - amount;
        } else {
            System.out.println(threadName + " failed to withdraw. Insufficient balance.");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
