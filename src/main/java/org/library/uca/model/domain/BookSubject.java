package org.library.uca.model.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookSubject {

	MATHEMATIC("mathematic");

	private String value;

	private BookSubject(String value) {
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
