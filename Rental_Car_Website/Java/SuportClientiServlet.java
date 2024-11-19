package InchiriereMasini;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SuportClientiServlet")
public class SuportClientiServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logica pentru procesarea datelor, de exemplu salvarea într-o bază de date
        // De exemplu, presupunem că salvăm mesajul și ID-ul în baza de date aici

        // După procesare, redirecționăm utilizatorul
        response.sendRedirect("ConfirmareSuport.html?email=" + request.getParameter("email"));
    }
}
