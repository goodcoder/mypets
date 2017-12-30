package com.core.producerconsumer;

public class Q {
		  int n;
		  boolean valueSet = false;

		  synchronized int get()  {
		    while(!valueSet)
		      try {
		    	System.out.println(" Pre Wait in get("+ n+")");
		        wait(); // Once control reaches here. Current consumer  thread loose monitor and producer thread will get it.
		        // Next control will go to next line where it left in put() i.e next line after wait()
		        System.out.println(" After1 Wait in get("+ n+")");
		        System.out.println(" After2 Wait in get("+ n+")");
		        System.out.println(" After3 Wait in get("+ n+")");
		      } catch(InterruptedException e) {
		        System.out.println("InterruptedException caught");
		      }

		      System.out.println("Got: " + n);
		      valueSet = false;
		      try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      notify();// Once Notifiy is executed , ccontrol is going back to while(!valueset) of same method! and the enters try loop again.
		      //Actually it make sense. We have notified other threads that this thread is done working, but didn't released it's lock!! 
		      //So need to call wait() i Think that's why get() is called again by same thread and then it encounters wait() in while loop 
		      // and then only releases the lock. Then I see that control go back to put(), coz now producer got the monitor.
		      //Note : Once consumer get monitor I see control first go back to where it left last time i.e line just AFTER wait() in put() 
		      //once all 3 sop and then again go back to start of while (naturally , its a loop...
		      // So point to remember, AFTER notify() a call to wait() is needed!! so Heading should be notify-wait mechanism not wait-notify !!
		      return n;
		  }

		  synchronized void put(int nt) {
		    while(valueSet)
		      try {
		    	  
		    	System.out.println(" Pre Wait in post("+ nt+")"); // Note:  Here SOP displays INCREMENTED value of n , which this method put JUST received from Producer as parameter
		    	//which is still NOT populated variable n of this instance! And after this wait() control will go to consumer , where it will consume previous value only.new value is still not populated in n. it will be when control reaches line 51      this.n = nt;
		        wait();
		        System.out.println(" After1 Wait in post("+ nt+")");  // not n!! new value is still not populated in n. it will be when control reaches line 51      this.n = nt;
		        System.out.println(" After2 Wait in post("+ nt+")");
		        System.out.println(" After3 Wait in post("+ nt+")");
		      } catch(InterruptedException e) {
		        System.out.println("InterruptedException caught");
		      }

		      this.n = nt;
		      valueSet = true;
		      System.out.println("Put: " + n);
		      try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      notify();// Once Notifiy is executed , control is going back to while(valueset) of same method! and the enters try loop again.
		      //Actually it make sense. We have notified other threads that this thread is done working, but didn't released it's lock!! 
		      //So need to call wait() ,i Think that's why put() is called again by same thread and then it encounters wait() in while loop 
		      // and then only releases the lock. Then I see that control go back to get(), coz now consumer got the monitor.
		      //Note : Once Producer get monitor I see control first go back to where it left last time i.e line just AFTER wait() in put() 
		      //once all 3 sop and then again go back to start of while (naturally , its a loop...
		      // So point to remember, AFTER notify() a call to wait() is needed!! so Heading should be notify-wait mechanism not wait-notify !!
		  }

}
