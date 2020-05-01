package PhareBeans;
import java.beans.*;
import java.util.*;
import java.io.Serializable;

public class BateauBean implements Serializable, PropertyChangeListener {
    
    private Vector listeners;
    
    public BateauBean() {
        listeners = new Vector();
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        BateauEvent be = new BateauEvent(this, pce.getNewValue().toString());
        for(int i = 0; i < listeners.size(); i++)
        {
            BateauEventListener bel = (BateauEventListener) listeners.elementAt(i);
            bel.BateauEventDetected(be);
        }
    }
    
    public void addAlertBoatEventListener(BateauEventListener bel){
        if(!listeners.contains(bel))
            listeners.addElement(bel);
    }
    
    public void removeAlertBoatEventListener(BateauEventListener bel){
        if(listeners.contains(bel))
            listeners.removeElement(bel);
    }
}
