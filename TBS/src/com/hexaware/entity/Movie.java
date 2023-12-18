package com.hexaware.entity;

import java.time.LocalTime;
import java.sql.Date;
public class Movie extends Event
{
	private String genre, actorName, actressName;
	
	public Movie()
	{
		super();
		this.genre="";
		this.actorName="";
		this.actressName="";
	}
	
	public Movie(String eventName, Date eventDate, LocalTime eventTime, String venueName, int totalSeats, float ticketPrice, EventTypes eventType, String genre, String actorName, String actressName)
	{
		super(eventName,eventDate, eventTime,venueName,totalSeats,ticketPrice,eventType);
		this.genre=genre;
		this.actorName= actorName;
		this.actressName= actressName;
	}
	
	

	public String getGenere() {
		return genre;
	}

	public void setGenere(String genere) {
		this.genre = genere;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActressName() {
		return actressName;
	}

	public void setActressName(String actressName) {
		this.actressName = actressName;
	}
	
	public void displayEventDetails() 
	{
        super.displayEventDetails(); 
        System.out.println("Genre: " + genre);
        System.out.println("Actor: " + actorName);
        System.out.println("Actress: " + actressName);
	
	}
}

