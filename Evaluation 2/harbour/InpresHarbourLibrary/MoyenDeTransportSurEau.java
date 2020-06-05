package InpresHarbour;

public abstract class MoyenDeTransportSurEau extends MoyenDeTransport {
    
    protected boolean estSubmersible;
    
    public MoyenDeTransportSurEau (){
        super();
    }
    public MoyenDeTransportSurEau (boolean sub, String e){
        super(e);
        estSubmersible = sub;
    }
    
    public boolean getEstSubmersible() { return estSubmersible; }
    public void setEstSubmersible (boolean sub) { this.estSubmersible = sub; }
    
   @Override
    public abstract String toString ();   
}
