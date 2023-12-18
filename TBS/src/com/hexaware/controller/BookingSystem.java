package com.hexaware.controller;

import java.util.Scanner;            // For task 1,2,3
import com.hexaware.controller.EventController;
public class BookingSystem {
	public static void main(String [] args) 
	{
		Scanner sc = new Scanner(System.in);
		//Booking b = new Booking();
		EventController bc = new EventController();
		while(true)
		{
			System.out.println("Welcome to ticket booking System. Enter the ticket option");
			System.out.println("silver");
			System.out.println("gold");
			System.out.println("diamond");
			System.out.println("EXIT to exit program");
			String category = sc.next();
			if("exit".equalsIgnoreCase(category))
			{	
				System.out.println("Thanks for using our system");
				break;
			}
			
			int basePrice = 0;
			switch(category.toLowerCase())
			{
			case "silver": {
				basePrice = 100;
				break;
			}
			case "gold":
			{
				basePrice = 150;
				break;
			}
			case "diamond":
			{
				basePrice = 200;
				break;
			}
			 default:
	             System.out.println("Invalid ticket category");
	             break;
					
			}
			
			System.out.println("Enter total no. of tickets available");
			int availableTickets = sc.nextInt();
			
			System.out.println("Enter no. of tickets to be booked");
			int noOfTicket= sc.nextInt();
			
			if(noOfTicket <= availableTickets)
			{
				int remTickets = availableTickets-noOfTicket;
				System.out.println("Tickets booked successfully !! Tickets Available : "+ remTickets);
			}
			else 
			{
				System.out.println("Unable to book ticket !! Available tickets : "+availableTickets);
			}
			
			int totalCost = basePrice*noOfTicket;
			
			System.out.println("Total Cost  : "+totalCost);
			System.out.println("*****************************");
			System.out.println();
			
			sc.nextLine();
		}
		
		
	}
}

