package org.library.uca.model.domain.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "template")
public class Template extends BaseEntity {

	private PhysicalFile physicalFile;

	@Embedded
	public PhysicalFile getPhysicalFile() {
		return physicalFile;
	}

	public void setPhysicalFile(PhysicalFile physicalFile) {
		this.physicalFile = physicalFile;
	}
	

}
