package org.library.uca.model.front.web.dto;

import java.util.Set;

import org.library.uca.model.domain.BookSubject;
import org.library.uca.model.domain.BookType;
import org.library.uca.model.domain.entity.Author;
import org.library.uca.model.domain.entity.BookEdition;

public class BookDTO extends BaseDTO {

	private static final long serialVersionUID = 1462937556020898573L;

	private String title;
	private String description;
	private BookSubject subject;
	private String collection;
	private BookType type;
	private Set<Author> authors;
	private Set<BookEdition> editions;
	private String chainedAuthorNames;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BookSubject getSubject() {
		return subject;
	}

	public void setSubject(BookSubject subject) {
		this.subject = subject;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<BookEdition> getEditions() {
		return editions;
	}

	public void setEditions(Set<BookEdition> editions) {
		this.editions = editions;
	}

	public String getChainedAuthorNames() {
		return chainedAuthorNames;
	}

	public void setChainedAuthorNames(String chainedAuthorNames) {
		this.chainedAuthorNames = chainedAuthorNames;
	}

}
