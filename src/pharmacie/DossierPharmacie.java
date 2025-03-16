package pharmacie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DossierPharmacie {
    private String nom;
    private HashMap<String, Patient> patients;
    
    public DossierPharmacie(String n) {
        nom = n;
        patients = new HashMap<String, Patient>();
    }
    
    public void nouveauPatient(String nom, String[] ord) {
      
        String nomLowerCase = nom.toLowerCase();
        Patient p = new Patient(nom);
        for (String s : ord) {
            p.ajoutMedicament(s);
        }
        patients.put(nomLowerCase, p);
    }
    
    public boolean ajoutMedicament(String nom, String m) {
   
        String nomLowerCase = nom.toLowerCase();
        Patient p = patients.get(nomLowerCase);
        if (p != null) {
            p.ajoutMedicament(m);
            return true;
        } else {
            return false;
        }
    }
    
    public void affichePatient(String nom) {
        String nomLowerCase = nom.toLowerCase();
        Patient p = patients.get(nomLowerCase);
        if (p != null) {
            p.affiche();
        } else {
            System.out.println("Patient non trouvé: " + nom);
        }
    }
    
    public void affiche() {
        System.out.println("Pharmacie: " + nom);
        System.out.println("Liste des patients:");
        Set<String> keys = patients.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Patient p = patients.get(key);
            p.affiche();
            
        }
    }
    
    public Collection<Patient> PatientAvecMedicament(String m) {
        Collection<Patient> result = new ArrayList<>();
        for (Patient p : patients.values()) {
            if (p.contientMedicament(m)) {
                result.add(p);
            }
        }
        return result;
    }
    
    public void enleverPatientOrdonnanceVide() {
        Iterator<String> it = patients.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Patient p = patients.get(key);
            if (p.ordonnanceVide()) {
                it.remove(); 
            }
        }
    }
}
