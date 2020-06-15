
package newpackage;

import java.util.*;
public class Customer extends User{
    Customer(String n,int a,String uname,String pass,String em,String contact,String t)
    {
        super(n,a,uname,pass,em,contact,t);
    }
    Schedule selectMovie(ArrayList<Schedule> schedule)
    {
        // Frontend Connectivity
        return new Schedule();
    }
    Genre selectGenre(ArrayList<Genre> genreList)
    {
        // Frontend Connectivity
        return new Genre();
    }
    Cinema selectCinema(ArrayList<Cinema> cinemaList)
    {
        // Frontend Connectivity
        return new Cinema();
    }
    int selectSeat(Hall hall)
    {
        // Frontend Connectivity
        return 0;
    }
    String searcMovieByName()
    {
        // Frontend Connectivity
        return null;
    }
    Feedback giveFeedback(Movie movie)
    {
        // Frontend Connectivity
        return new Feedback();
    }
}
