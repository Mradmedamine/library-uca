package org.library.uca.model.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookSubject {

	CHEMISTRY("chemistry"),
	HISTORY_ART("history_art"),
	INSTITUTIONAL("institutional"),
	LAW_JURISPRUDENCE("law_jurisprudence"),
	BIOMEDICAL_SCIENCES("biomedical_sciences"),
	MATHEMATICS_PHYSICAL("mathematics_physical"),
	BIOLOGY_NATURAL_SCIENCES("biology_natural_sciences"),
	ENGINEERING_ARCHITECTURE("engineering_architecture"),
	ECONOMIC_BUSINESS_SCIENCES("economic_business_sciences"),
	CELLULAR_MOLECULAR_BIOLOGY("cellular_molecular_biology"),
	PHILOSOPHY_PHILOLOGY_LINGUISTICS("philosophy_philology_linguistics"),
	SOCIAL_SCIENCES_BEHAVIORAL_POLICIES_EDUCATION("social_sciences_behavioral_policies_education");

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
