package capitainerie;
import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ListeBateaux extends javax.swing.JFrame {
    private final DefaultTableModel TablePlaisance;
    private final DefaultTableModel TablePeche;   
    
    public ListeBateaux(ArrayList<BateauPlaisance> plaisanceList, ArrayList<BateauPeche> pecheList) {
        initComponents();
        TablePlaisance = new DefaultTableModel ();
        TablePlaisance.addColumn("Identifiant");
        TablePlaisance.addColumn("Submersible");
        TablePlaisance.addColumn("Energie");
        TablePlaisance.addColumn("Nom");
        TablePlaisance.addColumn("Port d'attache");
        TablePlaisance.addColumn("Tonnage");
        TablePlaisance.addColumn("Longueur");
        TablePlaisance.addColumn("Pavillon");
        TablePlaisance.addColumn("Permis");
        
        for (BateauPlaisance Elem : plaisanceList)
        {
            System.out.println("Bateau");
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
            TablePlaisance.addRow(ligne);
        }        
        this.TableBateauxPlaisance.setModel(TablePlaisance);

        TablePeche = new DefaultTableModel ();
        TablePeche.addColumn("Identifiant");
        TablePeche.addColumn("Submersible");
        TablePeche.addColumn("Energie");
        TablePeche.addColumn("Nom");
        TablePeche.addColumn("Port d'attache");
        TablePeche.addColumn("Tonnage");
        TablePeche.addColumn("Longueur");
        TablePeche.addColumn("Pavillon");
        TablePeche.addColumn("Type");
        
        for (BateauPeche Elem : pecheList)
        {
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
            TablePeche.addRow(ligne);
        }
        this.TableBateauPeche.setModel(TablePeche);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelBateauPlaisance = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBateauPeche = new javax.swing.JTable();
        ListeBateauPeche = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBateauxPlaisance = new javax.swing.JTable();
        BoutonQuittez = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelBateauPlaisance.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        LabelBateauPlaisance.setForeground(new java.awt.Color(0, 102, 255));
        LabelBateauPlaisance.setText("Liste complète des bateaux de plaisance :");

        TableBateauPeche.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableBateauPeche);

        ListeBateauPeche.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        ListeBateauPeche.setForeground(new java.awt.Color(0, 102, 255));
        ListeBateauPeche.setText("Liste complète des bateaux de pêche :");

        TableBateauxPlaisance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identifiant", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TableBateauxPlaisance);

        BoutonQuittez.setText("Quitter");
        BoutonQuittez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonQuittezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BoutonQuittez))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelBateauPlaisance)
                            .addComponent(ListeBateauPeche))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelBateauPlaisance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListeBateauPeche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonQuittez)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonQuittezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonQuittezActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonQuittezActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) { 
        this.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonQuittez;
    private javax.swing.JLabel LabelBateauPlaisance;
    private javax.swing.JLabel ListeBateauPeche;
    private javax.swing.JTable TableBateauPeche;
    private javax.swing.JTable TableBateauxPlaisance;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
