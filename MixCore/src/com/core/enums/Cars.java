package com.core.enums;

public class Cars {

	public static void main(String[] args) {
		MyCars[] cars = MyCars.values();
		System.out.println(cars[0]);
		
		MyCars HONDA = MyCars.HONDA;
		HONDA.doSomeProcess();
	}

}

enum MyCars {
	HONDA("Civic"), TOYOTA("Corola");

	private final String model;

	private MyCars(String aModel) {
		model = aModel;
	}

	public String getModel() {
		return this.model;
	}
	
	public void doSomeProcess(){
		System.out.println("Do something else.... within ENUM like any regular business logic!!!");
	}

}
