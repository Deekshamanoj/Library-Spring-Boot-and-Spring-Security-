package com.tyss.Library.dao;

import java.util.List;

import com.tyss.Library.entity.Book;


public interface BookDao {

	Book saveBook(Book book);

	List<Book> getAllBooks();

	Book getBookById(int id);

	Book deleteBookById(int id);

	Book updateBookById(int id, Book book);

}
