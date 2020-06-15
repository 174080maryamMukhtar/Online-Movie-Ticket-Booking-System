
package newpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class OnlineMovieTicketBookingSystem {
    private ArrayList<Cinema> cinemaList=new ArrayList<>();
    private ArrayList<Movie> movieList=new ArrayList<>();
    private Registration registeredUsers=Registration.getInstance();
    private User currentUser;
    private Ticket ticket=new Ticket();
    private ArrayList<Slot> slotList=new ArrayList<>();
    private ArrayList<Genre> genreList=new ArrayList<>();
    private dbConnectivity obj=dbConnectivity.getInstance();
    private static OnlineMovieTicketBookingSystem omt;
    private AdminHelper adm=new AdminHelper();
    private OnlineMovieTicketBookingSystem()
    {
        try
        {
            registeredUsers.loadUsers();
            /////////////
            registeredUsers.printUsers();
            ////////////
            String s="select * from slot";
            ResultSet r=obj.getStmt().executeQuery(s);
            while(r.next())
            {
             String st=r.getString(2);
             String et=r.getString(3);
             Slot ss=new Slot(st,et);
             slotList.add(ss);
            }
            String q="Select * from genre";
            ResultSet rs=obj.getStmt().executeQuery(q);
            while(rs.next())
            {
                int id=rs.getInt(1);
                String n=rs.getString(2);
                Genre g=new Genre(n);
                genreList.add(g);
            }
            
            ////////////////
            for(int i=0;i<genreList.size();i++)
            {
                genreList.get(i).printGenre();
            }
            /////////////
            ArrayList <Integer> genreidlist=new ArrayList<>();
            q="Select * from movies";
            rs=obj.getStmt().executeQuery(q);
            while(rs.next())
            {
                int id=rs.getInt(1);
                int genreid=rs.getInt(2);
                String title=rs.getString(3);
                String des=rs.getString(4);
                genreidlist.add(genreid);
                /*String q2="select * from genre where genreID="+genreid+"";
                ResultSet rs2=obj.getStmt().executeQuery(q2);
                String genre="";
                while(rs2.next())
                {
                    genre=rs2.getString(2);
                }
                Genre g=new Genre(genre);*/
                //Movie m=new Movie(id,title,des,g);
                Movie m=new Movie();
                m.setID(id);
                m.setTitle(title);
                m.setDescription(des);
                movieList.add(m);
            }
            for(int i=0;i<movieList.size();i++)
            {
                int temp=genreidlist.get(i);
                String q2="select * from genre where genreID="+temp+"";
                ResultSet rs2=obj.getStmt().executeQuery(q2);
                String gname="";
                while(rs2.next())
                {
                    gname=rs2.getString(2);
                }
                
                Genre g=new Genre(gname);
                movieList.get(i).setGenre(g);
            }
            //---------------Adding feedback list in each movie--------------//
            
            for(int i=0;i<movieList.size();i++)
            {
                movieList.get(i).loadFeedback();
            }
            
            //////////////
            for(int i=0;i<movieList.size();i++)
            {
                movieList.get(i).printMovie();
            }
            //////////////
            
            q="select * from cinemas";
            rs=obj.getStmt().executeQuery(q);
            while(rs.next())
            {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String loc=rs.getString(3);
                String contact=rs.getString(4);
                String email=rs.getString(5);
                int price=rs.getInt(6);
                Cinema c=new Cinema(id,name,loc,contact,email,price);
                //c.loadSchedule();
                cinemaList.add(c);                                                                                                                                                 
            }
            for(int i=0;i<cinemaList.size();i++)
            {
                cinemaList.get(i).loadSchedule();
                cinemaList.get(i).loadMovieList();
            }
            
            //////////////
            for(int i=0;i<cinemaList.size();i++)
            {
                cinemaList.get(i).printCinema();
            }
            //////////////
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public static OnlineMovieTicketBookingSystem getInstance()
    {
        if(getOmt()!=null)
        {
            return getOmt();
        }
        else
        {
            setOmt(new OnlineMovieTicketBookingSystem());
            return getOmt();
        }
    }
    public static void setOmt(OnlineMovieTicketBookingSystem o)
    {
        omt=o;
    }
    public static OnlineMovieTicketBookingSystem getOmt()
    {
        return omt;
    }
    public Cinema getCinemaFromList(String name)
    {
        
        for(int i=0;i<cinemaList.size();i++)
        {
            if(cinemaList.get(i).getName().equals(name))
            {
                return cinemaList.get(i);
            }
        }
        return null;
    }
   
    public ArrayList<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(ArrayList<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public Registration getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(Registration registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    public AdminHelper getAdminHelper()
    {
        return adm;
    }
    public void setAdminHelper(AdminHelper a)
    {
        adm=a;
    }
    public void setCurrentUser(User currentUser) {
        
        if(currentUser.getType().equals("customer"))
        {
            
            this.currentUser=new Customer(currentUser.getName(),currentUser.getAge(),currentUser.getUsername(),currentUser.getPassword(),currentUser.getEmail(),currentUser.getContactNumber(),currentUser.getType());
        }
        else if(currentUser.getType().equals("admin"))
        {
            this.currentUser=new Admin(currentUser.getName(),currentUser.getAge(),currentUser.getUsername(),currentUser.getPassword(),currentUser.getEmail(),currentUser.getContactNumber(),currentUser.getType());
        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(ArrayList<Genre> genreList) {
        this.genreList = genreList;
    }
    public ArrayList<Movie> displayTopRatedMovies()
    {
        ArrayList<Movie> m=new ArrayList<>();
        Movie m1=new Movie();
        Movie m2=new Movie();
        Movie m3=new Movie();
        double a1,a2,a3;
        a1=0;
        a2=0;
        a3=0;
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).avgRating()>a1)
            {
                a3=a2;
                a2=a1;
                a1=movieList.get(i).avgRating();
                m3=m2;
                m2=m1;
                m1=movieList.get(i);
            }
            else if(movieList.get(i).avgRating()>a2)
            {
                a3=a2;
                a2=movieList.get(i).avgRating();
                m3=m2;
                m2=movieList.get(i);
            }
            else if(movieList.get(i).avgRating()>a3)
            {
               a3= movieList.get(i).avgRating();
               m3=movieList.get(i);
            }
        }
        m.add(m1);
        m.add(m2);
        m.add(m3);
        return m;
    }
    public Movie getMovieByName(String m)
    {
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getTitle().equals(m))
            {
                return movieList.get(i);
            }
        }
        return null;
    }
    public Slot getSlotByTime(String s)
    {
        for(int i=0;i<slotList.size();i++)
        {
            if(slotList.get(i).getStartTime().equals(s))
            {
                return slotList.get(i);
            }
        }
        return null;
    }
    public Schedule getScheduleObject(Cinema c,Movie m,Slot s,String d)
    {
        
        for(int i=0;i<cinemaList.size();i++)
        {
            if(cinemaList.get(i).equals(c))
            {
                for(int j=0;j<cinemaList.get(i).getSchedule().size();j++)
                {
                    if(cinemaList.get(i).getSchedule().get(j).getScheduleOb(m,s,d)!=null)
                    {
                        return cinemaList.get(i).getSchedule().get(j).getScheduleOb(m,s,d);
                    }
                }
            }
        }
        return null;
    }
    public void addScheduleInCinema(Cinema c,Schedule s)
    {
        for(int i=0;i<cinemaList.size();i++)
        {
            if(cinemaList.get(i).getName().equals(c.getName()))
            {
                cinemaList.get(i).addSchedule(s);
            }
        }
    }
    public void deleteMovieFromCinema(Cinema c,Movie m)
    {
        for(int i=0;i<cinemaList.size();i++)
        {
            if(cinemaList.get(i).getName().equals(c.getName()))
            {
                cinemaList.get(i).deleteMovie(m);
            }
        }
    }
    public void deleteSchedule(Cinema c,Movie m,Slot s,Genre g,String day)
    {
        for(int i=0;i<cinemaList.size();i++)
        {
            if(cinemaList.get(i).getName().equals(c.getName()))
            {
                Schedule ss=cinemaList.get(i).getScheduleObject(m, s, g, day);
                
                cinemaList.get(i).deleteScheduleFromCinema(ss);
            }
        }
    }
    public void changeMovieScheduleInCinema(Cinema c,Movie m,Slot s,Genre g,String day)
    {
        for(int i=0;i<cinemaList.size();i++)
        {
            if(cinemaList.get(i).getName().equals(c.getName()))
            {
                Schedule ss=cinemaList.get(i).getScheduleObject(m, s, g, day);
                
                cinemaList.get(i).changeMovieInSchedule(m,ss);
            }
        }
    }

}
