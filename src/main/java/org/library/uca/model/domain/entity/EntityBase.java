package org.library.uca.model.domain.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.library.uca.model.front.web.dto.BaseDTO;

@MappedSuperclass
public abstract class EntityBase {

	private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "created_at")
	LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "modified_at")
	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@PrePersist
	void createdAt() {
		this.createdAt = this.modifiedAt = LocalDateTime.now();
	}

	@PreUpdate
	void updatedAt() {
		this.modifiedAt = LocalDateTime.now();
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
