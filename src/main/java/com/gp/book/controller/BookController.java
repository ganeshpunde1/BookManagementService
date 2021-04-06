package com.gp.book.controller;

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

import com.gp.book.entity.Book;
import com.gp.book.exception.ResourceNotFoundException;
import com.gp.book.repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookRepository BookRepository;

	// get all Books
	@GetMapping
	public List<Book> getAllBooks() {
		return this.BookRepository.findAll();
	}

	// get Book by id
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable (value = "id") long BookId) {
		return this.BookRepository.findById(BookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + BookId));
	}

	// create Book
	@PostMapping
	public Book createBook(@RequestBody Book Book) {
		return this.BookRepository.save(Book);
	}
	
	// update Book
	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable ("id") long BookId) {
		 Book existingBook = this.BookRepository.findById(BookId)
			.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + BookId));
		 existingBook.setBookName(book.getBookName());
		 existingBook.setBookCd(book.getBookCd());
		 existingBook.setBookAuthor(book.getBookAuthor());
		 existingBook.setSubject(book.getSubject());
		 existingBook.setPrice(book.getPrice());
		 return this.BookRepository.save(existingBook);
	}
	
	// delete Book by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable ("id") long BookId){
		 Book existingBook = this.BookRepository.findById(BookId)
					.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + BookId));
		 this.BookRepository.delete(existingBook);
		 return ResponseEntity.ok().build();
	}
}
