package com.ninos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ninos.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	

}
