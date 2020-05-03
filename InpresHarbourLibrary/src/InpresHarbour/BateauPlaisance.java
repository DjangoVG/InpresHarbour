package InpresHarbour;

public class BateauPlaisance extends Bateau {
    private String Permis;
    
    // Constructeurs.
    public BateauPlaisance (){
        super();
        Permis = "inconnu";
    }
    public BateauPlaisance (String id, boolean sub, String e, String n, String port, float ton, float lg, String pav, Equipage equi, String per) throws ShipWithoutIdentificationException {
        super(id, sub, e, n, port, ton, lg, pav, equi);
        Permis = per;
    }
    
    // Get et Set.
    public String getPermis (){ return Permis; }
    public void setPermis (String per){ this.Permis = per; }
    
    // Autres méthodes.
    @Override
    public String toString (){
        return super.toString() + "\nBateau de plaisance : permis (" + Permis + ")";
    }    
}
