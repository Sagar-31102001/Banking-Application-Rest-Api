package com.bank.dto;

/**
 * dto used to transfer data between client to server and vise-versa
 * 
 */
public record AccountDto(Long id,String accountHolderName,Double balance)
{

}
