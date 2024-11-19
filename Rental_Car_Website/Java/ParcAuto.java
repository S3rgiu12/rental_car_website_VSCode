package InchiriereMasini;

public class ParcAuto {
    private String idParc;
    private String nrMasiniDisp;
    private String idManagerParc;
    private String locatieRid;
    private String locatieRet;
    private String idMasina;

    public String getIdParc() {
        return idParc;
    }

    public void setIdParc(String idParc) {
        this.idParc = idParc;
    }

    public String getNrMasiniDisp() {
        return nrMasiniDisp;
    }

    public void setNrMasiniDisp(String nrMasiniDisp) {
        this.nrMasiniDisp = nrMasiniDisp;
    }

    public String getLocatieRid() {
        return locatieRid;
    }

    public void setLocatieRid(String locatieRid) {
        this.locatieRid = locatieRid;
    }

    public String getIdManagerParc() {
        return idManagerParc;
    }

    public void setIdManagerParc(String idManagerParc) {
        this.idManagerParc = idManagerParc;
    }

    public String getLocatieRet() {
        return locatieRet;
    }

    public void setLocatieRet(String locatieRet) {
        this.locatieRet = locatieRet;
    }

    public String getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(String idMasina) {
        this.idMasina = idMasina;
    }

    @Override
    public String toString() {
        return "ParcAuto {" +
                "idParc='" + idParc + '\'' +
                ", nrMasiniDisp='" + nrMasiniDisp + '\'' +
                ", idManagerParc='" + idManagerParc + '\'' +
                ", locatieRid='" + locatieRid + '\'' +
                ", locatieRet='" + locatieRet + '\'' +
                ", idMasina='" + idMasina + '\'' +
                '}';
    }
}
