package InchiriereMasini;

import java.util.Date;

public class MasiniDisp {
    private String locatieRidic;
    private String locatieReturn;
    private Date dataRidic;
    private Date dataReturn;
    private String marca;
    private String model;
    private float pretInchiriere;

    // Constructor fără parametrii
    public MasiniDisp() {
    }

    // Constructor cu parametrii
    public MasiniDisp(String locatieRidic, String locatieReturn, Date dataRidic, Date dataReturn, String marca, String model, float pretInchiriere ) {
        this.locatieRidic = locatieRidic;
        this.locatieReturn = locatieReturn;
        this.dataRidic = dataRidic;
        this.dataReturn = dataReturn;
        this.marca = marca;
        this.model = model;
        this.pretInchiriere = pretInchiriere;
    }

    // Getter și Setter pentru locatieRidic
    public String getLocatieRidic() {
        return locatieRidic;
    }

    public void setLocatieRidic(String locatieRidic) {
        this.locatieRidic = locatieRidic;
    }

    // Getter și Setter pentru locatieReturn
    public String getLocatieReturn() {
        return locatieReturn;
    }

    public void setLocatieReturn(String locatieReturn) {
        this.locatieReturn = locatieReturn;
    }

    // Getter și Setter pentru dataRidic
    public Date getDataRidic() {
        return dataRidic;
    }

    public void setDataRidic(Date dataRidic) {
        this.dataRidic = dataRidic;
    }

    // Getter și Setter pentru dataReturn
    public Date getDataReturn() {
        return dataReturn;
    }

    public void setDataReturn(Date dataReturn) {
        this.dataReturn = dataReturn;
    }

    // Getter și Setter pentru marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter și Setter pentru model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public float getPretInchiriere() {
		return pretInchiriere;
	}

	public void setPretInchiriere(float pretInchiriere) {
		this.pretInchiriere = pretInchiriere;
	}

    // Metoda toString
    @Override
    public String toString() {
        return "MasiniDisp{" +
                "locatieRidic='" + locatieRidic + '\'' +
                ", locatieReturn='" + locatieReturn + '\'' +
                ", dataRidic=" + dataRidic +
                ", dataReturn=" + dataReturn +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                 ", pretInchiriere='" + pretInchiriere + '\'' +
                '}';
    }


}
