package PhareBeans;
import Outils.FichierLog;
import java.beans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import Thread.*;

public class TypeBateau implements Serializable, UtilisateurNombre {
       
    private ThreadRandomGenerator trg;
    private String Info;
    private PropertyChangeSupport pcs;
    
    private int nbAlea1;
    private int nbAlea2;
    
    public static FichierLog fichierLog;
    private Properties propServeur;
    private final String repertoireCourant;
    private final String separateur;
    
    public TypeBateau() {
        
        separateur = System.getProperty("file.separator");
        repertoireCourant = System.getProperty("user.dir");        
        String fileProperties = repertoireCourant + separateur + "src" + separateur + "Properties" + separateur +  "ServeurProperties.properties";
        
        fichierLog = new FichierLog("FichierLog.txt");
        propServeur = new Properties ();
        try {
            propServeur.load (new FileInputStream (fileProperties));
        } catch (FileNotFoundException e){
            fichierLog.ecritLigne ("Fichier ServeurProperties.properties non-trouvé.");
        } catch (IOException e){
            fichierLog.ecritLigne ("Erreur d'IO : ServeurProperties.properties" + e.getMessage());
        }    
        
        //RECUPERATION DES PROPERTIES
        
        Double nombreToInt = Double.parseDouble(propServeur.getProperty("sommeilThread"));
        trg = new ThreadRandomGenerator(this, 1, 4, 3, nombreToInt.intValue());
        
        nombreToInt = Double.parseDouble(propServeur.getProperty("nombreAleatoire1"));
        nbAlea1 = nombreToInt.intValue();
        
        nombreToInt = Double.parseDouble(propServeur.getProperty("nombreAleatoire2"));
        nbAlea2 = nombreToInt.intValue();
        
        pcs = new PropertyChangeSupport(this);
        setInfo(null);
    }
    
    public void run(){
        trg.start();
    }
    
    //MODIFICATION DE LA PROPRIETE LIEE
    public void setInfo(String newValue){
        
        if(newValue != null)
        {
            String oldValue = Info;
            Info = new String(newValue);
            pcs.firePropertyChange("Info", oldValue, newValue);
        }
    }
    
    public void addPropertyChangeListener(PropertyChangeListener pcl){
        pcs.addPropertyChangeListener(pcl);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener pcl){
        pcs.removePropertyChangeListener(pcl);
    }
    
    @Override
    public String getIdentifiant(){
        return "TypeBateau";
    }
    
    //VA CREER UN NOUVEAU BATEAU QUAND LE THREAD LE SIGNALE
    @Override
    public void traiteNombre(int n){
        
        Double nbAlea;
        boolean hasToRestart = true;
        
        while(hasToRestart)
        {
            nbAlea = new Double(Math.floor( 1 + (Math.random() * 17)));
            
            System.out.println(nbAlea);
            
            if(nbAlea % nbAlea1 == 0)
            {
                setInfo("Peche");
                hasToRestart = false;
            }
            else if(nbAlea % nbAlea2 == 0)
            {
                setInfo("Plaisance");
                hasToRestart = false;
            }
        }
    }
    
}
