package org.library.uca.model.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookType {

	MANUAL("manual"), MONOGRAPH("monograph");

	private String value;

	private BookType(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@JsonValue
	public String getName() {
		return name();
	}
}
