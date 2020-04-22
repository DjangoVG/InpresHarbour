package capitainerie;
import FenetresEnOption.*;
import InpresHarbour.Equipage;
import InpresHarbour.Marin;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import InpresHarbour.SailorWithoutIdentificationException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.text.SimpleDateFormat;

public class PublishEquipage extends javax.swing.JFrame 
{
    private final DefaultTableModel DTMEquipage;
    private Equipage equipage;
    private boolean TestCapi = false;
   
    public PublishEquipage(Equipage equipage) 
    {
        initComponents();
        this.equipage = equipage;
        
        String NomBateau = InfosBateau.LabelNomBateau.getText();
        if (InfosBateau.LabelPort.getText().equalsIgnoreCase(("")))
            NomBateau += " (INCONNU)";
        else
            NomBateau += " (" + InfosBateau.LabelPort.getText() + ")";
        
        LabelBateau.setText(NomBateau);
        DTMEquipage = new DefaultTableModel ();
        DTMEquipage.addColumn("Numéro du registre nationnal");
        DTMEquipage.addColumn("Nom");
        DTMEquipage.addColumn("Prénom");
        DTMEquipage.addColumn("Date de naissance");
        DTMEquipage.addColumn("Nationalité");
        DTMEquipage.addColumn("Fonction");   
        this.TableEquipage.setModel(DTMEquipage);
        
        if (equipage.getNombreHumains() > 0)
        {
            Marin Capitaine = equipage.getCapitaine();
            Marin Second = equipage.getSecond();
            if (Capitaine != null)
            {
                System.out.println("Capitaine : " + Capitaine.getFonction() + " " + Capitaine.getIdentifiant() + " " + Capitaine.getNom());
                Vector ligne = new Vector();
                ligne.add(Capitaine.getIdentifiant());                    
                ligne.add(Capitaine.getNom());
                ligne.add(Capitaine.getPrenom());
                ligne.add(Capitaine.getDateNaissance().getDay() + "/" + Capitaine.getDateNaissance().getMonth() + "/" + Capitaine.getDateNaissance().getYear());
                ligne.add(Capitaine.getNationalite());
                ligne.add(Capitaine.getFonction());
                DTMEquipage.addRow(ligne);
            }
            if (Second != null){
                Vector ligne = new Vector();
                ligne.add(Second.getIdentifiant());                    
                ligne.add(Second.getNom());
                ligne.add(Second.getPrenom());
                ligne.add(Second.getDateNaissance().getDay() + "/" + Second.getDateNaissance().getMonth() + "/" + Second.getDateNaissance().getYear());
                ligne.add(Second.getNationalite());
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
                    UnMarin.add(marin.getNationalite());
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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numéro de registre national", "Nom", "Prénom", "Date de naissance", "Nationalité", "Fonction"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            TableEquipage.getColumnModel().getColumn(4).setResizable(false);
            TableEquipage.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel3.setText("Nom :");

        jLabel4.setText("Prénom :");

        jLabel5.setText("Date de naissance :");

        BoxJour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        BoxMois.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator3)
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
                                        .addComponent(BoxMois, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BoxAnnee, 0, 111, Short.MAX_VALUE))))
                            .addComponent(jSeparator4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                        .addGap(12, 12, 12))))
                            .addComponent(BoutonAnnuler)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelNationalite)
                                    .addComponent(LabelRegistre)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BoutonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)))
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
        String RegistreNationalMarin = LabelRegistre.getText(); 
        String Nom = LabelNom.getText();
        String Prenom = LabelPrenom.getText();
        String DateNaissance = BoxJour.getSelectedItem() + "/" + BoxMois.getSelectedItem().toString() + "/" + BoxAnnee.getSelectedItem().toString();
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
        
        
        if (TableEquipage.getRowCount() > 0) // Si un membre existe déja
        {
            for (int j = 0; j < TableEquipage.getRowCount(); j++)
            {
                if (TableEquipage.getValueAt(j, 0).equals(RegistreNationalMarin)) // Je vérifie seulement pour les registres de l'équipage actuel (à modifier)
                {
                    String msg;
                    msg = "Un membre de l'équipe a déja ce numéro de registre !"; 
                    JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE); 
                    return;
                }
                if (TableEquipage.getValueAt(j, 5).equals("Second") && Fonction.equals("Second"))
                {  
                    String msg;
                    msg = "Vous avez déja ajouté un second !";
                    JOptionPane.showMessageDialog(this, msg, "Attention !", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (TableEquipage.getValueAt(j, 5).equals("Capitaine") && Fonction.equals("Capitaine")) // Un capitaine existe déja
                {
                    String msg;
                    msg = "Vous avez déja ajouté un capitaine !";
                    JOptionPane.showMessageDialog(this, msg, "Attention !", JOptionPane.INFORMATION_MESSAGE); 
                    return;
                }
            }
            try
            {
                Date dateNaissance=new SimpleDateFormat("dd/MM/yyyy").parse(DateNaissance);     
                try 
                {
                    Marin marin = new Marin (RegistreNationalMarin, Nom, Prenom, Nationalite, dateNaissance, Fonction);
                    Vector ligne = new Vector();
                    ligne.add(marin.getIdentifiant());                    
                    ligne.add(marin.getNom());
                    ligne.add(marin.getPrenom());
                    ligne.add(DateNaissance);
                    ligne.add(Nationalite);
                    ligne.add(marin.getFonction());
                    Capitainerie.fichierLog.ecritLigne ("Création du marin : " + RegistreNationalMarin);
                    DTMEquipage.addRow(ligne);
                    this.TableEquipage.setModel(DTMEquipage);    
                } catch (SailorWithoutIdentificationException ex) {
                    Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
                }            
            }catch (ParseException e){
                String msg;
                msg = "Erreur : la date est invalide !";
                JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE);            
            }     
        }
        else // Création du capitaine
        {      
            if (Fonction.equalsIgnoreCase("Capitaine")) // Je vérifie si c'est bien un capitaine que l'user veut ajouter
            {
                try
                {
                    Date dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(DateNaissance);     
                    try {
                        Marin marin = new Marin (RegistreNationalMarin, Nom, Prenom, Nationalite, dateNaissance, Fonction);
                        Vector ligne = new Vector();
                        ligne.add(marin.getIdentifiant());                    
                        ligne.add(marin.getNom());
                        ligne.add(marin.getPrenom());
                        ligne.add(DateNaissance);
                        ligne.add(Nationalite);
                        ligne.add(marin.getFonction());
                        Capitainerie.fichierLog.ecritLigne ("Création du capitaine : " + RegistreNationalMarin);
                        DTMEquipage.addRow(ligne);
                        this.TableEquipage.setModel(DTMEquipage);              
                    } catch (SailorWithoutIdentificationException ex) {
                        Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
                    }            
                }catch (ParseException e){
                    String msg;
                    msg = "Erreur : la date est invalide !";
                    JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE);            
                }    
            }
            else
            {
                String msg;
                msg = "Vous devez ajouter un capitaine comme premier membre d'équipage !";
                JOptionPane.showMessageDialog(this, msg, "Attention !", JOptionPane.WARNING_MESSAGE);  
            } 
        }
    }//GEN-LAST:event_BoutonAjouterActionPerformed

    private void BoutonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonModifierActionPerformed
        int i;
        i = TableEquipage.getSelectedRow();
        if (i != -1)
        {
            if (i == 0)
            {
                if (!BoxCapitaine.isSelected())
                {
                    String msg;
                    msg = "Vous ne pouvez pas modifier le capitaine !";
                    JOptionPane.showMessageDialog(this, msg, "Action impossible", JOptionPane.WARNING_MESSAGE);                      
                }
                else // modification du capitaine
                {
                    
                    String IdentifiantMarin = LabelRegistre.getText(); 
                    String Nom = LabelNom.getText();
                    String Prenom = LabelPrenom.getText();
                    String DateNaissance = BoxJour.getItemAt(0) + "/" + BoxMois.getItemAt(0) + "/" + BoxAnnee.getItemAt(0);
                    String Nationalite = LabelNationalite.getText().toUpperCase();
                    String Fonction = "Capitaine";

                    for (int j = 0; j < TableEquipage.getRowCount(); j++)
                    {
                        if (TableEquipage.getValueAt(j, 0).equals(IdentifiantMarin) && j != i) // Je vérifie seulement pour les registres de l'équipage actuel (à modifier)
                        {
                            String msg;
                            msg = "Un membre de l'équipe a déja ce numéro de registre !"; 
                            JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE); 
                            return;
                        }
                    }
                    try{
                    Date dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(DateNaissance);     
                    try {
                        Marin marin = new Marin (IdentifiantMarin, Nom, Prenom, Nationalite, dateNaissance, Fonction);
                        Vector ligne = new Vector();
                        ligne.add(marin.getIdentifiant());                    
                        ligne.add(marin.getNom());
                        ligne.add(marin.getPrenom());
                        ligne.add(DateNaissance);
                        ligne.add(marin.getNationalite());
                        ligne.add(marin.getFonction());
                        Capitainerie.fichierLog.ecritLigne ("Modification du Capitaine : " + IdentifiantMarin);
                        DTMEquipage.removeRow(i);
                        DTMEquipage.insertRow(i,ligne);
                        this.TableEquipage.setModel(DTMEquipage);              
                    } catch (SailorWithoutIdentificationException ex) {
                        Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
                    }            
                    }catch (ParseException e){
                        String msg;
                        msg = "Erreur : la date est invalide !";
                        JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE);            
                    } 
                }
            }
            else
            {
                String IdentifiantMarin = LabelRegistre.getText(); 
                String Nom = LabelNom.getText();
                String Prenom = LabelPrenom.getText();
                String DateNaissance = BoxJour.getItemAt(0) + "/" + BoxMois.getItemAt(0) + "/" + BoxAnnee.getItemAt(0);
                String Nationalite = LabelNationalite.getText().toUpperCase();
                String Fonction = null;
                
                for (int j = 0; j < TableEquipage.getRowCount(); j++)
                {
                    if (TableEquipage.getValueAt(j, 0).equals(IdentifiantMarin) && j != i) // Je vérifie seulement pour les registres de l'équipage actuel (à modifier)
                    {
                        String msg;
                        msg = "Un membre de l'équipe a déja ce numéro de registre !"; 
                        JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE); 
                        return;
                    }
                }
                    
                if (BoxCapitaine.isSelected())
                {
                    String msg;
                    msg = "Vous ne pouvez pas ajouter un deuxième capitaine !";
                    JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE); 
                }
                else if (BoxSecond.isSelected())
                {
                    for (int j = 0; j < TableEquipage.getRowCount(); j++)
                    {
                        if (TableEquipage.getValueAt(j, 5).equals("Second") && j != i) // Second existe déja ?
                        {
                            String msg;
                            msg = "Vous ne pouvez pas ajouter un deuxième second !"; 
                            JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE); 
                            return;
                        }
                    }
                    try
                    {
                        Date dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(DateNaissance);     
                        try {
                            Marin marin = new Marin (IdentifiantMarin, Nom, Prenom, Nationalite, dateNaissance, "Second");
                            Vector ligne = new Vector();
                            ligne.add(marin.getIdentifiant());                    
                            ligne.add(marin.getNom());
                            ligne.add(marin.getPrenom());
                            ligne.add(DateNaissance);
                            ligne.add(marin.getNationalite());
                            ligne.add(marin.getFonction());
                            Capitainerie.fichierLog.ecritLigne ("Modification du marin : " + IdentifiantMarin);
                            DTMEquipage.removeRow(i);
                            DTMEquipage.insertRow(i,ligne);
                            this.TableEquipage.setModel(DTMEquipage);              
                        } catch (SailorWithoutIdentificationException ex) {
                            Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
                        }            
                    }catch (ParseException e){
                        String msg;
                        msg = "Erreur : la date est invalide !";
                        JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE);            
                    }
                }
                else
                {
                    if (BoxBosco.isSelected()) {
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

                    try
                    {
                        Date dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(DateNaissance);     
                        try {
                            Marin marin = new Marin (IdentifiantMarin, Nom, Prenom, Nationalite, dateNaissance, Fonction);
                            Vector ligne = new Vector();
                            ligne.add(marin.getIdentifiant());                    
                            ligne.add(marin.getNom());
                            ligne.add(marin.getPrenom());
                            ligne.add(DateNaissance);
                            ligne.add(marin.getNationalite());
                            ligne.add(marin.getFonction());
                            Capitainerie.fichierLog.ecritLigne ("Modification du marin : " + IdentifiantMarin);
                            DTMEquipage.removeRow(i);
                            DTMEquipage.insertRow(i,ligne);
                            this.TableEquipage.setModel(DTMEquipage);              
                        } catch (SailorWithoutIdentificationException ex) {
                            Capitainerie.fichierLog.ecritLigne ("SailorWithoutIdentificationException : " + ex.getMessage());
                        }            
                    }catch (ParseException e){
                        String msg;
                        msg = "Erreur : la date est invalide !";
                        JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.WARNING_MESSAGE);            
                    }
                }  
            }
        }
        else
        {
            String msg;
            msg = "Vous devez sélectionner un marin dans l'équipage !";
            JOptionPane.showMessageDialog(this, msg, "Action impossible", JOptionPane.WARNING_MESSAGE);    
        }
    }//GEN-LAST:event_BoutonModifierActionPerformed

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed
        DefaultComboBoxModel DCBMEquipage = new DefaultComboBoxModel();
        for(int i = 0; i < TableEquipage.getRowCount(); i++) {
            try {
                String elem = TableEquipage.getValueAt(i, 5) + " : " + TableEquipage.getValueAt(i, 2) + " " + TableEquipage.getValueAt(i, 1); // Rajoute dans la liste "Capitaine : Prénom Nom"
                DCBMEquipage.addElement(elem);
                
                // On rempli l'équipage.
                String RegistreNational = (String) TableEquipage.getValueAt(i, 0);
                String Nom = (String) TableEquipage.getValueAt(i, 1);
                String Prenom = (String) TableEquipage.getValueAt(i, 2);
                String DateNaissance = (String)TableEquipage.getValueAt(i, 3);
                String Nationalite = (String)TableEquipage.getValueAt(i, 4);
                try
                {
                    Date dateNaissance=new SimpleDateFormat("dd/MM/yyyy").parse(DateNaissance);        
                    String Fonction = (String) TableEquipage.getValueAt(i, 5);
                    switch (Fonction){
                        case "Capitaine":
                            Marin Capitaine = new Marin (RegistreNational, Nom, Prenom, Nationalite, dateNaissance, Fonction);
                            this.equipage.ajouterMarin(Capitaine);
                            Capitainerie.fichierLog.ecritLigne("Création d'un capitaine : " + RegistreNational);
                            break;
                        case "Second":
                            Marin Second = new Marin (RegistreNational, Nom, Prenom, Nationalite, dateNaissance, Fonction);
                            this.equipage.ajouterMarin(Second);
                            Capitainerie.fichierLog.ecritLigne("Création d'un second : " + RegistreNational);
                            break;
                        default:
                            Marin mar = new Marin (RegistreNational, Nom, Prenom, Nationalite, dateNaissance, Fonction);
                            this.equipage.ajouterMarin(mar);
                            Capitainerie.fichierLog.ecritLigne("Création d'un marin : " + RegistreNational);
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
        InfosBateau.ListEquipage.setModel((ComboBoxModel) DCBMEquipage);
        setVisible(false);
        this.TableEquipage.clearSelection();
    }//GEN-LAST:event_BoutonValiderActionPerformed

    private void BoutonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSupprimerActionPerformed
        FenetreEtesVousSur fevs = new FenetreEtesVousSur(this, rootPaneCheckingEnabled, "Êtes-vous sur de vouloir supprimer l'équipage ?");
        fevs.setVisible(true);
        if (fevs.info)
        {
            for (int i=0 ; i < DTMEquipage.getRowCount();)
            {
                DTMEquipage.removeRow(i);
            } 
            TableEquipage.setModel(DTMEquipage);
        }   
    }//GEN-LAST:event_BoutonSupprimerActionPerformed

    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonAnnulerActionPerformed

    private void TableEquipageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableEquipageMouseClicked
        int i;
        i = TableEquipage.getSelectedRow();
        if (i != -1)
        {
            LabelNom.setText(TableEquipage.getValueAt(i, 1).toString());
            LabelPrenom.setText(TableEquipage.getValueAt(i, 2).toString());
            LabelRegistre.setText(TableEquipage.getValueAt(i, 0).toString());
            String DateNaissanceString = (String)TableEquipage.getValueAt(i, 3);
            String[] DateNaissance = DateNaissanceString.split("/");
            BoxJour.setSelectedIndex(Integer.parseInt(DateNaissance[0]) -1);
            BoxMois.setSelectedIndex(Integer.parseInt(DateNaissance[1]) -1);
            int AnneeCheck = 2020 - Integer.parseInt(DateNaissance[2]) ;
            BoxAnnee.setSelectedIndex(AnneeCheck);
            LabelNationalite.setText(TableEquipage.getValueAt(i, 4).toString());
            
            
            BoutonGroupFonction.clearSelection();
            String Fonction = (String)TableEquipage.getValueAt(i, 5);
            switch (Fonction)
            {
                case "Capitaine" :
                    BoxCapitaine.setSelected(true);
                    break;
                case "Second" :
                    BoxSecond.setSelected(true);
                    break;
                case "Bosco" :
                    BoxBosco.setSelected(true);
                    break;
                case "Matelot" :
                    BoxMatelot.setSelected(true);
                    break;
                case "Passager" :
                    BoxPassager.setSelected(true);
                    break;
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
