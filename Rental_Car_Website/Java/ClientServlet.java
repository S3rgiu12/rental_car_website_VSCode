package InchiriereMasini;



import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClientiServlet")
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clienti = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Înlocuiește cu datele tale de conexiune
            String dbURL = "jdbc:mysql://localhost:3306/inchirieri auto";
            String user = "root";
            String password = "";
            
            conn = DriverManager.getConnection(dbURL, user, password);
            String sql = "SELECT idClient, nume, prenume, dataNastere, adresa, telefon, email, idPermis, idContract FROM client";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String idClient = rs.getString("idClient");
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                Date dataNastere = rs.getDate("dataNastere");
                String adresa = rs.getString("adresa");
                String telefon = rs.getString("telefon");
                String email = rs.getString("email");
                String idPermis = rs.getString("idPermis");
                

                Client client = new Client(idClient, nume, prenume, dataNastere, adresa, telefon, email, idPermis);
                clienti.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (Exception e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }

        request.setAttribute("clienti", clienti);
        request.getRequestDispatcher("afiseazaClienti.html").forward(request, response);
    }
}