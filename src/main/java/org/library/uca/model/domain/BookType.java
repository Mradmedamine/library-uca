package org.library.uca.model.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookType {

	MANUAL("manual"), 
    MINUTES("minutes"), 
    TRIBUTES("tributes"),
    MONOGRAPH("monograph"),    
    TRANSLATION("translation"), 
    INSTITUTIONAL("institutional"),  
    STUDIES_REPORTS_PROJECTS("studies_reports_projects");

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
