package org.library.uca.model.domain.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.library.uca.model.domain.ExchangeType;

@Entity
@Table(name = "exchange")
public class Exchange extends BaseEntity {

	private String isbn;
	private ExchangeType type;
	private LocalDate date;
	private String authorName;
	private String bookTitle;
	private String destination;
	private String sender;
	private String receptionLibrary;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public ExchangeType getType() {
		return type;
	}

	public void setType(ExchangeType type) {
		this.type = type;
	}

	public String getReceptionLibrary() {
		return receptionLibrary;
	}

	public void setReceptionLibrary(String receptionLibrary) {
		this.receptionLibrary = receptionLibrary;
	}

}
