package org.library.uca.model.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Lob;

@Embeddable
public class PhysicalFile {

	private String fileName;
	private byte[] fileContent;

	@Column(nullable=true)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="file_content", nullable=true, columnDefinition="MEDIUMBLOB")
	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

}
