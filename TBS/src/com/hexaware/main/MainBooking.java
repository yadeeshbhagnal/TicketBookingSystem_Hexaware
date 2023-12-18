package com.hexaware.main;

import com.hexaware.controller.*;
import com.hexaware.entity.*;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.hexaware.exception.*;
import com.hexaware.exception.NullPointerException;

public class MainBooking{
	public static void main(String [] args) throws EventNotFoundException
	{	
		Scanner sc = new Scanner(System.in);
		EventController ec = new EventController();
		BookingController bc = new BookingController();
		
		String ch = null;
		Event e = null;
		
		do
		{
			
		System.out.println("Welcome to ticket booking system");
		System.out.println("Choose from the options to continue: ");
		System.out.println("1 . Create Event");
		System.out.println("2 . Book Tickets");
		System.out.println("3. Calculate total revenue"); 
		System.out.println("4. Cancel Booking");
		System.out.println("5. Display Event Details");
		System.out.println("6. Show Booked tickets");
		System.out.println("7. Delete Event");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: {
			try
			{
				e = ec.addEvent();
			}catch (EventNotFoundException enfe){
				 System.out.println("Error adding event, invalid event type: " + enfe.getMessage());
			}catch (EventDateInvalidException edie) {
		        System.out.println("Error adding event, invalid date format: " + edie.getMessage());
		    }catch (EventTimeInvalidException etie) {
		        System.out.println("Error adding event, invalid time format: " + etie.getMessage());
		    }
			break;
			
		}
		case 2:{
			
				bc.addBooking(e);
			break;
		}
		case 3:{
			ec.revenue();
			break;
		}
		case 4:
		{
			ec.cancelT();
			break;
		}
		case 5:
		{
			ec.display();
			break;
		}
		case 6:
		{
			ec.bookedTickets();
			break;
		}
		case 7:
		{
			ec.deleteEvent();
			break;
		}
		default :{
			System.out.println("Invalid choice, choose again");
			break;
		}
		}
		
		System.out.println("Do you want to continue? Y | y , else press any other key to EXIT!!");
		ch = sc.next();
	}
	while (ch.equals("Y") || ch.equals("y"));
	System.out.println("Thanks for using our system");
			
	}	
}
