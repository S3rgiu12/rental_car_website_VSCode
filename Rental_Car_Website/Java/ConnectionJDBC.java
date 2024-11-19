package InchiriereMasini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionJDBC {

	public static final String DBURL = "jdbc:mysql://localhost:3306";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DBNAME = "/inchirieri auto";
	
	public static final String QUERYmasina = "SELECT idMasina, marca, model, nrInmatriculare, anFabricatie, nrLocuri, capacCilindric, caiPutere, combustibil, managerAuto FROM masina";
    public static final String QUERYmanager_parc = "SELECT idManagerParc, numeManager, prenumeManager, nrTelefonManager, emailManager, idParc FROM manager_parc";
    public static final String QUERYclient = "SELECT idClient, nume, prenume, dataNastere, adresa, telefon, email, idPermis FROM client";
    public static final String QUERYmasinifiltrare = "SELECT * FROM masini_disponibile WHERE locatieRidic = ? AND locatieReturn = ? AND dataRidic = ? AND dataReturn = ? AND marca = ? AND model = ?";
    public static final String QUERYadaugamasina = "INSERT INTO masina (idMasina, marca, model, nrInmatriculare, anFabricatie, nrLocuri, capacCilindric, caiPutere, disponibila, combustibil, managerAuto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(DBURL + DBNAME, USER, PASSWORD);  
		return conn; 

	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				System.out.println(e.getMessage());

			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				System.out.println(e.getMessage());

			}
		}
	}

	public static void closePreparedStatement(Statement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {

				System.out.println(e.getMessage());

			}
		}
	}

	public static void closeAll(Connection conn, Statement pstmt, ResultSet rs) {

		closeResultSet(rs);
		closePreparedStatement(pstmt);
		closeConnection(conn);

	}
}