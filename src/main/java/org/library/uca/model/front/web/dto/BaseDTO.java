package org.library.uca.model.front.web.dto;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = 2085403430158338978L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		BaseDTO dto = (BaseDTO) o;
		return Objects.equals(id, dto.getId());
	}
}
