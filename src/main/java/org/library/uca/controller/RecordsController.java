package org.library.uca.controller;

import java.util.List;

import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;
import org.library.uca.model.domain.entity.Record;
import org.library.uca.model.front.web.RecordDTO;
import org.library.uca.model.front.web.RecordSearch;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.library.uca.service.RecordService;
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
public class RecordsController {

	private static final Logger logger = LoggerFactory.getLogger(RecordsController.class);

	@Autowired
	private RecordService recordService;

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/records";
	}

	@RequestMapping(path = "/records", method = RequestMethod.GET)
	public String recordsList(Model model) {
		return "modules/records/list";
	}

	@RequestMapping(path = "/records/search", method = RequestMethod.POST)
	public String searchRecords(Model model, @RequestBody RecordSearch recordSearch) {
		logger.debug("searching for records with parameters {}", recordSearch.toString());
		List<Record> foundRecords = recordService.findByCriteria(recordSearch);
		model.addAttribute("records", foundRecords);
		return "modules/records/dataTable::content";
	}

	@RequestMapping("/records/{id}")
	public String recordPage(Model model, @PathVariable Long id) {
		model.addAttribute("record", recordService.findById(id));
		return "modules/records/form";
	}

	@RequestMapping("/records/new")
	public String newRecord(Model model) {
		model.addAttribute("record", new Record());
		return "modules/records/form";
	}

	@ResponseBody
	@RequestMapping(path = "/records", method = RequestMethod.POST)
	public String saveRecord(Model model, @RequestBody RecordDTO record) {
		recordService.saveRecord(record);
		return "";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("recordStatusList", RecordStatus.values());
		model.addAttribute("recordTypeList", RecordType.values());
		model.addAttribute("ebookRecordType", RecordType.EBOOK);
		model.addAttribute("bookList", bookService.getAllBooks());
		model.addAttribute("authorList", authorService.findAll());
	}
}
