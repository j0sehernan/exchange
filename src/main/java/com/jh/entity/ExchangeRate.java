package com.jh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "exchanges_rate")
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "origin_currency_id")
	private Currency originCurrency;
	@ManyToOne
	@JoinColumn(name = "destination_currency_id")
	private Currency destinationCurrency;
	private double rate;

	public ExchangeRate() {
	}

	public ExchangeRate(Currency originCurrency, Currency destinationCurrency, double rate) {
		this.originCurrency = originCurrency;
		this.destinationCurrency = destinationCurrency;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "ExchangeRate [id=" + id + ", originCurrency=" + originCurrency + ", destinationCurrency=" + destinationCurrency + ", rate=" + rate + "]";
	}
}
