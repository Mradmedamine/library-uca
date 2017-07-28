package org.library.uca.controller;

import org.library.uca.domain.RecordStatus;
import org.library.uca.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecordsController {

	@Autowired
	private RecordService recordService;

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/records";
	}

	@RequestMapping("/records")
	public String allRecords(Model model) {
		model.addAttribute("records", recordService.getAllRecords());
		return "modules/records/list";
	}

	@RequestMapping("/records/{id}")
	public String recordView(Model model, @PathVariable Long id) {
		model.addAttribute("record", recordService.findById(id));
		return "modules/records/summary";
	}

	@RequestMapping("/records/edit/{id}")
	public String editRecord(Model model, @PathVariable Long id) {
		model.addAttribute("record", recordService.findById(id));
		model.addAttribute("recordStatusList", RecordStatus.values());
		return "modules/records/form";
	}

}
