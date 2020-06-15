
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "seatingPlanServlet", urlPatterns = {"/seatingPlanServlet"})
public class seatingPlanServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet seatingPlanServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet seatingPlanServlet at " + request.getContextPath() + "</h1>");
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
        
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
        Hall h=obj.getTicket().getSchedule().getHall();
        String[] result=request.getParameterValues("checkbox");
        int count=0;
        if(result!=null)
        {
            for(int i=0;i<result.length;i++)
            {
                 int s=Integer.parseInt(result[i]);
                h.bookSeat(s);
                obj.getTicket().getSeats().add(s);
                count++;
             //System.out.println("Seat Number: "+result[i]); 
             
            }
            obj.getTicket().setNoOfSeats(count);
        System.out.println("Cinema: "+obj.getTicket().getCinema().getName());
        System.out.println("Movie: "+obj.getTicket().getMovie().getTitle());
        System.out.println("Slot: "+obj.getTicket().getMovie().getTitle());
        System.out.println("Total Seats: "+obj.getTicket().getNoOfSeats());
       PrintWriter writer = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ticket.jsp");
        requestDispatcher.forward(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Please Select Seat');");
                out.println("location='seatingPlan.jsp';");
                out.println("</script>");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
