
package newpackage;

import java.util.*;

public class Ticket {
    private int id;
    private Movie movie=new Movie();
    private Cinema cinema=new Cinema();
    private double balance;
    private int noOfSeats;
    private ArrayList<Integer> seats=new ArrayList<Integer>();
    private Slot slot=new Slot();
    private Schedule schedule=new Schedule();
    private String day;
    private static int count=1;
    private Genre genre=new Genre();
    Ticket()
    {
        id=count;
        count++;
    }
    public ArrayList<Integer> getSeats()
    {
        return seats;
    }
    public void setSeatd(ArrayList<Integer> s)
    {
        seats=s;
    }
    public Schedule getSchedule()
    {
        return schedule;
    }
    public void setSchedule(Schedule s)
    {
        schedule=s;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        //this.movie.loadFeedback();
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
        //this.cinema.loadSchedule();
        //this.cinema.loadMovieList();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int aCount) {
        count = aCount;
    }
    public String getDay()
    {
        return day;
    }
    public void setDay(String d)
    {
        day=d;
    }
    public void setGenre(Genre g)
    {
        genre=g;
    }
    public Genre getGenre()
    {
        return genre;
    }
    public double calculateBalance()
    {
        if(day.equals("Wednesday"))
        {
            //Student Offer 10% discount
            balance=noOfSeats*cinema.getPricePerTicket();
            double dis=(10/100)*balance;
            balance=balance-dis;
        }
        else if(day.equals("Sunday"))
        {
            //Family Day Discount 20%
            balance=noOfSeats*cinema.getPricePerTicket();
            double dis=(20/100)*balance;
            balance=balance-dis;
        }
        else if(day.equals("Friday"))
        {
            //Jumma Discount 30%
            balance=noOfSeats*cinema.getPricePerTicket();
            double dis=(30/100)*balance;
            balance=balance-dis;
        }
        else
        {
            balance=noOfSeats*cinema.getPricePerTicket();
        }
        return balance;
    }
    public void generateTicket()
    {
        System.out.println("-----------"+cinema.getName()+"----------");
        System.out.println("Id: "+id);
        System.out.println(movie.getTitle());
        System.out.println(slot.getStartTime()+" - "+slot.getEndTime());
        System.out.println("Balance: "+balance);
        
    }
}
