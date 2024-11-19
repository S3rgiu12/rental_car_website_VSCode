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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        if (!password.equals(confirmPassword)) {
            response.sendRedirect("Register.html?error=Passwords do not match");
            return;
        }

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionJDBC.getConnection();
            String sql = "INSERT INTO useri_autentificare (username, email, password) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("Succes.html?message=Inregistrare reusita, te rog autentifica-te.");
            } else {
                response.sendRedirect("Register.html?error=Inregistrarea a esuat, te rog mai incearca.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("Register.html?error=An error occurred, please try again later");
        } finally {
            ConnectionJDBC.closeAll(connection, statement, null);
        }
    }
}
