package com.capgemini.service;

import java.math.BigDecimal;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Wallet;
import com.capgemini.exception.DupicateMobileNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.MobilenumberIsNotFoundException;
import com.capgemini.repo.WalletRepoInterface;

public class WalletServiceImp implements WalletService {
	
	
	WalletRepoInterface walletRepo;
	
	public WalletServiceImp(WalletRepoInterface walletRepo)
	{
		this.walletRepo = walletRepo;
	}
	
	
	@Override
	public Customer createAccount(String name, String mobileNo, Wallet wallet) throws DupicateMobileNumberException 
	{
		
		Customer customer = new Customer(name,mobileNo,wallet); 
		
		if(walletRepo.findOne(mobileNo) == null) {
			walletRepo.save(customer);   
			return customer;
		}
		throw new DupicateMobileNumberException();
	}
	
	
	@Override
	public Customer showBalance(String mobileNo) throws MobilenumberIsNotFoundException  
	{	
		if(walletRepo.findOne(mobileNo) != null)
			return walletRepo.findOne(mobileNo);
		
		throw new MobilenumberIsNotFoundException();
	}
	
	
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InsufficientBalanceException  
, MobilenumberIsNotFoundException
	{
		if(walletRepo.findOne(sourceMobileNo) != null && walletRepo.findOne(targetMobileNo) != null) {
			Customer sourceCustomer = walletRepo.findOne(sourceMobileNo);
			Customer targetCustomer = walletRepo.findOne(targetMobileNo);
			BigDecimal sourceAmount = sourceCustomer.getWallet().getBalance();
			int i = sourceAmount.compareTo(amount);
			if(i == -1) {
				throw new InsufficientBalanceException();
			}
			walletRepo.fundTransfer(sourceMobileNo, targetMobileNo, amount);
			
		}
		throw new MobilenumberIsNotFoundException();
		
	}
	
	
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) throws MobilenumberIsNotFoundException 
	{
		if(walletRepo.findOne(mobileNo) != null) {
			Customer customer = walletRepo.findOne(mobileNo);
			walletRepo.depositAmount(customer.getMobileNo(), customer.getWallet().getBalance());
		}
		throw new MobilenumberIsNotFoundException();
	}
	
	
	@Override
	public Customer withDrawAmount(String mobileNo, BigDecimal amount) throws InsufficientBalanceException,MobilenumberIsNotFoundException
	{
		if(walletRepo.findOne(mobileNo) != null) {
			Customer customer = walletRepo.findOne(mobileNo);
			BigDecimal amountInCustomer = customer.getWallet().getBalance();
			int i = amountInCustomer.compareTo(amount);
			if(i == -1) {
				throw new InsufficientBalanceException();
			}
			walletRepo.withDrawAmount(mobileNo,amount);
		}
		throw new MobilenumberIsNotFoundException();
	}
	
}