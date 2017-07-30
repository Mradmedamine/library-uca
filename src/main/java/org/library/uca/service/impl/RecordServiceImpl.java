package org.library.uca.service.impl;

import java.util.Arrays;
import java.util.List;

import org.library.uca.domain.Record;
import org.library.uca.domain.metadata.RecordSearch;
import org.library.uca.domain.metadata.RecordStatus;
import org.library.uca.domain.metadata.RecordType;
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
		return recordRepository.findByDescriptionContainingAndStatusInAndTypeIn(descriptionText, typeList, statusList);
	}

}
