package org.library.uca.service;

import java.util.List;

import org.library.uca.domain.Record;
import org.library.uca.domain.metadata.RecordSearch;

public interface RecordService {

	List<Record> findAll();

	List<Record> findByCriteria(RecordSearch recordSearch);

	Record findById(Long id);

}
