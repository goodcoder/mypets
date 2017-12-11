package com.rest.demo;

import com.rest.demo.model.Person;
import com.rest.demo.model.Response;

public interface PersonService {

	public Response person(Person p);
	
	public Person person(int id);
	
	public Response removePerson(int id);
	
	public Person dummyPerson(int id);
	
	public Person[] allPersons();
	


}
