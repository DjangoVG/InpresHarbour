package InpresHarbour;
import java.io.*;
import java.util.Date;

public class Humain implements Serializable {
    protected String Nom;
    protected String Prenom;
    protected Date DateNaissance;
    protected String Nationalite;
    
    public Humain (){
        Nom = null;
        Prenom = null;
        DateNaissance = null;
        Nationalite = null;
    }
    
    public Humain (String n, String p, String Nationalite, Date dN){
        Nom = n;
        Prenom = p;
        DateNaissance = dN;
        this.Nationalite = Nationalite;
    }
    
    public String getNom (){ return Nom; }
    public void setNom (String n){ this.Nom = n; }
    
    public String getPrenom (){ return Prenom; }
    public void setPrenom (String p){ this.Prenom = p; }
    
    public Date getDateNaissance (){ return DateNaissance; }
    public void setDateNaissance (Date DateNaissance){ this.DateNaissance = DateNaissance; }
    
    public String getNationalite (){ return Nationalite; }
    public void setNationalite (String Nationalite){ this.Nationalite = Nationalite; }
    
    @Override
    public String toString (){
        return "\nNom (" + Nom + "), Prenom (" + Prenom + "), Date de naissance (" + DateNaissance;
    }   
}