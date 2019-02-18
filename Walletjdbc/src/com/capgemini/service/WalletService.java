package com.capgemini.service;

import java.math.BigDecimal;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Wallet;
import com.capgemini.exception.DupicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.MobilenumberIsNotFoundException;

public interface WalletService {


	 Customer showBalance(String mobileNo) throws MobilenumberIsNotFoundException ;
		// TODO Auto-generated method stub
	

	  Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InsufficientBalanceException, MobilenumberIsNotFoundException;
		// TODO Auto-generated method stub
		

	 Customer depositAmount(String mobileNo, BigDecimal amount) throws MobilenumberIsNotFoundException;
		// TODO Auto-generated method stub
		

	 Customer withDrawAmount(String mobileNo, BigDecimal amount) throws InsufficientBalanceException, MobilenumberIsNotFoundException ;
		// TODO Auto-generated method stub
		

	 Customer createAccount(String name, String mobileNo, Wallet wallet) throws DupicateMobileNumberException, ClassNotFoundException;
		// TODO Auto-generated method stub
		

}