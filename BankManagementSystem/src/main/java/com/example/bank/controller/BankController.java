package com.example.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.entity.Bank;
import com.example.bank.mapstruct.Mapstruct;
import com.example.bank.service.IBankService;
import com.example.bank.util.BankUtil;





@ControllerAdvice
	@RequestMapping(value="/customer")
	@RestController
	
public class BankController {

	@Autowired
	private IBankService service;
	@Autowired
	private Mapstruct mapstruct;
	private final Logger logger = LoggerFactory.getLogger(BankController.class);
    @RequestMapping("/")
    String controller(){
        logger.info("This is a bank management controller layer");
        return "controller";
    }
    
    @GetMapping(value=BankUtil.GET)
	public ResponseEntity<List<Bank>> getAllCustomers()
	{
		List<Bank> getAllCustomers=service.getAllCustomers();
		
		return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
	}
    
    @GetMapping(value=BankUtil.GETBYID)
	public ResponseEntity<Bank> getCustomer(@PathVariable Integer cid)
	{
		Bank customer=service.getCustomer(cid);
		return new ResponseEntity<Bank>(customer,HttpStatus.OK);
    
	}
    
	@PostMapping(value=BankUtil.SAVE)
	public ResponseEntity<Bank> savecustomer( @RequestBody Bank customer)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addCustomer(customer));
	}
	
	@GetMapping(value =BankUtil.HEALTH)
	public ResponseEntity<String> healthcheck(@PathVariable Integer cid){
	String str = service.healthCheck(cid);
	logger.info("HealthCheck Successful");
	return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}
}
