package com.bank.rest_controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AccountDto;
import com.bank.service_impl.AccountServiceImpl;

@RestController
@RequestMapping("/accounts")
public class AccountController
{
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	// add account Rest API
	
	@PostMapping(value = "/add-account" , consumes = "application/json" , produces = "application/json")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
	{
		 AccountDto accountDto2 = accountServiceImpl.createAccount(accountDto);
		 return new ResponseEntity<>(accountDto2,HttpStatus.CREATED);
	}
	
	// Find account by id
	@GetMapping(value="/get-account-id/{id}" , produces = "application/json")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id)
	{
		AccountDto accountById = accountServiceImpl.getAccountById(id);
		return new ResponseEntity<AccountDto>(accountById,HttpStatus.OK);
	}
	
	// Deposit Rest API
	@PutMapping("/deposit/{id}")
	public ResponseEntity<AccountDto> depositAmount(@PathVariable("id") Long id,@RequestBody Map<String,Double> request)
	{
		Double amount = request.get("amount");
		AccountDto depositAccount = accountServiceImpl.deposit(id, amount);
		
		return new ResponseEntity<AccountDto>(depositAccount,HttpStatus.ACCEPTED);
	}
	
	// Withdraw amount Rest API
	@PutMapping("/withdraw/{id}")
	public ResponseEntity<AccountDto> withdrawAmount(@PathVariable("id") Long id,@RequestBody Map<String,Double> request)
	{
		Double amount = request.get("amount");
		
		AccountDto withdrawAccount = accountServiceImpl.withdraw(id, amount);
		
		return new ResponseEntity<AccountDto>(withdrawAccount,HttpStatus.ACCEPTED);
	}
	
	// Fetch All Accounts Using Rest API
	@GetMapping(value="/all-account",produces = "application/json")
	public ResponseEntity<List<AccountDto>> getAllAcc()
	{
		List<AccountDto> allAccounts = accountServiceImpl.getAllAccounts();
		return new ResponseEntity<List<AccountDto>>(allAccounts,HttpStatus.OK);
	}
	
	// Delete Account Rest API
	@DeleteMapping("/del-account/{id}")
	public ResponseEntity<String> getDeleteAccount(@PathVariable("id") Long id)
	{
		String deleteAccount = accountServiceImpl.deleteAccount(id);
		return new ResponseEntity<String>(deleteAccount,HttpStatus.OK);
	}
	
}
