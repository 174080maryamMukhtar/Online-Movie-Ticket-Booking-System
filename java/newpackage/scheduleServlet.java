/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


@WebServlet(name = "scheduleServlet", urlPatterns = {"/scheduleServlet"})
public class scheduleServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet scheduleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet scheduleServlet at " + request.getContextPath() + "</h1>");
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
        String m1=request.getParameter("m");
        String s1=request.getParameter("s");
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
        
        String size=(String)request.getSession().getAttribute("size");
        int ss=Integer.parseInt(size);
        /*ArrayList<Movie> m=(ArrayList<Movie>)request.getSession().getAttribute("movie");
        ArrayList<Slot> s=(ArrayList<Slot>)request.getSession().getAttribute("slot");*/
        
        
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
                obj.getTicket().setDay(day);
                ArrayList<Schedule> schedule=obj.getTicket().getCinema().getScheduleByWeekday(day,obj.getTicket().getGenre().getGenreName());
                Movie mov=schedule.get(i).getMovie();
                Slot sl=schedule.get(i).getSlot();
                obj.getTicket().setMovie(mov);
                obj.getTicket().setSlot(sl);
                request.setAttribute("movie",mov);
                request.setAttribute("cinema",obj.getTicket().getCinema());
            }
        }        
        
       /* for(int i=0;i<ss;i++)
        {
            String ii=String.valueOf(i);
            if(request.getParameter(ii)!=null)
            {
                String mov=request.getParameter("mov");
                String sl=request.getParameter("sl");
                Movie mm=obj.getMovieByName(mov);
                Slot ssl=obj.getSlotByTime(sl);
                obj.getTicket().setMovie(mm);
                obj.getTicket().setSlot(ssl);
                request.setAttribute("movie",mm);
                request.setAttribute("cinema",obj.getTicket().getCinema());
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
            obj.getTicket().setDay(day);
            }
        }*/
        /*for(int i=0;i<ss;i++)
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
                    day="Thurdsay";
                }
                else if(day.equals("4"))
                {
                    day="Friday";
                }
                
                obj.getTicket().setDay(day);
                Movie mm=obj.getMovieByName(m.get(i).getTitle());
                obj.getTicket().setMovie(mm);
                obj.getTicket().setSlot(s.get(i));
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\CHECKING\\\\\\\\\\\\\\\\\\\\\\\\\\");
                System.out.println(obj.getTicket().getSlot().getStartTime());
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\CHECKING\\\\\\\\\\\\\\\\\\\\\\\\\\");
                request.setAttribute("movie",m.get(i));
                request.setAttribute("cinema",obj.getTicket().getCinema());
            }
        }*/
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
    }
}
