package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.Book;

public interface BookService {

	List<Book> findAll();

}
