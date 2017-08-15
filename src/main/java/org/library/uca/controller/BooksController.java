package org.library.uca.controller;

import java.util.List;

import org.library.uca.model.domain.BookSubject;
import org.library.uca.model.domain.BookType;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.front.web.dto.BaseBookDTO;
import org.library.uca.model.front.web.dto.BookDetailsDTO;
import org.library.uca.model.front.web.queryparams.BookQueryParams;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BooksController {

	private static final Logger logger = LoggerFactory.getLogger(BooksController.class);

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@RequestMapping("/books")
	public String listBooks(Model model) {
		return "modules/books/list";
	}

	@RequestMapping(path = "/books/search", method = RequestMethod.POST)
	public String searchBookss(Model model, @RequestBody BookQueryParams bookQuery) {
		logger.debug("searching for books with parameters {}", bookQuery.toString());
		List<BookDetailsDTO> foundBooks = bookService.findByCriteria(bookQuery);
		model.addAttribute("books", foundBooks);
		return "modules/books/dataTable::content";
	}

	@RequestMapping("/books/{id}")
	public String findBook(Model model, @PathVariable Long id) {
		model.addAttribute("book", bookService.findById(id));
		model.addAttribute("editions", bookService.findBookEditions(id));
		return "modules/books/form";
	}

	@RequestMapping("/books/new")
	public String newBook(Model model) {
		model.addAttribute("book", new Book());
		return "modules/books/form";
	}

	@ResponseBody
	@RequestMapping(path = "/books", method = RequestMethod.POST)
	public String saveBook(Model model, @RequestBody BaseBookDTO book) {
		bookService.saveBook(book);
		return "";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("bookTypes", BookType.values());
		model.addAttribute("bookSubjects", BookSubject.values());
		model.addAttribute("authorList", authorService.findAll());
	}
}
