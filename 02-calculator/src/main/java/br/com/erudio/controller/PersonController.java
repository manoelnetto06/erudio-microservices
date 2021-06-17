package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController 
{	
	public static final java.lang.String APPLICATION_JSON = "application/json";
	
	@Autowired 
	private PersonServices services;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Person findById(@PathVariable("id") String id)  
	{					
		return services.findById(id);
	}	
	
	@RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<Person> findAll()  
	{					
		return services.findAll();
	}	
	
	@RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Person create(@RequestBody Person person)  
	{					
		return services.create(person);
	}	
	
	@RequestMapping(method = RequestMethod.PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Person update(@RequestBody Person person)  
	{					
		return services.update(person);
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id)  
	{					
		services.delete(id);
	}	
	
	
}
