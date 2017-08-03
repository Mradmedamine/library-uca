package org.library.uca.domain.metadata;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RecordStatus {
	
	CLOSED("closed"),
    PRINTED("printed"), 
    ACCEPTED("accepted"), 
    WITHDRAWN("withdrawn"), 
    DISMISSED("dismissed"), 
    IN_BUDGET("in_budget"), 
    IN_LAYOUT("in_layout"), 
    REGISTERED("registered"), 
    IN_PRINTING("in_printing"), 
    IN_EVALUATION("in_evaluation"),
    EXTERNAL_MANAGEMENT("external_management");
	
	private String value;

	private RecordStatus(String value) {
		this.setValue(value);
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
