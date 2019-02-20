package com.capgemini.testCases;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bean.Wallet;
import com.capgemini.exception.DupicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.MobilenumberIsNotFoundException;
import com.capgemini.repo.*;
import com.capgemini.service.*;

public class WalletTest {

	
	
	
	WalletRepoInterface walletRepo = new WalletRepoImpl();
	WalletService walletService = new WalletServiceImp(walletRepo);
	
	@Test(expected = com.capgemini.exception.DupicateMobileNumberException.class)
	public void WhenTheMobileNumberIsDuplicateThenThrowAnError() throws DupicateMobileNumberException,MobilenumberIsNotFoundException {
		
		BigDecimal amount1 = new BigDecimal(1000);
		Wallet wallet1 = new Wallet(amount1);
		
		walletService.createAccount("syed", "7408316888", wallet1);
		
		BigDecimal amount2 = new BigDecimal(500);
		Wallet wallet2 = new Wallet(amount2);
		
		walletService.createAccount("ajaz", "7408316888", wallet2);
		
	}
	
	
	@Test(expected = com.capgemini.exception.InsufficientBalanceException.class)
	public void WhenTheBalanceIsNotEnoughToWithDrawThenThrowAnError() throws InsufficientBalanceException, DupicateMobileNumberException, MobilenumberIsNotFoundException {
		
		BigDecimal withdrawAmount = new BigDecimal(2000);
		walletService.withDrawAmount("7408316888", withdrawAmount );
	}
	
	
	
	
	
	
	
	
	
}