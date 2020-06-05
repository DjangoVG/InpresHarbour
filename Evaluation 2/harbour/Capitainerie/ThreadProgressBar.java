package Thread;
import capitainerie.Capitainerie;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadProgressBar extends Thread {
    private Capitainerie fenCapitainerie;
    
    public ThreadProgressBar(Capitainerie fc)
    {
        fenCapitainerie = fc;
    }
    
    public void run()
    {
        for (int i=0; i<101; i++) 
        {
            try {
                this.sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadProgressBar.class.getName()).log(Level.SEVERE, null, ex);
            }
            fenCapitainerie.ProgressDemarrage.setValue(i);
            fenCapitainerie.BoutonDemarrerServeur.setEnabled(false);
            fenCapitainerie.BoutonArrêterServeur.setEnabled(true);
        }
    }
}
