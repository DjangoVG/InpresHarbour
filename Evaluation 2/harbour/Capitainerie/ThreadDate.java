package Thread;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import capitainerie.Capitainerie;

public class ThreadDate extends Thread {
    private final Capitainerie fenetreCapitainerie;
    private String Pays;
    private String FormatDate;
    private String FormatHeure;
    private String d;
    public ThreadDate(Capitainerie fs, String sPays, String sDate, String sHeure)
    {
        fenetreCapitainerie = fs;
        if (sPays == null)
        {
            sPays = "France";
            Locale locale;
            Date maintenant = new Date ();
        }
            
        else
        {
            Pays = sPays;
            FormatDate = sDate;
            FormatHeure = sHeure;                
        }

    }
    
    public void run()
    {
        while (true) 
        {
            Locale locale;
            Date maintenant = new Date ();
            switch (Pays){
                case "France":{
                    locale = new Locale ("fr", "FRANCE"); 
                    break;
                }
                case "Royaume-Uni" :{
                    locale = new Locale ("en", "ENGLISH");
                    break;
                }
                case "Allemagne" :{
                    locale = new Locale ("de","GERMAN");
                    break;
                }
                case "Italie" : {
                    locale = new Locale ("it", "ITALIEN");
                    break;
                }
                case "Etats-Unis" : {
                    locale = new Locale ("us", "ENGLISH");
                    break;
                }
                default :
                    locale = new Locale ("fr", "FRANCE"); 
            }

            switch (FormatDate){
                case "22 mars 2020": {
                    if (FormatHeure.equals("12:30:45"))
                        d = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale).format(maintenant);
                    else 
                        d = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, locale).format(maintenant);
                    break;
                }
                case "22 mar. 2020":{
                    if (FormatHeure.equals("12:30:45"))
                        d = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locale).format(maintenant);
                    else
                        d = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, locale).format(maintenant);
                    break;
                }
                case "22/03/2020": {
                    if (FormatHeure.equals("12:30:45"))
                        d = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, locale).format(maintenant);
                    else
                        d = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale).format(maintenant);
                    break;
                }
                default :
                    d = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale).format(maintenant);
            }
            fenetreCapitainerie.LabelDate.setText(d);
            try 
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadDate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}