/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhareBeans;

import java.beans.*;
import java.util.*;
import java.io.Serializable;

/**
 *
 * @author Timon
 */
public class BoatBean implements Serializable, PropertyChangeListener {
    
    private Vector listeners;
    
    public BoatBean() {
        listeners = new Vector();
    }   

    //LA PROPRIETE LIEE A CHANGE
    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        BoatEvent be = new BoatEvent(this, pce.getNewValue().toString());
        for(int i = 0; i < listeners.size(); i++)
        {
            //APPEL DE LA METHODE DES LISTENERS (NOTIFYBEAN ICI)
            BoatEventListener bel = (BoatEventListener) listeners.elementAt(i);
            bel.BoatEventDetected(be);
        }
    }
    
    public void addAlertBoatEventListener(BoatEventListener bel){
        if(!listeners.contains(bel))
            listeners.addElement(bel);
    }
    
    public void removeAlertBoatEventListener(BoatEventListener bel){
        if(listeners.contains(bel))
            listeners.removeElement(bel);
    }
}
