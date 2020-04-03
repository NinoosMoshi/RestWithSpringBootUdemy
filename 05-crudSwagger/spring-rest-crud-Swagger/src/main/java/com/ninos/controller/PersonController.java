package com.ninos.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
@RequestMapping("/api/person/v1")
public class PersonController {
	
	private PersonService services;
	
	
	@Autowired
	public PersonController(PersonService services) {
		this.services = services;
	}


	@GetMapping(produces = {"application/json","application/xml","application/x-yaml" })
	public List<Person> findPersons() {
		List<Person> personsAll = services.findAllPersons();
		personsAll.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findId(p.getId())).withSelfRel()));
		return personsAll;
		
		
	}
	
		
	@GetMapping(value="/{id}",produces = {"application/json","application/xml" ,"application/x-yaml"})      
	public Person findId(@PathVariable("id") Long id) {
		Person persons = services.findByPersonId(id);
		
		persons.add(linkTo(methodOn(PersonController.class).findId(id)).withSelfRel());
		return persons;
	}
	
	@PostMapping(produces = {"application/json","application/xml","application/x-yaml" },consumes = {"application/json","application/xml" ,"application/x-yaml"})
	public Person create(@RequestBody Person person) {
		Person persons = services.createPerson(person);
		persons.add(linkTo(methodOn(PersonController.class).findId(persons.getId())).withSelfRel());
		return persons;
	}
	
	
	@PutMapping(produces = {"application/json","application/xml","application/x-yaml" },consumes = {"application/json","application/xml" ,"application/x-yaml"})
	public Person update(@RequestBody Person person) {
		Person persons = services.updatePerson(person);
		persons.add(linkTo(methodOn(PersonController.class).findId(persons.getId())).withSelfRel());
		return persons;
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	   services.deletePerson(id);
	   return ResponseEntity.ok().build();
	}
	

}
