package com.capgemini.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Wallet {
	@Column(name = "balance")
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public 	Wallet() {
		
	}

	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "balance amount is " + balance + "";
	}

}
