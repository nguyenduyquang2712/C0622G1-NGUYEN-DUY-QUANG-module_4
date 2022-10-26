package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IBookService {
  void save(Book book);
  Book findById(int id);
  List<Book> findAll();
}
