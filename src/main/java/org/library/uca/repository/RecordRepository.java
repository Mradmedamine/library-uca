package org.library.uca.repository;

import org.library.uca.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
	
    
}
