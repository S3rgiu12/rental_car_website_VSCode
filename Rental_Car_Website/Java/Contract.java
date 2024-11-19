package InchiriereMasini;

import java.sql.Date;

public class Contract {
	private String idContract;
	  private Date dataIncepere;
	    private Date dataIncheiere;
	    private Float suma;
	    private Float reducere;
	    private String idMasina;
		
	    Contract(String idContract, Date dataIncepere, Date dataIncheiere, Float suma, Float reducere,
				String idMasina) {
			  
			this.idContract = idContract;
			this.dataIncepere = dataIncepere;
			this.dataIncheiere = dataIncheiere; 
			this.suma = suma;
			this.reducere = reducere;
			this.idMasina = idMasina;
		}

		public String getIdContract() {
			return idContract;
		}

		public void setIdContract(String idContract) {
			this.idContract = idContract;
		}

		public Date getDataIncepere() {
			return dataIncepere;
		}

		public void setDataIncepere(Date dataIncepere) {
			this.dataIncepere = dataIncepere;
		}

		public Date getDataIncheiere() {
			return dataIncheiere;
		}

		public void setDataIncheiere(Date dataIncheiere) {
			this.dataIncheiere = dataIncheiere;
		}

		public Float getSuma() {
			return suma;
		}

		public void setSuma(Float suma) {
			this.suma = suma;
		}

		public Float getReducere() {
			return reducere;
		}

		public void setReducere(Float reducere) {
			this.reducere = reducere;
		}

		public String getIdMasina() {
			return idMasina;
		}

		public void setIdMasina(String idMasina) {
			this.idMasina = idMasina;
		}

		@Override
		public String toString() {
			return "Contract [idContract=" + idContract + ", dataIncepere=" + dataIncepere + ", dataIncheiere="
					+ dataIncheiere + ", suma=" + suma + ", reducere=" + reducere + ", idMasina=" + idMasina + "]";
		}
	    
		

}
