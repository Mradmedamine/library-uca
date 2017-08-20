package org.library.uca.service.impl;

import java.util.List;

import org.library.uca.model.domain.entity.Exchange;
import org.library.uca.model.front.web.queryparams.ExchangeQueryParams;
import org.library.uca.repository.ExchangeRepository;
import org.library.uca.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl extends ServiceBaseImpl implements ExchangeService {

	@Autowired
	private ExchangeRepository exchangeRepository;

	@Override
	public List<Exchange> findAll() {
		return exchangeRepository.findAll();
	}


	@Override
	public List<Exchange> findByCriteria(ExchangeQueryParams exchangeQueryParams) {
		return null;
	}

	@Override
	public Exchange findById(Long id) {
		return exchangeRepository.findOne(id);
	}

	@Override
	public Exchange save(Exchange author) {
		return exchangeRepository.save(author);
	}

	@Override
	public Long delete(Long exchangeId) {
		try {
			exchangeRepository.delete(exchangeId);
		} catch (DataIntegrityViolationException err) {
			return -1L;
		} catch (Exception err) {
			return -100L;
		}
		return exchangeId;
	}
}