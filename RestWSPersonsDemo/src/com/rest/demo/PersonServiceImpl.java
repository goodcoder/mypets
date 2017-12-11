package com.rest.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.demo.model.Person;
import com.rest.demo.model.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class PersonServiceImpl implements PersonService {

	private static Map<Integer,Person> persons = new HashMap<Integer,Person>();
	
	 /* 
	  * URL : POST  http://localhost:8080/RestWSDemo/person/add
	   HTTP BODY :
	   <person>
	   <age>25</age>
		<id>1</id>
	    <name>First</name>
	   </person>
	  * */
	
	@Override
	@POST
    @Path("/add")       // Though /add was not needed but still I kept for clarity as POST tells its an insert
	public Response person(Person p) {
		Response response = new Response();
		if(persons.get(p.getId()) != null){
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	/*  
	 * http://localhost:8080/RestWSDemo/person/remove/1
	 * */
	@Override
	@DELETE 
    @Path("/remove/{id}")   // Though /remove was not needed but still I kept for clarity as DELETE tells its an delete
	public Response removePerson(@PathParam("id") int id) {
		Response response = new Response();
		if(persons.get(id) == null){
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}")  // GET  http://localhost:8080/RestWSDemo/person/1
	public Person person(@PathParam("id") int id) {
		return persons.get(id);
	}
	
	@GET
	@Path("/dummy/{id}")    // e.g GET  http://localhost:8080/RestWSDemo/person/dummy/5
	public Person dummyPerson(@PathParam("id") int id) {
		Person p = new Person();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/all")   //  GET  http://localhost:8080/RestWSDemo/person/all
	public Person[] allPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}