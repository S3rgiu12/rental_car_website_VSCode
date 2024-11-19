import static spark.Spark.*;
import java.sql.*;

public class AdaugaClientApp {
    public static void main(String[] args) {
        // Configurează ruta pentru adăugarea clientului
        post("/adauga-client", (req, res) -> {
            String idClient = req.queryParams("idClient");
            String nume = req.queryParams("nume");
            String prenume = req.queryParams("prenume");
            String dataNastere = req.queryParams("dataNastere");
            String adresa = req.queryParams("adresa");
            String telefon = req.queryParams("telefon");
            String email = req.queryParams("email");
            String idPermis = req.queryParams("idPermis");

            try (Connection conn = ConnectionJDBC.getConnection()) {
                String checkSql = "SELECT COUNT(*) AS count FROM client WHERE idClient = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(checkSql)) {
                    pstmt.setString(1, idClient);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next() && rs.getInt("count") > 0) {
                            return "Clientul cu acest ID există deja!";
                        }
                    }
                }

                String sql = "INSERT INTO client (idClient, nume, prenume, dataNastere, adresa, telefon, email, idPermis) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, idClient);
                    pstmt.setString(2, nume);
                    pstmt.setString(3, prenume);
                    pstmt.setDate(4, java.sql.Date.valueOf(dataNastere));
                    pstmt.setString(5, adresa);
                    pstmt.setString(6, telefon);
                    pstmt.setString(7, email);
                    pstmt.setString(8, idPermis);

                    int rows = pstmt.executeUpdate();
                    if (rows > 0) {
                        return "Client adăugat cu succes!";
                    } else {
                        return "Eroare la adăugarea clientului.";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Eroare: " + e.getMessage();
            }
        });
    }
}
