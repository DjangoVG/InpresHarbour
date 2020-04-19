package InpresHarbour;

import java.io.Serializable;
import java.util.Date;

public class Marin extends Humain implements AUnIdentifiant, Serializable {
    
    private String Identifiant; 
    private String Fonction;
    
    public Marin (){
        super();
        Identifiant = "inconnue";
        Fonction = "inconnue";
    }
    public Marin (String id, String n, String p, String nationalite, Date dN,  String fct) throws SailorWithoutIdentificationException{
        super(n, p, nationalite, dN);
        //if((!n.matches("^[a-zA-Z][a-zA-Z]{1,25}$")) || (!p.matches("^[a-zA-Z][a-zA-Z]{1,25}$")))
            //throw new SailorWithoutIdentificationException(id);
        Identifiant = id;
        Fonction = fct;
    }
    
    public String getFonction (){ return Fonction; }    
    public void setFonction (String fct){ this.Fonction = fct; }
    
    @Override
    public String getIdentifiant ()
    {
        return Identifiant;
    }

    @Override
    public String toString (){
        return super.toString() + "), Identifiant (" + Identifiant + "), Fonction (" + Fonction + ")";
    }
}    
