package mediatheque.tests;

import Tools.ToolBox;
import mediatheque.metier.Actif;
import mediatheque.metier.Adherent;
import mediatheque.metier.Entreprise;
import mediatheque.sauvegarde.SystemeDeSauvegarde;

import java.time.LocalDate;

public class ScenarioAjoutAdherent
{
    public static void main(String[] args) throws Exception {



        for(int i = 0; i < 10050;i++)
        {
            Adherent adh = Adherent.getAdherentAleatoire();
            System.out.println(adh.getPrenom()+", "+adh.getNom()+", "+adh.getDateNaissance()+", "+ adh.getCarte());
        }
        SystemeDeSauvegarde.getInstance().sauvegarder();

        /*Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0;i <= 10000;i++)
                    {
                        System.out.println(i);
                        Actif act = (Actif) Adherent.getAdherentAleatoire();
                        act.save();

                    }
                    //SystemeDeSauvegarde.getInstance().sauvegarder();
                }
                catch(Exception exc)
                {

                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        SystemeDeSauvegarde.getInstance().sauvegarder();*/
    }
}
