package com.hexaware.controller;
import com.hexaware.entity.*;
import com.hexaware.exception.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.sql.Date;
import java.util.Scanner;
import com.hexaware.dao.*;
public class EventController implements IEventServiceProvider {
	 
	Event e = new Event();
	Customer c = new Customer();
	Scanner sc = new Scanner(System.in);
	IBookingSystemRepo dao = new IBookingSystemRepo();
	
	
	public Event addEvent() throws EventNotFoundException, EventDateInvalidException, EventTimeInvalidException
	{
		
		System.out.println("Enter name of event: ");
		String ename = sc.next();
		e.setEventName(ename);
		
		System.out.println("Enter Event date in yyyy-MM-dd format: ");
        String dateStr = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date edate = new Date(sdf.parse(dateStr).getTime());
            e.setEventDate(edate);
        } catch (ParseException e1) {
            
            throw new EventDateInvalidException("Enter in yyyy-MM-dd format");
            
        }
		
		System.out.println("Enter Event time in HH:mm:ss format: ");
		String ti = sc.next();
		try {
			LocalTime lt = LocalTime.parse(ti);
			e.setEventTime(lt);
		}catch (DateTimeParseException dtpe) {
			throw new EventTimeInvalidException("Enter in HH:mm:ss format");
		}
		
		
		
		System.out.println("Enter the venue name: ");
		String vname = sc.next();
		e.setVenueName(vname);
		
		System.out.println("Enter total no. of seats: ");
		int tseats = sc.nextInt();
		e.setTotalSeats(tseats);;
		
		System.out.println("Enter the type of event, i.e Movie, Sports or Concert: ");
		String eType = sc.next();
		
	
		if(eType.equalsIgnoreCase("Movie"))
			e.setEventType(EventTypes.Movie);
		else if (eType.equalsIgnoreCase("Concert"))
			e.setEventType(EventTypes.Concert);
		else if(eType.equalsIgnoreCase("Sports"))
			e.setEventType(EventTypes.Sports);
		else
		{
			System.out.println("Event type is invalid ");
			throw new EventNotFoundException (eType);
		}
		
		System.out.println("Enter the price of ticket: ");
		float tprice = sc.nextFloat();
		e.setTicketPrice(tprice);
		
		e.setAvailableSeats();
		try {
			e = createEvent(e.getEventName(),e.getEventTime(),e.getEventDate(),e.getTotalSeats(),
					e.getTicketPrice(),e.getEventType(),e.getVenueName());
		} catch (EventNotFoundException e1) {
			e1.printStackTrace();
		}
		dao.insertEvent(e);
		return e;
		
	}
	private static Event createEvent(String eventName, LocalTime eventTime, Date eventDate, int totalSeats,
			float ticketPrice, EventTypes eventType, String venueName) throws EventNotFoundException {
		Event event = null;
        switch (eventType) {
            case Movie:
                System.out.print("Enter movie genre: ");
                String genre = new Scanner(System.in).nextLine();
                System.out.print("Enter actor name: ");
                String actorName = new Scanner(System.in).nextLine();
                System.out.print("Enter actress name: ");
                String actressName = new Scanner(System.in).nextLine();
                event = new Movie(eventName,eventDate, eventTime,venueName,totalSeats,ticketPrice,eventType,genre,actorName,actressName);
                break;
            case Concert:
                System.out.print("Enter artist name: ");
                String artistName = new Scanner(System.in).nextLine();
                System.out.print("Enter concert type: ");
                String concertType = new Scanner(System.in).nextLine();
                event = new Concert(eventName,eventDate, eventTime,venueName,totalSeats,ticketPrice,eventType,artistName,concertType);
                break;
            case Sports:
                System.out.print("Enter sport name: ");
                String sportName = new Scanner(System.in).nextLine();
                System.out.print("Enter teams playing: ");
                String teamsName = new Scanner(System.in).nextLine();
                event = new Sports(eventName,eventDate, eventTime,venueName,totalSeats,ticketPrice,eventType, sportName, teamsName);
                break;
            default:
                throw new EventNotFoundException("Event not found !!");
        }
        if (event != null) {
           
            System.out.println("Event created successfully!");
        }
        return event;	
	}
	
	public void revenue()
	{
		
		e.calculateTotalRevenue();
	}
	
	public void cancelT()
	{
		
		System.out.println("Enter the no. of tickets to be cancelled : ");
		int num = sc.nextInt();
		e.cancelBooking(num);
	}
	
	public void display()
	{	
	dao.showEvents();
	}
	public void bookedTickets()
	{
		
		System.out.println("Total no. of booked tickets: "+ e.getBookedTickets());
			
	}
	public void deleteEvent()
	{
		System.out.println("Enter Event ID to delete: ");
		int eid = sc.nextInt();
		dao.deleteEvent(eid);
	}

	

	
}
