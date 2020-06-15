
package newpackage;
import java.sql.ResultSet;
import java.util.*;
public class Movie {
    private String title;
    private Genre genre=new Genre();
    private String description;
    private ArrayList<Feedback> feedback=new ArrayList<Feedback>();
    int id;
    private dbConnectivity obj=dbConnectivity.getInstance();
    Movie(int i,String t,String d,Genre g)
    {
        id=i;        
        title=t;
        description=d;
        genre=g;
    }
    Movie(){}
    void loadFeedback()
    {
        try
        {
            String q="select * from feedback where movieID="+id+"";
            ResultSet rs=obj.getStmt().executeQuery(q);
            while(rs.next())
                {
                    String uname=rs.getString(2);
                    int rating=rs.getInt(3);
                    String review=rs.getString(4);
                    Feedback f=new Feedback(uname,rating,review);
                    //addFeedbackinList(f);
                    feedback.add(f);
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void addFeedback(Feedback f)
    {
        getFeedback().add(f);
        try
        {
            String q="insert into feedback values ("+id+",'"+f.getUsername()+"','"+f.getRating()+"','"+f.getReview()+"')";
            ResultSet rs=obj.getStmt().executeQuery(q);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public double avgRating()
    {
        double sum=0;
        for(int i=0;i<getFeedback().size();i++)
        {
            sum+=getFeedback().get(i).getRating();
        }
        return sum/getFeedback().size();
    }
    public int getID()
    {
        return id;
    }
    public void setID(int i)
    {
        id=i;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(ArrayList<Feedback> feedback) {
        this.feedback = feedback;
    }
    public void printMovie()
    {
        System.out.println(id);
        System.out.println(title);
        System.out.println(genre.getGenreName());
        System.out.println(description);
        for(int i=0;i<feedback.size();i++)
        {
            feedback.get(i).printFeedback();
        }
        
        System.out.println("\n\n");
    }
}
