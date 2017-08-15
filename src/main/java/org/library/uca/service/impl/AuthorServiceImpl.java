package org.library.uca.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.front.web.queryparams.AuthorQueryParams;
import org.library.uca.repository.AuthorRepository;
import org.library.uca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

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
		if (!CollectionUtils.isEmpty(authors)) {
			List<String> authorNames = authors.stream().map(Author::getFullname).collect(Collectors.toList());
			return String.join(", ", authorNames);
		}
		return "";
	}

	@Override
	public List<Author> findByCriteria(AuthorQueryParams authorQueryParams) {
		// full name
		String fullname = authorQueryParams.getFullname();
		if (StringUtils.isEmpty(fullname)) {
			fullname = "%";
		} else {
			fullname = "%" + fullname.toUpperCase()  + "%";
		}
		
		// id card
		String idCard = authorQueryParams.getIdCard();
		if (StringUtils.isEmpty(fullname)) {
			idCard = "%";
		} else {
			idCard = "%" + idCard.toUpperCase()  + "%";
		}
		
		// email
		String email = authorQueryParams.getEmail();
		if (StringUtils.isEmpty(email)) {
			email = "%";
		} else {
			email = "%" + email.toUpperCase() + "%";
		}

		return authorRepository.findByCriteria(fullname, idCard, email);
	}

	@Override
	public Author findById(Long id) {
		return authorRepository.findOne(id);
	}

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
}