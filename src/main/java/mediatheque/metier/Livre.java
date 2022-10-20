package mediatheque.metier;

import mediatheque.sauvegarde.Recordable;
import mediatheque.sauvegarde.SystemeDeSauvegarde;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Livre extends Ressource implements Recordable {

    public Livre(String titre) {
        super(titre);

        //Autoabonnement
        SystemeDeSauvegarde.getInstance().addRecordable(this);
    }

    @Override
    public boolean save() throws Exception
    {
        System.out.println("Sauvegarde du livre " + this + " dans le fichier livres.csv");

        //Définir le fichier cible
        File fichier = new File("C://Users//VignonP//Documents//FormationJava//Projects//Save//livres.csv");
        //fichier.mkdirs();
        // Création d'un outil d'écriture, le booleen indique que l'on ajoutera du texte au
        // fichier s'il y'a deja du texte dans le fichier
        FileWriter writer = new FileWriter(fichier, true);
        BufferedWriter buffWritter = new BufferedWriter(writer);
        //Ecrire la chaine à placer dans le fichier
        String chaine = this.getTitre();
        buffWritter.write(chaine);
        buffWritter.newLine();
        //Fermer l'accès au fichier
        buffWritter.close();

        return true;
    }
}
