
package newpackage;

import java.sql.ResultSet;
import java.util.*;

public class Hall {
    private int id;
    private ArrayList<Seat> seats=new ArrayList<Seat>();
    private int bookedSeats;
    private int maxSeats;
    private dbConnectivity obj=dbConnectivity.getInstance();
    Hall()
    {
        //bookedSeats=0;
        //maxSeats=30;
    }
    boolean bookSeat(int n)
    {
        if(seats.isEmpty()==false)
        {
            for(int i=0;i<seats.size();i++)
            {
                if(seats.get(i).getSeatNumber()==n)
                {
                    if(seats.get(i).isTaken())
                    {    
                        return false;
                    }
                }
            }
        }
        
        Seat s=new Seat(n);
        s.setStatus(false);
        seats.add(s);
        bookedSeats++;
        try
        {
            String q="insert into seats values("+id+","+n+",0)";
            ResultSet rs=obj.getStmt().executeQuery(q);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        /*if(getSeats().get(n-1).isFree())
        {
            getSeats().get(n-1).setStatus(false);
            return true;
        }
        return false;*/
        return true;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
    public void setID(int n)
    {
        id=n;
    }
    public int getID()
    {
        return id;
    }
    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }
    public boolean SeatBookedOrNot(int n)
    {
        for(int i=0;i<seats.size();i++)
        {
            if(seats.get(i).getSeatNumber()==n)
            {
                return true;
            }
        }
        return false;
    }
}
