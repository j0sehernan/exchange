package com.jh.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.jh.entity.Currency;
import com.jh.entity.ExchangeRate;
import com.jh.repository.ICurrencyRepository;
import com.jh.repository.IExchangeRateRepository;

@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	ICurrencyRepository currencyRepository;

	@Autowired
	IExchangeRateRepository exchangeRateRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// Currencies
		Currency currencyPEN = new Currency("PEN");
		Currency currencyUSD = new Currency("USD");
		Currency currencyJPY = new Currency("JPY");

		currencyRepository.save(currencyPEN);
		currencyRepository.save(currencyUSD);
		currencyRepository.save(currencyJPY);
		// Exchanges
		exchangeRateRepository.save(new ExchangeRate(currencyPEN, currencyUSD, 0.28));
		exchangeRateRepository.save(new ExchangeRate(currencyUSD, currencyPEN, 3.54));
		exchangeRateRepository.save(new ExchangeRate(currencyJPY, currencyPEN, 0.033));
		exchangeRateRepository.save(new ExchangeRate(currencyPEN, currencyJPY, 29.90));
		exchangeRateRepository.save(new ExchangeRate(currencyUSD, currencyJPY, 105.73));
		exchangeRateRepository.save(new ExchangeRate(currencyUSD, currencyJPY, 0.0095));
	}
}
