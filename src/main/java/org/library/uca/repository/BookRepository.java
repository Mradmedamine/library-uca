package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("select u from Book u where upper(u.title) like :title and upper(u.description) like :description")
	List<Book> findByCriteria(@Param("title") String title, @Param("description") String description);

}
