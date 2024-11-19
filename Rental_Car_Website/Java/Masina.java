package InchiriereMasini;

import java.util.ArrayList;
import java.util.List;

public class Masina implements CategorieMasina {
    private String idMasina;
    private String marca;
    private String model;
    private String nrInmatriculare;
    private String anFabricatie;
    private Integer nrLocuri;
    private Integer capacCilindric;
    private Integer caiPutere;
    private String disponibila;
    private String combustibil;
    private String managerAuto;
   

    // Lista pentru a stoca masinile
    private static List<Masina> masini = new ArrayList<>();

    public Masina(String idMasina, String marca, String model,String nrInmatriculare, String anFabricatie, Integer nrLocuri,
                  Integer capacCilindric, Integer caiPutere, String disponibila, String combustibil, String managerAuto
                  ) {

        this.idMasina = idMasina; 
        this.marca = marca;
        this.model = model;
        this.nrInmatriculare = nrInmatriculare;
        this.anFabricatie = anFabricatie;
        this.nrLocuri = nrLocuri;
        this.capacCilindric = capacCilindric;
        this.caiPutere = caiPutere;
        this.disponibila = disponibila;
        this.combustibil = combustibil;
        this.managerAuto = managerAuto;

    }

    public Masina() {
    }

    public String getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(String idMasina) {
        this.idMasina = idMasina;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(String anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public Integer getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(Integer nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public Integer getCapacCilindric() {
        return capacCilindric;
    }

    public void setCapacCilindric(Integer capacCilindric) {
        this.capacCilindric = capacCilindric;
    }

    public Integer getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(Integer caiPutere) {
        this.caiPutere = caiPutere;
    }

    public String getDisponibila() {
        return disponibila;
    }

    public void setDisponibila(String disponibila) {
        this.disponibila = disponibila;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public String getManagerAuto() {
        return managerAuto;
    }

    public void setManagerAuto(String managerAuto) {
        this.managerAuto = managerAuto;
    }

    @Override
    public void adaugaMasina(Masina masina) {
        masini.add(masina);
    }

    @Override
    public Masina gasesteMasinaDupaId(String idMasina) {
        for (Masina masina : masini) {
            if (masina.getIdMasina().equals(idMasina)) {
                return masina;
            }
        }
        return null;
    }

    @Override
    public void actualizeazaMasina(Masina masina) {
        for (int i = 0; i < masini.size(); i++) {
            if (masini.get(i).getIdMasina().equals(masina.getIdMasina())) {
                masini.set(i, masina);
                return;
            }
        }
    }

    @Override
    public void stergeMasina(String idMasina) {
        masini.removeIf(masina -> masina.getIdMasina().equals(idMasina));
    }

    @Override
    public List<Masina> obtineToateMasinile() {
        return new ArrayList<>(masini);
    }

    @Override
    public String toString() {
        return "Masina [idMasina=" + idMasina + ", marca=" + marca + ", model=" + model + ", nrInmatriculare=" + nrInmatriculare +",  anFabricatie="
                + anFabricatie + ", nrLocuri=" + nrLocuri + ", capacCilindric=" + capacCilindric + ", caiPutere="
                + caiPutere + ", disponibila=" + disponibila + ", combustibil=" + combustibil + ", managerAuto="
                + managerAuto + ", idContract="  + "]";
    }

	
}