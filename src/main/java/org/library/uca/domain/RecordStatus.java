package org.library.uca.domain;

public enum RecordStatus {
	
	REGISTERED("registered"), 
	ACCEPTED_WITH_MODIFICATIONS("accepted_with_modifs"), 
	ACCEPTED("accepted"), 
	DISMISSED("dismissed"), 
	EXTERNAL_EVALUATION("external_evaluation"), 
	IN_BUDGET("in_budget"), 
	IN_LAYOUT("in_layout"), 
	IN_PRINTING("in_printing"), 
	PRINTED("printed"), 
	PENDING_EXTERNAL_ACTION("pending_external_action"), 
	SIGNATURE_PENDING("signature_pending"), 
	PENDING_PROCEDURE("pending_procedure"), 
	PENDING_THE_DIRECTOR("pending_the_director"), 
	WITHDRAWN("withdrawn"), 
	SENT("sent"), 
	ANSWERED("answered"), 
	CLOSED("closed");
	
	private String value;

	private RecordStatus(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
