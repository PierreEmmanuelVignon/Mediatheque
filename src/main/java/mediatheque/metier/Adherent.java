package mediatheque.metier;

import java.time.LocalDate;

public class Adherent extends Personne
{
    private LocalDate dateAdhesion;

    public Adherent(String nouveauNom, String nouveauPrenom, LocalDate nouvelleDateNaissance) {
        super(nouveauNom, nouveauPrenom, nouvelleDateNaissance);
        dateAdhesion = LocalDate.now();
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public Location louer(Ressource ress)
    {
        System.out.println("Location plein tarif de " + ress.getTitre() + " par " + this.getPrenom() + " " + this.getNom());
        return null;
    }
}
