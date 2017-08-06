package org.library.uca.service.impl;

import java.util.List;

import org.library.uca.model.domain.entity.Book;
import org.library.uca.repository.BookRepository;
import org.library.uca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}


}
