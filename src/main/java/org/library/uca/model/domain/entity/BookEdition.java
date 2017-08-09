package org.library.uca.model.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_edition")
public class BookEdition extends EntityBase {

	private String isbn;
	private LocalDate startDate;
	private LocalDate endDate;
	private BigDecimal price;
	private BigDecimal vat;
	private Integer pages;
	private Boolean finalized;
	private Boolean finishedCopyright;
	private Book book;
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getVat() {
		return vat;
	}

	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Boolean getFinalized() {
		return finalized;
	}

	public void setFinalized(Boolean finalized) {
		this.finalized = finalized;
	}

	public Boolean getFinishedCopyright() {
		return finishedCopyright;
	}

	public void setFinishedCopyright(Boolean finishedCopyright) {
		this.finishedCopyright = finishedCopyright;
	}

	@ManyToOne
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}

}
