package org.library.uca.model.front.web.queryparams;

import java.io.Serializable;
import java.util.List;

import org.library.uca.model.domain.FileStatus;
import org.library.uca.model.domain.FileType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FileQueryParams implements Serializable {

	private static final long serialVersionUID = 2306798939310096115L;

	private String descriptionText;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<FileType> types;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<FileStatus> status;

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public List<FileType> getTypes() {
		return types;
	}

	public void setTypes(List<FileType> types) {
		this.types = types;
	}

	public List<FileStatus> getStatus() {
		return status;
	}

	public void setStatus(List<FileStatus> status) {
		this.status = status;
	}

}
