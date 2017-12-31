package com.core.deadlock;

public class BankTransferDeadLock {
	
	 
    public static void main(String[] args) {
        final BankAccount accountA = new BankAccount(1, 100d);
        final BankAccount accountB = new BankAccount(2, 200d);
        Thread t1 = new Thread() {
            public void run() {
                transfer(accountA, accountB, 10d);
            }
        };
         
        Thread t2=  new Thread() {
            public void run() {
                transfer(accountB, accountA, 20d);
            }
        };
        
        t1.start();
        t2.start();
        
       }
    
    static void transfer(BankAccount from, BankAccount to, double amount) {
        synchronized(from) {
            synchronized(to) {
            	 from.withdraw(amount);
                 to.deposit(amount);
            }
        }
        
        
       /*  Note : No deadlock will occur if we do this : ( Java concurrency in Practice Chapter 10 use this too !! forget it. My example is better and I don't wanna be a rocket scientist.
        *   synchronized(from) {
             synchronized(to) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }*/
    }
}
