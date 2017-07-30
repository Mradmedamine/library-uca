package org.library.uca.domain.metadata;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RecordStatus {
	
	SENT("sent"), 
	CLOSED("closed"),
	PRINTED("printed"), 
	ANSWERED("answered"), 
	ACCEPTED("accepted"), 
	WITHDRAWN("withdrawn"), 
	DISMISSED("dismissed"), 
	IN_BUDGET("in_budget"), 
	IN_LAYOUT("in_layout"), 
	REGISTERED("registered"), 
	IN_PRINTING("in_printing"), 
	SIGNATURE_PENDING("signature_pending"), 
	PENDING_PROCEDURE("pending_procedure"), 
	PENDING_THE_DIRECTOR("pending_the_director"), 
	EXTERNAL_EVALUATION("external_evaluation"), 
	PENDING_EXTERNAL_ACTION("pending_external_action"), 
	ACCEPTED_WITH_MODIFICATIONS("accepted_with_modifs");
	
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
