package com.core.producerconsumer;

public class ProducerConsumerRunner {
	
  public static void main(String args[]) {
    Q q = new Q();
    Producer p = new Producer(q);  // Note : Same instance of Q passed in both threads.
    Consumer c = new Consumer(q);

    // Start the threads.
    p.t.start();
    c.t.start();

    System.out.println("Press Control-C to stop.");
  }
}
