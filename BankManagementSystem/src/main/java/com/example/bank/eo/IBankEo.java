package com.example.bank.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bank.BankManagementSystemApplication;
import com.example.bank.dto.BankDto;



public interface IBankEo {

	static final Logger logger = LoggerFactory.getLogger(BankManagementSystemApplication.class);
	  public default String ServiceLog() {
		logger.info("this is a bank management eo file ");
		return "ServiceLog";
		}
	  
	  public List<BankDto> getAllCustomers();
		
	  public BankDto getCustomer(Integer cid);

	  public BankDto addCustomer(BankDto customer);

	  public String healthCheck(Integer cid);
}
