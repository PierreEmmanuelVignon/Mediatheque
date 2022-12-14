package mediatheque.metier;

import Tools.ToolBox;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Adherent extends Personne
{
    private LocalDate dateAdhesion;

    public Adherent(String nouveauNom, String nouveauPrenom, LocalDate nouvelleDateNaissance) throws Exception {
        super(nouveauNom, nouveauPrenom, nouvelleDateNaissance);
        dateAdhesion = LocalDate.now();
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public abstract Location louer(Ressource ress);

    public static Adherent getAdherentAleatoire() throws Exception {
        LocalDate ld = ToolBox.getRandomLocalDate(1937,2021);
        Adherent adh = new Actif("Nom"+ld.getYear()+ld.getMonthValue()+ld.getDayOfMonth(),
                "Prenom"+ld.getYear()+ld.getMonthValue()+ld.getDayOfMonth(),
                ld,
                new Entreprise("Ent1"));
        return adh;
    }

    public static ArrayList<Adherent> load() throws Exception {
        ArrayList<Adherent> annuaire= new ArrayList<>();

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

            //System.out.println(nom + " "+ prenom+ " " + dateNaissance);

            Retraite retraite = new Retraite(nom, prenom, dateNaissance);

            //On place le retraite dans l'annuaire
            annuaire.add(retraite);
        }

        //Fermeture de la connexion
        jeu.close();
        st.close();
        connex.close();

        return annuaire;
    }
}
