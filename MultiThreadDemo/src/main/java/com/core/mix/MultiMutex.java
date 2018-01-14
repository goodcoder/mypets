package com.core.mix;
public class MultiMutex {

	public static void main(String[] args) {
		SharedObject so = new SharedObject();

		Thread t1 = new Thread("A") {
			@Override
			public void run() {

				so.funA();
			}
		};

		Thread t2 = new Thread("B") {
			@Override
			public void run() {
				so.funB();
			}
		};

		t1.start();
		t2.start();
	}

}

class SharedObject {

	private Object mutex1 = new Object();
	private Object mutex2 = new Object();

	public void funA() {
		synchronized (mutex1) {   // But I  use synchronized (this) in both methods the funB will wait for funA to finish

			try {
				Thread.sleep(2000l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("In FunA");
		}
	}

	public void funB() {
		synchronized (mutex2) {
			System.out.println("In FunB");
		}
	}

}