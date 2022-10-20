package Tools;

import java.time.LocalDate;

public class ToolBox
{
    public static LocalDate getRandomLocalDate(int a, int b)
    {
        int jour = 0, mois = 0;
        int annee = 0;
        mois = (int)((Math.random()*100) % 12);

        if(mois == 0)
            mois = 1;

        switch(mois)
        {
            case 1,3,5,7,8,10,12 :
                jour = (int)(Math.random()*100) % 31;
                break;
            case 4,6,9,11 :
                jour = (int)(Math.random()*100) % 30;
                break;
            case 2 :
                jour = (int)(Math.random()*100) % 28;
                break;
            default :
                jour = 0;
        }

        if(jour==0)
            jour = 1;

        int ecart = (ecartAB(a,b));

        if(ecart != 0)
        {
            annee = (int) (Math.random() * 100) % (ecartAB(a, b)) + plusPetiteValeur(a, b);
        }
        else
        {
            annee = a;
        }

        if(jour < 10 && mois < 10)
        {
            return LocalDate.parse((annee) + "-0" + (mois) + "-0" + (jour));
        }
        else if (jour < 10)
        {
            return LocalDate.parse((annee) + "-" + (mois) + "-0" + (jour));
        }
        else if (mois < 10)
        {
            return LocalDate.parse((annee) + "-0" + (mois) + "-" + (jour));
        }

        return LocalDate.parse((annee) + "-" + (mois) + "-" + (jour));
    }

    private static int ecartAB(int a, int b)
    {
        if(a>b)
        {
            return b-a;
        }
        return a-b;
    }

    private static int plusPetiteValeur(int a, int b)
    {
        if(a>b)
        {
            return b;
        }
        return a;
    }
}
