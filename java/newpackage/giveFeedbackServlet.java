
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "giveFeedbackServlet", urlPatterns = {"/giveFeedbackServlet"})
public class giveFeedbackServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet giveFeedbackServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet giveFeedbackServlet at " + request.getContextPath() + "</h1>");
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
        String r=request.getParameter("rating");
        int rating=Integer.parseInt(r);
        System.out.println("Rating: "+rating);
        String review=request.getParameter("review");
        System.out.println("Review: "+review);
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
         System.out.println("Username: "+obj.getCurrentUser().getUsername());
        Feedback f=new Feedback(obj.getCurrentUser().getUsername(),rating,review);
        obj.getTicket().getMovie().addFeedback(f);
        PrintWriter writer = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("GiveFeedback.jsp");
        requestDispatcher.forward(request, response);
    }

       @Override
    public String getServletInfo() {
        return "Short description";
    }
}
