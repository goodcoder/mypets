package com.core.deadlock;
public class BankAccount {
    double balance;
    int id;
     
    BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
     
    void withdraw(double amount) {
        // Wait to simulate io like database access ...
        try {Thread.sleep(10l);} catch (InterruptedException e) {}
        balance -= amount;
        System.out.println(" Out :"+ amount+ " Balance :"+balance);
    }
     
    void deposit(double amount) {
        // Wait to simulate io like database access ...
        try {Thread.sleep(10l);} catch (InterruptedException e) {}
        balance += amount;
        System.out.println(" In :"+ amount + " Balance :"+balance);
    }
     
    static void transfer(BankAccount from, BankAccount to, double amount) {
        synchronized(from) {
            from.withdraw(amount);
            synchronized(to) {
                to.deposit(amount);
            }
        }
    }
     
    public static void main(String[] args) {
        final BankAccount fooAccount = new BankAccount(1, 100d);
        final BankAccount barAccount = new BankAccount(2, 100d);
         
        new Thread() {
            public void run() {
                BankAccount.transfer(fooAccount, barAccount, 10d);
            }
        }.start();
         
        new Thread() {
            public void run() {
                BankAccount.transfer(barAccount, fooAccount, 10d);
            }
        }.start();
         
    }
}