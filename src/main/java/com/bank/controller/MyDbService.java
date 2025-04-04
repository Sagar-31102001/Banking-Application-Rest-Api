package com.bank.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class MyDbService implements HealthIndicator
{
	
	public static final String DB_SERVICE="Database Service";
	

	public boolean isHealthGood()
	{
		// Custom Logic
		return false;
	}
	
	@Override
	public Health health() 
	{
		if (isHealthGood())
		{
			return Health.up().withDetail(DB_SERVICE,"Database is running up").build();
		} 
		else 
		{
			return Health.down().withDetail(DB_SERVICE,"Database is running down").build();
		}
	}

}
