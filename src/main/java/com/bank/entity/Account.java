package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account
{
	@Id
	private Long id;
	
	private String accountHolderName;
	
	private Double balance;

	
	
	public Account()
	{
		super();
	}
	
	

	public Account(Long id, String accountHolderName, Double balance) 
	{
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountHolderName=" + accountHolderName + ", balance=" + balance + "]";
	}
}
