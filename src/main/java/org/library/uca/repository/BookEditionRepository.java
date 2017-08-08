package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.entity.BookEdition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEditionRepository extends JpaRepository<BookEdition, Long> {

	List<BookEdition> findByBook_Id(Long bookId);
	
}
