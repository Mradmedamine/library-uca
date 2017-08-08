package org.library.uca.controller;

import org.library.uca.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorsController {

	private static final Logger logger = LoggerFactory.getLogger(AuthorsController.class);

	@Autowired
	private AuthorService authorService;

	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String recordsList(Model model) {
		return "modules/authors/list";
	}
}
