package org.library.uca.repository;

import java.util.List;

import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b INNER JOIN b.authors a WHERE upper(b.title) like :title AND "
			+ "upper(b.description) like :description AND (((:authors) is null) OR (a IN (:authors)))")
	List<Book> findByCriteria(@Param("title") String title, @Param("description") String description, @Param("authors") List<Author> authors);

}
