package com.example.bank.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.BankManagementSystemApplication;
import com.example.bank.bo.BankBo;
import com.example.bank.dto.BankDto;
import com.example.bank.entity.Bank;
import com.example.bank.mapstruct.Mapstruct;





@Service
public class BankService implements IBankService{
	@Autowired
	private BankBo bo;
	@Autowired
	private Mapstruct mapstruct;
	
	private static final Logger logger = LoggerFactory.getLogger(BankManagementSystemApplication.class);
	public String ServiceLog() {
	logger.info("this is a bank management service layer ");

	return "ServiceLog";
	}
	@Override
	public List<Bank> getAllCustomers(){
		List<Bank> allCustomers = mapstruct.bankDtoTobankList(bo.getAllCustomers());
		return allCustomers;
		}
						
	@Override
	public Bank getCustomer(Integer cid) {
		return mapstruct.bankDtoToBank(bo.getCustomer(cid));
	}
	
	public Bank addCustomer(Bank customer) {
		BankDto customerdto=bo.addCustomer(mapstruct.bankToBankDto(customer));
		return mapstruct.bankDtoToBank((customerdto));
	}
	
	@Override
	public String healthCheck(Integer cid) {
		return bo.healthCheck(cid);
	}

}
