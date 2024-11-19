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

@WebServlet("/ClientServlet")
public class ClientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("addClient".equals(action)) {
            addClient(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("viewClients".equals(action)) {
            viewClients(request, response);
        }
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClient = request.getParameter("idClient");
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String dataNastere = request.getParameter("dataNastere");
        String adresa = request.getParameter("adresa");
        String telefon = request.getParameter("telefon");
        String email = request.getParameter("email");
        String idPermis = request.getParameter("idPermis");
        String idContract = request.getParameter("idContract");

        String message = null;
        try (Connection conn = ConnectionJDBC.getConnection()) {
            String checkSql = "SELECT COUNT(*) AS count FROM client WHERE idClient = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(checkSql)) {
                pstmt.setString(1, idClient);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next() && rs.getInt("count") > 0) {
                        message = "Clientul cu ID-ul specificat este deja înregistrat.";
                    } else {
                        String sql = "INSERT INTO client (idClient, nume, prenume, dataNastere, adresa, telefon, email, idPermis, idContract) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement pstmtInsert = conn.prepareStatement(sql)) {
                            pstmtInsert.setString(1, idClient);
                            pstmtInsert.setString(2, nume);
                            pstmtInsert.setString(3, prenume);
                            pstmtInsert.setDate(4, java.sql.Date.valueOf(dataNastere));
                            pstmtInsert.setString(5, adresa);
                            pstmtInsert.setString(6, telefon);
                            pstmtInsert.setString(7, email);
                            pstmtInsert.setString(8, idPermis);
                            pstmtInsert.setString(9, idContract);
                            int rows = pstmtInsert.executeUpdate();
                            if (rows > 0) {
                                message = "Clientul a fost adăugat cu succes!";
                            } else {
                                message = "Eroare la adăugarea clientului.";
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "Eroare la adăugarea clientului: " + e.getMessage();
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("Administrator.html?action=addClient").forward(request, response);
    }

    private void viewClients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM client")) {

            request.setAttribute("clientList", rs);
            request.getRequestDispatcher("Administrator.html?action=viewClients").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}