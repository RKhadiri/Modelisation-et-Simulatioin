package signalisation;
import java.util.Random;

public class feu {
    Random rd = new Random();
    double Rouge=30,Vert=60,tau=90;
    public double Arrivée() {
        return (double)rd.nextInt((int)tau);
    }
    public double Attente(double t) {
        return t<Rouge? Rouge-t:0;
    }

}
