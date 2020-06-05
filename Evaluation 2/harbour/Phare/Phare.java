package Phare;
import Authentification.LoginPhare;
import FenetresEnOption.*;
import Outils.FichierLog;
import java.beans.*;
import PhareBeans.*;
import Thread.ThreadProgressBar;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import network.NetworkBasicClient;

public class Phare extends javax.swing.JFrame {

    private NetworkBasicClient cli;
    private final DefaultListModel dlmAttente;
    private Properties propServeur;
    public static FichierLog fichierLog;
    private final String repertoireCourant;
    private final String separateur;
    
    private TypeBateau TypeBateauBean;
    private BateauBean BateauBeann;
    private NotifBean NotifBeann;
    
    @SuppressWarnings("static-access")
    public Phare() {
        initComponents();
        fichierLog = new FichierLog("FichierLog.txt");
        separateur = System.getProperty("file.separator");
        repertoireCourant = System.getProperty("user.dir");        
        
        String fileProperties = repertoireCourant + separateur + "src" + separateur + "Properties" + separateur +  "ServeurProperties.properties";
        fichierLog.ecritLigne (fileProperties);
        
        propServeur = new Properties ();
        try {
            fichierLog.ecritLigne ("Nous avons chargé le fichier properties.");
            propServeur.load (new FileInputStream (fileProperties));
        } catch (FileNotFoundException e){
            fichierLog.ecritLigne ("Fichier ServeurProperties.properties non-trouvé.");
        } catch (IOException e){
            fichierLog.ecritLigne ("Erreur d'IO : ServeurProperties.properties" + e.getMessage());
        }    
        
        //CREATION DES BEANS
        try{
            TypeBateauBean = (TypeBateau) Beans.instantiate(null, "PhareBeans.TypeBateau");
        }
        catch(ClassNotFoundException e){
            fichierLog.ecritLigne("Classe TypeBateau non trouvée");
        }
        catch(IOException e){
            fichierLog.ecritLigne("Fichier de sérialisation non trouvé");
        }
        
        try{
            BateauBeann = (BateauBean) Beans.instantiate(null, "PhareBeans.BateauBean");
        }
        catch(ClassNotFoundException e){
            fichierLog.ecritLigne("Classe BateauBean non trouvée");
        }
        catch(IOException e){
            fichierLog.ecritLigne("Fichier de sérialisation non trouvé");
        }
        
        try{
            NotifBeann = (NotifBean) Beans.instantiate(null, "PhareBeans.NotifBean");
        }
        catch(ClassNotFoundException e){
            fichierLog.ecritLigne("Classe NotifBean non trouvée");
        }
        catch(IOException e){
            fichierLog.ecritLigne("Fichier de sérialisation non trouvé");
        }
        
        TypeBateauBean.addPropertyChangeListener(BateauBeann);
        BateauBeann.addAlertBoatEventListener(NotifBeann);
        
        dlmAttente = new DefaultListModel();
        dlmAttente.addElement("Peche/BE");
        dlmAttente.addElement("Plaisance/UK");
        dlmAttente.addElement("Peche/FR");
        this.ListeAttente.setModel(dlmAttente);
        
        //DEMARRAGE DE L'ARRIVEE ALEATOIRE DES BATEAUX
        TypeBateauBean.run();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BoutonDemarrerServeur = new javax.swing.JButton();
        ProgressDemarrage = new javax.swing.JProgressBar();
        BoutonArrêterServeur = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeAttente = new javax.swing.JList<>();
        BoutonSuivant = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LabelBateauIdentifie = new javax.swing.JTextField();
        BoutonAutorisationEntree = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        LabelReponseCapit = new javax.swing.JTextField();
        BoutonRAZ = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        BoutonEntreeRade = new javax.swing.JButton();
        LabelBateauEntreRade = new javax.swing.JTextField();
        MenuBarCapitainerie = new javax.swing.JMenuBar();
        MenuUtilisateur = new javax.swing.JMenu();
        MenuLogin = new javax.swing.JMenuItem();
        MenuLogout = new javax.swing.JMenuItem();
        MenuNewUser = new javax.swing.JMenuItem();
        MenuParametres = new javax.swing.JMenu();
        MenuFichierLOG = new javax.swing.JMenuItem();
        MenuAPropos = new javax.swing.JMenu();
        MenuAuteur = new javax.swing.JMenuItem();
        MenuAide = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Bienvenue sur le panel du Phare");

        BoutonDemarrerServeur.setText("Se connecter au serveur");
        BoutonDemarrerServeur.setEnabled(false);
        BoutonDemarrerServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonDemarrerServeurActionPerformed(evt);
            }
        });

        ProgressDemarrage.setStringPainted(true);

        BoutonArrêterServeur.setText("Se déconnecter du serveur");
        BoutonArrêterServeur.setEnabled(false);
        BoutonArrêterServeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonArrêterServeurActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ListeAttente);

        BoutonSuivant.setText("Suivant");
        BoutonSuivant.setEnabled(false);
        BoutonSuivant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonSuivantActionPerformed(evt);
            }
        });

        jLabel2.setText("Bateau identifié :");

        LabelBateauIdentifie.setEnabled(false);

        BoutonAutorisationEntree.setText("Demander une autorisation d'entrée");
        BoutonAutorisationEntree.setEnabled(false);
        BoutonAutorisationEntree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAutorisationEntreeActionPerformed(evt);
            }
        });

        jLabel3.setText("Réponse de la Capitainerie :");

        LabelReponseCapit.setEnabled(false);

        BoutonRAZ.setText("RAZ");
        BoutonRAZ.setEnabled(false);

        BoutonEntreeRade.setText("Bateau entré dans la rade");
        BoutonEntreeRade.setEnabled(false);
        BoutonEntreeRade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonEntreeRadeActionPerformed(evt);
            }
        });

        LabelBateauEntreRade.setEnabled(false);

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

        MenuParametres.setText("Paramètres");
        MenuParametres.setEnabled(false);

        MenuFichierLOG.setText("Fichier log");
        MenuFichierLOG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFichierLOGActionPerformed(evt);
            }
        });
        MenuParametres.add(MenuFichierLOG);

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
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BoutonSuivant)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BoutonEntreeRade)
                        .addGap(18, 18, 18)
                        .addComponent(LabelBateauEntreRade))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(LabelReponseCapit, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoutonRAZ))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2)
                                .addGap(95, 95, 95)
                                .addComponent(LabelBateauIdentifie, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonDemarrerServeur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProgressDemarrage, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BoutonArrêterServeur))
                            .addComponent(BoutonAutorisationEntree))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonDemarrerServeur)
                    .addComponent(ProgressDemarrage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoutonArrêterServeur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoutonSuivant))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(LabelBateauIdentifie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addGap(11, 11, 11)
                .addComponent(BoutonAutorisationEntree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LabelReponseCapit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoutonRAZ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonEntreeRade)
                    .addComponent(LabelBateauEntreRade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonDemarrerServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonDemarrerServeurActionPerformed
        cli = new NetworkBasicClient((String) propServeur.getProperty("adresse"), Integer.valueOf((String) propServeur.getProperty("portEcoute")));
        ThreadProgressBar tpb = new ThreadProgressBar(this);
        tpb.start();
    }//GEN-LAST:event_BoutonDemarrerServeurActionPerformed

    private void BoutonArrêterServeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonArrêterServeurActionPerformed
        cli.setEndSending(); 
        this.BoutonDemarrerServeur.setEnabled(true);
        this.BoutonArrêterServeur.setEnabled(false);
    }//GEN-LAST:event_BoutonArrêterServeurActionPerformed

    private void BoutonSuivantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSuivantActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new IdentificationBateau().setVisible(true);
        });
    }//GEN-LAST:event_BoutonSuivantActionPerformed

    private void BoutonEntreeRadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonEntreeRadeActionPerformed
        String msg = LabelBateauIdentifie.getText() + " / " + LabelReponseCapit.getText();
        String rep = cli.sendString (msg);
        LabelBateauEntreRade.setText (rep);
        BoutonEntreeRade.setEnabled(false);
        BoutonSuivant.setEnabled(true);
    }//GEN-LAST:event_BoutonEntreeRadeActionPerformed

    private void BoutonAutorisationEntreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAutorisationEntreeActionPerformed
        String msg = LabelBateauIdentifie.getText();
        String rep = cli.sendString (msg);
        System.out.println("Je reçois un message : " + rep);
        if ("Erreur".equals(rep)){
            LabelBateauEntreRade.setText("Le bateau est déjà amarré");
            BoutonSuivant.setEnabled(true);
        }
        else{     
            String Element = ListeAttente.getSelectedValue();
            dlmAttente.removeElement(Element);
            ListeAttente.setModel(dlmAttente);
            LabelReponseCapit.setText (rep);
            BoutonSuivant.setEnabled(false);
            BoutonAutorisationEntree.setEnabled(false);
            BoutonEntreeRade.setEnabled(true);
        }
    }//GEN-LAST:event_BoutonAutorisationEntreeActionPerformed

    private void MenuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLoginActionPerformed
        LoginPhare LogPhare;
        LogPhare = new LoginPhare(this, true);
        LogPhare.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        LogPhare.setVisible(true);
    }//GEN-LAST:event_MenuLoginActionPerformed

    private void MenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLogoutActionPerformed
        MenuParametres.setEnabled(false);
        BoutonDemarrerServeur.setEnabled(false);
        BoutonSuivant.setEnabled(false);
        MenuLogout.setEnabled(false);
        BoutonEntreeRade.setEnabled(false);
        BoutonAutorisationEntree.setEnabled(false);
        MenuLogin.setEnabled(true);
        MenuNewUser.setEnabled(false);
    }//GEN-LAST:event_MenuLogoutActionPerformed

    private void MenuNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNewUserActionPerformed
        LoginPhare LogPhare;
        LogPhare = new LoginPhare(this, true);
        LogPhare.BoutonConnexion.setText("Ajouter");
        LogPhare.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        LogPhare.setVisible(true);
    }//GEN-LAST:event_MenuNewUserActionPerformed

    private void MenuFichierLOGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFichierLOGActionPerformed
        String sLog = fichierLog.litFichier();
        java.awt.EventQueue.invokeLater(() -> {
            new FenetreLog(sLog).setVisible(true);
        });
    }//GEN-LAST:event_MenuFichierLOGActionPerformed

    private void MenuAuteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAuteurActionPerformed
        FenetreAuteur fen = new FenetreAuteur();
        fen.setVisible(true);
    }//GEN-LAST:event_MenuAuteurActionPerformed

    private void MenuAideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAideActionPerformed
        FenetreAide fen = new FenetreAide();
        fen.setVisible(true);
    }//GEN-LAST:event_MenuAideActionPerformed

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
                new Phare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BoutonArrêterServeur;
    public static javax.swing.JButton BoutonAutorisationEntree;
    public javax.swing.JButton BoutonDemarrerServeur;
    private javax.swing.JButton BoutonEntreeRade;
    private javax.swing.JButton BoutonRAZ;
    public javax.swing.JButton BoutonSuivant;
    private javax.swing.JTextField LabelBateauEntreRade;
    public static javax.swing.JTextField LabelBateauIdentifie;
    private javax.swing.JTextField LabelReponseCapit;
    public static javax.swing.JList<String> ListeAttente;
    private javax.swing.JMenu MenuAPropos;
    private javax.swing.JMenuItem MenuAide;
    private javax.swing.JMenuItem MenuAuteur;
    private javax.swing.JMenuBar MenuBarCapitainerie;
    public javax.swing.JMenuItem MenuFichierLOG;
    public javax.swing.JMenuItem MenuLogin;
    public javax.swing.JMenuItem MenuLogout;
    public javax.swing.JMenuItem MenuNewUser;
    private javax.swing.JMenu MenuParametres;
    private javax.swing.JMenu MenuUtilisateur;
    public javax.swing.JProgressBar ProgressDemarrage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
