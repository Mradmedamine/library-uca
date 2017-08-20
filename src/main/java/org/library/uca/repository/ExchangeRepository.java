package org.library.uca.repository;

import org.library.uca.model.domain.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
	
}
