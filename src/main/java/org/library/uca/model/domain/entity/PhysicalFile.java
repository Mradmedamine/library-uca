package org.library.uca.model.domain.entity;

import javax.persistence.Embeddable;

@Embeddable
public class PhysicalFile {

	private String fileName;
	private byte[] fileContent;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

}
