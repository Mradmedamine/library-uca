package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.front.web.BookDetails;

public interface BookService {

	List<BookDetails> getAllBooks();

	List<BookEdition> findBookEditions(long bookId);

	BookDetails findById(Long id);

}
