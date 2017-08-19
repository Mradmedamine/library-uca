package org.library.uca.model.front.web.queryparams;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookQueryParams implements Serializable {

	private static final long serialVersionUID = 2306798939310096115L;

	private String titleText;
	private String descriptionText;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private Set<Long> authorIds;

	public String getTitleText() {
		return titleText;
	}

	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}

	public Set<Long> getAuthorIds() {
		return authorIds;
	}

	public void setAuthorIds(Set<Long> authorIds) {
		this.authorIds = authorIds;
	}

}
