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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value="Person Endpoint",description = "description for Person",tags = {"PersonEndPoint"})
@Api(tags = "PersonEndpoint")
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService services;
	
	@ApiOperation(value="find all the person")
	@GetMapping
	public List<Person> findPersons() {
		return services.findAllPersons();
	}
	
		
	@ApiOperation(value="find person based on his id")
	@GetMapping("/{id}")      
	public Person findId(@PathVariable("id") Long id) {
		return services.findByPersonId(id);
	}
	
	@ApiOperation(value="create new person")
	@PostMapping
	public Person create(@RequestBody Person person) {
		return services.createPerson(person);
	}
	
	@ApiOperation(value="update the person")
	@PutMapping
	public Person update(@RequestBody Person person) {
		return services.updatePerson(person);
	}
	
	@ApiOperation(value="delete the person based on his id")
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	   services.deletePerson(id);
	   return ResponseEntity.ok().build();
	}
	

}
