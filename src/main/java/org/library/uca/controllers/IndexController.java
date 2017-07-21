package org.library.uca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {

	@RequestMapping("/")
	String index(Model model) {
		addViewTemplate(model, "index");
		return BASE_LAYOUT_VIEW;
	}

}
