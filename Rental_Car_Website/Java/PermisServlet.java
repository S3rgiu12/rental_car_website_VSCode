package InchiriereMasini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PermisServlet")
public class PermisServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("addPermit".equals(action)) {
            addPermit(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("viewPermits".equals(action)) {
            viewPermits(request, response);
        }
    }

    private void addPermit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPermis = request.getParameter("idPermis");
        String dataObtinere = request.getParameter("dataObtinere");
        String dataExpirare = request.getParameter("dataExpirare");
        String categorie = request.getParameter("categorie");
        String idClient = request.getParameter("idClient");

        String message = null;
        try (Connection conn = ConnectionJDBC.getConnection()) {
            String sql = "INSERT INTO permis (idPermis, dataObtinere, dataExpirare, categorie, idClient) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, idPermis);
                pstmt.setDate(2, java.sql.Date.valueOf(dataObtinere));
                pstmt.setDate(3, java.sql.Date.valueOf(dataExpirare));
                pstmt.setString(4, categorie);
                pstmt.setString(5, idClient);
                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    message = "Permisul a fost adăugat cu succes!";
                } else {
                    message = "Eroare la adăugarea permisului.";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "Eroare la adăugarea permisului: " + e.getMessage();
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("Administrator.html?action=addPermit").forward(request, response);
    }

    private void viewPermits(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM permis")) {

            request.setAttribute("permitList", rs);
            request.getRequestDispatcher("Administrator.html?action=viewPermits").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
