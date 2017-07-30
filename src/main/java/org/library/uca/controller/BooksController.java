package org.library.uca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BooksController {

	@RequestMapping("/books")
	public String allRecords(Model model) {
		return "modules/books/list";
	}

}
