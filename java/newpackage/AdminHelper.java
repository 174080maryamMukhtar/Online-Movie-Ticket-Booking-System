package newpackage;


public class AdminHelper 
{
    private int id;
    private Movie movie=new Movie();
    private Cinema cinema=new Cinema();
    private Slot slot=new Slot();
    private Schedule schedule=new Schedule();
    private String day;
    private Genre g=new Genre();
    
    AdminHelper()
    {
        
    }
    public Genre getGenre()
    {
        return g;
    }
    public void setGenre(Genre gg)
    {
        g=gg;
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
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
    
     public void setDay(String d)
    {
        day=d;
    }
     
     public String getDay()
    {
        return day;
    }
}