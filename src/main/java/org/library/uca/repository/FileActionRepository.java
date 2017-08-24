package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.entity.FileAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileActionRepository extends JpaRepository<FileAction, Long> {

	List<FileAction> findByFile_Id(Long fileId);
	
}
