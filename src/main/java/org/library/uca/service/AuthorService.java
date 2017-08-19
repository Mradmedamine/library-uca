package org.library.uca.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.front.web.queryparams.AuthorQueryParams;

public interface AuthorService {

	List<Author> findAll();

	Author findById(Long id);
	
	List<Author> findByIds(Set<Long> ids);
	
	List<Author> findByCriteria(AuthorQueryParams authorQueryParams);

	Author saveAuthor(Author author);

	String getChainedAuthorNames(Collection<Author> authors);

}
