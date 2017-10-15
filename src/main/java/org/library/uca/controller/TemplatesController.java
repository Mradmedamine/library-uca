package org.library.uca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TemplatesController {

	@RequestMapping(path = "/templates", method = RequestMethod.GET)
	public String templatesList(Model model) {
		return "modules/templates/templates";
	}

}
