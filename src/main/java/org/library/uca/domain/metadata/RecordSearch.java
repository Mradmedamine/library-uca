package org.library.uca.domain.metadata;

import java.io.Serializable;
import java.util.List;

public class RecordSearch implements Serializable {

	private static final long serialVersionUID = 2306798939310096115L;

	private String recordText;
	private List<RecordType> recordTypes;
	private List<RecordStatus> recordStatus;

	public String getRecordText() {
		return recordText;
	}

	public void setRecordText(String recordText) {
		this.recordText = recordText;
	}

	public List<RecordType> getRecordTypes() {
		return recordTypes;
	}

	public void setRecordTypes(List<RecordType> recordTypes) {
		this.recordTypes = recordTypes;
	}

	public List<RecordStatus> getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(List<RecordStatus> recordStatus) {
		this.recordStatus = recordStatus;
	}

}
