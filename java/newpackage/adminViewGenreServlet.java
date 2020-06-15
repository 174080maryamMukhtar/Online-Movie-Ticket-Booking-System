
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "adminViewGenreServlet", urlPatterns = {"/adminViewGenreServlet"})
public class adminViewGenreServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminViewGenreServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminViewGenreServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String horror=request.getParameter("horror");
        String action=request.getParameter("action");
        String romantic=request.getParameter("romantic");
        String comedy=request.getParameter("comedy");
        String animated=request.getParameter("animated");
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
        ArrayList<ArrayList> scheduleForEachCinema=new ArrayList<>();
        String genre="";
        if(horror!=null)
        {
            genre="Horror";   
        }
        else if(action!=null)
        {
            genre="Action";   
        }
        else if(romantic!=null)
        {
            genre="Romance";   
        }
        else if(comedy!=null)
        {
             genre="Comedy";   
        }
        else if(animated!=null)
        {
           genre="Animated";   
        }
            ArrayList<ArrayList> scheduleByWeekDay=new ArrayList<>();
                for(int j=0;j<5;j++)
                {
                    ArrayList <Schedule>s=new ArrayList<>();
                    if(j==0)
                    {
                        s=obj.getAdminHelper().getCinema().getScheduleByWeekday("Monday", genre);
                        scheduleByWeekDay.add(s);
                        
                    }
                    else if(j==1)
                    {
                        s=obj.getAdminHelper().getCinema().getScheduleByWeekday("Tuesday", genre);
                        scheduleByWeekDay.add(s);
                    }
                    else if(j==2)
                    {
                        s=obj.getAdminHelper().getCinema().getScheduleByWeekday("Wednesday", genre);
                        scheduleByWeekDay.add(s);
                    }
                    else if(j==3)
                    {
                        s=obj.getAdminHelper().getCinema().getScheduleByWeekday("Thursday", genre);
                        scheduleByWeekDay.add(s);
                    }
                    else if(j==4)
                    {
                        s=obj.getAdminHelper().getCinema().getScheduleByWeekday("Friday", genre);
                        scheduleByWeekDay.add(s);
                    }
                }
                
                obj.getAdminHelper().setGenre(new Genre(genre));
        request.setAttribute("schedule",scheduleByWeekDay);
        PrintWriter writer = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminViewSchedule.jsp");
        requestDispatcher.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
