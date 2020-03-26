package PhareBeans;
import Phare.Phare;
import java.beans.*;
import javax.swing.DefaultListModel;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class NotifyBean implements Serializable, BoatEventListener{
    
    @Override
    public void BoatEventDetected(BoatEvent be){
        //AJOUT A LA LISTE D'ATTENTE DE PHARE
        DefaultListModel dlmAttente = new DefaultListModel();
        dlmAttente = (DefaultListModel) Phare.ListeAttente.getModel();
        dlmAttente.addElement(be.getTypeBoat()+ "/" + be.getPavillon());
        
        //AFFICHAGE DE LA FENETRE DE DIALOGUE MODALE
        JOptionPane jop = new JOptionPane();
        String s2 = new String("(" + be.getDhReception() + " ) Nouveau bateau en vue : " + be.getTypeBoat() + "/" + be.getPavillon());
        jop.showMessageDialog(null, s2);
    }
}
