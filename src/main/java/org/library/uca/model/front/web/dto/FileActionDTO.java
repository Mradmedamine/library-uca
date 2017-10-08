package org.library.uca.model.front.web.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FileActionDTO extends BaseDTO {

	private static final long serialVersionUID = 9119104374174342341L;

	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	private MultipartFile physicalFile;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public MultipartFile getPhysicalFile() {
		return physicalFile;
	}

	public void setPhysicalFile(MultipartFile physicalFile) {
		this.physicalFile = physicalFile;
	}

}
