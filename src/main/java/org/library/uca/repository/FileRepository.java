package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;
import org.library.uca.model.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FileRepository extends JpaRepository<File, Long> {

	@Query("select u from File u where upper(u.description) like :description and u.status in :statusList and u.type in :typeList")
	List<File> findByCriteria(@Param("description") String description,
								@Param("statusList") List<FileStatus> statusList,
								@Param("typeList") List<FileType> typeList);

}
