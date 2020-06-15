
package newpackage;

import java.sql.ResultSet;
import java.util.*;

public class Cinema {
    private String name;
    private String location;
    private String contactNumber;
    private String email;
    private int pricePerTicket;
    private  ArrayList<Schedule> schedule=new ArrayList<Schedule>();
    private ArrayList<Movie> movieList=new ArrayList<Movie>();
    private dbConnectivity obj=dbConnectivity.getInstance();
    int id;
    Cinema()
    {
        
    }
    Cinema(int i,String n,String l,String c,String e, int p)
    {
        id=i;
        name=n;
        location=l;
        contactNumber=c;
        email=e;
        pricePerTicket=p;
    }
    public void loadMovieList()
    {
        for(int i=0;i<schedule.size();i++)
        {
            Movie m=schedule.get(i).getMovie();
            movieList.add(m);
        }
    }
    /*public void loadSchedule()
    {
        try
        {
            String q="select * from schedule where cinemaid="+id+"";
            ResultSet rs=obj.getStmt().executeQuery(q);
            while(rs.next())
            {
                int scheduleid=rs.getInt(1);
                 String d=rs.getString(2);
                 int gid=rs.getInt(3);
                 int mid=rs.getInt(4);
                 int slotid=rs.getInt(5);
                 //int hallid=rs.getInt(6);
                 
                 ResultSet rs2=obj.getStmt().executeQuery("select * from genre where genreID="+gid+"");
                 String genre=rs2.getString(2);
                 Genre g=new Genre(genre);
                 rs2=obj.getStmt().executeQuery("select * from movies where movieID="+mid+"");
                 String title=rs2.getString(3);
                 String des=rs2.getString(4);
                 Movie movie=new Movie(mid,title,des,g);
                 movie.loadFeedback();
                 
                 rs2=obj.getStmt().executeQuery("select * from slot where slotID="+slotid+"");
                 String st=rs2.getString(2);
                 String et=rs2.getString(3);
                 Slot slot=new Slot(st,et);
                 rs2=obj.getStmt().executeQuery("select * from hall where scheduleID="+scheduleid+"");
                 
                 int hallid=rs2.getInt(1);
                 int bseats=rs2.getInt(2);
                 int mseats=rs2.getInt(3);
                 Hall hall=new Hall();
                 hall.setID(hallid);
                 hall.setBookedSeats(bseats);
                 hall.setMaxSeats(mseats);
                 rs2=obj.getStmt().executeQuery("select * from seats where hallID="+hallid+"");
                 
                 ArrayList<Seat> seats=new ArrayList<>();
                 if(rs2.next())
                 {
                     while(rs2.next())
                    {
                        int seatno=rs2.getInt(2);
                        int s=rs2.getInt(3);
                        boolean status;
                        if(s==0)
                        {
                            status=false;
                        }
                        else
                        {
                            status=true;
                        }
                        Seat se=new Seat();
                        se.setSeatNumber(seatno);
                        se.setStatus(status);
                        seats.add(se);
                    }
                    hall.setSeats(seats);
                 }
                 
                 Schedule sch=new Schedule(scheduleid,g,movie,d,slot,hall);
                 schedule.add(sch);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }*/
    public void loadSchedule()
    {
        try
        {
            String q="select * from schedule where cinemaid="+id+"";
            ResultSet rs=obj.getStmt().executeQuery(q);
            ArrayList <Integer> gidlist=new ArrayList<>();
            ArrayList <Integer> midlist=new ArrayList<>();
            ArrayList <Integer> sidlist=new ArrayList<>();
            while(rs.next())
            {
                Schedule sch=new Schedule();
                int sid=rs.getInt(1);
                sch.setID(sid);
                String day=rs.getString(2);
                sch.setDay(day);
                int gid=rs.getInt(3);
                gidlist.add(gid);
                int mid=rs.getInt(4);
                midlist.add(mid);
                int slotid=rs.getInt(5);
                sidlist.add(slotid);
                
                Schedule.setCount(Schedule.getCount()+1);
                schedule.add(sch);
            }
            
            
            ////////////  Loading genre  ////////
            for(int i=0;i<schedule.size();i++)
            {
                int g=gidlist.get(i);
                ResultSet rs2=obj.getStmt().executeQuery("select * from genre where genreID="+g+"");
                String gname="";
                while(rs2.next())
                {
                    gname=rs2.getString(2);
                }                
                Genre gen=new Genre(gname);
                schedule.get(i).setGenre(gen);
                
                //////////// Loading Movie /////////////
                int m=midlist.get(i);
                ResultSet rs3=obj.getStmt().executeQuery("select * from movies where movieID="+m+"");
                String title="";
                String des="";
                while(rs3.next())
                {
                    title=rs3.getString(3);
                    des=rs3.getString(4);
                }
                 
                Movie movie=new Movie(m,title,des,gen);
                movie.loadFeedback();
                schedule.get(i).setMovie(movie);
                
                
                //////////// Loading Slot /////////////
                
                int s=sidlist.get(i);
                ResultSet rs4=obj.getStmt().executeQuery("select * from slot where slotID="+s+"");
                String st="";
                String et="";
                while(rs4.next())
                {
                    st=rs4.getString(2);
                    et=rs4.getString(3);
                }
                Slot slot=new Slot(st,et);
                schedule.get(i).setSlot(slot);
            }
            
            
            ////////////////  Loading Hall and Seats  /////////////////////
            for(int i=0;i<schedule.size();i++)
            {
                int scheduleid=schedule.get(i).getID();
                ResultSet rs5=obj.getStmt().executeQuery("select * from hall where scheduleID="+scheduleid+"");
                int hallid=0;
                int bseats=0;
                int mseats=0;
                while(rs5.next())
                {
                    hallid=rs5.getInt(1);
                    bseats=rs5.getInt(2);
                    mseats=rs5.getInt(3);

                }
                Hall hall=new Hall();
                hall.setID(hallid);
                hall.setBookedSeats(bseats);
                hall.setMaxSeats(mseats);                
                schedule.get(i).setHall(hall);
                
                ResultSet rs6=obj.getStmt().executeQuery("select * from seats where hallID="+hallid+"");
                 
                 ArrayList<Seat> seats=new ArrayList<>();
                 //if(rs6.next())
                 //{
                     while(rs6.next())
                    {
                        int seatno=rs6.getInt(2);
                        int s=rs6.getInt(3);
                        boolean status=false;
                        if(s==0)
                        {
                            status=false;
                        }
                        else
                        {
                            status=true;
                        }
                        Seat se=new Seat();
                        se.setSeatNumber(seatno);
                        se.setStatus(status);
                        seats.add(se);
                    }
                //}
                schedule.get(i).getHall().setSeats(seats);
            }
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPricePerTicket() {
        return pricePerTicket;
    }

    public void setPricePerTicket(int pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }
    
    public ArrayList<Schedule> getScheduleByMovie1(String movieName)
    {
        ArrayList<Schedule> temp=new ArrayList<Schedule>();
        for(int i=0;i<schedule.size();i++)
        {
            if(schedule.get(i).getMovie().getTitle().equals(movieName))
            {
                temp.add(schedule.get(i));
            }
        }
        return temp;
    }
    public ArrayList<Schedule> getScheduleByMovie(String movieName,String day)
    {
        ArrayList<Schedule> temp=new ArrayList<Schedule>();
        for(int i=0;i<schedule.size();i++)
        {
            if(schedule.get(i).getMovie().getTitle().equals(movieName) && schedule.get(i).getDay().equals(day))
            {
                temp.add(schedule.get(i));
            }
        }
        return temp;
    }
    public ArrayList<Schedule> getScheduleByWeekday(String day,String genre)
    {
        ArrayList<Schedule> temp=new ArrayList<Schedule>();
        for(int i=0;i<schedule.size();i++)
        {
            if(schedule.get(i).getGenre().getGenreName().equals(genre) && schedule.get(i).getDay().equals(day))
            {
                temp.add(schedule.get(i));
            }
        }
        return temp;
    }
    void deleteScheduleFromCinema(Schedule s)
    {
        //try
        //{
            for(int i=0;i<schedule.size();i++)
            {
                if(schedule.get(i).getID()==s.getID())
                {
                    schedule.remove(i); //removing by index
                    System.out.println("SCHEDULE REMOVED");
                    /*System.out.println("___________________________________________"+s.getID()+"_________________________________");
                    String t="delete from seats where hallid="+s.getHall().getID()+"";
                    obj.getStmt().executeQuery(t);
                    String p="delete from hall where scheduleid="+s.getID()+"";
                    obj.getStmt().executeQuery(p);
                    String q="delete from Schedule where scheduleID="+s.getID()+" ";
                    obj.getStmt().executeQuery(q);*/
                }
            }           
        //}
        //catch(Exception e)
        //{
           // System.out.println(e);
        //}
    }
    Schedule getScheduleObject(Movie m,Slot s,Genre g,String day)
    {
        for(int i=0;i<schedule.size();i++)
        {
            if(schedule.get(i).getMovie().getTitle().equals(m.getTitle()) && schedule.get(i).getSlot().getStartTime().equals(s.getStartTime()) && schedule.get(i).getGenre().getGenreName().equals(g.getGenreName()) && schedule.get(i).getDay().equals(day))
            {
                return schedule.get(i);
            }
        }
        return null;
    }
    void changeMovieInSchedule(Movie m,Schedule s)
    {
        try
        {
            for(int i=0;i<schedule.size();i++)
            {
                if(schedule.get(i).equals(s))
                {
                    schedule.get(i).setMovie(m);
                    String q="update schedule set movieid="+m.getID()+" where scheduleID="+s.getID()+"";
                    obj.getStmt().executeQuery(q);
                }
            }  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void addSchedule(Schedule s)
    {
        try
        {
            schedule.add(s);
            int gid=0;
            if(s.getGenre().getGenreName().equals("Horror"))
            {
                gid=1;
            }
            else if(s.getGenre().getGenreName().equals("Comedy"))
            {
                gid=2;
            }
            else if(s.getGenre().getGenreName().equals("Action"))
            {
                gid=3;
            }
            else if(s.getGenre().getGenreName().equals("Animated"))
            {
                gid=4;
            }
            else if(s.getGenre().getGenreName().equals("Romance"))
            {
                gid=5;
            }

            int sid=0;
            if(s.getSlot().getStartTime().equals("9 a.m"))
            {
                sid=1;
            }
            else if(s.getSlot().getStartTime().equals("1 p.m"))
            {
                sid=2;
            }
             else if(s.getSlot().getStartTime().equals("5 p.m"))
            {
                sid=3;
            }
             else if(s.getSlot().getStartTime().equals("9 p.m"))
            {
                sid=4;
            }
            String q="insert into schedule values("+s.getID()+",'"+s.getDay()+"',"+gid+","+s.getMovie().getID()+","+sid+","+id+")";
            s.getHall().setID(s.getID());
            s.getHall().setMaxSeats(50);
            s.getHall().setBookedSeats(0);
            obj.getStmt().executeQuery(q);
            q="insert into Hall values ("+s.getID()+",0,50,"+s.getID()+")";
            schedule.add(s);
        }
        catch(Exception e)
        {
            
        }
    }
    void deleteMovie(Movie m)
    {
        for(int i=0;i<movieList.size();i++)
        {
            if(movieList.get(i).getTitle().equals(m.getTitle()))
            {
                movieList.remove(i);    //removing by index
                //movieList.remove(m);    //removing the object directly
            }
        }
        for(int i=0;i<schedule.size();i++)
        {
            if(schedule.get(i).getMovie().getTitle().equals(m.getTitle()))
            {
                schedule.remove(i);
            }
        }
        try
        {
            String q="delete from Schedule where cinemaid="+id+" and movieid="+m.getID()+" ";
            obj.getStmt().executeQuery(q);
        }
        catch(Exception e)
        {
            
        }
    }
    void printCinema()
    {
        System.out.println(name);
        System.out.println(location);
        System.out.println(contactNumber);
        for(int i=0;i<schedule.size();i++)
        {
            System.out.println("Id: "+schedule.get(i).getID());
            System.out.println("Day: "+schedule.get(i).getDay());
            System.out.println("Genre: "+schedule.get(i).getGenre().getGenreName());
            System.out.println("Movie: "+schedule.get(i).getMovie().getTitle());
            System.out.println("Slot: "+schedule.get(i).getSlot().getStartTime()+" - "+schedule.get(i).getSlot().getEndTime());
            System.out.println("Hall: "+schedule.get(i).getHall().getID());
            ArrayList<Seat> s=schedule.get(i).getHall().getSeats();
            if(s.isEmpty())
            {
                System.out.println("No Booked Seats\n\n");
            }
            else
            {
                for(int k=0;k<s.size();k++)
                {
                    System.out.println("Seat Number: "+s.get(k).getSeatNumber());
                    if(s.get(k).isFree())
                    {
                        System.out.println("Seat Free");
                    }
                    else
                    {
                        System.out.println("Seat Booked");
                    }
                    
                }
            }
            System.out.println("-----------------------------------------------");
        }
    }
    
    
}
