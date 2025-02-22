package PhareBeans;
import Phare.Phare;
import java.beans.*;
import javax.swing.DefaultListModel;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class NotifBean implements Serializable, BateauEventListener{
    
    @Override
    public void BateauEventDetected(BateauEvent be){
        //AJOUT A LA LISTE D'ATTENTE DE PHARE
        DefaultListModel dlmAttente = new DefaultListModel();
        dlmAttente = (DefaultListModel) Phare.ListeAttente.getModel();
        dlmAttente.addElement(be.getTypeBoat()+ "/" + be.getPavillon());
        
        //AFFICHAGE DE LA FENETRE DE DIALOGUE MODALE
        JOptionPane jop = new JOptionPane();
        String s2 = new String("(" + be.getDhReception() + ") Bateau en entrée : " + be.getTypeBoat() + "/" + be.getPavillon());
        java.awt.EventQueue.invokeLater(() -> {
            jop.showMessageDialog(null, s2);
        }); 
        
    }
}
