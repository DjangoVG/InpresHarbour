package InpresHarbour;
import java.io.Serializable;
import java.util.ArrayList;

public class Ponton extends Amarrage implements AUnIdentifiant, Serializable{
    private String Identifiant; // Obligation pour le fichier .data
    private int NbrBateaux;
    private int CapacitePonton;
    private int emplacement;
    private ArrayList<MoyenDeTransportSurEau> ListeBateauCote1;
    private ArrayList<MoyenDeTransportSurEau> ListeBateauCote2;    
    
    // Constructeur.
    public Ponton (){
        Identifiant = "INCONNU";
        NbrBateaux = 0;
        CapacitePonton = 0;
        ListeBateauCote1 = new ArrayList<> ();
        ListeBateauCote2 = new ArrayList<> ();        
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
        ListeBateauCote1 = new ArrayList<> (tempA);
        ListeBateauCote2 = new ArrayList<> (tempA);
        for (int i = 0; i < cap; i++){
            if (i < tempA)
                ListeBateauCote1.add (null);
            else
                ListeBateauCote2.add (null);        
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
    
    public ArrayList<MoyenDeTransportSurEau> getListeBateauCote1 (){ return ListeBateauCote1; }
    public void setListeBateauCote1 (ArrayList<MoyenDeTransportSurEau> list){ this.ListeBateauCote1 = list; }   

    public ArrayList<MoyenDeTransportSurEau> getListeBateauCote2 (){ return ListeBateauCote2; }
    public void setListeBateauCote2 (ArrayList<MoyenDeTransportSurEau> list){ this.ListeBateauCote2 = list; }       
    
    public void ajouterBateau (MoyenDeTransportSurEau bpl, int Emplacement, int Cote){
        int nbrBateaux = getNbrBateau();
        if (Cote == 2)
        {
            ListeBateauCote1.add(Emplacement, bpl);
            System.out.println ("Ajouté cote A : " + Emplacement);
        }
        if (Cote == 1)
        {  
            ListeBateauCote2.add(Emplacement, bpl);
            System.out.println ("Ajouté cote b : " + Emplacement );      
        }
        nbrBateaux++;
        setNbrBateau(nbrBateaux);
    }  
    
    public void modifierBateau (MoyenDeTransportSurEau bpl, int emp, int cote){
        int nbr = getNbrBateau();
        if (cote == 2){
            ListeBateauCote1.remove(emp);
            ListeBateauCote1.add(emp, bpl);
            System.out.println ("Ajouté cote A : " + emp);
        }
        if (cote == 1){        
            ListeBateauCote2.remove(emp);
            ListeBateauCote2.add(emp, bpl);
            System.out.println ("Ajouté cote b : " + emp);   
        }
        nbr++;
        setNbrBateau(nbr);
    }      
        
    @Override
    public String toString (){
        return "Ponton " + "\nCapacité du ponton (" + CapacitePonton + ")" + "\nListe des bateaux côté A : " 
                + ListeBateauCote1.toString() + "\nListe des bateaux côté B : " + ListeBateauCote2.toString();
    }
}
