package org.library.uca.controller;

import org.library.uca.domain.metadata.RecordSearch;
import org.library.uca.domain.metadata.RecordStatus;
import org.library.uca.domain.metadata.RecordType;
import org.library.uca.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecordsController {

	@Autowired
	private RecordService recordService;

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/records";
	}

	@RequestMapping(path = "/records", method = RequestMethod.GET)
	public String recordsList(Model model) {
		model.addAttribute("records", recordService.findAll());
		return "modules/records/list";
	}

	@RequestMapping(path = "/records", method = RequestMethod.POST)
	public String searchRecords(Model model, @RequestBody RecordSearch recordSearch) {
		return "modules/records/list";
	}
	
	@RequestMapping("/records/{id}")
	public String recordSummary(Model model, @PathVariable Long id) {
		model.addAttribute("record", recordService.findById(id));
		return "modules/records/summary";
	}

	@RequestMapping("/records/edit/{id}")
	public String editRecord(Model model, @PathVariable Long id) {
		model.addAttribute("record", recordService.findById(id));
		return "modules/records/form";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("recordStatusList", RecordStatus.values());
		model.addAttribute("recordTypeList", RecordType.values());
	}
}
