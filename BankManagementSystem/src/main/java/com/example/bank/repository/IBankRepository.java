package com.example.bank.repository;

import java.util.List;

import com.example.bank.dto.BankDto;


public interface IBankRepository {
	
public int count();

public List<BankDto> findAll();
public BankDto findById(int cid);
public BankDto save(BankDto customer);







}
