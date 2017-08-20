package org.library.uca.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.front.web.queryparams.AuthorQueryParams;
import org.library.uca.repository.AuthorRepository;
import org.library.uca.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class AuthorServiceImpl extends ServiceBaseImpl implements AuthorService {

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
		String fullname = buildQueryTextParam(authorQueryParams.getFullname());
		// id card
		String idCard = buildQueryTextParam(authorQueryParams.getIdCard());
		// email
		String email = buildQueryTextParam(authorQueryParams.getEmail());
		return authorRepository.findByCriteria(fullname, idCard, email);
	}

	@Override
	public Author findById(Long id) {
		return authorRepository.findOne(id);
	}

	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> findByIds(Set<Long> ids) {
		return authorRepository.findByIdIn(ids);
	}

	@Override
	public Long delete(Long authorId) {
		try {
			authorRepository.delete(authorId);
		} catch (DataIntegrityViolationException err) {
			return -1L;
		} catch (Exception err) {
			return -100L;
		}
		return authorId;
	}
}