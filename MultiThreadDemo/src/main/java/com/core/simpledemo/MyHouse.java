package com.core.simpledemo;

class MyHouse {
    private boolean pizzaArrived = false;

    public void eatPizza(){
        synchronized(this){
            while(!pizzaArrived){
                try {
                	System.out.println("waiting for pizza..");
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        System.out.println("yumyum..");
    }

    public void deliverPizza(){
        synchronized(this){
        	try {
        		System.out.println("Please wait..stuck in traffic");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             this.pizzaArrived = true;
             notifyAll();
        }
    }
}