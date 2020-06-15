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
@WebServlet(name = "AdminGenreServlet", urlPatterns = {"/AdminGenreServlet"})
public class AdminGenreServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminGenreServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminGenreServlet at " + request.getContextPath() + "</h1>");
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
        ///processRequest(request, response);
        String horror=request.getParameter("horror");
        String action=request.getParameter("action");
        String romantic=request.getParameter("romantic");
        String comedy=request.getParameter("comedy");
        String animated=request.getParameter("animated");
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
       // ArrayList<ArrayList> scheduleForEachCinema=new ArrayList<>();
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminSchedule.jsp");
        requestDispatcher.forward(request, response);
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
