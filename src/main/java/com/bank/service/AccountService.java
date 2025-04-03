package com.bank.service;

import java.util.List;

import com.bank.dto.AccountDto;

public interface AccountService 
{
	public abstract AccountDto createAccount(AccountDto accountDto);
	
	public abstract AccountDto getAccountById(Long id);
	
	public abstract AccountDto deposit(Long id , Double amount);
	
	public abstract AccountDto withdraw(Long id, Double amount);
	
	public abstract List<AccountDto> getAllAccounts();
	
	public abstract String deleteAccount(Long id);
}
