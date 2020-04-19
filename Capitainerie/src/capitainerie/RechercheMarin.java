package capitainerie;
import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import InpresHarbour.Equipage;
import InpresHarbour.Marin;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import static capitainerie.Capitainerie.ListeBateauPeches;
import static capitainerie.Capitainerie.ListeBateauxPlaisances;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class RechercheMarin extends javax.swing.JFrame {
    private final DefaultTableModel DTMMarin;

    public RechercheMarin(ArrayList<BateauPlaisance> ListeBateauPlaisance, ArrayList<BateauPeche> ListeBateauPeche) {
        initComponents();
        DTMMarin = new DefaultTableModel ();
        DTMMarin.addColumn("Identifiant");
        DTMMarin.addColumn("Nom");
        DTMMarin.addColumn("Prénom");
        DTMMarin.addColumn("Date de naissance");
        DTMMarin.addColumn("Nationalité");
        DTMMarin.addColumn("Fonction");   
        DTMMarin.addColumn("Id du bateau");  
        this.TableMarin.setModel(DTMMarin);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        LabelRegistre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        BoutonRechercher = new javax.swing.JButton();
        BoutonReset = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMarin = new javax.swing.JTable();
        BoutonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Rechercher un marin");

        jLabel3.setText("Numéro de registre national :");

        BoutonRechercher.setText("Rechercher");
        BoutonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonRechercherActionPerformed(evt);
            }
        });

        BoutonReset.setText("Reinitialiser les champs");
        BoutonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonResetActionPerformed(evt);
            }
        });

        TableMarin.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableMarin);

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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(LabelRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(LabelRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonRechercher)
                    .addComponent(BoutonReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BoutonQuitter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonResetActionPerformed
        this.LabelRegistre.setText("");
    }//GEN-LAST:event_BoutonResetActionPerformed

    private void BoutonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonQuitterActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonQuitterActionPerformed

    private void BoutonRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonRechercherActionPerformed
        if (this.DTMMarin.getRowCount() > 0)
            this.DTMMarin.removeRow(0);
        String id = this.LabelRegistre.getText();
        boolean trouve = false;
        for (BateauPlaisance Elem : ListeBateauxPlaisances){
            Equipage equi = Elem.getEquipage();
            String idCap = equi.getCapitaine().getIdentifiant();
            if (idCap.equals(id)){
                trouve = true;
                Vector ligne = new Vector();
                Marin cap = equi.getCapitaine();
                ligne.add(cap.getIdentifiant());
                ligne.add(cap.getNom());
                ligne.add(cap.getPrenom());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = dateFormat.format(cap.getDateNaissance());
                ligne.add(strDate);   
                ligne.add(cap.getNationalite());
                ligne.add(cap.getFonction());
                ligne.add(Elem.getIdentifiant());
                DTMMarin.addRow(ligne); 
                this.TableMarin.setModel(DTMMarin);
            }
            String idSec = equi.getSecond().getIdentifiant();
            if (idSec.equals(id)){
                trouve = true;
                Vector ligne = new Vector();
                Marin sec = equi.getSecond();
                ligne.add(sec.getIdentifiant());
                ligne.add(sec.getNom());
                ligne.add(sec.getPrenom());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = dateFormat.format(sec.getDateNaissance());
                ligne.add(strDate);
                ligne.add(sec.getNationalite());
                ligne.add(sec.getFonction());
                ligne.add(Elem.getIdentifiant());
                DTMMarin.addRow(ligne); 
                this.TableMarin.setModel(DTMMarin);                
            } 
            if (equi.getListeMarin() != null){
                for (Marin ElemMar : equi.getListeMarin()){
                    String idMar = ElemMar.getIdentifiant();
                    if (idMar.equals(id)){
                        trouve = true;
                        Vector ligne = new Vector();
                        ligne.add(ElemMar.getIdentifiant());
                        ligne.add(ElemMar.getNom());
                        ligne.add(ElemMar.getPrenom());
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String strDate = dateFormat.format(ElemMar.getDateNaissance());
                        ligne.add(strDate);
                        ligne.add(ElemMar.getNationalite());
                        ligne.add(ElemMar.getFonction());
                        ligne.add(Elem.getIdentifiant());
                        DTMMarin.addRow(ligne); 
                        this.TableMarin.setModel(DTMMarin);                        
                    }
                }
            }  
        }
        for (BateauPeche Elem : ListeBateauPeches){
            Equipage equi = Elem.getEquipage();
            String idCap = equi.getCapitaine().getIdentifiant();
            System.out.println("ID : " + idCap);
            if (idCap.equals(id))
            {
                trouve = true;
                Vector ligne = new Vector();
                Marin cap = equi.getCapitaine();
                ligne.add(cap.getIdentifiant());
                ligne.add(cap.getNom());
                ligne.add(cap.getPrenom());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = dateFormat.format(cap.getDateNaissance());
                ligne.add(strDate);
                ligne.add(cap.getNationalite());
                ligne.add(cap.getFonction());
                ligne.add(Elem.getIdentifiant());
                DTMMarin.addRow(ligne); 
                this.TableMarin.setModel(DTMMarin);                
            }
            String idSec = equi.getSecond().getIdentifiant();
            if (idSec.equals(id))
            {
                trouve = true;
                Vector ligne = new Vector();
                Marin sec = equi.getSecond();
                ligne.add(sec.getIdentifiant());
                ligne.add(sec.getNom());
                ligne.add(sec.getPrenom());
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = dateFormat.format(sec.getDateNaissance());
                ligne.add(strDate);
                ligne.add(sec.getNationalite());
                ligne.add(sec.getFonction());
                ligne.add(Elem.getIdentifiant());
                DTMMarin.addRow(ligne); 
                this.TableMarin.setModel(DTMMarin);                 
            } 
            if (equi.getListeMarin() != null){
                for (Marin ElemMar : equi.getListeMarin()){
                    String idMar = ElemMar.getIdentifiant();
                    if (idMar.equals(id))
                    {
                        trouve = true;
                        Vector ligne = new Vector();
                        ligne.add(ElemMar.getIdentifiant());
                        ligne.add(ElemMar.getNom());
                        ligne.add(ElemMar.getPrenom());
                        
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        String strDate = dateFormat.format(ElemMar.getDateNaissance());
                        ligne.add(strDate);
                        ligne.add(ElemMar.getNationalite());
                        ligne.add(ElemMar.getFonction());
                        ligne.add(Elem.getIdentifiant());
                        DTMMarin.addRow(ligne); 
                        this.TableMarin.setModel(DTMMarin);                             
                    }
                }
            }  
        }
        if (!trouve)
        {
            String msg;
            msg = "Aucun marin trouvé sous ce numéro de registre !";
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
    private javax.swing.JTextField LabelRegistre;
    private javax.swing.JTable TableMarin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
