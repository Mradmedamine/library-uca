package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.Record;
import org.library.uca.model.front.web.RecordDTO;
import org.library.uca.model.front.web.RecordSearch;

public interface RecordService {

	List<Record> findAll();

	List<Record> findByCriteria(RecordSearch recordSearch);

	Record findById(Long id);

	Record saveRecord(RecordDTO record);

}
