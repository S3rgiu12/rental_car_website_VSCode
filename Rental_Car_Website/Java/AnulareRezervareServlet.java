package InchiriereMasini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import InchiriereMasini.ConnectionJDBC;

@WebServlet("/AnulareRezervareServlet")
public class AnulareRezervareServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Get the ID Rezervare from the request
        String idRezervare = request.getParameter("idRezervare");
        
        // Perform database deletion
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ConnectionJDBC.getConnection(); // Get connection from ConnectionJDBC class
            String query = "DELETE FROM rezervari_consilier WHERE idRezervare=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, idRezervare);
            int rowsAffected = pstmt.executeUpdate();
            
            // Print the HTML content with background
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Anulare Rezervare</title>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>");
            out.println("<style>");
            out.println("body {");
            out.println("background: url('https://images.unsplash.com/photo-1612544448445-b8232cff3b6c?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8fA%3D%3D') no-repeat center center fixed;");
            out.println("background-size: cover;");
            out.println("font-family: Arial, sans-serif;");
            out.println("color: white;");
            out.println("}");
            out.println(".container {");
            out.println("background: rgba(0, 0, 0, 0.5);");
            out.println("padding: 20px;");
            out.println("border-radius: 10px;");
            out.println("margin-top: 50px;");
            out.println("}");
            out.println("h1 {");
            out.println("text-align: center;");
            out.println("margin-bottom: 30px;");
            out.println("}");
            out.println(".message {");
            out.println("text-align: center;");
            out.println("font-size: 18px;");
            out.println("margin-top: 20px;");
            out.println("}");
            out.println(".section {");
            out.println("margin-bottom: 20px;");
            out.println("}");
            out.println(".section h2, .section button {");
            out.println("color: white;");
            out.println("}");
            out.println(".btn {");
            out.println("margin: 5px;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Anulare Rezervare</h1>");

            // Check if rows were affected and print message accordingly
            if (rowsAffected > 0) {
                out.println("<div class='message'>Anulare realizată cu succes!</div>");
            } else {
                out.println("<div class='message'>Nu există nicio înregistrare cu ID-ul specificat!</div>");
            }
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (ClassNotFoundException | SQLException e) {
            out.println("<div class='message'>Eroare la ștergere: " + e.getMessage() + "</div>");
        } finally {
            ConnectionJDBC.closeAll(conn, pstmt, null); // Close connection and statement
        }
    }
}
