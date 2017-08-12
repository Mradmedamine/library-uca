package org.library.uca.controller;

import org.library.uca.model.domain.BookSubject;
import org.library.uca.model.domain.BookType;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BooksController {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@RequestMapping("/books")
	public String allBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "modules/books/list";
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

//	@ResponseBody
//	@RequestMapping("/books/editions/{bookId}")
//	public List<BookEdition> getBookEditions(@PathVariable Long bookId, Model model) {
//		return bookService.findBookEditions(bookId);
//	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("bookTypes", BookType.values());
		model.addAttribute("bookSubjects", BookSubject.values());
		model.addAttribute("authorList", authorService.findAll());
	}
}
