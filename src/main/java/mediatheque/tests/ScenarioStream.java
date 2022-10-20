package mediatheque.tests;

import mediatheque.metier.Adherent;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ScenarioStream {

    public static void main(String[] args) throws Exception {

        //Récupération des adhérents de la base
        ArrayList<Adherent> annuaire = Adherent.load();

        System.out.println(annuaire.size() + " adhérents dans la base.");

        //Consumer<Adherent> consumer1 = (Adherent adh) -> System.out.println(adh);

        //annuaire.stream().forEach(consumer1);

        //Afficher le nombre total d'adhérents en utilisant un stream.
        long nbannuaire = annuaire.stream().count();

        System.out.println(nbannuaire);

        //Afficher le nombre d'adhérents nés en 1985.
        Predicate<Adherent> predicat1 = (Adherent adh) -> adh.getDateNaissance().getYear() == 1985;

        long nbAnnuaire1985 = annuaire.stream().filter(predicat1).count();

        System.out.println(nbAnnuaire1985);

        //Afficher l'adhérent le plus agé.
        Comparator<Adherent> comparator1 = (Adherent adh1, Adherent adh2) ->
        {
            if(adh1.getDateNaissance().isBefore(adh2.getDateNaissance()))
            {
                return 1;
            }
            else if (adh2.getDateNaissance().isBefore(adh1.getDateNaissance()))
            {
                return -1;
            }
            return 0;
        };


        Optional<Adherent> adhLePlusVieux = annuaire.stream().max(comparator1);

        System.out.println("L'adherent le plus âgé est " + adhLePlusVieux.get());

        //Afficher tous les adhérents nés en 1985 en les ordonnants par date de naissance.
        Predicate<Adherent> predicat2 = (Adherent adh) -> adh.getDateNaissance().getYear() == 1985;

        Consumer<Adherent> consumer1 = (Adherent adh) -> System.out.println(adh+" "+adh.getDateNaissance().toString());

        annuaire.stream().filter(predicat2).sorted(comparator1.reversed()).forEach(consumer1);
//        annuaire.stream().filter(predicat2).sorted(comparator1.reversed()).limit(15).forEach(consumer1);

        //Trouver un adherent né le 08/05/1945

        Predicate<Adherent> predicat3 = (Adherent adh) -> adh.getDateNaissance().getYear() == 1945;
        Predicate<Adherent> predicat4 = (Adherent adh) -> adh.getDateNaissance().getMonthValue() == 5;
        Predicate<Adherent> predicat5 = (Adherent adh) -> adh.getDateNaissance().getDayOfMonth() == 8;

        //annuaire.stream().filter(predicat3.and(predicat4.and(predicat5))).forEach(consumer1);

        Optional<Adherent> adh =annuaire.stream().filter(predicat3.and(predicat4.and(predicat5))).limit(1).findFirst();

        if(adh.isPresent())
            System.out.println(adh.get());
        else
        {
            System.out.println("Aucun n'adhérant ne correspond.");
        }

    }
}
