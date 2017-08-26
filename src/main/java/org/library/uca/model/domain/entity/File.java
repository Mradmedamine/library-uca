package org.library.uca.model.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;

@Entity
@Table(name = "file")
public class File extends BaseEntity {

	private String reference;
	private String description;
	private FileStatus status;
	private FileType type;
	private Author responsible;
	private Book book;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(columnDefinition="LONGTEXT")
	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	@Enumerated(EnumType.STRING)
	public FileStatus getStatus() {
		return status;
	}

	public void setStatus(FileStatus status) {
		this.status = status;
	}

	@Enumerated(EnumType.STRING)
	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "responsible_id")
	public Author getResponsible() {
		return responsible;
	}

	public void setResponsible(Author responsible) {
		this.responsible = responsible;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	@NotFound(action = NotFoundAction.IGNORE)
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
