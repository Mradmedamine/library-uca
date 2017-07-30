package org.library.uca.domain.metadata;

import java.io.Serializable;
import java.util.List;

public class RecordSearch implements Serializable {

	private static final long serialVersionUID = 2306798939310096115L;

	private String descriptionText;
	private List<RecordType> types;
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
