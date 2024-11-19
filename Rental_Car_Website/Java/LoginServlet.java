package InchiriereMasini;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Verific dacă utilizatorul și parola sunt corecte
        boolean isValid = checkCredentials(email, password);

        if (isValid) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            // Verific tipul de utilizator și redirecționez în funcție de acesta
            switch (email) {
                case "sergiudumitrasc@gmail.com":
                    response.sendRedirect("Administrator.jsp");
                    break;
                case "georgepopescu@gmail.com":
                    response.sendRedirect("Consilier.jsp");
                    break;
                case "alingrigore957@gmail.com":
                    response.sendRedirect("ContClient.jsp");
                    break;
                default:
                    response.sendRedirect("InchirieriAuto.jsp");
                    break;
            }
        } else {
            request.setAttribute("error", "Email sau parolă incorecte.");
            request.getRequestDispatcher("Login.html").forward(request, response);
        }
    }

    private boolean checkCredentials(String email, String password) {
        return ("sergiudumitrasc@gmail.com".equals(email) && "sergiu1209".equals(password)) ||
               ("georgepopescu@gmail.com".equals(email) && "george123".equals(password)) ||
               ("alingrigore957@gmail.com".equals(email) && "Alin1234".equals(password));
    }
}
