package InpresHarbour;

public class Bateau extends MoyenDeTransportSurEau implements AUnIdentifiant {
    
    protected String identifiant;
    protected String nom;
    protected String portAttache;
    protected float tonnage;
    protected float longueur;
    protected String pavillon;
    protected Equipage pEquipage;
    
    public Bateau (){
        super();
    }
    public Bateau (String id, boolean sub, String e, String n, String port, float ton, float lg, String pav, Equipage equi) throws ShipWithoutIdentificationException{
        super(sub,e);
        identifiant = id;
        nom = n;
        portAttache = port;
        tonnage = ton;
        longueur = lg;
        pavillon = pav;
        if (equi == null)
            pEquipage = new Equipage();
        else
            pEquipage = equi;
    }
    
    // Get et Set.
    public String getNom(){ return nom; }
    public void setNom (String n){ this.nom = n; }
    
    public String getPortAttache(){ return portAttache; }
    public void setPortAttache (String port){ this.portAttache = port; }
    
    public float getTonnage (){ return tonnage; }
    public void setTonnage (float ton){ this.tonnage = ton; }
    
    public float getLongueur (){ return longueur; } 
    public void setLongueur (float lg){ this.longueur = lg; }
    
    public String getPavillon (){ return pavillon; }
    public void setPavillon (String pav){ this.pavillon = pav; }
    
    public Equipage getEquipage (){ return pEquipage; }
    public void setEquipage (Equipage equi){ this.pEquipage = equi; }

    @Override
    public String getIdentifiant (){ return identifiant.toUpperCase(); }

    @Override
    public String toString (){
        return "Bateau : Energie (" + super.Energie + "), Est submersible (" + super.estSubmersible + "), Identifiant (" 
                + getIdentifiant() + "), Nom (" + nom + "), Port d'attache (" + portAttache + "), Tonnage (" + tonnage + "t), Longueur ("
                + longueur + "m), Pavillon (" + pavillon + pEquipage.toString();
    }

    @Override
    public int getNombreHumains() {
        return pEquipage.getNombreHumains();
    }
}
