package FenetresEnOption;
import Thread.ThreadDate;
import javax.swing.ComboBoxModel;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import capitainerie.Capitainerie;

public class FenetreDate extends javax.swing.JFrame {

    private Capitainerie FenCapitainerie;
    public FenetreDate(Capitainerie FenetreCapitainerie) {
        FenCapitainerie = FenetreCapitainerie;
        initComponents();
        DefaultComboBoxModel dlmPays = new DefaultComboBoxModel();
        dlmPays.addElement("France"); 
        dlmPays.addElement("Royaume-Uni");
        dlmPays.addElement("Allemagne"); 
        dlmPays.addElement("Italie");
        dlmPays.addElement("Etats-Unis");
        this.BoxPays.setModel((ComboBoxModel) dlmPays);
                
        DefaultComboBoxModel dlmDate = new DefaultComboBoxModel();
        dlmDate.addElement("22 mars 2020"); 
        dlmDate.addElement("22 mar. 2020");
        dlmDate.addElement("22/03/2020"); 
        this.BoxFormatDate.setModel((ComboBoxModel) dlmDate);
        
        DefaultComboBoxModel dlmHeure = new DefaultComboBoxModel();
        dlmHeure.addElement("12:30");
        dlmHeure.addElement("12:30:45");
        this.BoxFormatHeure.setModel((ComboBoxModel) dlmHeure);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelPays = new javax.swing.JLabel();
        BoxPays = new javax.swing.JComboBox();
        LabelDate = new javax.swing.JLabel();
        BoxFormatDate = new javax.swing.JComboBox();
        LabelHeure = new javax.swing.JLabel();
        BoxFormatHeure = new javax.swing.JComboBox();
        BoutonConfirmer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Format de la date");

        LabelPays.setText("Pays :");

        BoxPays.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BoxPays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxPaysActionPerformed(evt);
            }
        });

        LabelDate.setText("Formate de la date :");

        BoxFormatDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LabelHeure.setText("Format de l'heure :");

        BoxFormatHeure.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BoutonConfirmer.setText("Confirmer");
        BoutonConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonConfirmerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Parametrage du format de la date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelPays)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxFormatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelHeure)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BoxFormatHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BoutonConfirmer)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPays)
                    .addComponent(BoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDate)
                    .addComponent(BoxFormatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelHeure)
                    .addComponent(BoxFormatHeure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BoutonConfirmer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonConfirmerActionPerformed
        FenCapitainerie.MenuDateCourante.setSelected(true);
        FenCapitainerie.MenuDateCourante.setText("Cacher la date-heure courante");
        FenCapitainerie.td = new ThreadDate(FenCapitainerie, (String) BoxPays.getSelectedItem(), (String) BoxFormatDate.getSelectedItem (), (String) BoxFormatHeure.getSelectedItem ());
        FenCapitainerie.td.start();
        this.setVisible(false);
    }//GEN-LAST:event_BoutonConfirmerActionPerformed

    private void BoxPaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxPaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxPaysActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonConfirmer;
    private javax.swing.JComboBox BoxFormatDate;
    private javax.swing.JComboBox BoxFormatHeure;
    private javax.swing.JComboBox BoxPays;
    private javax.swing.JLabel LabelDate;
    private javax.swing.JLabel LabelHeure;
    private javax.swing.JLabel LabelPays;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
