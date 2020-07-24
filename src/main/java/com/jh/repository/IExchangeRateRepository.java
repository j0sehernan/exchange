package com.jh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jh.entity.ExchangeRate;

public interface IExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

	@Query(value = "SELECT * FROM exchanges_rate e WHERE e.origin_currency_id = :origin_currency_id and e.destination_currency_id = :destination_currency_id", nativeQuery = true)
	ExchangeRate findUserByOriginAndDestinationCurrency(@Param("origin_currency_id") Long originCurrencyId, @Param("destination_currency_id") Long destinationCurrencyId);
}
