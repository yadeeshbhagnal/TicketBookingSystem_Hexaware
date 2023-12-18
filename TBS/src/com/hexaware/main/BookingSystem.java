package com.hexaware.main;

import java.util.*;
import com.hexaware.entity.*;
import java.time.*;

public abstract class BookingSystem {
    protected ArrayList<Event> events = new ArrayList<>();

    
    public abstract Event create_event(String event_name, Date date, LocalTime time, int total_seats, float ticket_price,
                                       String event_type, String venue_name);

    public abstract void display_event_details(Event event);

    public abstract void book_tickets(Event event, int num_tickets);

    public abstract void cancel_tickets(Event event, int num_tickets);

    public abstract int getAvailableNoOfTickets();
}
