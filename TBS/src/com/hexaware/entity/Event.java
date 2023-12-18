package com.hexaware.entity;

import java.time.*;
import java.sql.Date;
public  class Event extends EventAbstract {
//	private String eventName, venueName;
	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", venueName=" + venueName + ", eventDate=" + eventDate
				+ ", eventTime=" + eventTime + ", totalSeats=" + totalSeats + ", availableSeats=" + availableSeats
				+ ", ticketPrice=" + ticketPrice + ", eventType=" + eventType + "]";
	}



//	private Date eventDate;
//	private LocalTime eventTime;
//	private int totalSeats, availableSeats;
//	private float ticketPrice;
//	private EventTypes eventType;
	
	public Event()
	{
		this.availableSeats=0;

		this.ticketPrice=0;
		this.venueName="";
		this.totalSeats=0;
		
	}
	
	public Event(String eventName,Date eventDate,LocalTime eventTime,String venueName,
			int totalSeats, float ticketPrice,EventTypes eventType)
	{
		this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venueName = venueName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.ticketPrice = ticketPrice;
        this.eventType = eventType;
       
	}
	
	public String getEventName()
	{
		return eventName;
	}
	public void setEventName(String eventName)
	{
		this.eventName=eventName;
	}
	
	public String getVenueName()
	{
		return venueName;
	}
	public void setVenueName(String venueName)
	{
		this.venueName=venueName;
	}
	
	public Date getEventDate()
	{
		return eventDate;
	}
	public void setEventDate(Date eventDate)
	{
		this.eventDate=eventDate;
	}
	
	public LocalTime getEventTime()
	{
		return eventTime;
	}
	public void setEventTime(LocalTime eventTime)
	{
		this.eventTime=eventTime;
	}
	
	public int getTotalSeats()
	{
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats)
	{
		this.totalSeats=totalSeats;
	}
	
	public int getAvailableSeats()
	{
		return availableSeats;
	}
	public void setAvailableSeats()
	{
		this.availableSeats=this.totalSeats;
	}
	
	public float getTicketPrice()
	{
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice)
	{
		this.ticketPrice=ticketPrice;
	}
	public EventTypes getEventType()
	{
		 return eventType;
	}
	public void setEventType(EventTypes eventType)
	{
		 this.eventType = eventType;
	}
	
	
	
	
	public void calculateTotalRevenue()
	{	if(totalSeats==0 || ticketPrice == 0.0 || (totalSeats- availableSeats)==0)
	{
		System.out.println("Book Tickets first to generate revenue ");
		return;
	}
		float totalRevenue = ticketPrice *(totalSeats- availableSeats);
		System.out.println("Total revenue: "+totalRevenue);
	}
	
	public  int getBookedTickets()
	{
		return totalSeats-availableSeats;
	}
	
	public void bookTickets(int numTickets)
	{	//System.out.println(numTickets);
		if (availableSeats==0 || totalSeats==0)
		{
			System.out.println("No seats available");
			return;
		}
	 if(numTickets > 0 && numTickets <= availableSeats && totalSeats != 0)
		{
			availableSeats= totalSeats-numTickets;
			System.out.println(numTickets + " Tickets booked successfully ");
		}
		else
		{
			System.out.println("Cannot book more than available no. of seats !!");
		}
	}
	
	public void cancelBooking(int numTickets)
	{if(availableSeats==0 || totalSeats==0|| (totalSeats- availableSeats)==0)
	{
		System.out.println("Unable to cancel tickets");
		return;
	}
	else if (numTickets>0 && numTickets<=(totalSeats-availableSeats))
		{
			availableSeats= availableSeats+numTickets;
			System.out.println(numTickets + " Tickets cancelled successfully, Avaialble seats:  "+availableSeats);
		}
		else
		{
			System.out.println("Cannot cancel more than no. of tickets booked !!");
		}
	}
	
	
	
	 public void displayEventDetails()
	 	{
	        System.out.println("Event Name: " + eventName);
	        System.out.println("Event Date: " + eventDate);
	        System.out.println("Event Time: " + eventTime);
	        System.out.println("Venue Name: " + venueName);
	        System.out.println("Total Seats: " + totalSeats);
	        System.out.println("Available Seats: " + availableSeats);
	        System.out.println("Ticket Price: $" + ticketPrice);
	        System.out.println("Event Type: " + eventType);
	    }
	 
	 
	
}



