package org.library.uca.repository;

import java.util.List;
import java.util.Set;

import org.library.uca.model.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	@Query("select u from Author u where upper(u.fullname) like :fullname and upper(u.idCard) like :idCard and upper(u.email) like :email")
	List<Author> findByCriteria(@Param("fullname") String fullname, 
								@Param("idCard") String idCard,
								@Param("email") String email);

	List<Author> findByIdIn(Set<Long> ids);
	
}
