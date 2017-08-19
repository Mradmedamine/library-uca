package org.library.uca.controller;

import java.util.List;

import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.front.web.queryparams.AuthorQueryParams;
import org.library.uca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorsController {

	@Autowired
	private AuthorService authorService;

	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String authorsList(Model model) {
		return "modules/authors/list";		
	}
	
	@RequestMapping(path = "/authors/search", method = RequestMethod.POST)
	public String searchAuthors(Model model, @RequestBody AuthorQueryParams authorQueryParams) {
		List<Author> authors = authorService.findByCriteria(authorQueryParams);
		if (authors != null && authors.size() > 0) {
			model.addAttribute("authors", authors);
		}
		return "modules/authors/dataTable::content";
	}
	
	@RequestMapping(path="/authors/{id}", method = RequestMethod.GET)
	public String authorPage(Model model, @PathVariable Long id) {
		model.addAttribute("author", authorService.findById(id));
		return "modules/authors/form";
	}
	
	@RequestMapping(path="/authors/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Long deleteAuthor(Model model, @PathVariable Long id) {
		return authorService.delete(id);
	}
	
	@ResponseBody
	@RequestMapping(path = "/authors", method = RequestMethod.POST)
	public Long saveAuthor(Model model, @RequestBody Author author) {
		Author savedAuthor = authorService.saveAuthor(author);
		return savedAuthor.getId();
	}
	
	@RequestMapping("/authors/new")
	public String newAuthor(Model model) {
		model.addAttribute("author", new Author());
		return "modules/authors/form";
	}
}
