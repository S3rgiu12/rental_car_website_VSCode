package InchiriereMasini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ModificaStatusMasinaServlet")
public class ModificaStatusMasinaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idMasina = Integer.parseInt(request.getParameter("idMasina"));
        String disponibil = request.getParameter("disponibil");

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ConnectionJDBC.getConnection();
            String sql = "UPDATE masina SET disponibila = ? WHERE idMasina = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, disponibil);
            pstmt.setInt(2, idMasina);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionJDBC.closeAll(conn, pstmt, null);
        }

        response.sendRedirect("Flota.html");
    }
}
