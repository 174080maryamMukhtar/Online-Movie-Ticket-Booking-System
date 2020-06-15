package newpackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Registration {
    ArrayList<User> registeredUsers=new ArrayList<User>();
    dbConnectivity obj=dbConnectivity.getInstance();
    private static Registration reg;
    private Registration()
    {
        
    }
    public static Registration getInstance()
    {
        if(getReg()!=null)
        {
            return getReg();
        }
        else
        {
            setReg(new Registration());
            return getReg();
        }
    }
    public static void setReg(Registration r)
    {
        reg=r;
    }
    public static Registration getReg()
    {
        return reg;
    }
    User login(String uname,String pass)
    {
        for(int i=0;i<registeredUsers.size();i++)
        {
            if(registeredUsers.get(i).getUsername().equals(uname) && registeredUsers.get(i).getPassword().equals(pass))
            {
                return registeredUsers.get(i);
            }
        }
        return null;
    }
    void registerUser(User user)
    {
        try
        {
            String q="insert into users values ('"+user.getName()+"','"+user.getType()+"',"+user.getAge()+",'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getContactNumber()+"')";
            obj.getStmt().execute(q);
            registeredUsers.add(user);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    boolean validUser(String uname)
    {
        for(int i=0;i<registeredUsers.size();i++)
        {
            if(registeredUsers.get(i).getUsername().equals(uname))
            {
                return false;
            }
        }
        return true;
    }
    User signup(String n,int a,String uname,String pass,String em,String contact,String t)
    {
        if(validUser(uname)==true)
        {
            return new User(n,a,uname,pass,em,contact,t);
        }
        return null;
    }
    void loadUsers()
    {
        try
        {
            String q="Select * from users";
            ResultSet rs=obj.getStmt().executeQuery(q);
            while(rs.next())
            {
                String n=rs.getString(1);
                String type=rs.getString(2);
                int age=rs.getInt(3);
                String uname=rs.getString(4);
                String pass=rs.getString(5);
                String email=rs.getString(6);
                String contact=rs.getString(7);
                User user=new User(n,age,uname,pass,email,contact,type);
                registeredUsers.add(user);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    void printUsers()
    {
        for(int i=0;i<registeredUsers.size();i++)
        {
            System.out.println(registeredUsers.get(i).getName());
        }
        System.out.println("\n\n");
    }
}
