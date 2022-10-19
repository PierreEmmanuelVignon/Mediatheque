package mediatheque.metier;

public class Carte {
    private Personne proprietaire;
    private String identifiant;
    private static int compteur = 0;

    public Carte(Personne p)
    {
        this.setProprietaire(p);
        compteur++;
        this.setIdentifiant("CART" + compteur);

        getProprietaire().setCarte(this);
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    private void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}
