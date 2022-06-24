package com.example.bank.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.bank.dto.BankDto;
import com.example.bank.entity.Bank;


@Mapper(componentModel="spring")
public interface Mapstruct {

	BankDto bankToBankDto(Integer cid);

	BankDto bankToBankDto(Bank customer);

	Bank bankDtoToBank(BankDto customer);

	List<BankDto> bankToBankDtoList(List<Bank> list);

	List<Bank> bankDtoTobankList(List<BankDto> list);
}
