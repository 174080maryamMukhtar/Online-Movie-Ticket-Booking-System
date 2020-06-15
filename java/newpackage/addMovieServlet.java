
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "addMovieServlet", urlPatterns = {"/addMovieServlet"})
public class addMovieServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addMovieServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addMovieServlet at " + request.getContextPath() + "</h1>");
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
        String cinema=request.getParameter("cinema");
        String genre=request.getParameter("genre");
        String movie=request.getParameter("movie");
        String day=request.getParameter("day");
        String slot=request.getParameter("slot");
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
        Cinema c=obj.getCinemaFromList(cinema);
        Movie m=obj.getMovieByName(movie);
        Genre g=new Genre(genre);
        Slot s=obj.getSlotByTime(slot);
        Schedule sch=new Schedule(g,m,day,s);
        obj.addScheduleInCinema(c,sch);
        PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Schedule Added');");
                out.println("location='AddMovie.jsp';");
                out.println("</script>");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
