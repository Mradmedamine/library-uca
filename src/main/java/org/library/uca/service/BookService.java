package org.library.uca.service;


import java.util.List;

import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.front.web.dto.BookDTO;
import org.library.uca.model.front.web.queryparams.BookQueryParams;

public interface BookService {

	List<BookDTO> findAll();

	List<BookEdition> findBookEditions(long bookId);

	BookDTO findById(Long id);

	List<BookDTO> findByCriteria(BookQueryParams bookQuery);

}
