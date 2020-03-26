package InpresHarbour;
import java.io.Serializable;
import java.util.ArrayList;

public class Quai extends Amarrage implements AUnIdentifiant, Serializable{
    private String Identifiant;
    private int NbrBateaux;
    private int Capacite;
    public ArrayList<BateauPeche> listeBateau;
    
    // Constructeur.
    public Quai (){
        Identifiant = "Inconnu";
        Capacite = 0;
        NbrBateaux = 0;
        listeBateau = new ArrayList<> ();
    }  
    public Quai (String id, int cap){
        Identifiant = id;
        Capacite = cap;
        NbrBateaux = 0;
        listeBateau = new ArrayList<> (cap);
        for (int i = 0; i < cap; i++)
            listeBateau.add (null);
    } 
    
    // Get et Set.
    @Override
    public String getIdentifiant (){ return Identifiant; }
    public void setIdentifiant (String id){ this.Identifiant = id; }
    
    @Override
    public int getCapacite (){ return Capacite; }
    public void setCapacite (int max){ this.Capacite = max; }   
    
    public int getNbrBateau(){ return NbrBateaux; }
    public void setNbrBateau(int nbrBat){ this.NbrBateaux = nbrBat; }
    
    public ArrayList<BateauPeche> getListeBateau (){ return listeBateau; }
    public void setListeBateau (ArrayList<BateauPeche> list){ this.listeBateau = list; }   
    
    // Autres fonctions.    
    public void ajouterBateau (BateauPeche bpe, int emp){
        int nbr = getNbrBateau();
        System.out.println ("Ajout du numéro : " + emp);
        listeBateau.add(emp, bpe);
        nbr++;
        setNbrBateau(nbr);
    }  
    
    public void supprimerBateau (int emp){
        int nbr = getNbrBateau();
        listeBateau.remove(emp);
        nbr--;
        setNbrBateau(nbr);
    }      

    @Override
    public String toString (){
        return "Quai " + "\nCapacité du quai (" + Capacite + ")" + "\nListe des bateaux de pêche: " + listeBateau.toString();
    }   
}
