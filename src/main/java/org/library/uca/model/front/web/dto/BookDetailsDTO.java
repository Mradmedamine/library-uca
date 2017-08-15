package org.library.uca.model.front.web.dto;

import java.util.Set;

import org.library.uca.model.domain.entity.Author;

public class BookDetailsDTO extends BaseBookDTO {

	private static final long serialVersionUID = 1462937556020898573L;

	private Set<Author> authors;
	private String chainedAuthorNames;

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getChainedAuthorNames() {
		return chainedAuthorNames;
	}

	public void setChainedAuthorNames(String chainedAuthorNames) {
		this.chainedAuthorNames = chainedAuthorNames;
	}

}
