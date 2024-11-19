package InchiriereMasini;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClientQuestionServlet")
public class ClientQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");

        // Setarea mesajului de confirmare
        request.setAttribute("message", "Mesajul către administrator a fost trimis cu succes!");

        // Redirecționarea către pagina JSP cu mesajul de confirmare
        request.getRequestDispatcher("ContClient.html").forward(request, response);
    }
}
