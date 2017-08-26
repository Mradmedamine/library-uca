package org.library.uca.model.front.web.queryparams;

import java.io.Serializable;
import java.time.LocalDate;

public class ExchangeQueryParams implements Serializable {

	private static final long serialVersionUID = 3572013661659348645L;

	private String authorName;
	private String bookTitle;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String destination;

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

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
