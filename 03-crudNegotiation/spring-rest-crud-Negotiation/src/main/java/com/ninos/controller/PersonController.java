package com.ninos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.Person;
import com.ninos.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@GetMapping(produces = {"application/json","application/xml" })
	public List<Person> findPersons() {
		return services.findAllPersons();
	}
	
		
	@GetMapping(value="/{id}",produces = {"application/json","application/xml" })      
	public Person findId(@PathVariable("id") Long id) {
		return services.findByPersonId(id);
	}
	
	@PostMapping(produces = {"application/json","application/xml" },consumes = {"application/json","application/xml" })
	public Person create(@RequestBody Person person) {
		return services.createPerson(person);
	}
	
	
	@PutMapping(produces = {"application/json","application/xml" },consumes = {"application/json","application/xml" })
	public Person update(@RequestBody Person person) {
		return services.updatePerson(person);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	   services.deletePerson(id);
	   return ResponseEntity.ok().build();
	}
	

}
