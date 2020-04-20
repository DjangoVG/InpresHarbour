package capitainerie;
import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import InpresHarbour.MoyenDeTransportSurEau;
import InpresHarbour.Ponton;
import InpresHarbour.Quai;
import static capitainerie.Capitainerie.BoutonChoisir;
import static capitainerie.Capitainerie.BoutonLire;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ListeAmarrage extends javax.swing.JFrame {
    private DefaultTableModel TableQuai;
    private DefaultTableModel TablePonton;
    
    @SuppressWarnings("UnnecessaryBoxing")
    public ListeAmarrage(ArrayList<Ponton> ListePonton, ArrayList<Quai> ListeQuai) 
    {
        initComponents();
        
        TablePonton = new DefaultTableModel ();
        TablePonton.addColumn("Ponton");
        TablePonton.addColumn("Emplacement");
        TablePonton.addColumn("Côté 1");
        TablePonton.addColumn("Côté 2");
        TablePonton.addColumn ("Identifiant bateau");
        TablePonton.addColumn("Nom");
        TablePonton.addColumn("Port d'attache");
        // Création du tableauPonton
        for (int j = 0; j < ListePonton.size(); j++)
        {
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
            ArrayList<MoyenDeTransportSurEau> listA = p.getListeBateauCoté1();
            ArrayList<MoyenDeTransportSurEau> listB = p.getListeBateauCoté2();
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
                    else
                    {
                        if (listA.get(i) instanceof BateauPlaisance)
                        {
                            BateauPlaisance bateau = (BateauPlaisance)listA.get(i);
                            try
                            {
                                ligne.add(null);
                                ligne.add (bateau.getIdentifiant());
                                ligne.add (bateau.getNom());
                                ligne.add(bateau.getPortAttache());                                
                            }
                            catch (NullPointerException e) {}

                        }
                        else
                        {
                            BateauPeche bateau = (BateauPeche)listA.get(i);
                            try
                            {
                                ligne.add(null);
                                ligne.add (bateau.getIdentifiant());
                                ligne.add (bateau.getNom());
                                ligne.add(bateau.getPortAttache());                                
                            }
                            catch (NullPointerException e) {}
                        }
                    }
                }
                else
                {
                    ligne.add(null);
                    ligne.add(k);
                    ligne.add(null);
                    ligne.add("****");
                    if (listB.get(k) == null)
                    {
                        ligne.add(null);
                        ligne.add(null);
                        ligne.add(null);
                    }
                    else
                    {
                        if (listB.get(k) instanceof BateauPlaisance)
                        {
                            BateauPlaisance bateau = (BateauPlaisance)listB.get(k);
                            try
                            {
                                ligne.add(null);
                                ligne.add (bateau.getIdentifiant());
                                ligne.add (bateau.getNom());
                                ligne.add(bateau.getPortAttache());                                
                            }
                            catch (NullPointerException e) {}
                        }
                        else
                        {
                            BateauPeche bateau = (BateauPeche)listB.get(k);
                            try
                            {
                                ligne.add (bateau.getIdentifiant());
                                ligne.add (bateau.getNom());
                                ligne.add(bateau.getPortAttache());                                
                            }
                            catch (NullPointerException e) {}
                        }
                    }
                    k++;
                }
                TablePonton.addRow(ligne);
            }
        }
        this.TableAmarragePonton.setModel(TablePonton);

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
            ArrayList<MoyenDeTransportSurEau> list = q.getListeBateau();
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
                else 
                {
                    if (list.get(i) instanceof BateauPlaisance)
                        {
                            BateauPlaisance bateau = (BateauPlaisance)list.get(i);
                            try
                            {
                                ligne.add (bateau.getIdentifiant());
                                ligne.add (bateau.getNom());
                                ligne.add(bateau.getPortAttache());                                
                            }
                            catch (NullPointerException e) {}

                        }
                        else
                        {
                            BateauPeche bateau = (BateauPeche)list.get(i);
                            try
                            {
                                ligne.add (bateau.getIdentifiant());
                                ligne.add (bateau.getNom());
                                ligne.add(bateau.getPortAttache());                                
                            }
                            catch (NullPointerException e) {}
                        }
                }
                TableQuai.addRow(ligne);
            }
        }
        this.TableAmarrageQuai.setModel(TableQuai);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAmarrageQuai = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        LabelEmplacement = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        BoutonSelectionner = new javax.swing.JButton();
        LabelSupprimer = new javax.swing.JButton();
        BoutonQuitter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAmarragePonton = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Liste des bateaux amarrés");

        TableAmarrageQuai.setModel(new javax.swing.table.DefaultTableModel(
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
        TableAmarrageQuai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAmarrageQuaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAmarrageQuai);

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

        TableAmarragePonton.setModel(new javax.swing.table.DefaultTableModel(
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
        TableAmarragePonton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAmarragePontonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableAmarragePonton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelEmplacement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonSelectionner)
                    .addComponent(LabelSupprimer)
                    .addComponent(BoutonQuitter))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LabelSupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelSupprimerActionPerformed

    private void BoutonSelectionnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonSelectionnerActionPerformed
        BoutonLire.setEnabled(false);
        BoutonChoisir.setEnabled(false);
        String req = Capitainerie.LabelRequete.getText();
        String[] separe = req.split("/");
        String bat = separe[2];
        String pav = separe[1];
        String im = separe[4];
       
        if (TableAmarragePonton.getSelectedRow() != -1 && TableAmarrageQuai.getSelectedRow() != -1)
        {
            System.out.println("Vous avez sélectionner dans les deux tableaux !");
            TableAmarragePonton.clearSelection();
            TableAmarrageQuai.clearSelection();
        }
        else if (TableAmarragePonton.getSelectedRow() == -1 && TableAmarrageQuai.getSelectedRow() == -1)
        {
            System.out.println("Vous n'avez rien sélectionné !");
        }
        else if (TableAmarragePonton.getSelectedRow() != -1)
        {    
            String Bateau = (String)TablePonton.getValueAt(TableAmarragePonton.getSelectedRow(), 5);                
            if (Bateau == null)
            {        
                String msg = LabelEmplacement.getText();
                Capitainerie.LabelAmarrageChoisir.setText (msg);
                BoutonSelectionner.setEnabled(true); 
                Capitainerie.BoutonEnvoyerChoix.setEnabled(true);
                Capitainerie.BoutonLire.setEnabled(false);
                Capitainerie.BoutonEnvoyerConfirmation.setEnabled(false);
                Capitainerie.BoutonChoisir.setEnabled(false);
                this.setVisible(false);
            }
            else 
            {
                String msg = "Un bateau y est déjà amarré !!!";
                LabelEmplacement.setText (msg);
            }
        }
        else
        {
            System.out.println("J'ai sélectionné un Quai !");
            String Bateau = (String)TableQuai.getValueAt(TableAmarrageQuai.getSelectedRow(), 2);                
            if (Bateau == null)
            {        
                String msg = LabelEmplacement.getText();
                Capitainerie.LabelAmarrageChoisir.setText (msg);
                BoutonSelectionner.setEnabled(true); 
                Capitainerie.BoutonEnvoyerChoix.setEnabled(true);
                Capitainerie.BoutonLire.setEnabled(false);
                Capitainerie.BoutonEnvoyerConfirmation.setEnabled(false);
                Capitainerie.BoutonChoisir.setEnabled(false);
                this.setVisible(false);
            }
            else 
            {
                String msg = "Un bateau y est déjà amarré !!!";
                LabelEmplacement.setText (msg);
            }
        }
    }//GEN-LAST:event_BoutonSelectionnerActionPerformed

    private void BoutonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonQuitterActionPerformed
        BoutonLire.setEnabled(false);
        BoutonChoisir.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_BoutonQuitterActionPerformed

    private void TableAmarrageQuaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAmarrageQuaiMouseClicked
        String Emplacement = null, NumPontonQuai = null;
        if (TableAmarrageQuai.getSelectedRow() != -1)
        {
            if (TableAmarrageQuai.getValueAt(TableAmarrageQuai.getSelectedRow(), 0) == null)
            {
                for (int i = TableAmarrageQuai.getSelectedRow(); i >= 0; i--)
                {
                    if (TableAmarrageQuai.getValueAt(i, 0) != null)
                    {
                        NumPontonQuai = TableAmarrageQuai.getValueAt(i, 0).toString();
                        i = -1;
                    }
                }
            }
            else
                NumPontonQuai = TableAmarrageQuai.getValueAt(TableAmarrageQuai.getSelectedRow(), 0).toString();
            Emplacement = "Q" + NumPontonQuai + "*" + TableAmarrageQuai.getValueAt(TableAmarrageQuai.getSelectedRow(), 1).toString();
            LabelEmplacement.setText(Emplacement);
        }
    }//GEN-LAST:event_TableAmarrageQuaiMouseClicked

    private void TableAmarragePontonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAmarragePontonMouseClicked
        String Emplacement = null, NumPontonQuai = null;
        if (TableAmarragePonton.getSelectedRow() != -1)
        {
            if (TableAmarragePonton.getValueAt(TableAmarragePonton.getSelectedRow(), 0) == null)
            {
                for (int i = TableAmarragePonton.getSelectedRow(); i >= 0; i--)
                {
                    if (TableAmarragePonton.getValueAt(i, 0) != null)
                    {
                        NumPontonQuai = TableAmarragePonton.getValueAt(i, 0).toString();
                        i = -1;
                    }
                }
            }
            else
                NumPontonQuai = TableAmarragePonton.getValueAt(TableAmarragePonton.getSelectedRow(), 0).toString();
            
            if (TableAmarragePonton.getValueAt(TableAmarragePonton.getSelectedRow(), 2) == "****")
                Emplacement = "P" + NumPontonQuai + "*" + TableAmarragePonton.getValueAt(TableAmarragePonton.getSelectedRow(), 1).toString() + "*2";
            else
                Emplacement = "P" + NumPontonQuai + "*" + TableAmarragePonton.getValueAt(TableAmarragePonton.getSelectedRow(), 1).toString() + "*1";
            LabelEmplacement.setText(Emplacement);
        }
    }//GEN-LAST:event_TableAmarragePontonMouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonQuitter;
    private javax.swing.JButton BoutonSelectionner;
    private javax.swing.JTextField LabelEmplacement;
    private javax.swing.JButton LabelSupprimer;
    private javax.swing.JTable TableAmarragePonton;
    private javax.swing.JTable TableAmarrageQuai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
