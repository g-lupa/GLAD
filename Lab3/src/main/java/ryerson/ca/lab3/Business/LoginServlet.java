package ryerson.ca.lab3.Business;

import ryerson.ca.lab3.Persistence.User_CRUD;
import ryerson.ca.lab3.Helper.UserInfo;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private boolean validateUser(String username, String password) {
        UserInfo user = User_CRUD.read(username, password);
        return user != null; 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if (validateUser(username, password)) {
            UserInfo user = User_CRUD.read(username, password); 

            session.setAttribute("username", username);
            session.setAttribute("user", user); 

            request.setAttribute("welcomeMessage", "Welcome, " + username + "!");

            RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
