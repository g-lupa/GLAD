package ryerson.ca.lab3.Business;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;


public class DashboardServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession(false);
       
        if (session == null || session.getAttribute("username") == null) {
            request.setAttribute("errorMessage", "You must be logged in to access the dashboard.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }
       
        String username = (String) session.getAttribute("username");
       
       
        request.setAttribute("dashboardMessage", "Hello, " + username + "! Here is your personalized dashboard.");


        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}