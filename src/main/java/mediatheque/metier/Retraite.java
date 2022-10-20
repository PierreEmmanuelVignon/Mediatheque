package mediatheque.metier;

import java.time.LocalDate;

public class Retraite extends Adherent{


    public Retraite(String nouveauNom, String nouveauPrenom, LocalDate nouvelleDateNaissance) throws Exception {
        super(nouveauNom, nouveauPrenom, nouvelleDateNaissance);
    }

    @Override
    public Location louer(Ressource ress)
    {
        System.out.println("Location demi-tarif de " + ress + " par " + this);
        return null;
    }
}
