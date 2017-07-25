package org.library.uca.controller;

import org.library.uca.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecordsController extends BaseController {

	@Autowired
	private RecordService recordService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("records", recordService.getAllRecords());
		return "modules/records";
	}

}
