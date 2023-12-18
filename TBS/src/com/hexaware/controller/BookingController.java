package com.hexaware.controller;

import com.hexaware.entity.*;
import com.hexaware.dao.*;

import java.util.Scanner;


public class BookingController implements IBookingSystemServiceProvider{
	Customer cust = new Customer();
	Scanner sc = new Scanner(System.in);
	IBookingSystemRepo dao = new IBookingSystemRepo();
	
	public void addBooking(Event e)
	{	
		 if (e == null)
		 	{
	            System.out.println("Create an event first before booking tickets.");
	            return;
	        }
		
		System.out.println("Enter Customer Name: ");
		String cname = sc.next();
		cust.setCustomerName(cname);
		
		System.out.println("Enter Customer phone no. ");
		String phoneNo = sc.next();
		cust.setPhoneNumber(phoneNo);
		
		System.out.println("Enter Customer email: ");
		String email = sc.next();
		cust.setEmail(email);
		
	
		System.out.println("Enter the no. of tickets to book: ");
		int num = sc.nextInt();
		System.out.println(num);
		e.bookTickets(num);	
		
	}	
}
