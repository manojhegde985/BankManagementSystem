package com.example.bank.eo;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bank.BankManagementSystemApplication;
import com.example.bank.dto.BankDto;
import com.example.bank.mapstruct.Mapstruct;
import com.example.bank.repository.IBankRepository;







@Component
public class BankEo implements IBankEo {

	@Autowired
	private IBankRepository repository;
	@Autowired
	private Mapstruct mapstruct;
	
	private static final Logger logger = LoggerFactory.getLogger(BankManagementSystemApplication.class);
	public String ServiceLog() {
	logger.info("this is a customer management entity file ");
	
	return "ServiceLog";
	}
	
	@Override
	public List<BankDto> getAllCustomers() {
		List<BankDto> allCustomers=repository.findAll();
		return allCustomers;
	}

	@Override
	public BankDto getCustomer(Integer cid) {
		
		return repository.findById(cid);

	}

	@Override
	public BankDto addCustomer(BankDto customer) {
		
		return repository.save(customer);
	}

	@Override
	public String healthCheck(Integer cid) {
		
		BankDto s = repository.findById(cid);
		if(s.getCid() != null) {
		return ("HealthCheck-Success");
		}
		else {
		return ("HealthCheck-Failure");
		}
	

	}

		
		
}

