package com.tyss.Library.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.Library.dao.BookDao;
import com.tyss.Library.dto.ResponseStructure;
import com.tyss.Library.entity.Book;
import com.tyss.Library.service.BookService;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookDao bookDao ;

	@Override
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bookDao.saveBook(book));
		responseStructure.setMessage(HttpStatus.CREATED.toString());
		return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.CREATED) ;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
		ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bookDao.getAllBooks());
		responseStructure.setMessage(" All Book Retrieved Successfully");
		return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Book>> getBookById(int id) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bookDao.getBookById(id));
		responseStructure.setMessage("Book Retrieved Successfully");
		return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<ResponseStructure<Book>> deleteBookById(int id) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bookDao.deleteBookById(id));
		responseStructure.setMessage("Book Deleted Successfully");
		return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<ResponseStructure<Book>> updateBookById(int id, Book book) {
		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bookDao.updateBookById(id, book));
		responseStructure.setMessage("Book Updated Successfully");
		return new ResponseEntity<ResponseStructure<Book>>(responseStructure,HttpStatus.OK) ;
	}

}
