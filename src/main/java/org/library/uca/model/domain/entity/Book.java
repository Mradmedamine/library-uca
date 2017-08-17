package org.library.uca.model.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.library.uca.model.domain.BookSubject;
import org.library.uca.model.domain.BookType;

@Entity
@Table(name = "book")
public class Book extends EntityBase {

	private String title;
	private String description;
	private BookSubject subject;
	private String collection;
	private BookType type;
	private Set<Author> authors;

	@Column(columnDefinition = "LONGVARCHAR")
	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@ManyToMany
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

}
