package mediatheque.sauvegarde;

import java.util.ArrayList;
import java.util.List;

public class SystemeDeSauvegarde
{

    private ArrayList<Recordable> liste;
    private static SystemeDeSauvegarde instance;

    private SystemeDeSauvegarde() {
        //Initialiser la liste
        this.liste = new ArrayList<>();
    }

    public boolean sauvegarder() throws Exception {
        //On parcourt la liste des éléments enregistrables
        //On invoque la méthode save sur chacun d'eux
        for (Recordable rec : liste) {
            rec.save();
        }

        return true;
    }

    public boolean addRecordable(Recordable rec) {
        return liste.add(rec);
    }

    public static SystemeDeSauvegarde getInstance()
    {
        if (instance == null)
        {
            instance = new SystemeDeSauvegarde();
        }
        return instance;
    }
}
