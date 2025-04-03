package com.bank.exception;

@SuppressWarnings("serial")
public class AccountException extends RuntimeException
{
	public AccountException()
	{
		super();
	}
	
	public AccountException(String msg)
	{
		super(msg);
	}
}
