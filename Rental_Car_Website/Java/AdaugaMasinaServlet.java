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

@WebServlet("/AdaugaMasinaServlet")
public class AdaugaMasinaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idMasina = request.getParameter("idMasina"); // Preluare idMasina
        String marca = request.getParameter("marca");
        String model = request.getParameter("model");
        String nrInmatriculare = request.getParameter("nrInmatriculare");
        int anFabricatie = Integer.parseInt(request.getParameter("anFabricatie"));
        int nrLocuri = Integer.parseInt(request.getParameter("nrLocuri"));
        int capacCilindric = Integer.parseInt(request.getParameter("capacCilindric"));
        int caiPutere = Integer.parseInt(request.getParameter("caiPutere"));
        String disponibila = request.getParameter("disponibila");
        String combustibil = request.getParameter("combustibil");
        String managerAuto = request.getParameter("managerAuto");
        

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ConnectionJDBC.getConnection();
            pstmt = conn.prepareStatement(ConnectionJDBC.QUERYadaugamasina);
            pstmt.setString(1, idMasina); // Setare idMasina în PreparedStatement
            pstmt.setString(2, marca);
            pstmt.setString(3, model);
            pstmt.setString(4, nrInmatriculare);
            pstmt.setInt(5, anFabricatie);
            pstmt.setInt(6, nrLocuri);
            pstmt.setInt(7, capacCilindric);
            pstmt.setInt(8, caiPutere);
            pstmt.setString(9, disponibila);
            pstmt.setString(10, combustibil);
            pstmt.setString(11, managerAuto);
           
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionJDBC.closeAll(conn, pstmt, null);
        }

        response.sendRedirect("Flota.html");
    }
}
