package InchiriereMasini;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RezervaMasinaServlet")
public class RezervaMasinaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Preluăm informațiile mașinii rezervate și creăm un obiect MasiniDisp
        MasiniDisp masina = new MasiniDisp();
        masina.setLocatieRidic(request.getParameter("locatieRidic"));
        masina.setLocatieReturn(request.getParameter("locatieReturn"));
        masina.setDataRidic(Date.valueOf(request.getParameter("dataRidic")));
        masina.setDataReturn(Date.valueOf(request.getParameter("dataReturn")));
        masina.setMarca(request.getParameter("marca"));
        masina.setModel(request.getParameter("model"));
        
        // Convertim pretInchiriere din String în float
        String pretInchiriereParam = request.getParameter("pretInchiriere");
        float pretInchiriere = 0;
        if (pretInchiriereParam != null && !pretInchiriereParam.isEmpty()) {
            try {
                pretInchiriere = Float.parseFloat(pretInchiriereParam);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        masina.setPretInchiriere(pretInchiriere);

        // Obținem lista de rezervări din sesiune sau creăm una nouă dacă nu există
        ArrayList<MasiniDisp> rezervari = (ArrayList<MasiniDisp>) session.getAttribute("rezervari");
        if (rezervari == null) {
            rezervari = new ArrayList<>();
        }
        rezervari.add(masina);
        session.setAttribute("rezervari", rezervari);

        // Actualizăm numărul de rezervări din sesiune
        session.setAttribute("numarRezervari", rezervari.size());

        // Setăm mesajul de confirmare a rezervării
        request.setAttribute("mesajRezervare", "Rezervare realizata cu succes!");

        // Redirecționăm înapoi la pagina cu mașini disponibile
        request.getRequestDispatcher("ContClient.html").forward(request, response);
    }
}
