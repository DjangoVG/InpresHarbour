package capitainerie;
import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import java.util.Vector;
import static capitainerie.Capitainerie.ListeBateauPeches;
import static capitainerie.Capitainerie.ListeBateauxPlaisances;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RechercheBateau extends javax.swing.JFrame {

    private final DefaultTableModel DTMBateau;
    public RechercheBateau() {
        initComponents();
        DTMBateau = new DefaultTableModel ();
        DTMBateau.addColumn("Identifiant");
        DTMBateau.addColumn("Submersible");
        DTMBateau.addColumn("Energie");
        DTMBateau.addColumn("Nom");
        DTMBateau.addColumn("Port d'attache");
        DTMBateau.addColumn("Tonnage");
        DTMBateau.addColumn("Longueur");
        DTMBateau.addColumn("Pavillon");
        DTMBateau.addColumn("Permis");
        this.TableBateau.setModel(DTMBateau);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        LabelPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LabelImmatriculation = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        BoutonRechercher = new javax.swing.JButton();
        BoutonReset = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBateau = new javax.swing.JTable();
        BoutonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Rechercher un bateau");

        jLabel2.setText("Port d'attache :");

        jLabel3.setText("Numéro d'immatriculation :");

        BoutonRechercher.setText("Rechercher");
        BoutonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonRechercherActionPerformed(evt);
            }
        });

        BoutonReset.setText("Réinitialiser les champs");
        BoutonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonResetActionPerformed(evt);
            }
        });

        TableBateau.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableBateau);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(LabelImmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonRechercher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BoutonReset))
                            .addComponent(BoutonQuitter))
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
                    .addComponent(jLabel2)
                    .addComponent(LabelPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LabelImmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonRechercher)
                    .addComponent(BoutonReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BoutonQuitter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonResetActionPerformed
        this.LabelImmatriculation.setText("");
        this.LabelPort.setText("");
    }//GEN-LAST:event_BoutonResetActionPerformed

    private void BoutonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonQuitterActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonQuitterActionPerformed

    private void BoutonRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonRechercherActionPerformed
        String id = this.LabelImmatriculation.getText().toLowerCase() + this.LabelPort.getText().toUpperCase();
        boolean trouve = false;
        
        for (BateauPlaisance Elem : ListeBateauxPlaisances)
        {
            String idListe = Elem.getIdentifiant();
            if (idListe.equals(id))
            {
                trouve = true;
                
                Vector ligne = new Vector();
                ligne.add(Elem.getIdentifiant());
                boolean tmp = Elem.getEstSubmersible();
                String sub;
                if (tmp)
                    sub = "Oui";
                else
                    sub = "Non";            
                ligne.add(sub);
                ligne.add(Elem.getEnergie());
                ligne.add(Elem.getNom());
                ligne.add(Elem.getPortAttache());
                ligne.add(Elem.getTonnage());
                ligne.add(Elem.getLongueur());
                ligne.add(Elem.getPavillon());
                ligne.add(Elem.getPermis());
                
                DTMBateau.addRow(ligne);  
                this.TableBateau.setModel(DTMBateau);
            }            
        }      
        
        for (BateauPeche Elem : ListeBateauPeches)
        {
            String idListe = Elem.getIdentifiant();
            if (idListe.equals(id))
            {
                trouve = true;
                Vector ligne = new Vector();
                ligne.add(Elem.getIdentifiant());
                boolean tmp = Elem.getEstSubmersible();
                String sub;
                if (tmp)
                    sub = "Oui";
                else
                    sub = "Non";            
                ligne.add(sub);
                ligne.add(Elem.getEnergie());
                ligne.add(Elem.getNom());
                ligne.add(Elem.getPortAttache());
                ligne.add(Elem.getTonnage());
                ligne.add(Elem.getLongueur());
                ligne.add(Elem.getPavillon());
                ligne.add(Elem.getType());            
                DTMBateau.addRow(ligne);
                this.TableBateau.setModel(DTMBateau);
            }                 
        }
        if (!trouve)
        {
            String msg;
            msg = "Aucun bateau trouvé sous ce numéro de pavillon !";
            JOptionPane.showMessageDialog(this, msg, "Attention !", JOptionPane.INFORMATION_MESSAGE, null); 
        }
    }//GEN-LAST:event_BoutonRechercherActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) { 
        this.setVisible(false);
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonQuitter;
    private javax.swing.JButton BoutonRechercher;
    private javax.swing.JButton BoutonReset;
    private javax.swing.JTextField LabelImmatriculation;
    private javax.swing.JTextField LabelPort;
    private javax.swing.JTable TableBateau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
