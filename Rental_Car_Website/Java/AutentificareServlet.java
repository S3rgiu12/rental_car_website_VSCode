package InchiriereMasini;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AutentificareServlet")
public class AutentificareServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Preiau datele din formular
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String parola = request.getParameter("parola");
        String idPermis = request.getParameter("idPermis");
        String nrTelefon = request.getParameter("nrTelefon");
        
        // Creez un obiect UseriAutentificare
        UseriAutentificare user = new UseriAutentificare();
        user.setNume(nume);
        user.setPrenume(prenume);
        user.setParola(parola);
        user.setIdPermis(idPermis);
        user.setNrTelefon(nrTelefon);
        
        // Aici fac operații cu obiectul user, cum ar fi să-l adaug în baza de date sau să-l verific
        
        // Setez atributul "user" în obiectul request pentru a fi accesibil în JSP
        request.setAttribute("user", user);
        
        // Redirecționez către pagina JSP
        request.getRequestDispatcher("useriautentificare.html").forward(request, response);
    }

    
}
