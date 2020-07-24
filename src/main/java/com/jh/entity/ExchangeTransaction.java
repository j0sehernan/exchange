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
@Table(name = "exchanges_transaction")
public class ExchangeTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double amount;
	private double amountExchanged;
	@ManyToOne
	@JoinColumn(name = "exchange_rate_id")
	private ExchangeRate exchangeRate;

	public ExchangeTransaction() {
	}

	public ExchangeTransaction(double amount, double amountExchanged, ExchangeRate exchangeRate) {
		this.amount = amount;
		this.amountExchanged = amountExchanged;
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "ExchangeTransaction [id=" + id + ", amount=" + amount + ", amountExchanged=" + amountExchanged + ", exchangeRate=" + exchangeRate + "]";
	}
}
