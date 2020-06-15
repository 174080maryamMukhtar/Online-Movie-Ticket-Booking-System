
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginServlet at " + request.getContextPath() + "</h1>");
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
        
        
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        OnlineMovieTicketBookingSystem obj=OnlineMovieTicketBookingSystem.getInstance();
        //obj.loadData();
        User u=obj.getRegisteredUsers().login(username, password);
        if(u!=null)
        {
            obj.setCurrentUser(u);
            System.out.println("Current User: "+obj.getCurrentUser().getUsername() );
            if(u.getType().equals("customer"))
            {
                PrintWriter writer = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("cinemas.jsp");
                requestDispatcher.forward(request, response);
            }
            else if(u.getType().equals("admin"))
            {
                PrintWriter writer = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminHomePage.jsp");
                requestDispatcher.forward(request, response);
            }
            
        }
        else
            {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect');");
                out.println("location='login.jsp';");
                out.println("</script>");
                
            }
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
