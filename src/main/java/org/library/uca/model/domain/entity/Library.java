package org.library.uca.model.domain.entity;

public class Library extends BaseEntity {

	private String name;

	public Library(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
