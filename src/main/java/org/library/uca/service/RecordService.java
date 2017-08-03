package org.library.uca.service;

import java.util.List;

import org.library.uca.domain.RecordSearch;
import org.library.uca.domain.entity.Record;

public interface RecordService {

	List<Record> findAll();

	List<Record> findByCriteria(RecordSearch recordSearch);

	Record findById(Long id);

	Record saveRecord(Record record);

}
