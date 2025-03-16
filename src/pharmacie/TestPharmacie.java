package pharmacie;

import java.util.Collection;

public class TestPharmacie {
    public static void main(String[] args) {
        
        
        Patient p1 = new Patient("Allel eya");
        System.out.println("Patient: " + p1.getNom());
        System.out.println("Ordonnance vide ou non  " + p1.ordonnanceVide());
        
        p1.ajoutMedicament("Doliprane");
        p1.ajoutMedicament("Aspirine");
        p1.ajoutMedicament("Ibuprofène");
        
        
        System.out.println("Ordonnance vide ou non " + p1.ordonnanceVide());
        System.out.println("Contient Aspirine ? " + p1.contientMedicament("Aspirine"));
        System.out.println("Contient Ventoline ? " + p1.contientMedicament("Ventoline"));
        
        p1.affiche();
        
        System.out.println(" tri de l'ordonnance:");
        p1.trieOrdonnance();
        p1.affiche();
        
        
       
        DossierPharmacie pharmacie = new DossierPharmacie("Pharmacie Soliman");
        
       
        String[] ordonnance1 = {"Doliprane", "Aspirine", "Ibuprofène"};
        pharmacie.nouveauPatient("Allel eya", ordonnance1);
        
        String[] ordonnance2 = {"Ventoline", "Doliprane"};
        pharmacie.nouveauPatient("Aissa yamen", ordonnance2);
        
        String[] ordonnance3 = {"Doliprane"};
        pharmacie.nouveauPatient("Chrigui mohamed amine ", ordonnance3);
        
        
        
        pharmacie.affiche();
        
       
       
        pharmacie.ajoutMedicament("Allel eya", "Ventoline");
        
        pharmacie.affichePatient("Allel eya");
        
       
        System.out.println("avec Doliprane:");
        Collection<Patient> patientsAvecDoliprane = pharmacie.PatientAvecMedicament("Doliprane");
        for (Patient p : patientsAvecDoliprane) {
            System.out.println(p.getNom());
        }
        
        
      ;
        
        
        pharmacie.nouveauPatient(" patient Vide", new String[0]);
        
        pharmacie.affiche();
        
       
        System.out.println("suppression des patients avec ordonnance vide:");
        pharmacie.enleverPatientOrdonnanceVide();
        pharmacie.affiche();
    }
}