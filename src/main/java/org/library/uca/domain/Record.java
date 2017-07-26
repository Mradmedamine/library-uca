package org.library.uca.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class Record {

	private Long id;
	private String Reference;
	private String name;
	private String author;
	@Enumerated(EnumType.STRING)
	private RecordStatus status;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public RecordStatus getStatus() {
		return status;
	}

	public void setStatus(RecordStatus status) {
		this.status = status;
	}

}
