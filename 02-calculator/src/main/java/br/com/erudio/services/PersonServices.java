package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices 
{
	private final AtomicLong counter = new AtomicLong(0);
	
	public Person create(Person person) 
	{
		return person;
	}
	
	public Person update(Person person) 
	{
		return person;
	}
	
	public void delete(String id) 
	{
		//return 0;
	}
	
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
	
	public List<Person> findAll()
	{
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) 
		{
			Person person = mockPerson(i);
			
			persons.add(person);
		}
		
		return persons;
	}

	private Person mockPerson(int i) 
	{
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstName("Nome " + i);
		person.setLastName("SobreNome " + i);
		person.setAddress("Endereço " + i);
		person.setGender("Sexo " + i);
		
		return person;
	}
}
