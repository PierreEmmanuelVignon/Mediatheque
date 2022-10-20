package mediatheque.metier;

import mediatheque.sauvegarde.Recordable;
import mediatheque.sauvegarde.SystemeDeSauvegarde;

import java.sql.*;
import java.time.LocalDate;

public class Actif extends Adherent implements Recordable {
    private Entreprise employeur;


    public Actif(String nouveauNom, String nouveauPrenom, LocalDate nouvelleDateNaissance, Entreprise ent) throws Exception {
        super(nouveauNom, nouveauPrenom, nouvelleDateNaissance);
        this.employeur = ent;

        //Autoabonnement
        SystemeDeSauvegarde.getInstance().addRecordable(this);
    }

    public Entreprise getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Entreprise employeur) {
        this.employeur = employeur;
    }

    public Location louer(Ressource ress) {
        System.out.println("Location plein tarif de " + ress.toString() + " par " + this.toString());
        return null;
    }

    @Override
    public boolean save() throws Exception {
        //Charger le pilote du SGBD en mémoire vive
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Obtenir une connexion a partir de l'url JDBC et des paramètres d'authentifications attendus
        String url = "jdbc:mysql://localhost:3308/mediatheque";
        String user = "root";
        String pwd = "";
        Connection connex = DriverManager.getConnection(url, user, pwd);
        //Création d'un Statement (objet technique utilisé pour lancer des requêtes)
        Statement st = connex.createStatement();
        //Exécution d'une requête en lecture
        boolean result = st.execute("INSERT INTO ADHERENT (nom, prenom, dateNaissance) values (\'" +
                this.getNom() + "\', \'"+ this.getPrenom()+"\'," + " \'" + this.getDateNaissance().toString() + "\');");



        //Fermeture de la connexion
        st.close();
        connex.close();

        return true;
    }
}
