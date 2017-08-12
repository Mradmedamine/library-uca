package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.Record;
import org.library.uca.model.front.web.dto.RecordDTO;
import org.library.uca.model.front.web.queryparams.RecordQueryParams;

public interface RecordService {

	List<Record> findAll();

	List<Record> findByCriteria(RecordQueryParams recordSearch);

	Record findById(Long id);

	Record saveRecord(RecordDTO record);

}
