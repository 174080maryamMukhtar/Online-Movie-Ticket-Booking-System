
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "adminViewCinemaServlet", urlPatterns = {"/adminViewCinemaServlet"})
public class adminViewCinemaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminViewCinemaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminViewCinemaServlet at " + request.getContextPath() + "</h1>");
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
        String universal=request.getParameter("universal");
        String cinepax=request.getParameter("cinepax");
        String cinestar=request.getParameter("cinestar");
        String supercinema=request.getParameter("super");
        if(universal!=null)
        {
            //obj.getTicket().setCinema(obj.getCinemaFromList("Universal Cinemas"));
            obj.getAdminHelper().setCinema(obj.getCinemaFromList("Universal Cinemas"));
            System.out.println("PRINTING FROM CONSOLE"+obj.getTicket().getCinema().getName());
            PrintWriter writer = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminViewGenre.jsp");
                requestDispatcher.forward(request, response);
        }
        else if(cinepax!=null)
        {
            obj.getAdminHelper().setCinema(obj.getCinemaFromList("Cinepax"));
            System.out.println("PRINTING FROM CONSOLE"+obj.getTicket().getCinema().getName());
            PrintWriter writer = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminViewGenre.jsp");
                requestDispatcher.forward(request, response);
        }
        else if(cinestar!=null)
        {
            obj.getAdminHelper().setCinema(obj.getCinemaFromList("Cinestar"));
            System.out.println("PRINTING FROM CONSOLE"+obj.getTicket().getCinema().getName());
            PrintWriter writer = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminViewGenre.jsp");
                requestDispatcher.forward(request, response);
        }
        else if(supercinema!=null)
        {
            obj.getAdminHelper().setCinema(obj.getCinemaFromList("Super Cinema"));
            System.out.println("PRINTING FROM CONSOLE"+obj.getTicket().getCinema().getName());
            PrintWriter writer = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminViewGenre.jsp");
                requestDispatcher.forward(request, response);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
