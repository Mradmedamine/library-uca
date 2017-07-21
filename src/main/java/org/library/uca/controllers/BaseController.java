package org.library.uca.controllers;

import org.springframework.ui.Model;

public abstract class BaseController {

	protected static final String BASE_LAYOUT_VIEW = "base :: layout";
	
	//Temporary work around for layout 
	protected void addViewTemplate(Model model, String templateName) {
		model.addAttribute("viewName", templateName);
	}
   
}
