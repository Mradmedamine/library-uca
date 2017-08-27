package org.library.uca.controller;

import java.util.List;

import org.library.uca.model.domain.entity.Exchange;
import org.library.uca.model.front.web.queryparams.ExchangeQueryParams;
import org.library.uca.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExchangesController {

	@Autowired
	private ExchangeService exchangeService;

	@RequestMapping(path = "/exchanges", method = RequestMethod.GET)
	public String exchangesList(Model model) {
		return "modules/exchanges/list";
	}

	@RequestMapping(path = "/exchanges/search", method = RequestMethod.POST)
	public String searchExhanges(Model model, @RequestBody ExchangeQueryParams exchangeQueryParams) {
		List<Exchange> exchanges = exchangeService.findByCriteria(exchangeQueryParams);
		if (exchanges != null && exchanges.size() > 0) {
			model.addAttribute("exchanges", exchanges);
		}
		return "modules/exchanges/dataTable::content";
	}

	@RequestMapping(path = "/exchanges/{id}", method = RequestMethod.GET)
	public String exchangePage(Model model, @PathVariable Long id) {
		model.addAttribute("exchange", exchangeService.findById(id));
		return "modules/exchanges/form";
	}


	@RequestMapping(path = "/exchanges/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Long deleteExchange(Model model, @PathVariable Long id) {
		return exchangeService.delete(id);
	}


	@ResponseBody
	@RequestMapping(path = "/exchanges", method = RequestMethod.POST)
	public Long saveExchange(Model model, @RequestBody Exchange exchange) {
		Exchange exchangeStored = exchangeService.save(exchange);
		return exchangeStored.getId();
	}

	@RequestMapping("/exchanges/new")
	public String newExchange(Model model) {
		return "modules/exchanges/form";
	}
}
