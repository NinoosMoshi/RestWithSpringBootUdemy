package com.ninos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninos.exception.ResourceNotFoundException;
import com.ninos.model.Book;
import com.ninos.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	// find all books
	public List<Book> findAllBooks(){
		return repository.findAll();
	}
	
	// create or save book
	public Book createBook(Book book) {
		 return repository.save(book);
	}
	
	// find by id of book
	public Book findByBookId(Long id) {
		return repository.findById(id).orElseThrow(() ->
		            new ResourceNotFoundException("It is could not found this ID"));
	}
	
	
	// update a book
	public Book updateBook(Book book) {
		Book entity = repository.findById(book.getId()).orElseThrow(() ->
                  new ResourceNotFoundException("It is could not found this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		return repository.save(entity);
	}
	
	
	
	// delete a book based on his Id
	public void deleteBook(Long id) {
		Book entity = repository.findById(id).orElseThrow(() ->
                 new ResourceNotFoundException("It is could not found this ID"));
		repository.delete(entity);
	}
	
	
	
	

}
