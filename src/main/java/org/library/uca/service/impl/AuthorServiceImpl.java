package org.library.uca.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.library.uca.model.domain.entity.Author;
import org.library.uca.repository.AuthorRepository;
import org.library.uca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public String getChainedAuthorNames(Collection<Author> authors) {
		if (CollectionUtils.isNotEmpty(authors)) {
			List<String> authorNames = authors.stream().map(Author::getName).collect(Collectors.toList());
			return String.join(", ", authorNames);
		}
		return "";
	}

}
