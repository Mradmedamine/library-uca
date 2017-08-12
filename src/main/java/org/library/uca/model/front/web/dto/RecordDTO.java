package org.library.uca.model.front.web.dto;

import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;

public class RecordDTO extends BaseDTO {

	private static final long serialVersionUID = 5797499071965067582L;

	private String reference;
	private String description;
	private RecordStatus status;
	private RecordType type;
	private Long responsibleId;
	private Long bookId;

	public Long getResponsibleId() {
		return responsibleId;
	}

	public void setResponsibleId(Long responsibleId) {
		this.responsibleId = responsibleId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RecordStatus getStatus() {
		return status;
	}

	public void setStatus(RecordStatus status) {
		this.status = status;
	}

	public RecordType getType() {
		return type;
	}

	public void setType(RecordType type) {
		this.type = type;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
