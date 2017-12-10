package com.demo.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.demo.soap.SoapDemoWSendPointInterface")
public class SoapDemoWSImpl implements SoapDemoWSendPointInterface {
	
	@Override
	public void searchIt(String make, String model){
		
		System.out.println("Hello Shekhar : Make of car :"+make+ " and model is:"+ model);
	}

}
