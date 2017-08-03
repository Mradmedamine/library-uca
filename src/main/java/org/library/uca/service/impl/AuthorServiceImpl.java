package org.library.uca.service.impl;

import java.util.List;

import org.library.uca.domain.entity.Author;
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


}
