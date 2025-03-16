package pharmacie;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class Patient {
    private String nom;
    private Set<String> ordonnance;
    
    public Patient(String n) {
        nom = n;
        ordonnance = new HashSet<String>();
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Set<String> getOrdonnance() {
        return ordonnance;
    }
    
    public void setOrdonnance(Set<String> ordonnance) {
        this.ordonnance = ordonnance;
    }
    
    public boolean ordonnanceVide() {
        return ordonnance.isEmpty(); // mieux que size()==0
    }
    
    public void ajoutMedicament(String m) {
        ordonnance.add(m);
    }
    
    public void affiche() {
        System.out.println("nom patient: " + this.nom);
        System.out.println("ordonnance: ");
        Iterator<String> it = ordonnance.iterator();
        while (it.hasNext()) {
            System.out.println("- " + it.next());
        }
    }
    
    public boolean contientMedicament(String m) {
        return ordonnance.contains(m);
    }
    
    public void trieOrdonnance() {
     
        TreeSet<String> ts = new TreeSet<>(ordonnance);
        ordonnance = ts;
    }
}
 