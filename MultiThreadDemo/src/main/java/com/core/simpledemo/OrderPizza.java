package com.core.simpledemo;

public class OrderPizza {
	
	public static void main(String[] args) {
		MyHouse home = new MyHouse();
		
		Runnable owner = new Runnable(){ 
			public void run(){
				home.eatPizza();
			}
			};
	
	
		Runnable pizzaGuy = new Runnable(){ 
		public void run(){
			home.deliverPizza();
		}
		};
	
		new Thread(owner).start();
		new Thread(pizzaGuy).start();

	}
}
