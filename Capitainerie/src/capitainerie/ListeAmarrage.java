package capitainerie;
import static capitainerie.Capitainerie.ListePonton;
import static capitainerie.Capitainerie.ListeQuai;
import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import InpresHarbour.Ponton;
import InpresHarbour.Quai;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ListeAmarrage extends javax.swing.JFrame {
    private DefaultTableModel TableQuai;
    private DefaultTableModel TablePonton;
    private final String Type;
    
    @SuppressWarnings("UnnecessaryBoxing")
    public ListeAmarrage(ArrayList<Ponton> ListePonton, ArrayList<Quai> ListeQuai, String t) {
        initComponents();
        
        for (int i =0; i < ListePonton.size(); i++)
        {
            System.out.println(ListePonton.get(i));
        }
        Type = t;
        if ("Plaisance".equals(Type)){
            TablePonton = new DefaultTableModel ();
            TablePonton.addColumn("Ponton");
            TablePonton.addColumn("Emplacement");
            TablePonton.addColumn("Côté 1");
            TablePonton.addColumn("Côté 2");
            TablePonton.addColumn ("Identifiant bateau");
            TablePonton.addColumn("Nom");
            TablePonton.addColumn("Port d'attache");
            // Création du tableauPonton
            for (int j = 0; j < ListePonton.size(); j++){
                Ponton p = ListePonton.get(j);
                int cap = p.getCapacite ();
                int tempA;
                int reste = cap%2;
                if (reste != 0){
                    tempA = (cap/2)+1;
                }
                else{
                    tempA = (cap/2);
                }
                int k = 0;
                ArrayList<BateauPlaisance> listA = p.getListeBateauCoté1();
                ArrayList<BateauPlaisance> listB = p.getListeBateauCoté2();
                for (int i=0; i < cap; i++)
                {
                    @SuppressWarnings("UseOfObsoleteCollectionType")
                    Vector ligne = new Vector();
                    if (i < tempA){
                        if (i == 0)
                            ligne.add(p.getIdentifiant());
                        else
                            ligne.add(null);
                        ligne.add(i);
                        ligne.add("****");
                        if (listA.get(i) == null){
                            ligne.add(null);
                            ligne.add(null);
                            ligne.add(null);
                            ligne.add(null);
                        }
                        else{
                            ligne.add(null);
                            ligne.add (listA.get(i).getIdentifiant());
                            ligne.add (listA.get(i).getNom());
                            ligne.add(listA.get(i).getPortAttache());
                        }
                    }
                    else {
                        ligne.add(null);
                        ligne.add(k);
                        ligne.add(null);
                        ligne.add("****");
                        if (listB.get(k) == null){
                            ligne.add(null);
                            ligne.add(null);
                            ligne.add(null);
                        }
                        else{
                            ligne.add (listB.get(k).getIdentifiant());
                            ligne.add(listB.get(k).getNom());
                            ligne.add(listB.get(k).getPortAttache());
                        }
                        k++;
                    }
                    TablePonton.addRow(ligne);
                }
            }
            this.TableAmarrage.setModel(TablePonton);
        }
        else 
        {
            TableQuai = new DefaultTableModel();
            TableQuai.addColumn("Quai");
            TableQuai.addColumn("Emplacement");
            TableQuai.addColumn ("Identifiant bateau");
            TableQuai.addColumn("Nom");
            TableQuai.addColumn("Port d'attache");        

            // Création du tableauQuai
            for (int j = 0; j < ListeQuai.size(); j++)
            {
                Quai q = ListeQuai.get(j);
                ArrayList<BateauPeche> list = q.getListeBateau();
                for (int i=0; i < q.getCapacite(); i++)
                {
                    @SuppressWarnings("UseOfObsoleteCollectionType")
                    Vector ligne = new Vector();
                    if (i == 0)
                        ligne.add(q.getIdentifiant());
                    else
                        ligne.add(null);
                    ligne.add(i);
                    if (list.get(i) == null) {
                        ligne.add(null);
                        ligne.add(null);
                        ligne.add (null);
                    }
                    else {
                        ligne.add (list.get(i).getIdentifiant());
                        ligne.add(list.get(i).getNom());
                        ligne.add(list.get(i).getPortAttache());
                    }
                    TableQuai.addRow(ligne);
                }
            }
            this.TableAmarrage.setModel(TableQuai);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAmarrage = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LabelEmplacement = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        BoutonSelectionner = new javax.swing.JButton();
        LabelSupprimer = new javax.swing.JButton();
        BoutonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Liste des bateaux amarrés");

        TableAmarrage.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableAmarrage);

        jLabel2.setText("Emplacement :");

        LabelEmplacement.setEnabled(false);

        BoutonSelectionner.setText("Sélectionner");
        BoutonSelectionner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonSelectionnerActionPerformed(evt);
            }
        });

        LabelSupprimer.setText("Supprimer");
        LabelSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LabelSupprimerActionPerformed(evt);
            }
        });

        BoutonQuitter.setText("Quitter");
        BoutonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelEmplacement))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonSelectionner)
                                .addGap(18, 18, 18)
                                .addComponent(LabelSupprimer)
                                .addGap(18, 18, 18)
                                .addComponent(BoutonQuitter)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LabelEmplacement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonSelectionner)
                    .addComponent(LabelSupprimer)
                    .addComponent(BoutonQuitter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelSupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelSupprimerActionPerformed

    private void BoutonSelectionnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSelectionnerActionPerformed
        String req = Capitainerie.LabelRequete.getText();
        String[] separe = req.split("/");
        String bat = separe[2];
        String pav = separe[1];
        String im = separe[4];
        String id = pav + "_" + im;
       
        if ("Plaisance".equals(Type)){  
            System.out.println("Bateau de plaisance !");
            int existe = 0;
            TablePonton = (DefaultTableModel) this.TableAmarrage.getModel();
            int i = this.TableAmarrage.getSelectedRow(); 
            int tmp = i;
            if (tmp != -1){
                i = tmp;
                // On vérifie que l'id n'est pas déjà dans le tableau.
                for (int j = 0; j < TablePonton.getRowCount(); j++){
                    String idTable = (String)TablePonton.getValueAt(j, 4);
                    if (idTable != null){
                        if (idTable.equals(id)){
                            existe = 1;
                        }
                    }
                }
                if (existe == 1){
                    String msg = "Vous avez déja choisi cet emplacement !";
                    LabelEmplacement.setText (msg);
                    Capitainerie.LabelAmarrageChoisir.setText(msg);
                    Capitainerie.BoutonEnvoyerChoix.setEnabled (true);                    
                    this.setVisible(false);
                    this.TableAmarrage.clearSelection();                    
                }
                else {
                    int Emplacement = (int)TablePonton.getValueAt(i, 1);
                    int cote;
                    String Ponton;
                    if ((String)TablePonton.getValueAt(i, 2) != null){
                        cote = 1;
                        Ponton = (String)TablePonton.getValueAt(i-Emplacement, 0);
                    }
                    else{
                        cote = 2;
                        // Un peu de chipotage pour récupérer le ponton.
                        int tmpbis = (int) TablePonton.getValueAt(i-Emplacement-1, 1);
                        Ponton = (String)TablePonton.getValueAt(i-Emplacement-tmpbis-1, 0);
                    }
                    String Bateau = (String)TablePonton.getValueAt(i, 5);                
                    if (Bateau == null){
                        System.out.println("Nickel");
                        String msg = Ponton;
                        msg += "-";
                        msg += Integer.toString(Emplacement); 
                        msg += "-";
                        msg += Integer.toString(cote);                    
                        LabelEmplacement.setText (msg);
                        BoutonSelectionner.setEnabled(true); 
                        this.setVisible(false);
                    }
                    else {
                        String msg = "Un bateau y est déjà amarré !!!";
                        LabelEmplacement.setText (msg);
                    }                       
                }
            } 
        }
        else{
            int existe = 0;
            TableQuai = (DefaultTableModel) this.TableAmarrage.getModel();
            int i = this.TableAmarrage.getSelectedRow(); 
            int tmp = i;
            if (tmp != -1){
                i = tmp;
                for (int j = 0; j < TableQuai.getRowCount(); j++){
                    String idTable = (String)TableQuai.getValueAt(j, 2);
                    if (idTable != null){
                        if (idTable.equals(id)){
                            existe = 1;
                        }                        
                    }
                }
                if (existe == 1){
                    String msg = "Erreur";
                    LabelEmplacement.setText (msg);
                    Capitainerie.LabelAmarrageChoisir.setText(msg);
                    Capitainerie.BoutonEnvoyerChoix.setEnabled (true);                    
                    this.setVisible(false);
                    this.TableAmarrage.clearSelection();                    
                }
                else {
                    int Emplacement = (int)TableQuai.getValueAt(i, 1);
                    String Quai = (String)TableQuai.getValueAt(i-Emplacement, 0);            
                    String Bateau = (String)TableQuai.getValueAt(i, 3);                
                    if (Bateau == null){
                        String msg = Quai;
                        msg += "-";
                        msg += Integer.toString(Emplacement);  
                        LabelEmplacement.setText (msg);
                        BoutonSelectionner.setEnabled(true);  
                        this.setVisible(false);
                    }
                    else {
                        String msg = "Un bateau y est déjà amarré !!!";
                        LabelEmplacement.setText (msg);
                    }                    
                }                
            }            
        }
    }//GEN-LAST:event_BoutonSelectionnerActionPerformed

    private void BoutonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonQuitterActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonQuitterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonQuitter;
    private javax.swing.JButton BoutonSelectionner;
    private javax.swing.JTextField LabelEmplacement;
    private javax.swing.JButton LabelSupprimer;
    private javax.swing.JTable TableAmarrage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
