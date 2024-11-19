package InchiriereMasini;

import java.sql.Date;

public class Rezervare {
    private String idRezervare;
    private String client;
    private String masina;
    private String nrInmatric;
    private Date dataRezervare;
    private Date dataIncheiereRezerv;
    private String status;
    private String idClient;

    // Constructor fără parametri
    public Rezervare() {
    }

    // Constructor cu parametri
    public Rezervare(String idRezervare, String client, String masina, String nrInmatric, Date dataRezervare, Date dataIncheiereRezervare, String status, String idClient) {
        this.idRezervare = idRezervare;
        this.client = client;
        this.masina = masina;
        this.nrInmatric = nrInmatric;
        this.dataRezervare = dataRezervare;
        this.dataIncheiereRezerv = dataIncheiereRezervare;
        this.status = status;
        this.idClient = idClient;
    }

    public String getIdRezervare() {
        return idRezervare;
    }

    public void setIdRezervare(String idRezervare) {
        this.idRezervare = idRezervare;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMasina() {
        return masina;
    }

    public void setMasina(String masina) {
        this.masina = masina;
    }
    
    public String getNrInmatric() {
        return nrInmatric;
    }

    public void setNrInmatric(String nrInmatric) {
        this.nrInmatric = nrInmatric;
    }

    public Date getDataRezervare() {
        return dataRezervare;
    }

    public void setDataRezervare(Date dataRezervare) {
        this.dataRezervare = dataRezervare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getDataIncheiereRezerv() {
		return dataIncheiereRezerv;
	}

	public void setDataIncheiereRezerv(Date dataIncheiereRezerv) {
		this.dataIncheiereRezerv = dataIncheiereRezerv;
	}
	
	public String getIdClient() {
		return idClient;
	}

	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}

    @Override
    public String toString() {
        return "Rezervare{" +
                "idRezervare='" + idRezervare + '\'' +
                ", client='" + client + '\'' +
                ", masina='" + masina + '\'' +
                 ", nrInmatric='" + nrInmatric + '\'' +
                ", dataRezervare=" + dataRezervare +
                 ", dataIncheiereRezerv=" + dataIncheiereRezerv +
                ", status='" + status + '\'' +
                ", idClient='" + idClient + '\'' +
                '}';
    }

	

	
}