package mediatheque.metier;

import java.time.LocalDate;
import java.time.Period;

public class Personne {

    //Propriétés
    private String nom, prenom;
    private LocalDate dateNaissance;

    private static int ageMajorite = 18;

    private Carte carte;


    //Methodes
    /*public Personne()
    {
        this.nom = null;
        this.prenom = null;
        this.dateNaissance = null;
    }*/

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.setCarte(new Carte(this));
    }

    public Personne(String nouveauNom, String nouveauPrenom, LocalDate nouvelleDateNaissance)
    {
        //this.nom = nouveauNom;
        //this.prenom = nouveauPrenom;
        this(nouveauNom,nouveauPrenom);
        this.dateNaissance = nouvelleDateNaissance;
    }

    //Méthodes
    public boolean marcher()
    {
        System.out.println(prenom + " " + this.getNom() + " marche.");
        return true;
    }

    public String getNom() {
        return nom.toUpperCase();
    }

    public void setNom(String nom) {
        if(nom.length() >= 3)
        {
            this.nom = nom;
        }
        else
        {
            System.out.println("Le nom " + nom + " est invalide. Le nom n'est pas mis à jour.");
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public static int getNbAnnees(LocalDate date1, LocalDate date2)
    {
        Period periode =  Period.between(date1, date2);
        return Math.abs(periode.getYears());
    }

    public String getAge()
    {
        /*Period periode = Period.between(this.getDateNaissance(), LocalDate.now());
        return periode.getYears();*/
        return getNbAnnees(this.getDateNaissance(), LocalDate.now()) + " ans";
    }

    public void setCarte(Carte carte)
    {
        this.carte = carte;
    }

    public Carte getCarte()
    {
        return carte;
    }

    @Override
    public String toString() {
        return getPrenom() + ", " + getNom();
    }
}
