package com.example.bank;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.example.bank.bo.BankBo;
import com.example.bank.dto.BankDto;
import com.example.bank.entity.Bank;
import com.example.bank.eo.BankEo;
import com.example.bank.mapstruct.Mapstruct;
import com.example.bank.repository.IBankRepository;
import com.example.bank.service.BankService;





@SpringBootTest
@ContextConfiguration({"classpath*:spring/applicationContext.xml"})

class BankManagementSystemApplicationTests {

	@Autowired
	private BankService service;
	
	@Autowired
	private Mapstruct mapstruct;
	
	@Autowired 
	private BankEo eo;
	
	@Autowired
	private BankBo bo;
	
	
	
	/*@Autowired
	private MockMvc mockMvc;
*/
	 @MockBean
	private IBankRepository repository;

	 @Before
		public void init() {
			MockitoAnnotations.initMocks(this);
		}
	 
	
	 
	 @Test
		public void getAllCustomersTest() {
		 BankDto customer = new BankDto();
		when(repository.findAll()).thenReturn(Stream
		.of(new BankDto(1,"Manoj","H","Bangalore","manoj","1234"),
		new BankDto(2,"John","L","Bangalore","john","1020")).collect
		(Collectors.toList()));
		assertEquals(2,service.getAllCustomers().size());
		verify(repository).findAll();
		}
	 
	
			@Test
			public void  getCustomer(){
			BankDto customer = new BankDto();
			customer.setCid(8);
			when(repository.findById(customer.getCid())).thenReturn(customer);
			Bank expected = (Bank) service.getCustomer(customer.getCid());
		//	assertThat(expected).isSameAs(customer);
			verify(repository).findById(customer.getCid());
			}
			
			
			@Test
			public void addCustomerTest()
			{
				Bank customer = new Bank(1,"Manoj","H","Bangalore","manoj","1234");

				service.addCustomer(customer);
				

				
			}
			
			@Test
			public void healthcheckTest() {
				Integer cid=1;
				service.healthCheck(cid);
			}
			
			@Test
			public void loggerTest() {
				service.ServiceLog();
				eo.ServiceLog();
				bo.ServiceLog();
				
				
			}
						
			
}
			


			
