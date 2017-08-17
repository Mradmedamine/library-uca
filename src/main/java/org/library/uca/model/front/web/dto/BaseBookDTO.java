package org.library.uca.model.front.web.dto;

import java.util.Set;

import org.library.uca.model.domain.BookSubject;
import org.library.uca.model.domain.BookType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseBookDTO extends BaseDTO {

	private static final long serialVersionUID = -6756086645323382322L;

	private String title;
	private String description;
	private BookSubject subject;
	private String collection;
	private BookType type;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private Set<Long> authorIds;

	public Set<Long> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(Set<Long> authorIds) {
		this.authorIds = authorIds;
	}

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

}
