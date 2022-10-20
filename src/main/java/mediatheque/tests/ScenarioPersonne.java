package mediatheque.tests;

import mediatheque.metier.Carte;
import mediatheque.metier.Etudiant;
import mediatheque.metier.Personne;
import mediatheque.metier.Univesite;

import java.time.LocalDate;

public class ScenarioPersonne {

    public static void main(String[] args)
    {
        try {
            Personne p1 = new Personne("Pierre", "Paul");

            p1.marcher();
            p1.setPrenom("Marie");
            p1.setNom("Dupond");
            p1.setDateNaissance(LocalDate.parse("1985-02-02"));

            p1.marcher();

            Personne p2 = new Personne("Pas", "Je sais", LocalDate.parse("1980-03-10"));

            System.out.println("L'année de naissance de " + p2.getPrenom() + " " + p2.getNom() + " est " + p2.getDateNaissance().getYear());
            ;

            System.out.println(Personne.getNbAnnees(LocalDate.now(), LocalDate.parse("1918-11-11")));

            System.out.println("L'âge de p1 est " + p1.getAge());

            System.out.println("L'âge de p2 est " + p2.getAge());

            //p1.obtenirCarte("ID23456");

            Carte carte = new Carte(p1);

            //System.out.println("Le propriétaire de la carte " + p1.getCarte().getIdentifiant() + " est " + p1.getCarte().getProprietaire().getNom() +
            //        ".Le propriétaire est né le mois de " + carte.getProprietaire().getDateNaissance().getMonth());

            for (int i = 0; i < 100; i++) {
                Carte c = new Carte(p1);

                System.out.println(p1.getCarte().getIdentifiant());
            }

            Univesite campus = new Univesite("Dijon");

            Personne p3 = new Etudiant("Tarte", "Pomme", LocalDate.parse("1995-01-01"), campus);
        }
        catch (Exception exc)
        {
            System.out.println(exc.getMessage());
        }
    }
}
