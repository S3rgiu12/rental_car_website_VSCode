package InchiriereMasini;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private String idManagerParc;
    private String numeManager;
    private String prenumeManager;
    private String nrTelefonManager;
    private String idParc;
    private String emailManager;
    
    private static List<Manager> manageri = new ArrayList<>();
    
    public Manager(String idManagerParc, String numeManager, String prenumeManager, String nrTelefonManager, 
                   String idParc, String emailManager) {
        this.idManagerParc = idManagerParc;
        this.numeManager = numeManager;
        this.prenumeManager = prenumeManager;
        this.nrTelefonManager = nrTelefonManager;
        this.emailManager = emailManager;
        this.idParc = idParc;
        
        // Adaugă acest manager în lista statică
        manageri.add(this);
    }
    
    public String getIdManagerParc() {
        return idManagerParc;
    }

    public void setIdManagerParc(String idManagerParc) {
        this.idManagerParc = idManagerParc;
    }

    public String getNumeManager() {
        return numeManager;
    }

    public void setNumeManager(String numeManager) {
        this.numeManager = numeManager;
    }

    public String getPrenumeManager() {
        return prenumeManager;
    }

    public void setPrenumeManager(String prenumeManager) {
        this.prenumeManager = prenumeManager;
    }

    public String getNrTelefonManager() {
        return nrTelefonManager;
    }

    public void setNrTelefonManager(String nrTelefonManager) {
        this.nrTelefonManager = nrTelefonManager;
    }

    public String getIdParc() {
        return idParc;
    }

    public void setIdParc(String idParc) {
        this.idParc = idParc;
    }

    public String getEmailManager() {
        return emailManager;
    }

    public void setEmailManager(String emailManager) {
        this.emailManager = emailManager;
    }

    // Metodă statică pentru a obține toți managerii
    public static List<Manager> getAllManagers() {
        return new ArrayList<>(manageri); // Întoarce o copie a listei pentru a proteja lista originală
    }

    // Metodă statică pentru a adăuga un manager
    public static void addManager(Manager manager) {
        manageri.add(manager);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "idManagerParc='" + idManagerParc + '\'' +
                ", numeManager='" + numeManager + '\'' +
                ", prenumeManager='" + prenumeManager + '\'' +
                ", nrTelefonManager='" + nrTelefonManager + '\'' +
                ", idParc='" + idParc + '\'' +
                ", emailManager='" + emailManager + '\'' +
                '}';
    }
}

