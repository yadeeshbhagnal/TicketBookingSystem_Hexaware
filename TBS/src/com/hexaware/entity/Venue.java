package com.hexaware.entity;

public class Venue {
	private String venueName, address;
	
	@Override
	public String toString() {
		return "Venue [venueName=" + venueName + ", address=" + address + "]";
	}

	public Venue()
	{
		
	}
	
	public Venue(String venueName, String address)
	{
		this.venueName = venueName;
		this.address = address;
	}
	
	public String getVenueName()
	{
		return venueName;
	}
	public void setVenueName (String venueName)
	{
		this.venueName= venueName;
	}
	
	public String getAddress()
	{
		return address;
	}
	public void getAddress(String address)
	{
		this.address=address;
	}
	
	public void displayVenueDetails()
	{
		System.out.println("Venue name: "+venueName);
		System.out.println("Address: "+address);
	}
	
	
}
