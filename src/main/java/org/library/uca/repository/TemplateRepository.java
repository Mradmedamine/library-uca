package org.library.uca.repository;

import org.library.uca.model.domain.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Long> {
	
}
