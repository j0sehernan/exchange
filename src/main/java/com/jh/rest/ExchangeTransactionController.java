package com.jh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jh.entity.ExchangeRate;
import com.jh.entity.ExchangeTransaction;
import com.jh.repository.IExchangeRateRepository;
import com.jh.repository.IExchangeTransactionRepository;

@RestController
@RequestMapping("/exchanges")
public class ExchangeTransactionController {

	@Autowired
	private IExchangeTransactionRepository exchangeTransactionRepository;

	@Autowired
	private IExchangeRateRepository exchangeRateRepository;

	@PostMapping
	public ExchangeTransaction exchange(@RequestBody ExchangeTransaction exchangeTransaction) {
		ExchangeRate exchangeRate = exchangeRateRepository.findUserByOriginAndDestinationCurrency(exchangeTransaction.getExchangeRate().getOriginCurrency().getId(),
				exchangeTransaction.getExchangeRate().getDestinationCurrency().getId());

		double amountExchanged = exchangeTransaction.getAmount() * exchangeRate.getRate();

		exchangeTransaction.setExchangeRate(exchangeRate);
		exchangeTransaction.setAmountExchanged(amountExchanged);

		return exchangeTransactionRepository.save(exchangeTransaction);
	}
}
