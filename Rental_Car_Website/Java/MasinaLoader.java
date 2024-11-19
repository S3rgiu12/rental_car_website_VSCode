package InchiriereMasini;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MasinaLoader {

	public static List<Masina> load() throws ClassNotFoundException {

		List<Masina> listamasini = new ArrayList<Masina>();

		try (Connection conn = ConnectionJDBC.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select marca,model from masina");) {
			while (rs.next()) {
				Masina masina = new Masina();
				masina.setMarca(rs.getString("marca"));
				masina.setModel(rs.getString("model"));
				listamasini.add(masina); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listamasini;
	}
	
	
	public static List<Masina> loadWithCriteria(String combustibil) throws ClassNotFoundException {

		List<Masina> listamasini = new ArrayList<Masina>();

		try (Connection conn = ConnectionJDBC.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select marca,model from masina where combustibil='" + combustibil + "'");) {
			while (rs.next()) {
				Masina masina = new Masina();
				masina.setMarca(rs.getString("marca"));
				masina.setModel(rs.getString("model"));
				listamasini.add(masina);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listamasini;
	} 

	
	

	}
	
	