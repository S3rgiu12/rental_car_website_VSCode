package InchiriereMasini;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InchirieriServlet")
public class InchirieriServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Obțin parametrii din cererea HTTP
        String dataPreluarii = request.getParameter("home-pu-day") + "/" + 
                               request.getParameter("home-pu-month") + "/" + 
                               request.getParameter("home-pu-year");
        String dataReturnarii = request.getParameter("home-do-day") + "/" + 
                               request.getParameter("home-do-month") + "/" + 
                               request.getParameter("home-do-year");
        String categorieMasina = request.getParameter("home-category");
        String marcaMasina = request.getParameter("home-marca");
        String modelMasina = request.getParameter("home-model");
        String anFabricatie = request.getParameter("home-an");
        
        // Acțiuni pentru procesare
        // Aici adaug logica pentru a procesa cererea, de exemplu, pentru a căuta mașinile disponibile în baza de date.
        
        // Răspuns către client
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Rezultate căutare</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Rezultate căutare:</h2>");
        out.println("<p>Data preluării: " + dataPreluarii + "</p>");
        out.println("<p>Data returnării: " + dataReturnarii + "</p>");
        out.println("<p>Categorie mașină: " + categorieMasina + "</p>");
        out.println("<p>Marca mașină: " + marcaMasina + "</p>");
        out.println("<p>Model mașină: " + modelMasina + "</p>");
        out.println("<p>An fabricație: " + anFabricatie + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

