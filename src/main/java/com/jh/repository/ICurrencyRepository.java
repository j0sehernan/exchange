package com.jh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jh.entity.Currency;

public interface ICurrencyRepository extends JpaRepository<Currency, Long> {

}
