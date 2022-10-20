package mediatheque.tests;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class TestSyntaxe {

    public static void saluer()
    {
        System.out.println("Bonjour Monsieur");
        System.out.println("Il est actullement " + LocalTime.now());
    }

    //Calculer le perimetre d'un cercle
    public static double calculerPerimetreCercle(double rayon)
    {
        return 2*Math.PI*rayon;
    }

    /**
     * 2
     * @param genre
     * @param nom
     */
    public static void salutationGenree(boolean genre, String nom)
    {
        String genreString = "";
        if(genre == true)
        {
            genreString = "Monsieur";
            //System.out.println("Bonjour Monsieur " + nom + ", il est actuellment " + LocalTime.now());
        }
        else
        {
            genreString = "Madame";
            //System.out.println("Bonjour Madame " + nom + ", il est actuellment " + LocalTime.now());
        }

        System.out.println("Bonjour " + genreString + " " + nom + ", il est actuellment " + LocalTime.now());

    }


    public static void main(String[] args) {

        //Déclaration et valorisation d'une variable
        int compteur = 20;

        System.out.println("Le compteur vaut: " + compteur);

        //Déclaration et valorisation d'une constante
        final boolean SUCCESS = true;

        //Réalisation d'un test
        //Utilisation d'opérateurs de comparaison
        if (compteur >= 100 && SUCCESS) {
            System.out.println("Le compteur a une valeur importante et SUCCESS vaut TRUE");
        } else {
            System.out.println("Le compteur a une valeur faible");
        }

        //Traitement itératif
        //1.On contnait à l'avance le nombre d'itérations
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " X " + j + " = " + (i * j));
            }

        }

        //2.On ne connait pas le nombre d'itérations à l'avance
        //Afficher lers 4 premières années bissextiles après 1857
        Year annee = Year.of(1857);
        int nombreAnnees = 0;
        while (nombreAnnees < 4) {
            //System.out.println("Annee :" + annee);
            if (annee.isLeap()) {
                System.out.println("Bonjour, je suis l'année " + annee + " et je suis bissextile :D");
                nombreAnnees++;
            }
            annee = annee.plusYears(1);
        }

        //3.On ne connait pas le nomnbre d'itération à l'avance, mais on veut faire ua moins une itération
        double valeur = 123456789.0;
        int nbIteration = 0;
        do {
            System.out.println("A l'itération " + nbIteration + ", la variable valeur vaut " + valeur);
            valeur = valeur / Math.PI;
            nbIteration++;
        }
        while (valeur >= 3);
        System.out.println("Après la boucle, valeur vaut " + valeur);


        //Traitement au cas par cas.
        //Affiche le nombre de jours d'un mois précis
        int moisCourant = 10;
        int nbJours = 0;

        switch(moisCourant )

        {
            case 1:
                nbJours = 31;
            case 2:
                nbJours = 28;
            case 3:
                nbJours = 31;
            case 10:
                nbJours = 31;
                break;
            default:
                nbJours = 0;

        }

        if(nbJours == 0)
        {
            System.out.println("Nombre jours inconnus");
        }
        else
        {
            System.out.println(nbJours + " jours");
        }

        //Tableaux
        String[] joursDeLaSemaine = {"Lundi", "Mardi", "Mercredi", "Jedui", "Vendredi", "Samedi", "Dimanche"};

        System.out.println("Le premier jour de la semaine est " + joursDeLaSemaine[0]);

        String[] codesPostaux = new String[40000];
        for (int i = 0; i < 40000 ; i++)
        {
            codesPostaux[i] = String.valueOf(i + 10000);
        }

        System.out.println(codesPostaux[1]);

        //Tableau a double entrée (matrice)
        String[][] annuaire = new String[21][4];
        annuaire[1][3] = "2021-01-0";
        annuaire[20][0] = "N21";

        //Affichage de tous les jours de la semaine
        for(String jour : joursDeLaSemaine)
        {
            System.out.println(jour);
            saluer();
        }

        double rayon = 12;
        System.out.println("Le perimetre du cercle de rayon "+ rayon +" est de " + calculerPerimetreCercle(rayon));

        salutationGenree(true, "Dupont");
        salutationGenree(false, "Laporte");
    }
}
