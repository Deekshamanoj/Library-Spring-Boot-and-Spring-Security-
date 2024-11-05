package com.tyss.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.Library.entity.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{

}
