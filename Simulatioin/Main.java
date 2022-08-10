package signalisation;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int nbr=10000; //Nombre de voitures.

        double  Esperance=0,somme=0, ecartType=0 , squareSum = 0;
        double[] attentes=new double[nbr+1];

        List<Voitures> voitures= new ArrayList<>();
        feu feu = new feu();

        for(int i=0; i<=nbr; i++) {
            Voitures v = new Voitures(feu.Arrivée());
            voitures.add(v);

            somme =somme+feu.Attente(v.getT());

            //Temps d'attente devant une voiture: System.out.println("voiture " +i+" temps d'attente devant un feu rouge:  "+feu.Attente(v.getT()));

            attentes[i]= feu.Attente(v.getT());// en enregistre les temps d'attente pour calculer l'écart type
            System.out.println("le temps d'attente de la voiture "+i+" est = "+attentes[i]);
        }

        Esperance=somme/nbr;
        System.out.println("Nombre de voiture est: " + nbr+",  L'espérance ou la moyenne expérimental est: "+Esperance);




        for (int i = 0; i < attentes.length; i++)
        {

            squareSum += Math.pow(attentes[i] - Esperance, 2);

        }
        ecartType=Math.sqrt((squareSum) / (attentes.length-2 ));

        System.out.println("L'écart type est : " +ecartType);

    }
}
