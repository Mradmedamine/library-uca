package org.library.uca.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.front.web.BookDetails;
import org.library.uca.repository.BookEditionRepository;
import org.library.uca.repository.BookRepository;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.library.uca.util.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookEditionRepository bookEditionRepository;

	@Autowired
	private AuthorService authorService;

	@Override
	public List<BookDetails> getAllBooks() {
		List<Book> booksEntity = bookRepository.findAll();
		List<BookDetails> books = new ArrayList<>(booksEntity.size());
		for (Book book : booksEntity) {
			BookDetails bookDetails = mapToBookDetails(book);
			books.add(bookDetails);
		}
		return books;
	}

	@Override
	public BookDetails findById(Long id) {
		Book book =  bookRepository.findOne(id);
		return mapToBookDetails(book);
	}

	@Override
	public List<BookEdition> findBookEditions(long bookId) {
		return bookEditionRepository.findByBook_Id(bookId);
	}

	private BookDetails mapToBookDetails(Book book) {
		BookDetails bookDetails = MappingUtils.map(book, BookDetails.class);
		bookDetails.setChainedAuthorNames(authorService.getChainedAuthorNames(book.getAuthors()));
		return bookDetails;
	}
}
