package com.jh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.entity.ExchangeRate;
import com.jh.repository.IExchangeRateRepository;

@Service
public class ExchangeRateService {
	private List<ObserverService> observers = new ArrayList<ObserverService>();

	@Autowired
	IExchangeRateRepository exchangeRateRepository;

	public ExchangeRate save(ExchangeRate exchangeRate) {
		return exchangeRateRepository.save(exchangeRate);
	}

	public void agregar(ObserverService observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		observers.forEach(x -> x.update());
	}
}
