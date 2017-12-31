package com.core.deadlock;

public class BankTransferReordered {
	
	 
    public static void main(String[] args) {
        final BankAccount accountA = new BankAccount(1, 100d);
        final BankAccount accountB = new BankAccount(2, 200);
         
        Thread t1 = new Thread("A") {
            public void run() {
                transfer(accountA, accountB, 10d);
            }
        };
         
        Thread t2=  new Thread("B") {
            public void run() {
                transfer(accountB, accountA, 20d);
            }
        };
        
        t1.start();
        t2.start();
         
    }
    
    static void transfer(final BankAccount from, final BankAccount to, double amount) {
    	/* Basic Idea of swapping is , Any two thread can come to this method first.
    	 * Whoever comes first will lock BOTH locks in same order of there ID, the second thread will come following
    	 * but he also will need to lock the accounts in SAME order of ID's so it won't be able to lock so 2nd thread 
    	 * will wait . Actually we don't even need swapping.  We actually need ORDERING . Swapping is done to achieve the sorting.
    	 * Any other field say Account name , or bank row number would have worked. Or we could have created a hash map / hashset and added all accounts 
    	 * in order they are created then use that sorted collection  to get the order.
    	 * 
    	 * Note : Order of Locking by swapping of accounts don't mean from and to account are getting swapped. 
    	 * They will always stay in same only locking order is changed which will be based on ID sorting.
    	 * As you can see references of from and to are never mutated/changed and are final ,only  firstById and secondById just keep shuffling there pointers.
    	 *  */
    	  BankAccount firstById = from;
          BankAccount secondById = to;
          if (firstById.compareTo(secondById) < 0) {
              // Swap them to order them by ID
        	  firstById = to;
        	  secondById = from;
          }
          System.out.println("Waiting Outside for Lock of BankAccount " +Thread.currentThread().getName());
          synchronized(firstById){
        	  
        	   System.out.println("I'm Inside  " +Thread.currentThread().getName());
        	   System.out.println("From account is of BankAccount #" +Thread.currentThread().getName());
        	   from.withdraw(amount);
               synchronized(secondById){
                    to.deposit(amount);
               }
          }
    }



    
    
    
}
