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

import com.ninos.model.Book;
import com.ninos.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService services;
	
	@GetMapping
	public List<Book> findBooks() {
		return services.findAllBooks();
	}
	
		
	@GetMapping("/{id}")      
	public Book findId(@PathVariable("id") Long id) {
		return services.findByBookId(id);
	}
	
	@PostMapping
	public Book create(@RequestBody Book book) {
		return services.createBook(book);
	}
	
	
	@PutMapping
	public Book update(@RequestBody Book book) {
		return services.updateBook(book);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
	   services.deleteBook(id);
	   return ResponseEntity.ok().build();
	}
	

}
