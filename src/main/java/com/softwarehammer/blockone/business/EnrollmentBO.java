package com.softwarehammer.blockone.business;

import org.springframework.stereotype.Component;

/**
 * Contains business logic for the enrollment process.
 */
@Component
public class EnrollmentBO
{
	private final int maxCredits = 20;
	
	public EnrollmentBO()
	{
		
	}
	
	public boolean isMaxCredits(int proposedCredits)
	{
		return proposedCredits > maxCredits;
	}
}
