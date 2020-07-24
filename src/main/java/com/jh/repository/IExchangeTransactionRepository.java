package com.jh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jh.entity.ExchangeTransaction;

public interface IExchangeTransactionRepository extends JpaRepository<ExchangeTransaction, Long> {

}
