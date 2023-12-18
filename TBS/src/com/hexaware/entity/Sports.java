package com.hexaware.entity;

import java.time.LocalTime;
import java.sql.Date;

public class Sports extends Event
{
	private String sportName, teamsName;
	
	

	public Sports()
	{
		super();
		this.sportName="";
		this.teamsName = "";
	}
	
	 public Sports(String eventName, Date eventDate, LocalTime eventTime, String venueName, int totalSeats, float ticketPrice, EventTypes eventType,String sportName, String teamsName) 
	 {
		 super(eventName,eventDate, eventTime,venueName,totalSeats,ticketPrice,eventType);
	     this.sportName = sportName;
	     this.teamsName = teamsName;
	 }
	 public String getSportName() {
			return sportName;
		}

		public void setSportName(String sportName) {
			this.sportName = sportName;
		}

		public String getTeamsName() {
			return teamsName;
		}

		public void setTeamsName(String teamsName) {
			this.teamsName = teamsName;
		}
	 
	 public void displayEventDetails() 
	 {
	     super.displayEventDetails(); 
	     System.out.println("Sport: " + sportName);
	     System.out.println("Teams: " + teamsName);
	 }
}
  