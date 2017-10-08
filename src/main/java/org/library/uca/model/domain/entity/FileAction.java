package org.library.uca.model.domain.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "file_action")
public class FileAction extends BaseEntity {

	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	private PhysicalFile physicalFile;
	private File file;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Column(columnDefinition = "LONGTEXT")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Embedded
	public PhysicalFile getPhysicalFile() {
		return physicalFile;
	}

	public void setPhysicalFile(PhysicalFile physicalFile) {
		this.physicalFile = physicalFile;
	}

	@ManyToOne
	@JoinColumn(name = "file_id")
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
