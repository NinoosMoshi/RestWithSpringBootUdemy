package com.ninos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninos.exception.ResourceNotFoundException;
import com.ninos.model.Person;
import com.ninos.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	// find all persons
	public List<Person> findAllPersons(){
		return repository.findAll();
	}
	
	// create or save person
	public Person createPerson(Person person) {
		 return repository.save(person);
	}
	
	// find by id of person
	public Person findByPersonId(Long id) {
		return repository.findById(id).orElseThrow(() ->
		            new ResourceNotFoundException("It is could not found this ID"));
	}
	
	
	// update a person
	public Person updatePerson(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow(() ->
                  new ResourceNotFoundException("It is could not found this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	
	
	// delete a person based on his Id
	public void deletePerson(Long id) {
		Person entity = repository.findById(id).orElseThrow(() ->
                 new ResourceNotFoundException("It is could not found this ID"));
		repository.delete(entity);
	}
	
	
	
	

}
