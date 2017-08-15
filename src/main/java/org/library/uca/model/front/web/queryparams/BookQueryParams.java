package org.library.uca.model.front.web.queryparams;

import java.io.Serializable;

public class BookQueryParams implements Serializable {

	private static final long serialVersionUID = 2306798939310096115L;

	private String titleText;
	private String descriptionText;

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

}
