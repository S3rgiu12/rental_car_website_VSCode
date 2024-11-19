package InchiriereMasini;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Client {
	private String idClient;
	 private String nume;
	    private String prenume;
	    private Date dataNastere;
	    private String adresa;
	    private String telefon;
	    private String email;
	    private String idPermis;
	   
		
	    private static List<Client> clienti = new ArrayList<>();
	    public Client(String idClient, String nume, String prenume, Date dataNastere, String adresa, String telefon, 
				String email, String idPermis) {
			  
			this.idClient = idClient;
			this.nume = nume;
			this.prenume = prenume;
			this.dataNastere = dataNastere;
			this.adresa = adresa;
			this.telefon = telefon;
			this.email = email;
			this.idPermis = idPermis;
			
		}

		public String getIdClient() {
			return idClient;
		}

		public void setIdClient(String idClient) {
			this.idClient = idClient;
		}

		public String getNume() {
			return nume;
		}

		public void setNume(String nume) {
			this.nume = nume;
		}

		public String getPrenume() {
			return prenume;
		}

		public void setPrenume(String prenume) {
			this.prenume = prenume;
		}

		public Date getDataNastere() {
			return dataNastere;
		}

		public void setDataNastere(Date dataNastere) {
			this.dataNastere = dataNastere;
		}

		public String getAdresa() {
			return adresa;
		}

		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}

		public String getTelefon() {
			return telefon;
		}

		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getIdPermis() {
			return idPermis;
		}

		public void setIdPermis(String idPermis) {
			this.idPermis = idPermis;
		}

		

		@Override
		public String toString() {
			return "Client [idClient=" + idClient + ", nume=" + nume + ", prenume=" + prenume + ", dataNastere="
					+ dataNastere + ", adresa=" + adresa + ", telefon=" + telefon + ", email=" + email + ", idPermis="
					+ idPermis +  "]";
		}
	    
		
		
	  

}
