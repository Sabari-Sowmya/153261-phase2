package com.capgemini.wallet.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.wallet.exception.InvalidInputException;
import com.capgemini.wallet.service.WalletService;
import com.capgemini.wallet.service.WalletServiceImpl;
import com.capgemini.wallwt.beans.Customer;
import com.capgemini.wallwt.beans.Wallet;


public class TestClass {
	WalletService service;
	Customer cust1,cust2,cust3,cust4;	
		@Before
		public void initData(){
			 Map<String,Customer> data= new HashMap<String, Customer>();
			 cust1=new Customer("Sabari", "9876543219",new Wallet(new BigDecimal(9000)));
			  cust2=new Customer("Sowmya", "9123456789",new Wallet(new BigDecimal(6000)));
			  cust3=new Customer("Nandhu", "9876512348",new Wallet(new BigDecimal(7000)));
			 cust4=new Customer("Aru","9123405678",new Wallet(new BigDecimal(0)));
						
					
			 data.put("9876543219", cust1);
			 data.put("9123456789", cust2);	
			 data.put("9876512348", cust3);	
			 data.put("9123405678", cust4);
				service= new WalletServiceImpl(data);
		
		}
		@Test(expected=NullPointerException.class)
		public void testCreateAccount() {
			
			service.createAccount(null,null,null);
			
			
		}
		@Test
		public void testCreateAccount1() {
			
			
			Customer c=new Customer();
			Customer cust=new Customer();
			cust=service.createAccount("Sabari","9988776655",new BigDecimal(7000));
			c.setMobileNo("998876655");
			c.setName("Sabari");
			c.setWallet(new Wallet(new BigDecimal(7000)));
			assertEquals(cust.getMobileNo(),c.getMobileNo());
			assertEquals(cust.getName(),c.getName());
			
		}
	@Test	
	public void testCreateAccount2() {
			
			
			
			Customer cust=new Customer();
			cust=service.createAccount("Sabari","9988776655",new BigDecimal(7000));
			assertEquals("Sabari", cust.getName());
		
			
			
		}
	@Test
	public void testCreateAccount3() {
		
		Customer cust=new Customer();
		cust=service.createAccount("Sabari","998877655",new BigDecimal(7000));
		assertEquals("9988776655", cust.getMobileNo());

		
		
	}


	@Test(expected=InvalidInputException.class)
	public void testShowBalance() {
		Customer cust=new Customer();
	cust=service.showBalance("9988779988");

	}

	@Test
	public void testShowBalance2() {
		
		Customer cust=new Customer();
		
	cust=service.showBalance("9989898989");
	assertEquals(cust, cust3);

	}
	
	
	@Test
	public void testShowBalance3() {
		
		Customer cust=new Customer();
	cust=service.showBalance("9101910178");
	BigDecimal actual=cust.getWallet().getBalance();
	BigDecimal expected=new BigDecimal(9000);
	assertEquals(expected, actual);

	}

	@Test(expected=InvalidInputException.class)
	public void testFundTransfer() {
		service.fundTransfer(null, null,new BigDecimal(7000));
	}

	@Test
	public void testFundTransfer2() {
		cust1=service.fundTransfer("9101910178","9787878787",new BigDecimal(2000));
		BigDecimal actual=cust1.getWallet().getBalance();
		BigDecimal expected=new BigDecimal(8000);
		assertEquals(expected, actual);
	}
	@Test(expected=InvalidInputException.class)
	public void testDeposit()
	{
		service.depositAmount("900000000", new BigDecimal(2000));
	}
		
	@Test
	public void testDeposit2()
	{
		cust1=service.depositAmount("9494949494", new BigDecimal(2000));
		BigDecimal actual=cust1.getWallet().getBalance();
		BigDecimal expected=new BigDecimal(8000);
		assertEquals(expected, actual);
	}
	@Test(expected=InvalidInputException.class)
	public void testWithdraw()
	{
		service.withdrawAmount("900000000", new BigDecimal(2000));
	}
		
	@Test
	public void testWithdraw2()
	{
		cust1=service.withdrawAmount("9978675643", new BigDecimal(2000));
		BigDecimal actual=cust1.getWallet().getBalance();
		BigDecimal expected=new BigDecimal(4000);
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testGetName()
	{
		Customer cust=new Customer("Capgemini","9978675643");
		assertEquals("Capgemini",cust.getName());
	}
	@Test
	public void testGetMobileNo()
	{
		Customer cust=new Customer("Capgemini","9978675643");
		assertEquals("8179793280",cust.getMobileNo());
	}
	
	@Test
	public void testGetBalance()
	{
		Wallet wallet=new Wallet(new BigDecimal(1000));
		Customer cust=new Customer("Capgemini","9978675643",wallet);
		assertEquals(new BigDecimal(1000),cust.getWallet().getBalance());
	}
	@Test
	public void TestValidate()
	{
		Customer customer=new Customer("Vaish","9876787845",new Wallet(new BigDecimal(10)));
		service.acceptCustomerDetails(customer);
	}

	@After
	public void testAfter()
	{
		service=null;
	}
	
}
