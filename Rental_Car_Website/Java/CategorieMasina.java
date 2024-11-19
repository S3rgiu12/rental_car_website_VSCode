package InchiriereMasini;



import java.util.List;

public interface CategorieMasina {
    void adaugaMasina(Masina masina);
    Masina gasesteMasinaDupaId(String idMasina);
    void actualizeazaMasina(Masina masina);
    void stergeMasina(String idMasina);
    List<Masina> obtineToateMasinile();
}