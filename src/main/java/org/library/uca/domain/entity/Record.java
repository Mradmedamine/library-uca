package org.library.uca.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.library.uca.domain.metadata.RecordStatus;
import org.library.uca.domain.metadata.RecordType;

@Entity
@Table(name = "record")
public class Record extends EntityBase {

	private String reference;
	private String description;
	private RecordStatus status;
	private RecordType type;
	private Author responsible;
	private Book book;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}

	@Enumerated(EnumType.STRING)
	public RecordStatus getStatus() {
		return status;
	}

	public void setStatus(RecordStatus status) {
		this.status = status;
	}

	@Enumerated(EnumType.STRING)
	public RecordType getType() {
		return type;
	}

	public void setType(RecordType type) {
		this.type = type;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "responsible_id")
	public Author getResponsible() {
		return responsible;
	}

	public void setResponsible(Author responsible) {
		this.responsible = responsible;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "book_id")
	@NotFound(action = NotFoundAction.IGNORE)
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
