package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;
import org.library.uca.model.domain.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordRepository extends JpaRepository<Record, Long> {

	@Query("select u from Record u where upper(u.description) like :description and u.status in :statusList and u.type in :typeList")
	List<Record> findByCriteria(@Param("description") String description,
								@Param("statusList") List<RecordStatus> statusList,
								@Param("typeList") List<RecordType> typeList);

}
