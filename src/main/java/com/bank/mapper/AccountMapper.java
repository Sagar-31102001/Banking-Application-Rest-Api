package com.bank.mapper;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;

public class AccountMapper 
{
	// Convert into AccountDto To Jpa Account 
	public static Account mapToAccount(AccountDto accountDto)
	{
		Account account = new Account(accountDto.id(),accountDto.accountHolderName(),accountDto.balance());
		return account;
	}
	
	// Convert into Jpa Account To  AccountDto
	public static AccountDto mapToAccountDto(Account account)
	{
		AccountDto accountDto = new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance());
		return accountDto;
	}
}
