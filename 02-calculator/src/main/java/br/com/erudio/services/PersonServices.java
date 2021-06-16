package br.com.erudio.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices 
{
	private final AtomicLong counter = new AtomicLong(0);
	
	public Person findById(String id) 
	{
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Manoel");
		person.setLastName("Neto");
		person.setAddress("Rua Barão do Rio Branco, Itabuna, Bahia");
		person.setGender("Male");
		
		return person;
	}
}
