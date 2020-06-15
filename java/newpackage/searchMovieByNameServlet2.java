
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


@WebServlet(name = "searchMovieByNameServlet2", urlPatterns = {"/searchMovieByNameServlet2"})
public class searchMovieByNameServlet2 extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchMovieByNameServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchMovieByNameServlet2 at " + request.getContextPath() + "</h1>");
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
        
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
        
        String size=(String)request.getSession().getAttribute("size");
        String moviename=request.getParameter("moviename");
         int ss=Integer.parseInt(size);
        for(int i=0;i<ss;i++)
        {
            String ii=String.valueOf(i);
            if(request.getParameter(ii)!=null)
            {
             String day=request.getParameter("day");
                if(day.equals("0"))
                {
                    day="Monday";
                }
                else if(day.equals("1"))
                {
                    day="Tuesday";
                }
                else if(day.equals("2"))
                {
                    day="Wednesday";
                }
                else if(day.equals("3"))
                {
                    day="Thursday";
                }
                else if(day.equals("4"))
                {
                    day="Friday";
                }
                String cinema=request.getParameter("cinema");
                if(cinema.equals("0"))
                {
                    cinema="Universal Cinemas";
                }
                else if(cinema.equals("1"))
                {
                    cinema="Cinepax";
                }
                else if(cinema.equals("2"))
                {
                    cinema="Cinestar";
                }
                else if(cinema.equals("3"))
                {
                    cinema="Super Cinema";
                }
                System.out.println("-----------------CHECKING----------------");
                System.out.println("Cinema: "+cinema);
                System.out.println("DAY: "+day);
                System.out.println("-----------------CHECKING----------------");
                obj.getTicket().setCinema(obj.getCinemaFromList(cinema));
                obj.getTicket().setDay(day);
                ArrayList<Schedule> schedule=obj.getTicket().getCinema().getScheduleByMovie(moviename,day);
                Movie mov=schedule.get(i).getMovie();
                Slot sl=schedule.get(i).getSlot();
                obj.getTicket().setMovie(mov);
                obj.getTicket().setSlot(sl);
                request.setAttribute("movie",mov);
                request.setAttribute("cinema",obj.getTicket().getCinema());
            }
        }
        
        System.out.println("____Movie___");
        obj.getTicket().getMovie().printMovie();
        System.out.println("Slot: "+obj.getTicket().getSlot().getStartTime());
        System.out.println("Day: "+obj.getTicket().getDay());
        Cinema cc=obj.getTicket().getCinema();
        ArrayList<Schedule> sch=cc.getSchedule();
        System.out.println("Schedule for "+cc.getName());
        cc.printCinema();
        Schedule temp=new Schedule();
        for(int i=0;i<sch.size();i++)
        {
            if(sch.get(i).getDay().equals(obj.getTicket().getDay()) && sch.get(i).getMovie().getTitle().equals(obj.getTicket().getMovie().getTitle()) && sch.get(i).getSlot().getStartTime().equals(obj.getTicket().getSlot().getStartTime()))
            {
                temp=sch.get(i);
                break;
            }
        }
        obj.getTicket().setSchedule(temp); 
        PrintWriter writer = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("DetailsOfSelectedMovie.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
