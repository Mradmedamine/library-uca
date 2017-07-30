package org.library.uca.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.library.uca.domain.metadata.RecordStatus;
import org.library.uca.domain.metadata.RecordType;

@Entity
@Table(name = "record")
public class Record extends EntityBase {

	private String Reference;
	private String description;
	private RecordStatus status;
	private RecordType type;
	private String author;

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
