package PhareBeans;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.util.EventObject;

public class BateauEvent extends EventObject{
    
    private String dhReception;
    private String typeBoat;
    private String pavillon;
    
    public BateauEvent(Object source, String tb){
       super(source);
       Date maintenant = new Date ();
       setDhReception(new String(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRANCE).format(maintenant)));
       setTypeBoat(tb);
       setPavillon(pickUpAPavillon());
    }

    private String pickUpAPavillon(){
        
        String s = new String();
        Double nbAlea = new Double(Math.floor(Math.random() * 5));
        
        switch(nbAlea.intValue()){
            case 0 : s = "UK";
                break;
            case 1 : s = "BE";
                break;
            case 2 : s = "FR";
                break;
            case 3 : s = "DE";
                break;
            case 4 : s = "NL";
                break;
        }
        
        return s;
    }
    
    public String getDhReception() {
        return dhReception;
    }

    public void setDhReception(String dhReception) {
        this.dhReception = dhReception;
    }

    public String getTypeBoat() {
        return typeBoat;
    }

    public void setTypeBoat(String typeBoat) {
        this.typeBoat = typeBoat;
    }

    public String getPavillon() {
        return pavillon;
    }

    public void setPavillon(String pavillon) {
        this.pavillon = pavillon;
    }
    
}
