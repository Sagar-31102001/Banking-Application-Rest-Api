package com.bank.service_impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;
import com.bank.exception.AccountException;
import com.bank.mapper.AccountMapper;
import com.bank.repository.AccountRepository;
import com.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountRepository accRepo;
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) 
	{
		Account account = AccountMapper.mapToAccount(accountDto);
		
		Account saveAccount = accRepo.save(account);
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) 
	{
		Account account = accRepo.findById(id).orElseThrow(()->new AccountException("Account Does Not Exists"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, Double amount) 
	{
		Account account = accRepo.findById(id).orElseThrow(()->new AccountException("Account Does Not Exists"));
		
		account.setBalance(account.getBalance()+amount);
		
		Account saveAccount = accRepo.save(account);
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public AccountDto withdraw(Long id, Double amount) 
	{
		Account account = accRepo.findById(id).orElseThrow(()->new AccountException("Account Does Not Exists"));
		
		if (account.getBalance()>=amount) 
		{
			account.setBalance(account.getBalance()-amount);
		} 
		else 
		{
			throw new AccountException("Insufficient Balance...");
		}
		
		Account saveAccount = accRepo.save(account);
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts()
	{
		List<Account> accounts = accRepo.findAll();
		
		/*
			Function<Account, AccountDto> function= new Function<Account, AccountDto>() {
				
				@Override
				public AccountDto apply(Account account)
				{
					
					return AccountMapper.mapToAccountDto(account);
				}
			};
		*/
		return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
	}

	@Override
	public String deleteAccount(Long id) 
	{
		Account account = accRepo.findById(id).orElseThrow(() -> new AccountException("Account Does Not Exists"));

		accRepo.deleteById(account.getId());
		return "The Account Succfully Deleted With Id Is : "+id;
	}

}
