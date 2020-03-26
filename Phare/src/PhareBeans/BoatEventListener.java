/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhareBeans;

import java.util.EventListener;

/**
 *
 * @author Timon
 */
public interface BoatEventListener extends EventListener{
    public void BoatEventDetected(BoatEvent be);
}
