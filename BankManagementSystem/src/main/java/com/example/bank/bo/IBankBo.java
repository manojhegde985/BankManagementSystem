package com.example.bank.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bank.BankManagementSystemApplication;
import com.example.bank.dto.BankDto;



public interface IBankBo {
	static final Logger logger = LoggerFactory.getLogger(BankManagementSystemApplication.class);
	  public default String ServiceLog() {
		logger.info("this is a bank management bo file ");
	     
		return "ServiceLog";
}
	  
	  public BankDto getCustomer(Integer cid);
	  
	  public List<BankDto> getAllCustomers();
	  
	  public BankDto addCustomer(BankDto Customer);
	  
	  public String healthCheck(Integer cid);
	  
	  
	  
}
