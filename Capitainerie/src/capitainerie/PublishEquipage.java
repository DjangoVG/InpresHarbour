package capitainerie;

import FenetresEnOption.*;
import InpresHarbour.Equipage;
import InpresHarbour.Marin;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import InpresHarbour.SailorWithoutIdentificationException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import static capitainerie.InfosBateau.equipage;

public class PublishEquipage extends javax.swing.JFrame {
    private final DefaultTableModel DTMEquipage;
   
    public PublishEquipage(Equipage equipage) {
        initComponents();
        
        
        String NomBateau = InfosBateau.LabelNomBateau.getText();
        NomBateau += " (" + InfosBateau.LabelPort.getText() + ")";
        LabelBateau.setText(NomBateau);
        
        DTMEquipage = new DefaultTableModel ();
        DTMEquipage.addColumn("Numéro du registre nationnal");
        DTMEquipage.addColumn("Nom");
        DTMEquipage.addColumn("Prénom");
        DTMEquipage.addColumn("Date de naissance");
        DTMEquipage.addColumn("Fonction");   
        this.TableEquipage.setModel(DTMEquipage);
        
        if (equipage.getNombreHumains() > 0){
            Marin Capitaine = equipage.getCapitaine();
            Marin Second = equipage.getSecond();
            if (Capitaine != null){
                Vector ligne = new Vector();
                ligne.add(Capitaine.getIdentifiant());                    
                ligne.add(Capitaine.getNom());
                ligne.add(Capitaine.getPrenom());
                ligne.add(Capitaine.getDateNaissance().getDay() + "/" + Capitaine.getDateNaissance().getMonth() + "/" + Capitaine.getDateNaissance().getYear());
                ligne.add(Capitaine.getFonction());
                DTMEquipage.addRow(ligne);                
            }
            if (Second != null){
                Vector ligne = new Vector();
                ligne.add(Second.getIdentifiant());                    
                ligne.add(Second.getNom());
                ligne.add(Second.getPrenom());
                ligne.add(Second.getDateNaissance().getDay() + "/" + Second.getDateNaissance().getMonth() + "/" + Second.getDateNaissance().getYear());
                ligne.add(Second.getFonction());
                DTMEquipage.addRow(ligne);               
            }
            if (equipage.getListeMarin() != null){
                for (Marin marin : equipage.getListeMarin()){
                    Vector UnMarin = new Vector ();
                    UnMarin.add(marin.getIdentifiant());
                    UnMarin.add(marin.getNom());
                    UnMarin.add(marin.getPrenom());
                    UnMarin.add(marin.getDateNaissance().getDay() + "/" + marin.getDateNaissance().getMonth() + "/" + marin.getDateNaissance().getYear());
                    UnMarin.add(marin.getFonction());
                    DTMEquipage.addRow(UnMarin);
                }
            }
            this.TableEquipage.setModel(DTMEquipage);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BoutonGroupFonction = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LabelBateau = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEquipage = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        LabelNom = new javax.swing.JTextField();
        LabelPrenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BoxJour = new javax.swing.JComboBox<>();
        BoxMois = new javax.swing.JComboBox<>();
        BoxAnnee = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LabelRegistre = new javax.swing.JTextField();
        LabelNationalite = new javax.swing.JTextField();
        BoxBosco = new javax.swing.JRadioButton();
        BoxMatelot = new javax.swing.JRadioButton();
        BoxPassager = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        BoutonAjouter = new javax.swing.JButton();
        BoutonModifier = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        BoutonValider = new javax.swing.JButton();
        BoutonSupprimer = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        BoutonAnnuler = new javax.swing.JButton();
        BoxCapitaine = new javax.swing.JRadioButton();
        BoxSecond = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Fenête d'enregistrement d'un équipage");

        jLabel2.setText("Bateau :");

        LabelBateau.setEnabled(false);

        TableEquipage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom", "Prénom", "Date de naissance", "Fonction"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableEquipage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableEquipageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableEquipage);
        if (TableEquipage.getColumnModel().getColumnCount() > 0) {
            TableEquipage.getColumnModel().getColumn(0).setResizable(false);
            TableEquipage.getColumnModel().getColumn(1).setResizable(false);
            TableEquipage.getColumnModel().getColumn(2).setResizable(false);
            TableEquipage.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel3.setText("Nom :");

        jLabel4.setText("Prénom :");

        jLabel5.setText("Date de naissance :");

        BoxJour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        BoxMois.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" }));

        BoxAnnee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940" }));

        jLabel6.setText("Registre national :");

        jLabel7.setText("Nationalité :");

        BoutonGroupFonction.add(BoxBosco);
        BoxBosco.setText("Bosco");

        BoutonGroupFonction.add(BoxMatelot);
        BoxMatelot.setText("Matelot");

        BoutonGroupFonction.add(BoxPassager);
        BoxPassager.setText("Passager");

        BoutonAjouter.setText("Ajouter le membre");
        BoutonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAjouterActionPerformed(evt);
            }
        });

        BoutonModifier.setText("Modifier le membre");
        BoutonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonModifierActionPerformed(evt);
            }
        });

        BoutonValider.setText("Valider l'équipage");
        BoutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonValiderActionPerformed(evt);
            }
        });

        BoutonSupprimer.setText("Supprimer l'équipage");
        BoutonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonSupprimerActionPerformed(evt);
            }
        });

        BoutonAnnuler.setText("Annuler");
        BoutonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnulerActionPerformed(evt);
            }
        });

        BoutonGroupFonction.add(BoxCapitaine);
        BoxCapitaine.setText("Capitaine");

        BoutonGroupFonction.add(BoxSecond);
        BoxSecond.setText("Second");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addComponent(LabelRegistre, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(76, 76, 76)
                                .addComponent(LabelNationalite, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BoutonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(LabelBateau, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel3))
                                            .addGap(32, 32, 32)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(LabelNom)
                                                .addComponent(LabelPrenom)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(BoxJour, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BoxMois, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(BoxAnnee, 0, 58, Short.MAX_VALUE))))
                                        .addComponent(BoutonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(BoutonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BoutonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(BoxBosco)
                                                .addComponent(BoxCapitaine))
                                            .addGap(44, 44, 44)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(BoxSecond)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(BoxMatelot)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(BoxPassager)
                                                    .addGap(12, 12, 12)))))
                                    .addComponent(BoutonAnnuler))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(LabelBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(LabelNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(LabelPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoxJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoxAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(LabelNationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxCapitaine)
                            .addComponent(BoxSecond))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoxBosco)
                            .addComponent(BoxMatelot)
                            .addComponent(BoxPassager))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoutonAjouter)
                            .addComponent(BoutonModifier))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BoutonValider)
                            .addComponent(BoutonSupprimer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BoutonAnnuler))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAjouterActionPerformed
        String IdentifiantMarin = LabelNationalite + "_" + LabelRegistre; 
        String Nom = LabelNom.getText();
        String Prenom = LabelPrenom.getText();
        String DateNaissance = BoxJour.getItemAt(0) + "/" + BoxMois.getItemAt(0) + "/" + BoxAnnee.getItemAt(0);
        String NumRegistre = LabelRegistre.getText();
        String Nationalite = LabelNationalite.getText().toUpperCase();
        String Fonction = null;
        if (BoxCapitaine.isSelected()){
            Fonction = "Capitaine";
        }
        else if (BoxSecond.isSelected()) {
            Fonction = "Second";
        }
        else if (BoxBosco.isSelected()) {
            Fonction = "Bosco";
        }
        else if (BoxMatelot.isSelected()) {
            Fonction = "Matelot";
        }
        else if (BoxPassager.isSelected()) {
            Fonction = "Passager";
        }
        else {
            Fonction = "Clandestin";
        }
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
        df.setLenient(false);
        Date dateNaissance;
        try{
            dateNaissance = df.parse(DateNaissance);
            try {
                Marin marin = new Marin (IdentifiantMarin, Nom, Prenom, dateNaissance, Fonction);
                Vector ligne = new Vector();
                ligne.add(marin.getIdentifiant());                    
                ligne.add(marin.getNom());
                ligne.add(marin.getPrenom());
                ligne.add(marin.getDateNaissance().getDay() + "/" + marin.getDateNaissance().getMonth() + "/" + marin.getDateNaissance().getYear());
                ligne.add(marin.getFonction());
                Capitainerie.fichierLog.ecritLigne ("Création du marin : " + IdentifiantMarin);
                DTMEquipage.addRow(ligne);
                this.TableEquipage.setModel(DTMEquipage);              
            } catch (SailorWithoutIdentificationException ex) {
                Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
            }            
        }catch (ParseException e){
            String msg;
            msg = "Erreur : la date est invalide !";
            JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.INFORMATION_MESSAGE);            
        }
    }//GEN-LAST:event_BoutonAjouterActionPerformed

    private void BoutonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonModifierActionPerformed
        int i;
        i = TableEquipage.getSelectedRow();
        if (i != -1)
        {
            DTMEquipage.removeRow(i);
            String IdentifiantMarin = LabelNationalite + "_" + LabelRegistre; 
            String Nom = LabelNom.getText();
            String Prenom = LabelPrenom.getText();
            String DateNaissance = BoxJour.getItemAt(0) + "/" + BoxMois.getItemAt(0) + "/" + BoxAnnee.getItemAt(0);
            String NumRegistre = LabelRegistre.getText();
            String Nationalite = LabelNationalite.getText().toUpperCase();
            String Fonction = null;
            if (BoxCapitaine.isSelected()){
                Fonction = "Capitaine";
            }
            else if (BoxSecond.isSelected()) {
                Fonction = "Second";
            }
            else if (BoxBosco.isSelected()) {
                Fonction = "Bosco";
            }
            else if (BoxMatelot.isSelected()) {
                Fonction = "Matelot";
            }
            else if (BoxPassager.isSelected()) {
                Fonction = "Passager";
            }
            else {
                Fonction = "Clandestin";
            }

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
            df.setLenient(false);
            Date dateNaissance;
            try{
                dateNaissance = df.parse(DateNaissance);
                try {
                    Marin marin = new Marin (IdentifiantMarin, Nom, Prenom, dateNaissance, Fonction);
                    Vector ligne = new Vector();
                    ligne.add(marin.getIdentifiant());                    
                    ligne.add(marin.getNom());
                    ligne.add(marin.getPrenom());
                    ligne.add(marin.getDateNaissance().getDay() + "/" + marin.getDateNaissance().getMonth() + "/" + marin.getDateNaissance().getYear());
                    ligne.add(marin.getFonction());
                    Capitainerie.fichierLog.ecritLigne ("Modification du marin : " + IdentifiantMarin);
                    DTMEquipage.addRow(ligne);
                    this.TableEquipage.setModel(DTMEquipage);              
                } catch (SailorWithoutIdentificationException ex) {
                    Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
                }            
            }catch (ParseException e){
                String msg;
                msg = "Erreur : la date est invalide !";
                JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.INFORMATION_MESSAGE);            
            }
        }
        else
        {
            String msg;
            msg = "Vous devez sélectionner un marin dans l'équipage !";
            JOptionPane.showMessageDialog(this, msg, "Action impossible", JOptionPane.INFORMATION_MESSAGE);    
        }
    }//GEN-LAST:event_BoutonModifierActionPerformed

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed
        DefaultComboBoxModel DCBMEquipage = new DefaultComboBoxModel();
        Marin Capitaine = new Marin ();
        Marin Second = new Marin ();
        for(int i = 0; i < TableEquipage.getRowCount(); i++) {
            try {
                String elem = TableEquipage.getValueAt(i, 2) + " : " + TableEquipage.getValueAt(i, 1);
                DCBMEquipage.addElement(elem);
                // On crée l'équipage.
                String Identifiant = (String) TableEquipage.getValueAt(i, 0);
                String Nom = (String) TableEquipage.getValueAt(i, 1);
                String Prenom = (String) TableEquipage.getValueAt(i, 2);
                String DateNaissance = (String) TableEquipage.getValueAt(i, 3);
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
                df.setLenient(false);
                Date dateNaissance;
                try{
                    dateNaissance = df.parse(DateNaissance);                
                
                    String Fonction = (String) TableEquipage.getValueAt(i, 4);
                    switch (Fonction){
                        case "Capitaine":
                            Capitainerie.fichierLog.ecritLigne ("Création d'un capitaine " + Identifiant);
                            Capitaine = new Marin (Identifiant, Nom, Prenom, dateNaissance, Fonction);
                            break;
                        case "Second":
                            Capitainerie.fichierLog.ecritLigne ("Création d'un second " + Identifiant);
                            Second = new Marin (Identifiant, Nom, Prenom, dateNaissance, Fonction);
                            break;
                    }
                }catch (ParseException e){
                    String msg;
                    msg = "Erreur : la date est invalide !";
                    JOptionPane.showMessageDialog(this, msg, "A propos", JOptionPane.INFORMATION_MESSAGE);            
                }                     
            } catch (SailorWithoutIdentificationException ex) {
                Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
            }
        }
        equipage = new Equipage (Capitaine, Second);
        
        for(int i = 0; i < TableEquipage.getRowCount(); i++) {
            try {
                // On crée l'équipage.
                String ID = (String) TableEquipage.getValueAt(i, 0);
                String NOM = (String) TableEquipage.getValueAt(i, 1);
                String PRENOM = (String) TableEquipage.getValueAt(i, 2);
                String DATEN = (String) TableEquipage.getValueAt(i, 3);
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
                df.setLenient(false);
                Date dateNaissance;
                try{
                    dateNaissance = df.parse(DATEN);                
                    String FONCTION = (String) TableEquipage.getValueAt(i, 4);
                    if("Capitaine".equals(FONCTION)){
                        String msgC;
                        msgC = "Le Capitaine a déja été créé !";
                        JOptionPane.showMessageDialog(this, msgC, "Attention !", JOptionPane.INFORMATION_MESSAGE, null);
                    }
                    else{
                        if ("Second".equals(FONCTION)){
                            String msgS;
                            msgS = "Le Second a déja été créé !";
                            JOptionPane.showMessageDialog(this, msgS, "Attention !", JOptionPane.INFORMATION_MESSAGE, null);
                        }
                        else {
                        Marin mar = new Marin (ID, NOM, PRENOM, dateNaissance, FONCTION);
                        Capitainerie.fichierLog.ecritLigne ("Création d'un marin : " + ID);
                        equipage.ajouterMarin(mar);
                        }
                    }
                } catch (SailorWithoutIdentificationException ex) {
                   Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
                }
            }catch (ParseException e){
                String msg;
                msg = "Erreur : la date est invalide ! ";
                JOptionPane.showMessageDialog(this, msg, "Attention", JOptionPane.INFORMATION_MESSAGE);            
            }                  
        }        
        InfosBateau.ListEquipage.setModel((ComboBoxModel) DCBMEquipage);
        setVisible(false);
        this.TableEquipage.clearSelection();
    }//GEN-LAST:event_BoutonValiderActionPerformed

    private void BoutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSupprimerActionPerformed
        FenetreEtesVousSur fevs = new FenetreEtesVousSur(this, rootPaneCheckingEnabled, "Êtes-vous sur de vouloir supprimer l'équipage ?");
        while (fevs.isVisible())
        {
            
        }
        if (fevs.info)
            TableEquipage.clearSelection();
    }//GEN-LAST:event_BoutonSupprimerActionPerformed

    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonAnnulerActionPerformed

    private void TableEquipageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableEquipageMouseClicked
        int i;
        i = TableEquipage.getSelectedRow();
        if (i != -1)
        {
            LabelNom = (JTextField)TableEquipage.getValueAt(i, 0);
            LabelPrenom = (JTextField)TableEquipage.getValueAt(i, 1);
            BoutonGroupFonction.clearSelection();
            String Fonction = (String)TableEquipage.getValueAt(i, 4);
            switch (Fonction)
            {
                case "Capitaine" :
                    BoxCapitaine.setSelected(true);
                case "Second" :
                    BoxSecond.setSelected(true);
                case "Bosco" :
                    BoxBosco.setSelected(true);
                case "Matelot" :
                    BoxMatelot.setSelected(true);
                case "Passager" :
                    BoxPassager.setSelected(true);
            }
        }
    }//GEN-LAST:event_TableEquipageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAjouter;
    private javax.swing.JButton BoutonAnnuler;
    private javax.swing.ButtonGroup BoutonGroupFonction;
    private javax.swing.JButton BoutonModifier;
    private javax.swing.JButton BoutonSupprimer;
    private javax.swing.JButton BoutonValider;
    private javax.swing.JComboBox<String> BoxAnnee;
    private javax.swing.JRadioButton BoxBosco;
    private javax.swing.JRadioButton BoxCapitaine;
    private javax.swing.JComboBox<String> BoxJour;
    private javax.swing.JRadioButton BoxMatelot;
    private javax.swing.JComboBox<String> BoxMois;
    private javax.swing.JRadioButton BoxPassager;
    private javax.swing.JRadioButton BoxSecond;
    private javax.swing.JTextField LabelBateau;
    private javax.swing.JTextField LabelNationalite;
    private javax.swing.JTextField LabelNom;
    private javax.swing.JTextField LabelPrenom;
    private javax.swing.JTextField LabelRegistre;
    private javax.swing.JTable TableEquipage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
