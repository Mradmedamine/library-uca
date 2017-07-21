package org.library.uca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecordsController extends BaseController {

	@RequestMapping("/")
	public String index(Model model) {
		return "base :: records";
	}

}
