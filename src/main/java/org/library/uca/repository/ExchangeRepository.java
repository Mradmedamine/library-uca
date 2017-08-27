package org.library.uca.repository;

import java.time.LocalDate;
import java.util.List;

import org.library.uca.model.domain.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

	@Query("SELECT e FROM Exchange e WHERE upper(e.authorName) like :author "
									+ "AND upper(e.bookTitle) like :book "
									+ "AND (((:from) is null) OR (e.date >= :from)) "
									+ "AND (((:to) is null) OR (e.date <= :to))")
	List<Exchange> findByCriteria(@Param("author") String authorText, 
								  @Param("book") String bookText,
								  @Param("from") LocalDate from, 
								  @Param("to") LocalDate to);

}
