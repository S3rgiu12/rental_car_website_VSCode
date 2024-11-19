package InchiriereMasini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MasiniDisponibileServlet")
public class MasiniDisponibileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/inchirieri auto"; 
        String user = "root"; 
        String password = ""; 

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM masina"; // Selectăm toate datele din tabelul "masina"
            
            rs = stmt.executeQuery(sql);
            
            // Stocăm rezultatele în request și le trimitem către JSP
            request.setAttribute("resultSet", rs);
            request.getRequestDispatcher("MasiniDisponibile.html").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Închidem conexiunea, instrucția și setul de rezultate
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}