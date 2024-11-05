package com.tyss.Library.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tyss.Library.dto.ResponseStructure;
import com.tyss.Library.entity.Book;

public interface BookService {

	ResponseEntity<ResponseStructure<Book>> saveBook(Book book);

	ResponseEntity<ResponseStructure<List<Book>>> getAllBooks();

	ResponseEntity<ResponseStructure<Book>> getBookById(int id);

	ResponseEntity<ResponseStructure<Book>> deleteBookById(int id);

	ResponseEntity<ResponseStructure<Book>> updateBookById(int id, Book book);


}
