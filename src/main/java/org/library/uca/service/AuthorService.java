package org.library.uca.service;

import java.util.Collection;
import java.util.List;

import org.library.uca.model.domain.entity.Author;

public interface AuthorService {

	List<Author> findAll();

	String getChainedAuthorNames(Collection<Author> authors);

}
