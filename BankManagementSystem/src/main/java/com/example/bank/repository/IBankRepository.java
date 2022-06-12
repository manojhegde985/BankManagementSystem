package com.example.bank.repository;

import java.util.List;
import java.util.Optional;

import com.example.bank.dto.BankDto;
import com.example.bank.entity.Bank;

public interface IBankRepository {
	
public int count();
public BankDto save(BankDto customer);
public List<BankDto> findAll();
public BankDto findById(int cid);



}
