package org.library.uca.service.impl;

import java.util.Arrays;
import java.util.List;

import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;
import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.Book;
import org.library.uca.model.domain.entity.Record;
import org.library.uca.model.front.web.RecordDTO;
import org.library.uca.model.front.web.RecordSearch;
import org.library.uca.repository.RecordRepository;
import org.library.uca.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;

	@Override
	public List<Record> findAll() {
		return recordRepository.findAll();
	}

	@Override
	public Record findById(Long id) {
		return recordRepository.findOne(id);
	}

	@Override
	public Record saveRecord(RecordDTO record) {
		Record entityRecord = null;
		Long recordId = record.getId();
		if (recordId != null) {
			entityRecord = findById(recordId);
		} else {
			entityRecord = new Record();
		}
		entityRecord.setDescription(record.getDescription());
		entityRecord.setStatus(record.getStatus());
		entityRecord.setType(record.getType());
		record.setReference("any reference");
		// Book
		if(record.getBookId() != null) {
			Book entityBook = new Book();
			entityBook.setId(record.getBookId());
			entityRecord.setBook(entityBook);
		}
		// Responsible
		Author responsible = new Author();
		responsible.setId(record.getResponsibleId());
		entityRecord.setResponsible(responsible);
		return recordRepository.save(entityRecord);
	}

	@Override
	public List<Record> findByCriteria(RecordSearch recordSearch) {

		String descriptionText = recordSearch.getDescriptionText();
		if (StringUtils.isEmpty(descriptionText)) {
			descriptionText = "%";
		} else {
			descriptionText = "%" + descriptionText + "%";
		}

		List<RecordType> typeList = recordSearch.getTypes();
		if (CollectionUtils.isEmpty(typeList)) {
			typeList = Arrays.asList(RecordType.values());
		}

		List<RecordStatus> statusList = recordSearch.getStatus();
		if (CollectionUtils.isEmpty(statusList)) {
			statusList = Arrays.asList(RecordStatus.values());
		}
		return recordRepository.findByDescriptionContainingIgnoreCaseAndStatusInAndTypeIn(descriptionText, statusList,
				typeList);
	}

}
