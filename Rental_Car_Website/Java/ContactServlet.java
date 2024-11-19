package InchiriereMasini;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Contact")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String DBURL = "jdbc:mysql://localhost:3306/inchirieri_auto";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Manager> manageri = new ArrayList<>();
        
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD);

            // Inserarea datelor în tabelă
            String insertQuery = "SELECT FROM manager_parc (idManagerParc, numeManager, prenumeManager, nrTelefonManager, emailManager, idParc) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "125643");
            preparedStatement.setString(2, "Lascu");
            preparedStatement.setString(3, "Cosmin");
            preparedStatement.setString(4, "0731369421");
            preparedStatement.setString(5, "lascuc@gmail.com");
            preparedStatement.setString(6, "09817");
            preparedStatement.executeUpdate();

            // Preluarea datelor din tabelă
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM manager_parc";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            
            while (resultSet.next()) {
                String idManagerParc = resultSet.getString("idManagerParc");
                String numeManager = resultSet.getString("numeManager");
                String prenumeManager = resultSet.getString("prenumeManager");
                String nrTelefonManager = resultSet.getString("nrTelefonManager");
                String idParc = resultSet.getString("idParc");
                String emailManager = resultSet.getString("emailManager");
                
                Manager manager = new Manager(idManagerParc, numeManager, prenumeManager, nrTelefonManager, idParc, emailManager);
                manageri.add(manager);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Setați lista de manageri ca atribut al request-ului
        request.setAttribute("manageri", manageri);
        
        // Redirecționați către pagina JSP
        request.getRequestDispatcher("/Contact.html").forward(request, response);
    }
}


