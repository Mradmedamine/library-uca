package org.library.uca.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.library.uca.model.domain.entity.PhysicalFile;
import org.library.uca.model.domain.entity.Template;
import org.library.uca.repository.TemplateRepository;
import org.library.uca.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/templates")
public class TemplatesController {

	private static final Logger logger = LoggerFactory.getLogger(TemplatesController.class);

	@Autowired
	private TemplateRepository templateRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String templatesList(Model model) {
		model.addAttribute("templates", templateRepository.findAll());
		return "modules/templates/templates";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = { "multipart/mixed",
	        MediaType.MULTIPART_FORM_DATA_VALUE })
	public String saveTemplateDocument(@RequestParam("physicalFile") MultipartFile document, Model model) {
		Template template = new Template();
		template.setPhysicalFile(FileUtils.createPhysicalFile(document));
		templateRepository.save(template);
		return StringUtils.EMPTY;
	}

	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteTemplateDocument(@PathVariable Long id, Model model) {
		templateRepository.delete(id);
		return StringUtils.EMPTY;
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public void downloadTemplateDocument(@PathVariable Long id, HttpServletResponse response) {
		Template template = templateRepository.findOne(id);
		PhysicalFile physicalFile = template.getPhysicalFile();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + physicalFile.getFileName() + "\"");
		try {
			OutputStream os = response.getOutputStream();
			ByteArrayInputStream in = new ByteArrayInputStream(physicalFile.getFileContent());
			IOUtils.copy(in, os);
			response.flushBuffer();
		} catch (IOException e) {
			logger.error("error occured while downloading template document id {}. Ex : {}", id, e.getMessage());
		}
	}

}
