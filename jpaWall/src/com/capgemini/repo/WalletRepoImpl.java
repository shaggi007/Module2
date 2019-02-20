package com.capgemini.repo;




import java.math.BigDecimal;

import com.capgemini.bean.Customer;
import com.capgemini.bean.Wallet;
import com.capgemini.util.Util;
import com.capgemini.util.Database;
import com.capgemini.repo.*;

public class WalletRepoImpl implements WalletRepoInterface {
	private Database databaseUtil = new Database();

	public WalletRepoImpl() {
		super();
		new Util();
	}

	@Override
	public boolean save(Customer customer)  {
		Customer cust = findOne(customer.getMobileNo());
		if (cust == null) {
			return databaseUtil.insertCustomer(customer);
		} else {
			return databaseUtil.updateWalletBalance(customer);
		}
	}
		
	@Override
	public Customer findOne(String mobileNumber) {
		Customer customer = databaseUtil.selectCustomer(mobileNumber);
		return customer;
	}

	@Override
	public void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositAmount(String mobileNo, BigDecimal balance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withDrawAmount(String mobileNo, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}
}
	
