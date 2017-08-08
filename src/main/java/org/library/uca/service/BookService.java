package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.BookEdition;

public interface BookService {

	List<Book> findAll();

	List<BookEdition> findBookEditions(long bookId);

	Book findById(Long id);

}
