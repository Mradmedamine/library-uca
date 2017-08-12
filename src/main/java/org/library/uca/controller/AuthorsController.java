package org.library.uca.controller;

import java.util.List;

import org.library.uca.model.domain.entity.Author;
import org.library.uca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorsController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String recordsList(Model model) {
		List<Author> authors = authorService.findAll();
		if (authors != null && authors.size() > 0) {
			model.addAttribute("authors", authors);
		}
		return "modules/authors/list";
	}
}
