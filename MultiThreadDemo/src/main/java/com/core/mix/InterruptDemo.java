package com.core.mix;
//Ref : SOF 39683952
public class InterruptDemo {

	  public static void main(String[] args) {
		

	    
	RunningThread t = new RunningThread();
	t.start();
	try{
	Thread.sleep(1000l);
	}
	catch(Exception e){}
		   	t.stopThread();
	
	}
}
	 class RunningThread extends Thread {

	   private volatile boolean running = true;

	   public void run() {

	     while (running) {
	        try {
	        	  if (Thread.interrupted()){
	        		  return;
	        	  }
	           System.out.println("I am running!");
	        } catch (Exception e) {
	             if(!running){
	                break;
	             }
	        }
	     }
	   }

	   public void stopThread() {
	     // running = false;
	     interrupt();  
	     // Qn: Somehow just interrupt not working!!!! I think only Interruptable tasks stops . Seems SOP is not Interruptable! :)
	    // Solution:  Actually there should be a method in your run() which can understand and recognize and act on your interrupt!
	     // See Interrupts Sun Java docs . very clear. https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html
	     // i.e We should handle our own interrupts.
	     // That's why I added another code line if (Thread.interrupted()){return;} befor SOF coz I need to pool interrupt and act on it.
	   }

	}