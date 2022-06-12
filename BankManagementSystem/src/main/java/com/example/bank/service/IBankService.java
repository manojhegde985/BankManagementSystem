package com.example.bank.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bank.BankManagementSystemApplication;
import com.example.bank.entity.Bank;




public interface IBankService {

	static final Logger logger = LoggerFactory.getLogger(BankManagementSystemApplication.class);
	  public default String ServiceLog() {
		logger.info("this is bank management service file ");
		return "ServiceLog";
		}
	  
	  public List<Bank> getAllCustomers();
		
	  public Bank getCustomer(Integer cid);

	  public Bank addCustomer(Bank customer);

	  public String healthCheck(Integer cid);

}
