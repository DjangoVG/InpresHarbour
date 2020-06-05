package InpresHarbour;
import java.io.Serializable;
import java.util.ArrayList;

public class Equipage implements Serializable {
    private int NombreHumains;
    private Marin capitaine;
    private Marin second;
    private ArrayList<Marin> listeMarin;
    
    public Equipage (){
        NombreHumains = 0;
        capitaine = new Marin ();
        second = new Marin();
        listeMarin = new ArrayList<> ();
    }
    public Equipage (Marin cap, Marin sec){
        NombreHumains = 0;
        if (cap != null){
            capitaine = cap;
            NombreHumains++;
        }
        if (sec != null) {
            second = sec;
            NombreHumains++;
        }
        listeMarin = new ArrayList<> ();
    }    
    
    public int getNombreHumains (){ return NombreHumains; }
    public void setNombreHumains (int NbrPers){ this.NombreHumains = NbrPers; }
    
    public Marin getCapitaine (){ return capitaine; }
    public void setCapitaine (Marin cap){ this.capitaine = cap; }
    
    public Marin getSecond (){ return second; }
    public void setSecond (Marin sec){ this.second = sec; }
    
    public ArrayList<Marin> getListeMarin (){ return listeMarin; }
    public void setListeMarin (ArrayList<Marin> list){ this.listeMarin = list; }
    
   public void ajouterMarin (Marin m)
   {
       if (m.getFonction().equalsIgnoreCase("Capitaine"))
           this.setCapitaine(m);
       if (m.getFonction().equalsIgnoreCase("Second"))
           this.setSecond(m);
        int nbrHumains = getNombreHumains();
        ArrayList<Marin> liste = getListeMarin ();
        liste.add(m);
        nbrHumains ++;
        setNombreHumains(nbrHumains);
    }
    
    @Override
    public String toString (){
        return ") \nEquipage : " + "Nombre de personnes à bord (" + NombreHumains + ")" + "\n - Capitaine : " + capitaine.toString () +
            "\n - Second : "+ second.toString () + "\n - Marin : " + listeMarin.toString();
    }   
}
