package mediatheque.tests;

import mediatheque.metier.Actif;
import mediatheque.metier.Entreprise;
import mediatheque.metier.Livre;
import mediatheque.sauvegarde.SystemeDeSauvegarde;

import java.time.LocalDate;

public class ScenarioSauvegarde
{
    public static void main(String[] args) throws Exception {


        for(int i = 1; i <= 5; i++)
        {
            //Créer 5 actifs
            Actif act = new Actif("nom"+i, "prenom"+i, LocalDate.now(), new Entreprise("ent"+i));
            //Créer 5 livres
            Livre livre = new Livre("titre"+i);
        }

        //Lancer la sauvegarde
        SystemeDeSauvegarde.getInstance().sauvegarder();

    }//Fin du main
}
