package org.library.uca.model.front.web.queryparams;

import java.io.Serializable;
import java.util.List;

import org.library.uca.model.domain.RecordStatus;
import org.library.uca.model.domain.RecordType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RecordQueryParams implements Serializable {

	private static final long serialVersionUID = 2306798939310096115L;

	private String descriptionText;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<RecordType> types;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<RecordStatus> status;

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public List<RecordType> getTypes() {
		return types;
	}

	public void setTypes(List<RecordType> types) {
		this.types = types;
	}

	public List<RecordStatus> getStatus() {
		return status;
	}

	public void setStatus(List<RecordStatus> status) {
		this.status = status;
	}

}
