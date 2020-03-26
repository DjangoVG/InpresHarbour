package InpresHarbour;
import java.io.Serializable;
import java.util.ArrayList;

public class Ponton extends Amarrage implements AUnIdentifiant, Serializable{
    
    private String Identifiant;
    private int NbrBateaux;
    private int CapacitePonton;
    private int emplacement;
    private ArrayList<BateauPlaisance> ListeBateauCoté1;
    private ArrayList<BateauPlaisance> ListeBateauCoté2;    
    
    // Constructeur.
    public Ponton (){
        Identifiant = "inconnu";
        NbrBateaux = 0;
        CapacitePonton = 0;
        ListeBateauCoté1 = new ArrayList<> ();
        ListeBateauCoté2 = new ArrayList<> ();        
    }
    
    public Ponton (String id, int cap){
        Identifiant = id;
        NbrBateaux = 0;
        CapacitePonton = cap;
        int tempA;
        
        if (cap%2 != 0){
            tempA = (cap/2)+1;
        }
        else{
            tempA = cap/2;
        }        
        ListeBateauCoté1 = new ArrayList<> (tempA);
        ListeBateauCoté2 = new ArrayList<> (tempA);
        for (int i = 0; i < cap; i++){
            if (i < tempA)
                ListeBateauCoté1.add (null);
            else
                ListeBateauCoté2.add (null);        
        }
    }    
    
    // Get et Set.
    @Override
    public String getIdentifiant (){ return Identifiant; }
    public void setIdentifiant (String id){ this.Identifiant = id; }
    
    @Override
    public int getCapacite (){ return CapacitePonton; }
    public void setCapacite (int cap){ this.CapacitePonton = cap; }
    
    public int getEmplacement(){ return emplacement; }
    public void setEmplacement(int emp){ emplacement = emp; }
        
    public int getNbrBateau(){ return NbrBateaux; }
    public void setNbrBateau(int nbrBat){ this.NbrBateaux = nbrBat; }  
    
    public ArrayList<BateauPlaisance> getListeBateauCoté1 (){ return ListeBateauCoté1; }
    public void setListeBateauCoté1 (ArrayList<BateauPlaisance> list){ this.ListeBateauCoté1 = list; }   

    public ArrayList<BateauPlaisance> getListeBateauCoté2 (){ return ListeBateauCoté2; }
    public void setListeBateauCoté2 (ArrayList<BateauPlaisance> list){ this.ListeBateauCoté2 = list; }       
    
    public void ajouterBateau (BateauPlaisance bpl, int Emplacement, int Cote){
        int NbrBateaux = getNbrBateau();
        if (Cote == 1){
            ListeBateauCoté1.add(Emplacement, bpl);
            System.out.println ("Ajouté cote A : " + Emplacement);
        }
        if (Cote == 2){  
            ListeBateauCoté2.add(Emplacement, bpl);
            System.out.println ("Ajouté cote b : " + Emplacement );      
        }
        NbrBateaux++;
        setNbrBateau(NbrBateaux);
    }  
    
    public void modifierBateau (BateauPlaisance bpl, int emp, int cote){
        int nbr = getNbrBateau();
        if (cote == 1){
            ListeBateauCoté1.remove(emp);
            ListeBateauCoté1.add(emp, bpl);
            System.out.println ("Ajouté cote A : " + emp);
        }
        if (cote == 2){        
            ListeBateauCoté2.remove(emp);
            ListeBateauCoté2.add(emp, bpl);
            System.out.println ("Ajouté cote b : " + emp);   
        }
        nbr++;
        setNbrBateau(nbr);
    }      
        
    @Override
    public String toString (){
        return "Ponton " + "\nCapacité du ponton (" + CapacitePonton + ")" + "\nListe des bateaux de plaisance côté A : " 
                + ListeBateauCoté1.toString() + "\nListe des bateaux de plaisance côté B : " + ListeBateauCoté2.toString();
    }
}
