package org.library.uca.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.front.web.dto.BookDTO;
import org.library.uca.model.front.web.queryparams.BookQueryParams;
import org.library.uca.repository.BookEditionRepository;
import org.library.uca.repository.BookRepository;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.library.uca.util.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceBaseImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookEditionRepository bookEditionRepository;

	@Autowired
	private AuthorService authorService;

	@Override
	public List<BookDTO> findAll() {
		List<Book> booksEntity = bookRepository.findAll();
		return mapToBookDTOList(booksEntity);
	}

	@Override
	public BookDTO findById(Long id) {
		Book book = bookRepository.findOne(id);
		return mapToBookDTO(book);
	}

	@Override
	public List<BookEdition> findBookEditions(long bookId) {
		return bookEditionRepository.findByBook_Id(bookId);
	}

	@Override
	public List<BookDTO> findByCriteria(BookQueryParams bookQuery) {
		String titleText = buildQueryTextParam(bookQuery.getTitleText());
		String descriptionText = buildQueryTextParam(bookQuery.getDescriptionText());
		List<Book> booksEntity = bookRepository.findByCriteria(titleText, descriptionText);
		return mapToBookDTOList(booksEntity);
	}

	private List<BookDTO> mapToBookDTOList(List<Book> booksEntity) {
		List<BookDTO> books = new ArrayList<>(booksEntity.size());
		for (Book book : booksEntity) {
			BookDTO bookDetails = mapToBookDTO(book);
			books.add(bookDetails);
		}
		return books;
	}
	
	private BookDTO mapToBookDTO(Book bookEntity) {
		BookDTO book = MappingUtils.map(bookEntity, BookDTO.class);
		book.setChainedAuthorNames(authorService.getChainedAuthorNames(bookEntity.getAuthors()));
		return book;
	}
}
