package com.core.deadlock;

/*Ref:  SOF[13326861] or TU[dead-or-lock]*/

public class BankAccount implements Comparable<BankAccount>{
    double balance;
    int id;
     
    BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
     
    void withdraw(double amount) {
        // Wait to simulate io like database access ...
        //try {Thread.sleep(10l);} catch (InterruptedException e) {}
        balance -= amount;
        System.out.println(" Withdraw :"+ amount+ " Balance :"+balance);
    }
     
    void deposit(double amount) {
        // Wait to simulate io like database access ...
       // try {Thread.sleep(110);} catch (InterruptedException e) {}
        balance += amount;
        System.out.println(" Deposit :"+ amount + " Balance :"+balance);
    }
    
    @Override
	public int compareTo(BankAccount account) {
		if(this.id > account.id) return 1;
		else if(this.id < account.id) return -1;
		else return 0;
	}

}