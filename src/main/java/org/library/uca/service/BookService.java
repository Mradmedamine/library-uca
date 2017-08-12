package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.front.web.dto.BookDetailsDTO;

public interface BookService {

	List<BookDetailsDTO> findAll();

	List<BookEdition> findBookEditions(long bookId);

	BookDetailsDTO findById(Long id);

}
