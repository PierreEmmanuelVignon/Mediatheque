package lambdas;

import mediatheque.sauvegarde.Recordable;
import mediatheque.sauvegarde.SystemeDeSauvegarde;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestLambdas
{
    public static void main(String[] args) throws Exception {

        //Creation d'un runnable sous forme de class anonyme.
        Runnable runnalbe1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
            }
        };

        Runnable runnabble2 = () -> System.out.println(LocalTime.now().format(DateTimeFormatter.ISO_TIME));

        Thread thread2 = new Thread(runnabble2);
        thread2.start();

        //Creer un recordable sous forme de classe anonyme, puis traduction en lambda
        Recordable recordable1 = new Recordable() {
            @Override
            public boolean save() throws Exception {
                System.out.println("Sauvegarde spécifique");
                SystemeDeSauvegarde.getInstance().addRecordable(this);
                return true;
            }
        };

        Recordable recordable2 = () -> {
                System.out.println("Sauvegarde spécifique");
                return true;
            };


        recordable2.save();


        //Ccréation d'un gestionnaire de clique sur un bouton
        ActionListener gestionnaire1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World!");
            }
        };

        ActionListener gestionnaire2 = event -> System.out.println("Hello World!");

        //Creation d'une IHM exposant un bouton
        //Une fenêtre
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Essai de gestion de clique");
        fenetre.setSize(500,200);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //On associe un gestionaire d'affichage à la fenêtre
        fenetre.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Un bouton
        JButton button = new JButton("Cliquer ici");
        fenetre.add(button);

        //Abbonnement du bouton a l'action listener
        button.addActionListener(gestionnaire2);

        fenetre.setVisible(true);

    }//Fin du main

}
