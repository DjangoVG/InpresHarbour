package capitainerie;
import Authentification.LoginCapitainerie;
import FenetresEnOption.*;
import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import InpresHarbour.Equipage;
import InpresHarbour.Marin;
import InpresHarbour.Ponton;
import InpresHarbour.Quai;
import InpresHarbour.SailorWithoutIdentificationException;
import InpresHarbour.ShipWithoutIdentificationException;
import Thread.ThreadDate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import network.NetworkBasicServer;
import Outils.FichierLog;
import Thread.ThreadProgressBar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Capitainerie extends javax.swing.JFrame {
    private NetworkBasicServer NServer;
    private Properties propServeur;
    public ThreadDate td;
    private final String separateur;
    private final String repertoireCourant;
    public static DefaultTableModel DTMBateaux;
    
    public static ArrayList<BateauPlaisance> ListeBateauxPlaisances;
    public static ArrayList<BateauPeche> ListeBateauPeches;   
    public static ArrayList<Ponton> ListePonton;
    public static ArrayList<Quai> ListeQuai; 
    public static Equipage equipage;
    public static FichierLog fichierLog;
        
    private File fichierPlaisance;
    private File fichierPeche;
    private File fichierQuai;
    private File fichierPonton;
    
    public Capitainerie() {
        initComponents();
        
        fichierLog = new FichierLog("FichierLog.txt");
        separateur = System.getProperty("file.separator");
        repertoireCourant = System.getProperty("user.dir");
        
        String fileProperties = repertoireCourant + separateur + "src" + separateur + "Properties" + separateur +  "ServeurProperties.properties";
        propServeur = new Properties ();
        try {
            propServeur.load (new FileInputStream (fileProperties));
            
        } catch (FileNotFoundException e){
            fichierLog.ecritLigne ("Fichier ServeurProperties.properties non-trouvé.");
        } catch (IOException e){
            fichierLog.ecritLigne ("Erreur d'IO : ServeurProperties.properties" + e.getMessage());
        }    
        
        DTMBateaux = new DefaultTableModel ();
        DTMBateaux.addColumn("Identifiant");
        DTMBateaux.addColumn("Nom");
        DTMBateaux.addColumn("Longueur");
        DTMBateaux.addColumn("Pavillon");
        DTMBateaux.addColumn("Emplacement");
        DTMBateaux.addColumn("Type");
        TableBateaux.setModel(DTMBateaux);
        
        // Création des différentes listes
        ListeBateauxPlaisances = new ArrayList();
        ListePonton = new ArrayList();
        ListeBateauPeches = new ArrayList();
        ListeQuai = new ArrayList();
        System.out.println("Création du Ponton/Quai");
        try 
        {
            Marin Capitaine1 = new Marin ("85.02.01-002.00", "Claes", "Isen", new Date ("08/02/1993"), "Capitaine");
            Marin Capitaine2 = new Marin ("02.04.21-525.54", "Lourant", "Jacques", new Date ("15/04/1998"), "Capitaine");
            Marin Capitaine3 = new Marin ("02.98.21-665.35", "Evrard", "Régis", new Date ("23/08/1990"), "Capitaine");
            Marin Capitaine4 = new Marin ("02.04.21-458.22", "Fiori", "Patrick", new Date ("23/10/1991"), "Capitaine");
            Marin Second1 = new Marin ("11.45.21-554.65", "Manso Pescador", "Lea", new Date ("26/01/1996"), "Second");
            Marin Second2 = new Marin ("47.04.98-896.22", "Costas", "Diego", new Date ("04/11/2001"), "Second");
            Marin Second3 = new Marin ("02.16.21-524.52", "Louam", "Stephane", new Date ("08/11/1993"), "Second");
            Marin Second4 = new Marin ("11.98.21-854.22", "Dubois", "Hugo", new Date ("23/06/1998"), "Second");
            Marin Bosco1 = new Marin ("23.45.58-256.55", "Petit", "Benjamin", new Date ("26/02/1994"), "Bosco");
            Marin Bosco2 = new Marin ("55.04.21-215.22", "Boraita", "Manuel", new Date ("15/04/1994"), "Bosco");
            Marin Matelot1 = new Marin ("47.58.21-458.31", "Sisou", "Louis", new Date ("01/01/1999"), "Matelot");
            Marin Matelot2 = new Marin ("85.86.21-221.17", "Winandy", "Alexia", new Date ("05/11/1995"), "Matelot");
            Marin Passager1 = new Marin ("65.22.21-124.21", "Troisfrere", "Michel", new Date ("23/10/1984"), "Passager");
            Marin Passager2 = new Marin ("36.04.21-125.22", "Boulout", "Aurelie", new Date ("29/12/1968"), "Passager");
            
            // -------------
            Equipage Equipage1 = new Equipage (Capitaine1, Second1);
            Equipage Equipage2 = new Equipage (Capitaine2, Second2); 
            
            Equipage Equipage3 = new Equipage (Capitaine3, Second3);
            Equipage3.ajouterMarin(Bosco1);
            Equipage3.ajouterMarin(Matelot1); 
            Equipage3.ajouterMarin(Passager1);  
            
            Equipage Equipage4 = new Equipage (Capitaine4, Second4);
            Equipage4.ajouterMarin(Bosco2);
            Equipage4.ajouterMarin(Matelot2); 
            Equipage4.ajouterMarin(Passager2);
            // -------------
            BateauPlaisance BateauPlaisance1 = new BateauPlaisance ("BE-1236589", false, "Voile", "Marie basse", "Anvers", 1.5f, 4.5f, "BE", Equipage1, "Option Metallique");
            BateauPlaisance BateauPlaisance2 = new BateauPlaisance ("BE-1425874", false, "Voile", "Marie Hurlante", "Nantes", 1.5f, 4.5f, "BE", Equipage2, "Voiles supplémentaires"); 
            BateauPeche BateauPeche1 = new BateauPeche ("BE-1457455", false, "Diesel", "Boutounon", "Roubaix", 1.5f, 10.5f, "BE", Equipage3, "Chalutier");
            BateauPeche BateauPeche2 = new BateauPeche ("BE-2147856", false, "Nucléaire", "Black Pearl", "St-Jacques", 1.5f, 10.5f, "FR", Equipage4, "Thonnier");   
            //--------------
            ListeBateauxPlaisances.add(BateauPlaisance1);
            ListeBateauxPlaisances.add(BateauPlaisance2);
            ListeBateauPeches.add(BateauPeche1);
            ListeBateauPeches.add(BateauPeche2);
            // --------------
            Ponton Ponton1 = new Ponton("1", 5);
            Ponton Ponton2 = new Ponton ("2", 6);
            Ponton Ponton3 = new Ponton ("3", 4);
            Ponton Ponton4 = new Ponton ("4", 3);
            Ponton Ponton5 = new Ponton ("5", 4);
            Ponton Ponton6 = new Ponton ("6", 8);
            Quai Quai1 = new Quai("1", 5);
            Quai Quai2 = new Quai ("2", 6);
            Quai Quai3 = new Quai ("3", 4);
            Quai Quai4 = new Quai ("4", 4);
            Quai Quai5 = new Quai ("5", 4);
            Quai Quai6 = new Quai ("6", 4);
            //--------------
            ListePonton.add(Ponton1);
            ListePonton.add(Ponton2);
            ListePonton.add(Ponton3);
            ListePonton.add(Ponton4);
            ListePonton.add(Ponton5);
            ListePonton.add(Ponton6);  
            ListeQuai.add(Quai1);
            ListeQuai.add(Quai2);
            ListeQuai.add(Quai3);
            ListeQuai.add(Quai4);
            ListeQuai.add(Quai5);
            ListeQuai.add(Quai6);
            //--------------
            Ponton1.ajouterBateau(BateauPlaisance1, 0, 1);
            Ponton1.ajouterBateau(BateauPlaisance2, 1, 2);
            Quai1.ajouterBateau(BateauPeche1, 0);

        } catch (SailorWithoutIdentificationException ex) {
            fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
        } catch (ShipWithoutIdentificationException ex) {
            fichierLog.ecritLigne ("ShipWithoutIdentificationException : " + ex.getMessage());
        }
        
        File dirPlaisance = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Plaisance");
        boolean dirExistPlaisance = dirPlaisance.exists();
        if (!dirExistPlaisance){                        
            dirPlaisance.mkdirs();
            fichierPlaisance = new File(dirPlaisance + separateur + "Plaisance.data");
            try {
                fichierLog.ecritLigne ("Aucun bateau de plaisance existe : création du sous dossier Plaisance avec un Plaisance.data.");
                FileOutputStream fos = new FileOutputStream(fichierPlaisance);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListeBateauxPlaisances);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPlaisance + " a bien été crée");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPlaisance + "non trouvé en écriture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture sur le fichier : " + fichierPlaisance + " avec comme message : " + ex);
            }    
        }
        else 
        {
            // Permet la création de la liste quai en la désérialisant
            fichierPlaisance = new File(dirPlaisance + separateur + "Plaisance.data");
            try {
                fichierLog.ecritLigne (fichierPlaisance +" existe déjà, lecture du fichier.");
                FileInputStream fis = new FileInputStream(fichierPlaisance);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ListeBateauxPlaisances = (ArrayList<BateauPlaisance>) ois.readObject();
                ois.close();
                fis.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPlaisance + " a bien été lu");
            } 
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPlaisance + "non trouvé en lecture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en lecture sur le fichier : " + fichierPlaisance + " avec comme message : " + ex); 
            } 
            catch (ClassNotFoundException ex) {
                fichierLog.ecritLigne ("Problème de casting en lecture sur le fichier : " + fichierPlaisance + " avec comme message : " + ex);
            }                 
        }

        // Enregistrement de la liste des pontons soit le fichier n'existe pas, on le crée avec la liste créée plus haut
        // soit il existe déjà, on le lit et on change la liste.        
        File dirPonton = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Ponton");
        boolean dirExistPonton = dirPonton.exists();
        if (!dirExistPonton)
        {   
            dirPonton.mkdirs();
            fichierPonton = new File(dirPonton + separateur + "Ponton.data");
            try {
                fichierLog.ecritLigne ("Aucun Ponton existe : création du sous dossier Ponton avec un Ponton.data.");
                FileOutputStream fos = new FileOutputStream(fichierPonton);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListePonton);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier Ponton.data a bien été crée");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPonton + "non trouvé en écriture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture sur le fichier : " + fichierPonton + " avec comme message : " + ex);
            }
        }
        else
        {
            // Permet la création de la liste quai en la désérialisant
            fichierPonton = new File(dirPonton + separateur + "Ponton.data");
            try {
                fichierLog.ecritLigne (fichierPonton +" existe déjà, lecture du fichier.");
                FileInputStream fis = new FileInputStream(fichierPonton);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ListePonton = (ArrayList<Ponton>) ois.readObject();
                ois.close();
                fis.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPonton + " a bien été lu");
            } 
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPonton + "non trouvé en lecture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en lecture sur le fichier : " + fichierPonton + " avec comme message : " + ex); 
            } 
            catch (ClassNotFoundException ex) {
                fichierLog.ecritLigne ("Problème de casting en lecture sur le fichier : " + fichierPonton + " avec comme message : " + ex);
            }                 
        }
        
        
        // Enregistrement de la liste des bateaux pêche soit le fichier n'existe pas, on le crée avec la liste créée plus haut
        // soit il existe déjà, on le lit et on change la liste.
        File dirPeche = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Peche");
        boolean dirExistPeche = dirPeche.exists();
        if (!dirExistPeche)
        {                        
            dirPeche.mkdirs();
            fichierPeche = new File(dirPeche + separateur + "Peche.data");
            try {
                fichierLog.ecritLigne ("Aucun bateau de pêche existe : création du sous dossier Peche avec un " + fichierPeche);
                FileOutputStream fos = new FileOutputStream(fichierPeche);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListeBateauPeches);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPeche + " a bien été crée");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPeche + "non trouvé en écriture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture sur le fichier : " + fichierPeche + " avec comme message : " + ex);
            }
        }
        else 
        {
            // Permet la création de la liste quai en la désérialisant
            fichierPeche = new File(dirPeche + separateur + "Peche.data");
            try {
                fichierLog.ecritLigne (fichierPeche +" existe déjà, lecture du fichier.");
                FileInputStream fis = new FileInputStream(fichierPeche);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ListeBateauPeches = (ArrayList<BateauPeche>) ois.readObject();
                ois.close();
                fis.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPeche + " a bien été lu");
            } 
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPeche + "non trouvé en lecture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en lecture sur le fichier : " + fichierPeche + " avec comme message : " + ex); 
            } 
            catch (ClassNotFoundException ex) {
                fichierLog.ecritLigne ("Problème de casting en lecture sur le fichier : " + fichierPeche + " avec comme message : " + ex);
            }                 
        }

        // Enregistrement de la liste des quais soit le fichier n'existe pas, on le crée avec la liste créée plus haut
        // soit il existe déjà, on le lit et on change la liste.   
        File dirQuai = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Quai");
        boolean dirExistQuai = dirQuai.exists();
        if (!dirExistQuai)
        {     
            dirQuai.mkdirs();
            fichierQuai = new File(dirQuai + separateur + "Quai.data");
            try {
                fichierLog.ecritLigne ("Aucun Quai existe : création du sous dossier Quai avec un Quai.data.");
                FileOutputStream fos = new FileOutputStream(fichierQuai);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListeQuai);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier " + fichierQuai + " a bien été crée");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierQuai + "non trouvé en écriture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture sur le fichier : " + fichierQuai + " avec comme message : " + ex);
            }
        }
        else
        {
            // Permet la création de la liste quai en la désérialisant
            fichierQuai = new File(dirQuai + separateur + "Quai.data");
            try {
                fichierLog.ecritLigne (fichierQuai +" existe déjà, lecture du fichier.");
                FileInputStream fis = new FileInputStream(fichierQuai);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ListeQuai = (ArrayList<Quai>) ois.readObject();
                ois.close();
                fis.close();
                fichierLog.ecritLigne ("Le fichier " + fichierQuai + " a bien été lu");
            } 
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierQuai + "non trouvé en lecture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en lecture sur le fichier : " + fichierQuai + " avec comme message : " + ex); 
            } 
            catch (ClassNotFoundException ex) {
                fichierLog.ecritLigne ("Problème de casting en lecture sur le fichier : " + fichierQuai + " avec comme message : " + ex);
            }  
        }
        
        td = new ThreadDate(this, "France", "22/03/2020", "12:30:45");
        td.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        ProgressDemarrage = new javax.swing.JProgressBar();
        BoutonDemarrerServeur = new javax.swing.JButton();
        jCheckBoxRequete = new javax.swing.JCheckBox();
        BoutonLire = new javax.swing.JButton();
        LabelRequete = new javax.swing.JTextField();
        FieldAmarragesPossibles = new javax.swing.JLabel();
        BoutonChoisir = new javax.swing.JButton();
        LabelAmarrageChoisir = new javax.swing.JTextField();
        BoutonEnvoyerChoix = new javax.swing.JButton();
        LabelEnvoyerChoix = new javax.swing.JTextField();
        BoutonEnvoyerConfirmation = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        PhotoBateau1 = new javax.swing.JLabel();
        PhotoBateau2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        TableBateauScroll = new javax.swing.JScrollPane();
        TableBateaux = new javax.swing.JTable();
        FieldBateauEnEntree = new javax.swing.JLabel();
        BoutonBateauAmarré = new javax.swing.JButton();
        BoutonArrêterServeur = new javax.swing.JButton();
        LabelDate = new javax.swing.JLabel();
        LabelBienvenue = new javax.swing.JLabel();
        MenuBarCapitainerie = new javax.swing.JMenuBar();
        MenuUtilisateur = new javax.swing.JMenu();
        MenuLogin = new javax.swing.JMenuItem();
        MenuLogout = new javax.swing.JMenuItem();
        MenuNewUser = new javax.swing.JMenuItem();
        MenuAmarrage = new javax.swing.JMenu();
        MenuPlaisance = new javax.swing.JMenuItem();
        MenuPeche = new javax.swing.JMenuItem();
        MenuBateau = new javax.swing.JMenu();
        MenuListeBateau = new javax.swing.JMenuItem();
        MenuRechercheBateau = new javax.swing.JMenuItem();
        MenuPersonnel = new javax.swing.JMenu();
        MenuEquipage = new javax.swing.JMenuItem();
        MenuRechercheMarin = new javax.swing.JMenuItem();
        MenuParametres = new javax.swing.JMenu();
        MenuFormatDate = new javax.swing.JMenuItem();
        MenuFichierLOG = new javax.swing.JMenuItem();
        MenuDateCourante = new javax.swing.JMenuItem();
        MenuAPropos = new javax.swing.JMenu();
        MenuAuteur = new javax.swing.JMenuItem();
        MenuAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(0, 679));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ProgressDemarrage.setStringPainted(true);

        BoutonDemarrerServeur.setText("Démarrer le serveur");
        BoutonDemarrerServeur.setEnabled(false);
        BoutonDemarrerServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonDemarrerServeurActionPerformed(evt);
            }
        });

        jCheckBoxRequete.setText("Bateau en attente");
        jCheckBoxRequete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxRequeteMouseClicked(evt);
            }
        });

        BoutonLire.setText("Lire");
        BoutonLire.setEnabled(false);
        BoutonLire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonLireActionPerformed(evt);
            }
        });

        LabelRequete.setEnabled(false);

        FieldAmarragesPossibles.setText("Amarrage(s) possible(s) :");

        BoutonChoisir.setText("Choisir");
        BoutonChoisir.setEnabled(false);
        BoutonChoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonChoisirActionPerformed(evt);
            }
        });

        LabelAmarrageChoisir.setEnabled(false);

        BoutonEnvoyerChoix.setText("Envoyer mon choix");
        BoutonEnvoyerChoix.setEnabled(false);
        BoutonEnvoyerChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonEnvoyerChoixActionPerformed(evt);
            }
        });

        LabelEnvoyerChoix.setEnabled(false);

        BoutonEnvoyerConfirmation.setText("Envoyer la confirmation");
        BoutonEnvoyerConfirmation.setEnabled(false);
        BoutonEnvoyerConfirmation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonEnvoyerConfirmationActionPerformed(evt);
            }
        });

        PhotoBateau1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BateauPeche.jpg"))); // NOI18N

        PhotoBateau2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BateauPlaisance.jpg"))); // NOI18N

        TableBateaux.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableBateauScroll.setViewportView(TableBateaux);

        FieldBateauEnEntree.setText("Bateau(x) en entrée(s)");

        BoutonBateauAmarré.setText("Bateau amarré");
        BoutonBateauAmarré.setEnabled(false);
        BoutonBateauAmarré.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonBateauAmarréActionPerformed(evt);
            }
        });

        BoutonArrêterServeur.setText("Arrêter le serveur");
        BoutonArrêterServeur.setEnabled(false);
        BoutonArrêterServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonArrêterServeurActionPerformed(evt);
            }
        });

        LabelDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        LabelBienvenue.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        LabelBienvenue.setForeground(new java.awt.Color(51, 51, 255));
        LabelBienvenue.setText("Bienvenue sur le panel de la Capitainerie");

        MenuUtilisateur.setText("Utilisateurs");

        MenuLogin.setText("Se connecter");
        MenuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLoginActionPerformed(evt);
            }
        });
        MenuUtilisateur.add(MenuLogin);

        MenuLogout.setText("Se déconnecter");
        MenuLogout.setEnabled(false);
        MenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLogoutActionPerformed(evt);
            }
        });
        MenuUtilisateur.add(MenuLogout);

        MenuNewUser.setText("Ajouter un nouvel utilisateur");
        MenuNewUser.setEnabled(false);
        MenuNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNewUserActionPerformed(evt);
            }
        });
        MenuUtilisateur.add(MenuNewUser);

        MenuBarCapitainerie.add(MenuUtilisateur);

        MenuAmarrage.setText("Amarrage");
        MenuAmarrage.setEnabled(false);

        MenuPlaisance.setText("Bateau de plaisance");
        MenuPlaisance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPlaisanceActionPerformed(evt);
            }
        });
        MenuAmarrage.add(MenuPlaisance);

        MenuPeche.setText("Bateau de pêche");
        MenuPeche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPecheActionPerformed(evt);
            }
        });
        MenuAmarrage.add(MenuPeche);

        MenuBarCapitainerie.add(MenuAmarrage);

        MenuBateau.setText("Bateau");
        MenuBateau.setEnabled(false);

        MenuListeBateau.setText("Liste des bateaux");
        MenuListeBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListeBateauActionPerformed(evt);
            }
        });
        MenuBateau.add(MenuListeBateau);

        MenuRechercheBateau.setText("Rechercher un bateau");
        MenuRechercheBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRechercheBateauActionPerformed(evt);
            }
        });
        MenuBateau.add(MenuRechercheBateau);

        MenuBarCapitainerie.add(MenuBateau);

        MenuPersonnel.setText("Personnel");
        MenuPersonnel.setEnabled(false);

        MenuEquipage.setText("Equipage d'un bateau");
        MenuEquipage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEquipageActionPerformed(evt);
            }
        });
        MenuPersonnel.add(MenuEquipage);

        MenuRechercheMarin.setText("Rechercher un marin");
        MenuRechercheMarin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRechercheMarinActionPerformed(evt);
            }
        });
        MenuPersonnel.add(MenuRechercheMarin);

        MenuBarCapitainerie.add(MenuPersonnel);

        MenuParametres.setText("Paramètres");

        MenuFormatDate.setText("Format de la date");
        MenuFormatDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFormatDateActionPerformed(evt);
            }
        });
        MenuParametres.add(MenuFormatDate);

        MenuFichierLOG.setText("Fichier log");
        MenuFichierLOG.setEnabled(false);
        MenuFichierLOG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFichierLOGActionPerformed(evt);
            }
        });
        MenuParametres.add(MenuFichierLOG);

        MenuDateCourante.setText("Cacher la date-heure courante");
        MenuDateCourante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDateCouranteActionPerformed(evt);
            }
        });
        MenuParametres.add(MenuDateCourante);

        MenuBarCapitainerie.add(MenuParametres);

        MenuAPropos.setText("A propos");

        MenuAuteur.setText("Auteur");
        MenuAuteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAuteurActionPerformed(evt);
            }
        });
        MenuAPropos.add(MenuAuteur);

        MenuAide.setText("Aide");
        MenuAide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAideActionPerformed(evt);
            }
        });
        MenuAPropos.add(MenuAide);

        MenuBarCapitainerie.add(MenuAPropos);

        setJMenuBar(MenuBarCapitainerie);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BoutonDemarrerServeur)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProgressDemarrage, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoutonArrêterServeur, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PhotoBateau2)
                            .addComponent(PhotoBateau1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(FieldBateauEnEntree)
                                .addGap(258, 258, 258))
                            .addComponent(TableBateauScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                            .addComponent(BoutonBateauAmarré, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(FieldAmarragesPossibles))
                            .addComponent(jCheckBoxRequete))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BoutonChoisir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BoutonEnvoyerChoix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BoutonEnvoyerConfirmation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BoutonLire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelEnvoyerChoix)
                                    .addComponent(LabelAmarrageChoisir)
                                    .addComponent(LabelRequete)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(LabelBienvenue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelBienvenue))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonDemarrerServeur)
                    .addComponent(ProgressDemarrage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoutonArrêterServeur))
                .addGap(13, 13, 13)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonLire)
                    .addComponent(LabelRequete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxRequete))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAmarrageChoisir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoutonChoisir)
                    .addComponent(FieldAmarragesPossibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelEnvoyerChoix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoutonEnvoyerChoix))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonEnvoyerConfirmation)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PhotoBateau1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(PhotoBateau2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(FieldBateauEnEntree)
                        .addGap(18, 18, 18)
                        .addComponent(TableBateauScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BoutonBateauAmarré)
                        .addGap(10, 10, 10))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNewUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuNewUserActionPerformed

    private void MenuPecheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPecheActionPerformed
        String TypeBateau = "Peche";
        java.awt.EventQueue.invokeLater(() -> {
            new ListeAmarrage(ListePonton, ListeQuai, TypeBateau).setVisible(true);
        });
    }//GEN-LAST:event_MenuPecheActionPerformed

    private void MenuFormatDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFormatDateActionPerformed
        try {
            if (td.isAlive())
                td.stop();
        } catch (NullPointerException e) {}

        FenetreDate fenetreDate = new FenetreDate(this);
        fenetreDate.setVisible(true);
    }//GEN-LAST:event_MenuFormatDateActionPerformed

    private void MenuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLoginActionPerformed
        LoginCapitainerie LogCapit;
        LogCapit = new LoginCapitainerie(this, true);
        LogCapit.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        LogCapit.setVisible(true);
    }//GEN-LAST:event_MenuLoginActionPerformed

    private void MenuAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAuteurActionPerformed
        FenetreAuteur fen = new FenetreAuteur();
        fen.setVisible(true);
    }//GEN-LAST:event_MenuAuteurActionPerformed

    private void MenuAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAideActionPerformed
        FenetreAide fen = new FenetreAide();
        fen.setVisible(true);
    }//GEN-LAST:event_MenuAideActionPerformed

    private void MenuDateCouranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDateCouranteActionPerformed
        if (LabelDate.isVisible())
        {
            LabelDate.setVisible(false);
            MenuDateCourante.setText("Afficher la date-heure courante");
        }
        else
        {
            LabelDate.setVisible(true);
            MenuDateCourante.setText("Cacher la date-heure courante");
        }
    }//GEN-LAST:event_MenuDateCouranteActionPerformed

    private void MenuListeBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListeBateauActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new ListeBateaux(ListeBateauxPlaisances, ListeBateauPeches).setVisible(true);
        });    
    }//GEN-LAST:event_MenuListeBateauActionPerformed

    private void MenuRechercheBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRechercheBateauActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new RechercheBateau().setVisible(true);
        });
    }//GEN-LAST:event_MenuRechercheBateauActionPerformed

    private void MenuEquipageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEquipageActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new InfosEquipage(ListeBateauxPlaisances, ListeBateauPeches).setVisible(true);
        });
    }//GEN-LAST:event_MenuEquipageActionPerformed

    private void MenuRechercheMarinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRechercheMarinActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new RechercheMarin(ListeBateauxPlaisances, ListeBateauPeches).setVisible(true);
        });
    }//GEN-LAST:event_MenuRechercheMarinActionPerformed

    private void MenuPlaisanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPlaisanceActionPerformed
        String TypeBateau = "Plaisance";
        java.awt.EventQueue.invokeLater(() -> {
            new ListeAmarrage(ListePonton, ListeQuai, TypeBateau).setVisible(true);
        });
    }//GEN-LAST:event_MenuPlaisanceActionPerformed

    private void BoutonChoisirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonChoisirActionPerformed
        String req = LabelRequete.getText (); 
        String[] separe = req.split("/");
        String TypeBateau = separe[0];     
        java.awt.EventQueue.invokeLater(() -> {
            new ListeAmarrage(ListePonton, ListeQuai, TypeBateau).setVisible(true);
        });
    }//GEN-LAST:event_BoutonChoisirActionPerformed

    private void BoutonEnvoyerChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonEnvoyerChoixActionPerformed
        BoutonLire.setEnabled(true);
        BoutonEnvoyerChoix.setEnabled(false);
        String msg = LabelAmarrageChoisir.getText();
        NServer.sendMessage(msg);
    }//GEN-LAST:event_BoutonEnvoyerChoixActionPerformed

    private void MenuFichierLOGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFichierLOGActionPerformed
        String sLog = fichierLog.litFichier();
        java.awt.EventQueue.invokeLater(() -> {
            new FenetreLog(sLog).setVisible(true);
        });
    }//GEN-LAST:event_MenuFichierLOGActionPerformed

    private void BoutonArrêterServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonArrêterServeurActionPerformed
        BoutonDemarrerServeur.setEnabled(true);
        BoutonArrêterServeur.setEnabled(false);        
        NServer.setEndReceiving();  
    }//GEN-LAST:event_BoutonArrêterServeurActionPerformed

    private void BoutonDemarrerServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonDemarrerServeurActionPerformed
        NServer = new NetworkBasicServer(Integer.valueOf((String) propServeur.getProperty("portEcoute")), this.jCheckBoxRequete); 
        ThreadProgressBar tpb = new ThreadProgressBar(this);
        tpb.start();
        BoutonLire.setEnabled(true);
    }//GEN-LAST:event_BoutonDemarrerServeurActionPerformed

    private void BoutonBateauAmarréActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonBateauAmarréActionPerformed
        if (TableBateaux.getSelectedRow() != -1)
        {
            java.awt.EventQueue.invokeLater(() -> {
                new InfosBateau(ListeBateauxPlaisances, ListeBateauPeches, ListePonton, ListeQuai).setVisible(true);
            });            
        }
        else
        {
            String msg;
            msg = "Vous devez sélctionner un bateau dans la liste.";
            JOptionPane.showMessageDialog(this, msg, "Attention !", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BoutonBateauAmarréActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (TableBateaux.getRowCount() != 0)
        {
            String msg;
            msg = "Vous ne pouvez pas fermer ce programme tant qu'il y aura des bateaux en entrée qui attendent d'être enregistré complètement. \nMerci de votre compréhension.";
            JOptionPane.showMessageDialog(this, msg, "Impossible de fermer la capitainerie", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            File dirPlaisance = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Plaisance");
            fichierPlaisance = new File(dirPlaisance + separateur + "Plaisance.data");
            try {
                fichierLog.ecritLigne ("Enregistrement des bateaux de plaisance juste avant la fermeture");
                FileOutputStream fos = new FileOutputStream(fichierPlaisance);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListeBateauxPlaisances);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPlaisance + " a bien été enregistré juste avant la fermeture");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPlaisance + "non trouvé en écriture juste avant la fermeture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture juste avant la fermeture sur le fichier : " + fichierPlaisance + " avec comme message : " + ex);
            }    
            
            File dirPeche = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Peche");
            fichierPeche = new File(dirPeche + separateur + "Peche.data");
            try {
                fichierLog.ecritLigne ("Enregistement des bateaux de pêches juste avant la fermeture.");
                FileOutputStream fos = new FileOutputStream(fichierPeche);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListeBateauPeches);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPeche + " a bien été enregistré juste avant la fermeture");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPeche + "non trouvé en écriture juste avant la fermeture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture juste avant la fermeture sur le fichier : " + fichierPeche + " avec comme message : " + ex);
            }
            
            File dirPonton = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Ponton");
            fichierPonton = new File(dirPonton + separateur + "Ponton.data");
            try {
                fichierLog.ecritLigne ("Enregistrement des bateaux de ponton juste avant la fermeture");
                FileOutputStream fos = new FileOutputStream(fichierPonton);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListePonton);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier " + fichierPonton + " a bien été enregistré juste avant la fermeture");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPonton + " non trouvé en écriture juste avant la fermeture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture juste avant la fermeture sur le fichier : " + fichierPonton + " avec comme message : " + ex);
            }
            
            File dirQuai = new File (repertoireCourant + separateur + "InpresHarbour" + separateur + "Quai");
            fichierQuai = new File(dirQuai + separateur + "Quai.data");
            try {
                fichierLog.ecritLigne ("Enregistrement des bateaux de quai juste avant la fermeture");
                FileOutputStream fos = new FileOutputStream(fichierQuai);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ListeQuai);
                oos.flush();
                oos.close();
                fos.close();
                fichierLog.ecritLigne ("Le fichier " + fichierQuai + " a bien été enregistré juste avant la fermeture");
            }
            catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierQuai + " non trouvé en écriture juste avant la fermeture avec comme message : " + ex);
            }
            catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en écriture juste avant la fermeture sur le fichier : " + fichierQuai + " avec comme message : " + ex);
            }
            System.exit(0);  
        }
    }//GEN-LAST:event_formWindowClosing

    private void MenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLogoutActionPerformed
        BoutonBateauAmarré.setEnabled(false);
        BoutonChoisir.setEnabled(false);
        BoutonEnvoyerConfirmation.setEnabled(false);
        MenuLogout.setEnabled(false);
        BoutonEnvoyerChoix.setEnabled(false);
        BoutonLire.setEnabled(false);
        MenuAmarrage.setEnabled(false);
        MenuBateau.setEnabled(false);
        MenuPersonnel.setEnabled(false);
    }//GEN-LAST:event_MenuLogoutActionPerformed

    private void BoutonLireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonLireActionPerformed
        String msg = NServer.getMessage();
        LabelRequete.setText(msg);
        if (!"RIEN".equals(msg))
        {
            LabelRequete.setText(msg);
            if (msg.indexOf("*")>0)
            {
                String[] separe = msg.split("/");
                String TypeBateau = separe[0];
                String Pavillon = separe[1];
                String NomBateau = separe[2];
                String LongueurBateau = separe[3];
                String ImmatBateau = separe[4];
                String QuaiPonton = separe[5];
                QuaiPonton = QuaiPonton.replaceAll("\\s", "");
                BoutonChoisir.setEnabled(false);
                BoutonEnvoyerConfirmation.setEnabled(true);
                LabelEnvoyerChoix.setText(NomBateau + " <-- " + QuaiPonton);
            }
            else
            {
                BoutonChoisir.setEnabled(true);              
            }
        }
        else
            LabelRequete.setText("Pas de message entrant !");
    }//GEN-LAST:event_BoutonLireActionPerformed

    private void jCheckBoxRequeteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxRequeteMouseClicked
        if (jCheckBoxRequete.isSelected())
            jCheckBoxRequete.setSelected(false);
        else
            jCheckBoxRequete.setSelected(true);
    }//GEN-LAST:event_jCheckBoxRequeteMouseClicked

    private void BoutonEnvoyerConfirmationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonEnvoyerConfirmationActionPerformed
        String msg = LabelEnvoyerChoix.getText();
        NServer.sendMessage(msg);
        BoutonEnvoyerConfirmation.setEnabled(false);
        String[] separe = LabelRequete.getText().split("/");
        String type = separe[0];
        String pavillon = separe[1];
        String nom = separe[2];
        String lg = separe[3];
        float longueur = parseFloat(lg);
        String immatriculation = separe[4];
        immatriculation = immatriculation.replaceAll("\\s", "");
        String id = pavillon + "_" + immatriculation;
        String emplacement = separe[5];
        emplacement = emplacement.replaceAll("\\s", "");
        
        if ("Plaisance".equals(type)){
            String[] sep = emplacement.split("\\*");
            String ep = sep[0];
            String e = ep.substring(1);
            String n = sep[1];
            String c = sep[2];
            int emp = parseInt (e);
            int num = parseInt (n);  
            int cote = parseInt (c);
            try {                
                BateauPlaisance bpl = new BateauPlaisance (id, false, "", nom, "inconnu pour l'instant", 0.0f, longueur, pavillon, null, "");
                Ponton p = ListePonton.get(emp-1);
                p.modifierBateau(bpl, num, cote);
                Vector ligne = new Vector ();                        
                ligne.add (id);
                ligne.add (nom);
                ligne.add (longueur);
                ligne.add (pavillon);
                ligne.add (emplacement);
                ligne.add (type);
                fichierLog.ecritLigne ("Le bateau " + id + " a bien été ajouter temporairement");
                DTMBateaux.addRow(ligne);
                this.TableBateaux.setModel (DTMBateaux);
                BoutonBateauAmarré.setEnabled(true);                
            } catch (ShipWithoutIdentificationException ex) {
                fichierLog.ecritLigne ("ShipWithoutIdentificationException : " + ex.getMessage());
            }

            try {
                FileOutputStream fos = new FileOutputStream(fichierPonton);
                ObjectOutputStream oos = new ObjectOutputStream(fos);                
                oos.writeObject(ListePonton);
                oos.close();
                fos.close();                
            } catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierPonton + "non trouvé en lecture avec comme message : " + ex);
            } catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en lecture sur le fichier : " + fichierPonton + " avec comme message : " + ex); 
            }
        }
        else
        {
            String[] sep = emplacement.split("\\*");
            String ep = sep[0];
            String e = ep.substring(1);
            String n = sep[1];
            System.out.println("e : " + e);
            System.out.println("n : " + n);
            int emp = parseInt (e);
            int num = parseInt (n);                      
            // Permet la création de la liste quai en la désérialisant
            try 
            {
                BateauPeche bpe = new BateauPeche (id, false, "", nom, "inconnu pour l'instant", 0.0f, longueur, pavillon, null, "");
                Quai q = ListeQuai.get(emp-1);
                q.supprimerBateau(num);
                q.ajouterBateau(bpe, num);
                Vector ligne = new Vector ();                        
                ligne.add (id);
                ligne.add (nom);
                ligne.add (longueur);
                ligne.add (pavillon);
                ligne.add (emplacement);
                ligne.add (type);
                fichierLog.ecritLigne ("Le bateau " + id + " a bien été ajouté temporairement");
                DTMBateaux.addRow(ligne);
                this.TableBateaux.setModel (DTMBateaux); 
                BoutonBateauAmarré.setEnabled(true);                
            } catch (ShipWithoutIdentificationException ex) {
                fichierLog.ecritLigne ("ShipWithoutIdentificationException : " + ex.getMessage());
            }
            try {
                FileOutputStream fos = new FileOutputStream(fichierQuai);
                ObjectOutputStream oos = new ObjectOutputStream(fos);                
                oos.writeObject(ListeQuai);
                oos.close();
                fos.close();                
            } catch (FileNotFoundException ex) {
                fichierLog.ecritLigne ("Fichier " + fichierQuai + "non trouvé en lecture avec comme message : " + ex);
            } catch (IOException ex) {
                fichierLog.ecritLigne ("IO Exception en lecture sur le fichier : " + fichierQuai + " avec comme message : " + ex); 
            }                    
        }        
    }//GEN-LAST:event_BoutonEnvoyerConfirmationActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capitainerie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BoutonArrêterServeur;
    public static javax.swing.JButton BoutonBateauAmarré;
    public static javax.swing.JButton BoutonChoisir;
    public javax.swing.JButton BoutonDemarrerServeur;
    public static javax.swing.JButton BoutonEnvoyerChoix;
    public static javax.swing.JButton BoutonEnvoyerConfirmation;
    public static javax.swing.JButton BoutonLire;
    private javax.swing.JLabel FieldAmarragesPossibles;
    private javax.swing.JLabel FieldBateauEnEntree;
    public static javax.swing.JTextField LabelAmarrageChoisir;
    private javax.swing.JLabel LabelBienvenue;
    public javax.swing.JLabel LabelDate;
    private javax.swing.JTextField LabelEnvoyerChoix;
    public static javax.swing.JTextField LabelRequete;
    private javax.swing.JMenu MenuAPropos;
    private javax.swing.JMenuItem MenuAide;
    public javax.swing.JMenu MenuAmarrage;
    private javax.swing.JMenuItem MenuAuteur;
    private javax.swing.JMenuBar MenuBarCapitainerie;
    public javax.swing.JMenu MenuBateau;
    public javax.swing.JMenuItem MenuDateCourante;
    private javax.swing.JMenuItem MenuEquipage;
    public javax.swing.JMenuItem MenuFichierLOG;
    private javax.swing.JMenuItem MenuFormatDate;
    private javax.swing.JMenuItem MenuListeBateau;
    public javax.swing.JMenuItem MenuLogin;
    public javax.swing.JMenuItem MenuLogout;
    private javax.swing.JMenuItem MenuNewUser;
    private javax.swing.JMenu MenuParametres;
    private javax.swing.JMenuItem MenuPeche;
    public javax.swing.JMenu MenuPersonnel;
    private javax.swing.JMenuItem MenuPlaisance;
    private javax.swing.JMenuItem MenuRechercheBateau;
    private javax.swing.JMenuItem MenuRechercheMarin;
    private javax.swing.JMenu MenuUtilisateur;
    private javax.swing.JLabel PhotoBateau1;
    private javax.swing.JLabel PhotoBateau2;
    public javax.swing.JProgressBar ProgressDemarrage;
    private javax.swing.JScrollPane TableBateauScroll;
    public static javax.swing.JTable TableBateaux;
    public javax.swing.JCheckBox jCheckBoxRequete;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
