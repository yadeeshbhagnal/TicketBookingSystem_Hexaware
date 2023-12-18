package com.hexaware.controller;

import com.hexaware.entity.Event;
import com.hexaware.exception.EventDateInvalidException;
import com.hexaware.exception.EventNotFoundException;
import com.hexaware.exception.EventTimeInvalidException;

public interface IEventServiceProvider {
	public Event addEvent() throws EventNotFoundException, EventDateInvalidException, EventTimeInvalidException;
	//public void bookTicket();
	public void revenue();
	public void cancelT();
	public void display();
	public void bookedTickets();
	
	
}
