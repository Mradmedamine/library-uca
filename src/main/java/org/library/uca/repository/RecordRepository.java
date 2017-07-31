package org.library.uca.repository;

import java.util.List;

import org.library.uca.domain.entity.Record;
import org.library.uca.domain.metadata.RecordStatus;
import org.library.uca.domain.metadata.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

	List<Record> findByDescriptionContainingIgnoreCaseAndStatusInAndTypeIn(String description, List<RecordStatus> statusList,
			List<RecordType> typeList);

}
