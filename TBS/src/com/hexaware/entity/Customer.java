package com.hexaware.entity;

public class Customer {
	private String customerName,email;
	String phoneNumber;
	
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

	public Customer()
	{
		
	}
	
	public Customer(String customerName, String email, String phoneNumber)
	{
		this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName=customerName;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public String getPhoneNumber()
	{
		return  phoneNumber;
	}
	public void setPhoneNumber(String  phoneNo)
	{
		this. phoneNumber= phoneNo;
	}
	
	 public void displayCustomerDetails() 
	 {
	        System.out.println("Customer Name: " + customerName);
	        System.out.println("Email: " + email);
	        System.out.println("Phone Number: " + phoneNumber);
	 }     
}
