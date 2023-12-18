package com.hexaware.entity;
import java.sql.Date;
import java.time.*;
public abstract class EventAbstract{
    protected String eventName;
    protected Date eventDate;
    protected LocalTime eventTime;
    protected String venueName;
    protected int totalSeats;
    protected int availableSeats;
    protected float ticketPrice;
    protected EventTypes eventType;

    
    public abstract void calculateTotalRevenue();

    public abstract int getBookedTickets();

    public abstract void bookTickets(int numTickets);

    public abstract void cancelBooking(int numTickets);

    public abstract void displayEventDetails();
}
