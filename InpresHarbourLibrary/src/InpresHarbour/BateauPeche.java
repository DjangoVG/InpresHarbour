package InpresHarbour;

public class BateauPeche extends Bateau {
    private String type;
    
    public BateauPeche (){
        super();
        type = "inconnu";
    }
    public BateauPeche (String id, boolean sub, String e, String n, String port, float ton, float lg, String pav, Equipage equi,  String t) throws ShipWithoutIdentificationException {
        super(id, sub, e, n, port, ton, lg, pav, equi);
        type = t;
    }
    
    public String getType (){ return type; }
    public void setType (String t){ type = t; }
    
    @Override
    public String toString (){
        return super.toString() + "\nBateau de pêche : type (" + type +")";
    }
}
