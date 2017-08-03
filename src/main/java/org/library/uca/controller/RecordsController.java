package org.library.uca.controller;

import java.util.List;

import org.library.uca.domain.RecordSearch;
import org.library.uca.domain.entity.Record;
import org.library.uca.domain.metadata.RecordStatus;
import org.library.uca.domain.metadata.RecordType;
import org.library.uca.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecordsController {

	private static final Logger logger = LoggerFactory.getLogger(RecordsController.class);

	@Autowired
	private RecordService recordService;

	@RequestMapping("/")
	public String index(Model model) {
		return "redirect:/records";
	}

	@RequestMapping(path = "/records", method = RequestMethod.GET)
	public String recordsList(Model model) {
		return "modules/records/list";
	}

	@RequestMapping(path = "/records/search", method = RequestMethod.POST)
	public String searchRecords(Model model, @RequestBody RecordSearch recordSearch) {
		logger.debug("searching for records with parameters {}", recordSearch.toString());
		List<Record> foundRecords = recordService.findByCriteria(recordSearch);
		model.addAttribute("records", foundRecords);
		return "modules/records/dataTable::content";
	}

	@RequestMapping("/records/{id}")
	public String recordPage(Model model, @PathVariable Long id) {
		model.addAttribute("record", recordService.findById(id));
		return "modules/records/form";
	}

	@ResponseBody
	@RequestMapping(path = "/records", method = RequestMethod.POST)
	public String saveRecord(Model model, @RequestBody Record record) {
		Long recordId = record.getId();
		if (recordId != null) {
			Record oldRecord = recordService.findById(recordId);
			oldRecord.setDescription(record.getDescription());
			oldRecord.setStatus(record.getStatus());
			oldRecord.setType(record.getType());
			recordService.saveRecord(oldRecord);
		} else {
			recordService.saveRecord(record);
		}
		return "";
	}

	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("recordStatusList", RecordStatus.values());
		model.addAttribute("recordTypeList", RecordType.values());
	}
}