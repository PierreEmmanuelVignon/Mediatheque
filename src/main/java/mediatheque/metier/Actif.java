package mediatheque.metier;

import java.time.LocalDate;

public class Actif extends Adherent
{
    private Entreprise employeur;


    public Actif(String nouveauNom, String nouveauPrenom, LocalDate nouvelleDateNaissance, Entreprise ent) {
        super(nouveauNom, nouveauPrenom, nouvelleDateNaissance);
        this.employeur = ent;
    }

    public Entreprise getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Entreprise employeur) {
        this.employeur = employeur;
    }
}
