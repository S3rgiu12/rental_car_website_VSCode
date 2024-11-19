package InchiriereMasini;

import java.sql.Date;

public class Permis {

	private String idPermis;
	  private Date dataObtinere;
	    private Date dataExpirare;
	    private String categorie;
	    private String idClient;
		
	    public Permis(String idPermis, Date dataObtinere, Date dataExpirare, String categorie, String idClient) {
			super();  
			this.idPermis = idPermis;
			this.dataObtinere = dataObtinere;
			this.dataExpirare = dataExpirare;
			this.categorie = categorie;
			this.idClient = idClient; 
		}

		public String getIdPermis() {
			return idPermis;
		}

		public void setIdPermis(String idPermis) {
			this.idPermis = idPermis;
		}

		public Date getDataObtinere() {
			return dataObtinere;
		}

		public void setDataObtinere(Date dataObtinere) {
			this.dataObtinere = dataObtinere;
		}

		public Date getDataExpirare() {
			return dataExpirare;
		}

		public void setDataExpirare(Date dataExpirare) {
			this.dataExpirare = dataExpirare;
		}

		public String getCategorie() {
			return categorie;
		}

		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}

		public String getIdClient() {
			return idClient;
		}

		public void setIdClient(String idClient) {
			this.idClient = idClient;
		}

		@Override
		public String toString() {
			return "Permis [idPermis=" + idPermis + ", dataObtinere=" + dataObtinere + ", dataExpirare=" + dataExpirare
					+ ", categorie=" + categorie + ", idClient=" + idClient + "]";
		}
	    
	
	    
		
}
