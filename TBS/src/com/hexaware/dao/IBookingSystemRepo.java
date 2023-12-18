package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.util.MyDBConnection;
import com.hexaware.entity.*;

public class IBookingSystemRepo {
    Connection connection;
    Statement statement;
    PreparedStatement ps;
    ResultSet rs;
    
   

    public void insertEvent(Event event) 
    {
        try {
        	connection = MyDBConnection.getMyDbConnection();
            ps = connection.prepareStatement("insert into  addevent (event_name,event_date, event_time, venue_name, total_seats, event_type, ticket_price,genre,actor_name,actress_name,artist_name,concert_type,sport_name,teams_name) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, event.getEventName());
            ps.setDate(2, (Date) event.getEventDate());

            java.sql.Time sqlTime = java.sql.Time.valueOf(event.getEventTime());
            ps.setTime(3, sqlTime);
            ps.setString(4, event.getVenueName());
            ps.setInt(5, event.getTotalSeats());
            ps.setString(6, event.getEventType().toString());
            ps.setFloat(7, event.getTicketPrice());
            if (event.getEventType().toString().equalsIgnoreCase("movie"))
            {
            	Movie m = (Movie)event;
            	ps.setString(8,m.getGenere());
            	ps.setString(9,m.getActorName());
            	ps.setString(10,m.getActressName());
            	ps.setString(11,"");
            	ps.setString(12,"");
            	ps.setString(13,"");
            	ps.setString(14,"");
            	
            }
            else if (event.getEventType().toString().equalsIgnoreCase("concert"))
            {
            	Concert c = (Concert)event;
            	ps.setString(8,"");
            	ps.setString(9,"");
            	ps.setString(10,"");
            	ps.setString(11,c.getArtist());
            	ps.setString(12,c.getType());
            	ps.setString(13,"");
            	ps.setString(14,"");
            	
            	
            }
            else if (event.getEventType().toString().equalsIgnoreCase("sports"))
            {
            	Sports s = (Sports)event;
            	ps.setString(8,"");
            	ps.setString(9,"");
            	ps.setString(10,"");
            	ps.setString(11,"");
            	ps.setString(12,"");
            	ps.setString(13,s.getSportName());
            	ps.setString(14,s.getTeamsName());
            }
            

            int noofrows = ps.executeUpdate();
            System.out.println(noofrows + " inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showEvents() 
    {
        try {
        	connection = MyDBConnection.getMyDbConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select Event_ID, event_name,event_date, event_time, venue_name, total_seats, event_type, ticket_price,genre,actor_name,actress_name,artist_name,concert_type,sport_name,teams_name from addevent");
            while (rs.next()) {
            	 System.out.println("Event ID  : " + rs.getInt(1));
                System.out.println("Event Name  : " + rs.getString(2));
                System.out.println("Event Date : " + rs.getDate(3));
                System.out.println("Event Time  : " + rs.getTime(4));
                System.out.println("Venue Name  : " + rs.getString(5));
                System.out.println("Total Seats : " + rs.getInt(6));
                System.out.println("Event Type : " + rs.getString(7));
                System.out.println("Ticket Price : " + rs.getFloat(8));
                if (rs.getString(7).equalsIgnoreCase("movie"))
                {
                	System.out.println("Genre : " + rs.getString(9));
                	System.out.println("Actor Name : " + rs.getString(10));
                	System.out.println("Actress Name : " + rs.getString(11));
                	
                }
                else if (rs.getString(7).equalsIgnoreCase("concert"))
                {
                	System.out.println("Artist Name : " + rs.getString(12));
                	System.out.println("Concert Type : " + rs.getString(13));
                	
                }
                else if (rs.getString(7).equalsIgnoreCase("sports"))
                {
                	System.out.println("Sport Name : " + rs.getString(14));
                	System.out.println("Teams Name : " + rs.getString(15));
                	
                }
                
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEvent(int eid)
    {
    	try {
    		connection = MyDBConnection.getMyDbConnection();
    		ps = connection.prepareStatement("Delete from addevent where event_ID = ?");
    		ps.setInt(1, eid);
    		int noofrows = ps.executeUpdate();
    		System.out.println(eid + " deleted successfully !!");
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
}
