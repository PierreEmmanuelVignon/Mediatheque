package mediatheque.tests;

import mediatheque.metier.Retraite;

import java.sql.*;
import java.time.LocalDate;

public class ScenarioConnexion
{
    public static void main(String[] args) throws Exception {

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
        ResultSet jeu = st.executeQuery("SELECT * FROM ADHERENT;");

        //Traiter les données
        while(jeu.next())
        {
            /*System.out.println(jeu.getString("nom"));
            System.out.println(jeu.getString("prenom"));
            System.out.println(jeu.getString("dateNaissance"));*/
            String nom = jeu.getString("nom");
            String prenom = jeu.getString("prenom");
            Date dateNaissanceBDD = jeu.getDate("dateNaissance");

            LocalDate dateNaissance = dateNaissanceBDD.toLocalDate();

            System.out.println(nom + " "+ prenom+ " " + dateNaissance);

            Retraite retraite = new Retraite(nom, prenom, dateNaissance);

        }

        //Fermeture de la connexion
        jeu.close();
        st.close();
        connex.close();
    }
}
