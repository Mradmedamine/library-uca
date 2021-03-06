package org.library.uca.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.BookEdition;
import org.library.uca.model.front.web.dto.BaseBookDTO;
import org.library.uca.model.front.web.dto.BookDetailsDTO;
import org.library.uca.model.front.web.queryparams.BookQueryParams;
import org.library.uca.repository.BookEditionRepository;
import org.library.uca.repository.BookRepository;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.library.uca.util.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class BookServiceImpl extends ServiceBaseImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookEditionRepository bookEditionRepository;

	@Autowired
	private AuthorService authorService;

	@Override
	public List<BookDetailsDTO> findAll() {
		List<Book> booksEntity = bookRepository.findAll();
		return mapToBookDTOList(booksEntity);
	}

	@Override
	public BookDetailsDTO findById(Long id) {
		Book book = bookRepository.findOne(id);
		return mapToBookDTO(book);
	}

	@Override
	public List<BookEdition> findEditionsByBookId(Long bookId) {
		return bookEditionRepository.findByBook_Id(bookId);
	}

	@Override
	public List<BookDetailsDTO> findByCriteria(BookQueryParams bookQuery) {
		String titleText = buildQueryTextParam(bookQuery.getTitleText());
		String descriptionText = buildQueryTextParam(bookQuery.getDescriptionText());
		Set<Long> authorIds = bookQuery.getAuthorIds();
		List<Author> authors = null;
		if (!CollectionUtils.isEmpty(authorIds)) {
			authors = authorService.findByIds(authorIds);
		}
		List<Book> booksEntity = bookRepository.findByCriteria(titleText, descriptionText, authors);
		return mapToBookDTOList(booksEntity);
	}

	@Override
	public BookDetailsDTO saveBook(BaseBookDTO book) {
		Book entityBook = MappingUtils.map(book, Book.class);
		Set<Author> authors = new HashSet<>();
		for (Long authorId : book.getAuthorIds()) {
			Author author = new Author();
			author.setId(authorId);
			authors.add(author);
		}
		entityBook.setAuthors(authors);
		entityBook = bookRepository.save(entityBook);
		return MappingUtils.map(entityBook, BookDetailsDTO.class);
	}

	@Override
	public BookEdition saveBookEdition(Long bookId, BookEdition bookEdition) {
		Book book = bookRepository.findOne(bookId);
		bookEdition.setBook(book);
		return bookEditionRepository.save(bookEdition);
	}

	@Override
	public BookEdition findBookEditionById(Long id) {
		return bookEditionRepository.findOne(id);
	}

	private List<BookDetailsDTO> mapToBookDTOList(List<Book> booksEntity) {
		List<BookDetailsDTO> books = new ArrayList<>(booksEntity.size());
		for (Book book : booksEntity) {
			BookDetailsDTO bookDetails = mapToBookDTO(book);
			books.add(bookDetails);
		}
		return books;
	}

	private BookDetailsDTO mapToBookDTO(Book bookEntity) {
		BookDetailsDTO book = MappingUtils.map(bookEntity, BookDetailsDTO.class);
		book.setChainedAuthorNames(authorService.getChainedAuthorNames(bookEntity.getAuthors()));
		return book;
	}

}
