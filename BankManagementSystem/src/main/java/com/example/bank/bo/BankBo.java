package com.example.bank.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bank.dto.BankDto;
import com.example.bank.eo.BankEo;
import com.example.bank.mapstruct.Mapstruct;



@Component
public class BankBo implements IBankBo {
	@Autowired
	private BankEo eo;
	@Autowired
	private Mapstruct mapstruct;
	
	private static final Logger logger = LoggerFactory.getLogger(BankBo.class);
	public String ServiceLog() {
	logger.info("this is a bank management bo file ");
	return "ServiceLog";
	}

	@Override
	public BankDto getCustomer(Integer cid) {
		return eo.getCustomer( cid);
	}

	@Override
	public List<BankDto> getAllCustomers() {
		List<BankDto> allCustomers=eo.getAllCustomers();
		return allCustomers;
	}

	@Override
	public BankDto addCustomer(BankDto Customer) {
		return eo.addCustomer(Customer);
	}

	@Override
	public String healthCheck(Integer cid) {
		
		return eo.healthCheck(cid);
	}

}
