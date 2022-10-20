package mediatheque.tests;

import mediatheque.metier.*;
import mediatheque.sauvegarde.SystemeDeSauvegarde;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class ScenarioAdherant {

    public static void main(String[] args) {

        try {
            Univesite uni = new Univesite("Sté");
            //Création d'un adhérant
            Adherent adh1 = new Etudiant("Tarte", "Pomme", LocalDate.parse("2000-01-01"), uni);
            //Lui demander l'identifiant de sa carte
            if (adh1.getCarte() != null)
                System.out.println(adh1.getCarte().getIdentifiant());

            //On supprime la date de naissance de adh1
            //adh1.setDateNaissance(null);

            try {
                //Lui demander le nom du jour de sa naissance
                System.out.println("Le jour de la naissance de " + adh1 + " est le "
                        + adh1.getDateNaissance().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
            } catch (NullPointerException exc) {
                System.out.println("L'adhérent doit disposer d'une date de naissance");
            }
            //Lui demander de louer "Harry Potter"
            Ressource ress = new Ressource("Harry Potter");
            adh1.louer(ress);

            Entreprise ent = new Entreprise("Savoye");
            Actif acti = new Actif("Prenom", "Nom", LocalDate.parse("1974-08-08"), ent);

            Univesite campus = new Univesite("Dijon");
            Etudiant etud = new Etudiant("Tarte", "Mirabelle", LocalDate.parse("1995-01-01"), campus);

            acti.louer(ress);

            Ressource ress2 = new Ressource("Fondation");

            etud.louer(ress2);

            //Afficher le numéro de la carte de etud
            //System.out.println(etud.getCarte().getIdentifiant());

            //Gestion d'un tableau d'adhérents
            Adherent[] annuaire = new Adherent[10];
            annuaire[0] = adh1;
            annuaire[1] = acti;
            annuaire[2] = etud;

            Etudiant tampon = (Etudiant) annuaire[2];

            //On demande au tableau de nous fournir l'un des éléments
            System.out.println(tampon.getClass().getTypeName());
            if (tampon.getClass().getSimpleName().equals("Etudiant")) {
                Etudiant etudiantRang2 = (Etudiant) annuaire[2];
                System.out.println(etudiantRang2.getCampus());
            }

            //Creation d'un tableau d'oject rempli avec des objets et afficher les noms/prenoms de l'élément situé au rang 1

            Object[] elements = new Object[10];
            elements[0] = adh1;
            elements[1] = etud;
            elements[2] = acti;

            if (elements[1] instanceof Personne) {
                Personne pers = (Personne) elements[1];
                System.out.println(pers.getNom() + " " + pers.getPrenom());
            }

            //On a toujours le droit de regarder un objet comme s'il était issu
            //d'une de ses classes parentes
            boolean boucleValide = false;

          /*  while (boucleValide != true) {
                try {
                    //Calcul du nombre d'années entre 2 dates
                    System.out.println("Veuillez saisir la date de l'armistice 1918");
                    Scanner scanner = new Scanner(System.in);
                    String saisie = scanner.nextLine();

                    LocalDate.parse(saisie);
                    System.out.println(saisie);

                    boucleValide = true;
                } catch (DateTimeException dte) {
                    System.out.println("Le format de la date saisie n'est pas correct.");
                    System.out.println("Veuillez réessayer svp.");
                }
            }*/

            //Transformer un actif en entreprise via un transformateur
            TransformationActiEntreprise transfo = new TransformationActiEntreprise();

            Entreprise enttre = transfo.TransformAtoB(acti);

            System.out.println(enttre.getNom());

            //Objectif : enregistrer 10000 adhérents.
            //On va créer un objet Runnable en utiliant une classe anonyme.

            Runnable runnable1 = new Runnable() {
                @Override
                public void run() {
                    try {
                        for(int i = 0;i <= 10/*00000*/;i++)
                        {
                            Actif act = (Actif) Adherent.getAdherentAleatoire();
                            act.save();

                        }
                        SystemeDeSauvegarde.getInstance().sauvegarder();
                    }
                    catch(Exception exc)
                    {

                    }

                }
            };

            Thread thread1 = new Thread(runnable1);
            thread1.start();

            //Création d'un type d'adhérent scpécifique pour Noel 2022: promo: quart du tarif
            Adherent adhNoel2022 = new Adherent("abcd", "defg", LocalDate.parse("1999-04-20")) {
                @Override
                public Location louer(Ressource ress) {
                    System.out.println("Location au quart du prix de "+ress+ " par adhNoel2022");
                    return null;
                }
            };

            adhNoel2022.louer(null);


            System.out.println("Programme terminé");



        }
        catch(Exception exc)
        {
            System.out.println(exc.getMessage());
        }

    }//Fin du main

}
