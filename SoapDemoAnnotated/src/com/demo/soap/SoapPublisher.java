package com.demo.soap;

import javax.xml.ws.Endpoint;

public class SoapPublisher  {
	
	public static void main(String[] args) {
		Endpoint end = Endpoint.publish("http://localhost:9999/SoapDemoWSImpl/search", new SoapDemoWSImpl());
		// In browser point to  http://localhost:9999/SoapDemoWSImpl/search?wsdl
		
	}
	

}
