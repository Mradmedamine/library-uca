package org.library.uca.repository;

import java.util.List;

import org.library.uca.domain.Record;
import org.library.uca.domain.metadata.RecordStatus;
import org.library.uca.domain.metadata.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {

	List<Record> findByDescriptionContainingAndStatusInAndTypeIn(String description, List<RecordType> typeList,
			List<RecordStatus> statusList);

}
