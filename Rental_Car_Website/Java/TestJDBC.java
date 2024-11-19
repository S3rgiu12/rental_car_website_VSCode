package InchiriereMasini;

import java.util.List;

public class TestJDBC {


	public static void main(String[] args) throws ClassNotFoundException {

new MasinaLoader();
List<Masina> listamasini = MasinaLoader.load();
System.out.println("Delete complete.");

for (int i = 0; i < listamasini.size(); i++) {
			System.out.println(listamasini.get(i).getMarca() + " " + listamasini.get(i).getModel());
		}

		
		new MasinaLoader();
		List<Masina> listamasinidiesel = MasinaLoader.loadWithCriteria("M' UNION SELECT marca as marcamasina,model as modelmasina FROM masina WHERE  ''='");
		
		
		for (int i = 0; i < listamasinidiesel.size(); i++) {
			System.out.println("Lista masini diesel: " + listamasinidiesel.get(i).getMarca() + " " + listamasinidiesel.get(i).getModel());
		}
		
		

	} 

} 