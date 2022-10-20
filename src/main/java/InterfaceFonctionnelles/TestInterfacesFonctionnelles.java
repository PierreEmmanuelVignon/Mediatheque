package InterfaceFonctionnelles;

import mediatheque.metier.Livre;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestInterfacesFonctionnelles
{
    public static void main(String[] args) {

        //Créer une fonction qui, ç partir d'un code postal, renvoie un nom de ville
        Function<String, String> fonction1 = codePostal ->
        {
          if(codePostal.equalsIgnoreCase("42000")) return "saint etienne";
          if(codePostal.equalsIgnoreCase("75000")) return "paris";
          return null;
        };

        //Utilisation de la fonction
        String nomVille = fonction1.apply("42000");
        System.out.println(nomVille);

        String[] tableau = {"69000","42000","13000","59000","75000","79000"};
        List<String> listCodesPostaux = Arrays.asList(tableau);

        //Definition d'un consomateur de String
        Consumer<String> consumer1 = (String s) ->
        {
            if(s != null) System.out.println(s.toUpperCase());
            else System.out.println("Nom de ville inconnu");
        };
        //On soumet la lsite à la fonction.
        //Il faut pour cela la transformer en Stream.
        listCodesPostaux.stream().map(fonction1).forEach(consumer1);

        //Créer un prédicat qui affirme qu'une date correspond à un lundi.
        Predicate<LocalDate> predicat1 = (LocalDate ld) -> { return ld.getDayOfWeek().equals( DayOfWeek.MONDAY);};

        System.out.println(predicat1.test(LocalDate.parse("2022-10-17")));

        //Création d'un fournisseur de livre.

        Supplier<Livre> supplier1 = () -> new Livre("Titre  par défaut");
        Livre livre = supplier1.get();

        //


    }//Fin du main
}
