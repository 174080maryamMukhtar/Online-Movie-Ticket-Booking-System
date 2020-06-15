
package newpackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnectivity {
    private static dbConnectivity obj;
    private Connection con;
    private Statement stmt;
    private dbConnectivity()
    {
        try
        {
           //Class.forName("com.mysql.jdbc.Driver");  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ooad;user=sa;password=123456;");
 
            System.out.println("Connected to database !");
            stmt=con.createStatement();
        }
        catch(SQLException sqle) 
        {
            System.out.println("Sql Exception :"+sqle.getMessage());
        }
        catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
    }
    public static dbConnectivity getInstance()
    {
        if(getObj()!=null)
        {
            return getObj();
        }
        else
        {
            setObj(new dbConnectivity());
            return getObj();
        }
    }

    public static dbConnectivity getObj() {
        return obj;
    }

    public static void setObj(dbConnectivity aObj) {
        obj = aObj;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}
