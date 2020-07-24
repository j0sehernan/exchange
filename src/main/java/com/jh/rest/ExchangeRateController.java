package com.jh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jh.entity.ExchangeRate;
import com.jh.repository.IExchangeRateRepository;

@RestController
@RequestMapping("/exchangerate")
public class ExchangeRateController {
	@Autowired
	private IExchangeRateRepository exchangeRateRepository;

	@GetMapping
	public List<ExchangeRate> list() {
		return exchangeRateRepository.findAll();
	}

	@PostMapping
	public void insert(@RequestBody ExchangeRate currency) {
		exchangeRateRepository.save(currency);
	}

	@PutMapping("/update/{id}")
	public void update(@RequestBody ExchangeRate exchangeRateObj, @PathVariable Long id) {
		ExchangeRate exchangeRate = exchangeRateRepository.getOne(id);
		exchangeRate.setRate(exchangeRateObj.getRate());
		exchangeRateRepository.save(exchangeRate);
	}
}
