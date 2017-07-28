package org.library.uca.service.impl;

import java.util.List;

import org.library.uca.domain.Record;
import org.library.uca.repository.RecordRepository;
import org.library.uca.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordRepository recordRepository;
	
	@Override
	public List<Record> getAllRecords() {
		return recordRepository.findAll();
	}

	@Override
	public Record findById(Long id) {
		return recordRepository.findOne(id);
	}


}
