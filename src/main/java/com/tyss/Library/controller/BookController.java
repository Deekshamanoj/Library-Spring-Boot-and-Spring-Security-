package com.tyss.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.tyss.Library.dto.ResponseStructure;
import com.tyss.Library.entity.Book;
import com.tyss.Library.service.BookService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookService bookService;


	@PostMapping("/saveBook")
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/getBookById")
	public ResponseEntity<ResponseStructure<Book>> getBookById(@RequestParam int id) {
		return bookService.getBookById(id);
	}

	@DeleteMapping("/deleteBookById")
	public ResponseEntity<ResponseStructure<Book>> deleteBookById(@RequestParam int id) {
		return bookService.deleteBookById(id);
	}
	
	@PutMapping("/updateBookById")
	public ResponseEntity<ResponseStructure<Book>> updateBookById(@RequestParam int id , @RequestBody Book book) {
		return bookService.updateBookById(id, book);
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getToken(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
	}

}
