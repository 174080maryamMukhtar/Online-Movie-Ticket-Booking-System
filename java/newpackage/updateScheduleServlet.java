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

/**
 *
 * @author abc
 */
@WebServlet(name = "updateScheduleServlet", urlPatterns = {"/updateScheduleServlet"})
public class updateScheduleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateScheduleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateScheduleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                obj.getAdminHelper().setDay(day);
                ArrayList<Schedule> schedule=obj.getAdminHelper().getCinema().getScheduleByWeekday(day,obj.getAdminHelper().getGenre().getGenreName());
                System.out.println("Cinema : "+obj.getAdminHelper().getCinema().getName());
                System.out.println("Genre : "+obj.getAdminHelper().getGenre().getGenreName());
                 System.out.println("Day: "+day);
                 System.out.println("Schedule Id: "+schedule.get(i).getID());
                Movie mov=schedule.get(i).getMovie();
                Slot sl=schedule.get(i).getSlot();
                obj.getAdminHelper().setMovie(mov);
                obj.getAdminHelper().setSlot(sl);
                PrintWriter writer = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("UpdateMovieSchedule.jsp");
        requestDispatcher.forward(request, response);
            }
            
            
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
