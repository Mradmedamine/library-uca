package org.library.uca.service;

import java.util.List;

import org.library.uca.model.domain.entity.Exchange;
import org.library.uca.model.front.web.queryparams.ExchangeQueryParams;

public interface ExchangeService {

	List<Exchange> findAll();

	Exchange findById(Long id);
	
	List<Exchange> findByCriteria(ExchangeQueryParams exchangeQueryParams);

	Exchange save(Exchange exchange);
	
	Long delete(Long exchangeId);

}
