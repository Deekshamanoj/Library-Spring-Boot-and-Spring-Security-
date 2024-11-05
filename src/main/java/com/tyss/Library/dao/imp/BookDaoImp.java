package com.tyss.Library.dao.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.Library.dao.BookDao;
import com.tyss.Library.entity.Book;
import com.tyss.Library.exception.BookNotFoundException;
import com.tyss.Library.repository.BookRepository;

@Repository
public class BookDaoImp implements BookDao {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(int id) {
		Optional<Book> op = bookRepository.findById(id);
		if (op.isPresent())
			return op.get();
		else
			throw new BookNotFoundException("Book with the given ID not found");
	}

	@Override
	public Book deleteBookById(int id) {
		Book book = getBookById(id);
		if (book != null)
			bookRepository.delete(book);
		else
			throw new BookNotFoundException("Book with the given ID Not found");
		return book;
	}

	@Override
	public Book updateBookById(int id, Book book) {
		Book bookRetrived = getBookById(id);
		if (bookRetrived != null) {
			book.setId(bookRetrived.getId());
			bookRepository.save(book);
		} else
			throw new BookNotFoundException("Book with the given ID Not found");
		return book;
	}

}
