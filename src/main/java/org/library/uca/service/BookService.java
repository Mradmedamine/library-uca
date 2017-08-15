package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.front.web.dto.BaseBookDTO;
import org.library.uca.model.front.web.dto.BookDetailsDTO;
import org.library.uca.model.front.web.queryparams.BookQueryParams;

public interface BookService {

	List<BookDetailsDTO> findAll();

	List<BookEdition> findBookEditions(long bookId);

	BookDetailsDTO findById(Long id);

	List<BookDetailsDTO> findByCriteria(BookQueryParams bookQuery);

	BookDetailsDTO saveBook(BaseBookDTO book);
}
