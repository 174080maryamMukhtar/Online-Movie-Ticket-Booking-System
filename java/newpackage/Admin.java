
package newpackage;
import java.util.*;

public class Admin extends User{
    Admin(String n,int a,String uname,String pass,String em,String contact,String t)
    {
        super(n,a,uname,pass,em,contact,t);
    }
    void selectMovieToAdd(ArrayList<Cinema> cinemas,ArrayList<Movie> movielist)
    {
             // Frontend Connectivity && return type is not decided yet
    }
    void selectMovieToDelete(ArrayList<Cinema> cinemaList)
    {
             // Frontend Connectivity && return type is not decided yet
    }
    void updateSchedule(ArrayList<Cinema> cinemaList)
    {
        // Frontend Connectivity && return type is not decided yet
    }
    void viewWebsite(ArrayList<Cinema> cinemaList)
    {
        // Frontend Connectivity && return type is not decided yet
    }
    void deleteSchedule(ArrayList<Cinema> cinemaList)
    {
        // Frontend Connectivity && return type is not decided yet
    }
    Movie changeMovie(ArrayList<Movie> movieList)
    {
        // Frontend Connectivity
        return new Movie();
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
}
