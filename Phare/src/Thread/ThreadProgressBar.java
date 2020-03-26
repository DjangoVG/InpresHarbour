package Thread;
import Phare.Phare;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadProgressBar extends Thread {
    private Phare phare;
    
    public ThreadProgressBar(Phare p)
    {
        phare = p;
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
            phare.ProgressDemarrage.setValue(i);
            phare.BoutonDemarrerServeur.setEnabled(false);
            phare.BoutonArrêterServeur.setEnabled(true);
            phare.BoutonSuivant.setEnabled(true);
        }
    }
}
