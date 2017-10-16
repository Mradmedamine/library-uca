package org.library.uca.controller;

import org.apache.commons.lang3.StringUtils;
import org.library.uca.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TemplatesController {

	@Autowired 
	private TemplateRepository templateRepository;
	
	@RequestMapping(path = "/templates", method = RequestMethod.GET)
	public String templatesList(Model model) {
		model.addAttribute("templates", templateRepository.findAll());
		return "modules/templates/templates";
	}

	@ResponseBody
	@RequestMapping(path = "/templates", method = RequestMethod.POST, consumes = { "multipart/mixed",
	        MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveTemplateDocument(@RequestParam("physicalFile") MultipartFile document, Model model) {
		return StringUtils.EMPTY;
	}
	
}
