package org.library.uca.model.front.web;

import java.io.Serializable;

public abstract class DTOBase implements Serializable {

	private static final long serialVersionUID = 2085403430158338978L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
