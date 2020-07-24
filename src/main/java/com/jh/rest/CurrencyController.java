package com.jh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jh.entity.Currency;
import com.jh.repository.ICurrencyRepository;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

	@Autowired
	private ICurrencyRepository currencyRepository;

	@GetMapping
	public List<Currency> list() {
		return currencyRepository.findAll();
	}

	@PostMapping
	public void insert(@RequestBody Currency currency) {
		currencyRepository.save(currency);
	}
}
