package com.bank.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp, String error_message, String details_url , String error_code)
{
	
}
