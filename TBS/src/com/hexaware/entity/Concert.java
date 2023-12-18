package com.hexaware.entity;

import java.time.LocalTime;
import java.sql.Date;

public class Concert extends Event
{
	private String artist,type;
	
	

	public Concert()
	{
		 super(); 
	     this.artist = "";
	     this.type = "";
	}
	
	public Concert(String eventName, Date eventDate, LocalTime eventTime, String venueName, int totalSeats, float ticketPrice, EventTypes eventType, String artist, String type)
	{
		super(eventName,eventDate, eventTime,venueName,totalSeats,ticketPrice,eventType);
		this.artist=artist;
		this.type=type;
	}
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void displayEventDetails() 
	{
        super.displayEventDetails(); 
        System.out.println("Artist: " + artist);
        System.out.println("Type: " + type);
    }
}


