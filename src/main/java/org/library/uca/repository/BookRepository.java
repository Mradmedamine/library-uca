package org.library.uca.repository;

import org.library.uca.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
