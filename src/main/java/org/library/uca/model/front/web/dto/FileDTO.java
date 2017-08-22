package org.library.uca.model.front.web.dto;

import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;

public class FileDTO extends BaseDTO {

	private static final long serialVersionUID = 5797499071965067582L;

	private String reference;
	private String description;
	private FileStatus status;
	private FileType type;
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

	public FileStatus getStatus() {
		return status;
	}

	public void setStatus(FileStatus status) {
		this.status = status;
	}

	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

}
