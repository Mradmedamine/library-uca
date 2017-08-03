package org.library.uca.domain.metadata;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RecordType {

	PAPER("paper"),
	EBOOK("ebook"), 
    REPRINT("reprint"),
    ADMINISTRATIVE("administrative");
	
	private String value;

	private RecordType(String value) {
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
