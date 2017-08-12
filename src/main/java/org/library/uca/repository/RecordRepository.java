package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;
import org.library.uca.model.domain.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordRepository extends JpaRepository<Record, Long> {

	@Query("select u from Record u where upper(u.description) like ?1 and u.status in ?2 and u.type in ?3")
	List<Record> findByCriteria(String description, List<RecordStatus> statusList, List<RecordType> typeList);

}
