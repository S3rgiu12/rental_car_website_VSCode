package InchiriereMasini;

public class UseriAutentificare {
	private String idUseri;
	private String nume;
	 private String prenume;
	 private String parola;
	 private String idPermis;
	 private String nrTelefon;
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
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public String getIdPermis() {
		return idPermis;
	}
	public void setIdPermis(String idPermis) {
		this.idPermis = idPermis;
	}
	public String getNrTelefon() {
		return nrTelefon;
	}
	public void setNrTelefon(String nrTelefon) {
		this.nrTelefon = nrTelefon;
	}
	public String getIdUseri() {
		return idUseri;
	}
	public void setIdUseri(String idUseri) {
		this.idUseri = idUseri;
	}
	@Override
	public String toString() {
		return "UseriAutentificare [Nume=" + nume +  ", Prenume=" + prenume + ", Parola="
				+ parola + ", IDPermis=" + idPermis + ", telefon=" + nrTelefon +", IdUseri=" + idUseri  + "]";
	}
	
}
