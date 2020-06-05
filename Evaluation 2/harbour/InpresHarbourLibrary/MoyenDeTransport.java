package InpresHarbour;
import java.io.Serializable;

public abstract class MoyenDeTransport implements AvecHumains, Serializable{
    
    protected String Energie;
    
    public MoyenDeTransport (){}
    public MoyenDeTransport (String e){
        Energie = e;
    }
    
    public String getEnergie () { return Energie; }
    public void setEnergie (String e) { this.Energie = e; }  

    @Override
    public abstract int getNombreHumains();
}
