package InchiriereMasini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestiuneMasini {
	public static List<Masina>getListaMasini()throws ClassNotFoundException {
		List<Masina>listamasini = new ArrayList<Masina>();
		String Query = "select ID_masina,marca,model,An_Fabricatie,Nr_Locuri,Capac_Cilindric,CP,Disponibila,Combustibil,Manager_Auto,ID_Contract from masina";
		try(Connection conn = ConnectionJDBC.getConnection();
				Statement pstmt = conn.prepareStatement(Query);
				ResultSet rs = pstmt.executeQuery(Query);){
			while (rs.next()) {
				Masina masina = new Masina();
				masina.setIdMasina(rs.getString(1));
				masina.setMarca(rs.getString(2));
				masina.setModel(rs.getString(3));
				masina.setAnFabricatie(rs.getString(4));
				masina.setNrLocuri(rs.getInt(5));
				masina.setCapacCilindric(rs.getInt(6));
				masina.setCaiPutere(rs.getInt(7));
				masina.setDisponibila(rs.getString(8));
				masina.setCombustibil(rs.getString(9));
				masina.setManagerAuto(rs.getString(10));
				listamasini.add(masina);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listamasini;
	}


public static void deleteMasina(Masina masina) {
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
try { conn = ConnectionJDBC.getConnection();
    pstmt = conn.prepareStatement("delete from categorie_masina where ManagerAuto=?");
		pstmt.setString(10, masina.getManagerAuto());
		int executed=pstmt.executeUpdate();
		if(executed>0) {
			System.out.println("Masina a fost stearsa din baza de date! "); 
		}
    
} catch (SQLException e) {
	System.out.println("Eroare conexiune DB" + e.getMessage());
	
} catch (ClassNotFoundException e) {
	System.out.println ("Clasa necesara conexiunii la baza de date nu a fost gasita");
} finally {
	ConnectionJDBC.closeAll(conn, pstmt, rs);
}
}

public static void insertMasina(Masina masina) {
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs= null;
	try {conn = ConnectionJDBC.getConnection();
    pstmt = conn.prepareStatement("Insert Into masina Values(?,?,?,?,?,?,?,?,?,?,?)");
    
   pstmt.setString(1, masina.getIdMasina());
	pstmt.setString(2,masina.getMarca());
	pstmt.setString (3,masina.getModel());
	pstmt.setString(4, masina.getAnFabricatie());
	pstmt.setInt(5, masina.getNrLocuri());
	pstmt.setInt(6, masina.getCapacCilindric());
	pstmt.setInt(7, masina.getCaiPutere());
	pstmt.setString(8, masina.getDisponibila());
	pstmt.setString(9, masina.getCombustibil());
	pstmt.setString(10, masina.getManagerAuto());
	
	int executed=pstmt.executeUpdate();
	if(executed>0) {
		System.out.println("Masina a fost adaugata in baza de date! ");
	}

} catch (SQLException e) {
System.out.println("Eroare conexiune DB" + e.getMessage());

} catch (ClassNotFoundException e) {
System.out.println ("Clasa necesara conexiunii la baza de date nu a fost gasita");
} finally {
ConnectionJDBC.closeAll(conn, pstmt, rs);
}
		
	}
	public static void updateMasina(Masina masina, String ID_masina) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {conn = ConnectionJDBC.getConnection();
	    pstmt = conn.prepareStatement("update masina set id_masina=? where marca=? and model=?");
	    
	    pstmt.setString(1,ID_masina);
	    pstmt.setString(2, masina.getMarca());
	    pstmt.setString(3, masina.getModel());
	    
	    int executed=pstmt.executeUpdate();
		if(executed>0) {
			System.out.println("Masina a fost updatata cu succes! ");
		}

	} catch (SQLException e) {
	System.out.println("Eroare conexiune DB" + e.getMessage());

	} catch (ClassNotFoundException e) {
	System.out.println ("Clasa necesara conexiunii la baza de date nu a fost gasita");
	} finally {
	ConnectionJDBC.closeAll(conn, pstmt, rs);
	}
	}
}
