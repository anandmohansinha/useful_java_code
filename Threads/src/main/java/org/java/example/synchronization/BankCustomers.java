package org.java.example.synchronization;

public class BankCustomers {

    BankAccount account = new BankAccount(1000);
    public void customer1(int amount) {
        Thread cust1 = new Thread(() ->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.withdraw("customer1", amount);
        });
        cust1.start();
    }

    public void customer2(int amount) {
        Thread cust1 = new Thread(() ->{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.withdraw("customer2", amount);
        });
        cust1.start();
    }

    public static void main(String[] args) {
        BankCustomers bc = new BankCustomers();
        bc.customer1(700);
        bc.customer2(500);
        System.out.println(bc.account.getBalance());
    }
}
