package org.library.uca.controller;

import java.util.List;

import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;
import org.library.uca.model.domain.entity.File;
import org.library.uca.model.front.web.dto.FileDTO;
import org.library.uca.model.front.web.queryparams.FileQueryParams;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.library.uca.service.FileService;
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
public class FilesController {

	private static final Logger logger = LoggerFactory.getLogger(FilesController.class);

	@Autowired
	private FileService fileService;

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/files";
	}

	@RequestMapping(path = "/files", method = RequestMethod.GET)
	public String filesList(Model model) {
		return "modules/files/list";
	}

	@RequestMapping(path = "/files/search", method = RequestMethod.POST)
	public String searchFiles(Model model, @RequestBody FileQueryParams fileSearch) {
		logger.debug("searching for files with parameters {}", fileSearch.toString());
		List<File> foundFiles = fileService.findByCriteria(fileSearch);
		model.addAttribute("files", foundFiles);
		return "modules/files/dataTable::content";
	}

	@RequestMapping("/files/{id}")
	public String filePage(Model model, @PathVariable Long id) {
		model.addAttribute("file", fileService.findById(id));
		return "modules/files/form";
	}

	@RequestMapping("/files/new")
	public String newFile(Model model) {
		model.addAttribute("file", new File());
		return "modules/files/form";
	}

	@ResponseBody
	@RequestMapping(path = "/files", method = RequestMethod.POST)
	public Long saveFile(Model model, @RequestBody FileDTO file) {
		File savedFile = fileService.saveFile(file);
		return savedFile.getId();
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("fileStatusList", FileStatus.values());
		model.addAttribute("fileTypeList", FileType.values());
		model.addAttribute("ebookFileType", FileType.EBOOK);
		model.addAttribute("bookList", bookService.findAll());
		model.addAttribute("authorList", authorService.findAll());
	}
}
