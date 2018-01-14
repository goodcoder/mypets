package com.core.simpledemo;

public class OrderPizza {
	
	public static void main(String[] args) {
		MyHouse home = new MyHouse();  // Shared Object
		
		Runnable owner = new Runnable(){    // Thread 1
			public void run(){
				home.eatPizza();
			}
			};
	
	
		Runnable pizzaGuy = new Runnable(){   // Thread 2
		public void run(){
			home.deliverPizza();
		}
		};
	
		new Thread(owner).start();
		new Thread(pizzaGuy).start();

	}
}
