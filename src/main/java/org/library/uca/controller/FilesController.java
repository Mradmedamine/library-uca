package org.library.uca.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;
import org.library.uca.model.domain.entity.File;
import org.library.uca.model.domain.entity.FileAction;
import org.library.uca.model.domain.entity.PhysicalFile;
import org.library.uca.model.front.web.dto.FileActionDTO;
import org.library.uca.model.front.web.dto.FileDTO;
import org.library.uca.model.front.web.queryparams.FileQueryParams;
import org.library.uca.service.AuthorService;
import org.library.uca.service.BookService;
import org.library.uca.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FilesController {

	private static final Logger logger = LoggerFactory.getLogger(FilesController.class);

	@Autowired
	private FileService fileService;

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/files";
	}

	@RequestMapping(path = "/files", method = RequestMethod.GET)
	public String filesList(Model model) {
		return "modules/files/list";
	}

	@RequestMapping(path = "/files/search", method = RequestMethod.POST)
	public String searchFiles(Model model, @RequestBody FileQueryParams fileSearch) {
		logger.debug("searching for files with parameters {}", fileSearch.toString());
		List<File> foundFiles = fileService.findByCriteria(fileSearch);
		model.addAttribute("files", foundFiles);
		return "modules/files/dataTable::content";
	}

	@RequestMapping("/files/{id}")
	public String filePage(Model model, @PathVariable Long id) {
		model.addAttribute("file", fileService.findById(id));
		model.addAttribute("actions", fileService.findActionsByFileId(id));
		return "modules/files/form";
	}

	@RequestMapping("/files/new")
	public String newFile(Model model) {
		model.addAttribute("file", new File());
		return "modules/files/form";
	}

	@ResponseBody
	@RequestMapping(path = "/files", method = RequestMethod.POST)
	public Long saveFile(Model model, @RequestBody FileDTO file) {
		File savedFile = fileService.saveFile(file);
		return savedFile.getId();
	}

	@RequestMapping(path = "/files/actions/{actionId}", method = RequestMethod.GET)
	public String getFileActionModal(@PathVariable Long actionId, Model model) {
		FileAction fileAction = fileService.findFileActionById(actionId);
		model.addAttribute("action", fileAction);
		return "modules/files/actionModal::content";
	}

	@ResponseBody
	@RequestMapping(path = "/files/actions/{fileId}", method = RequestMethod.POST, consumes = { "multipart/mixed",
	        MediaType.MULTIPART_FORM_DATA_VALUE })
	public Long saveFileAction(@PathVariable Long fileId, @RequestPart("physicalFile") MultipartFile document,
	        @RequestPart FileActionDTO fileAction, Model model) {
		fileAction.setPhysicalFile(document);
		FileAction savedAction = fileService.saveFileAction(fileId, fileAction);
		return savedAction.getId();
	}

	@RequestMapping(path = "/files/actions/document/{actionId}", method = RequestMethod.GET)
	public void downloadActionDocument(@PathVariable Long actionId, HttpServletResponse response) {
		FileAction fileAction = fileService.findFileActionById(actionId);
		PhysicalFile physicalFile = fileAction.getPhysicalFile();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + physicalFile.getFileName() + "\"");
		try {
			OutputStream os = response.getOutputStream();
			ByteArrayInputStream in = new ByteArrayInputStream(physicalFile.getFileContent());
			IOUtils.copy(in, os);
		    response.flushBuffer();
		} catch (IOException e) {
			logger.error("error occured while downloading document actionId {}. Ex : {}", actionId, e.getMessage());
		}
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("fileStatusList", FileStatus.values());
		model.addAttribute("fileTypeList", FileType.values());
		model.addAttribute("ebookFileType", FileType.EBOOK);
		model.addAttribute("bookList", bookService.findAll());
		model.addAttribute("authorList", authorService.findAll());
	}
}
