package mediatheque.metier;

import java.time.LocalDate;

public class Etudiant extends Adherent
{
    private Univesite Campus;

    public Etudiant(String nouveauNom, String nouveauPrenom, LocalDate nouvelleDateNaissance, Univesite campus) throws Exception {
        super(nouveauNom, nouveauPrenom, nouvelleDateNaissance);
        this.Campus = campus;
    }

    public Univesite getCampus() {
        return Campus;
    }

    public void setCampus(Univesite campus) {
        Campus = campus;
    }

    @Override
    public Location louer(Ressource ress) {
        System.out.println("Location gratuite de " + ress + " par " + this);
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.getAge() + ", " + this.getCampus();
    }
}
