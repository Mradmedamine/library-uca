package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	
	List<Author> findByFullnameContainingIgnoreCaseAndIdCardContainingIgnoreCaseAndEmailContainingIgnoreCase(String fullname, String idCard, String email);


}
