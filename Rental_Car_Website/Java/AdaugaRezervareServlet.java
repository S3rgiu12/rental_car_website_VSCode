package InchiriereMasini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adaugaRezervare")
public class AdaugaRezervareServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRezervare = request.getParameter("idRezervare");
        String client = request.getParameter("client");
        String masina = request.getParameter("masina");
        String nrInmatric = request.getParameter("nrInmatric");
        Date dataRezervare = Date.valueOf(request.getParameter("dataRezervare"));
        Date dataIncheiereRezerv = Date.valueOf(request.getParameter("dataIncheiereRezerv"));
        String status = request.getParameter("status");
        String idClient = request.getParameter("idClient");

        try (Connection conn = ConnectionJDBC.getConnection()) {
            String sql = "INSERT INTO rezervari_consilier (idRezervare, client, masina, nrInmatric, dataRezervare, dataIncheiereRezerv, status, idClient) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idRezervare);
                pstmt.setString(2, client);
                pstmt.setString(3, masina);
                pstmt.setString(4, nrInmatric);
                pstmt.setDate(5, dataRezervare);
                pstmt.setDate(6, dataIncheiereRezerv);
                pstmt.setString(7, status);
                pstmt.setString(8, idClient);
                pstmt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("AfisareRezervari.html");
    }
}
