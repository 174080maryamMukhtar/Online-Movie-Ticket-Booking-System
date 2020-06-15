
package newpackage;


public class Genre {
    String name;
    Genre()
    {
        
    }
    Genre(String n)
    {
        name=n;
    }
    void setGenreName(String n)
    {
        name=n;
    }
    public String getGenreName()
    {
        return name;
    }
    void printGenre()
    {
        System.out.println(name);
    }
}
