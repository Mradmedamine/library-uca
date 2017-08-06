package org.library.uca.model.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RecordType {

	PAPER("paper"),
	EBOOK("ebook"), 
    REPRINT("reprint"),
    ADMINISTRATIVE("administrative");
	
	private String value;

	private RecordType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	@JsonValue
	public String getName() {
		return name();
	}
	
}
