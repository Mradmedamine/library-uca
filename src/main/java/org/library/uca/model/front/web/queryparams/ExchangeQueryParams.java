package org.library.uca.model.front.web.queryparams;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ExchangeQueryParams implements Serializable {

	private static final long serialVersionUID = 3572013661659348645L;

	private String authorName;
	private String bookTitle;
	private LocalDate fromDate;
	private LocalDate toDate;

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

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

}
