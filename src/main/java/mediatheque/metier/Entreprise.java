package mediatheque.metier;

public class Entreprise {

    private String nom;
    public Entreprise(String str) {
        this.nom = str;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
