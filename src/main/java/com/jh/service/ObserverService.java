package com.jh.service;

import org.springframework.stereotype.Service;

@Service
public abstract class ObserverService {

	protected ExchangeRateService exchangeRateService;

	public abstract void update();
}
