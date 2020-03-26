package Phare;
import static java.lang.Float.parseFloat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class IdentificationBateau extends javax.swing.JFrame {
    private DefaultListModel DLMAttente;

    public IdentificationBateau() {
        initComponents();
        String Bateau;
        DLMAttente = new DefaultListModel();
        DLMAttente = (DefaultListModel) Phare.ListeAttente.getModel();
        Bateau = (String) Phare.ListeAttente.getModel().getElementAt(0);       
        String[] separe = Bateau.split("/");
        String TypeBateau = separe[0];
        String PavillonBateau = separe[1];
        this.LabelTypeBateau.setText(TypeBateau);
        this.LabelPavillonBateau.setText(PavillonBateau);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LabelTypeBateau = new javax.swing.JTextField();
        LabelPavillonBateau = new javax.swing.JTextField();
        LabelNomBateau = new javax.swing.JTextField();
        LabelLongueurBateau = new javax.swing.JTextField();
        LabelImmatBateau = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        BoutonConfirmer = new javax.swing.JButton();
        BoutonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Identification d'un bateau en attente d'entrée");

        jLabel2.setText("Type du bateau :");

        jLabel3.setText("Pavillon du bateau :");

        jLabel4.setText("Nom du bateau :");

        jLabel5.setText("Longueur du bateau :");

        jLabel6.setText("Immatriculation du bateau :");

        LabelTypeBateau.setEnabled(false);

        LabelPavillonBateau.setEnabled(false);

        BoutonConfirmer.setText("Confirmer");
        BoutonConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonConfirmerActionPerformed(evt);
            }
        });

        BoutonAnnuler.setText("Annuler");
        BoutonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnulerActionPerformed(evt);
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
                        .addGap(87, 87, 87)
                        .addComponent(LabelTypeBateau))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(72, 72, 72)
                        .addComponent(LabelPavillonBateau))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelLongueurBateau)
                            .addComponent(LabelNomBateau)
                            .addComponent(LabelImmatBateau)))
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonConfirmer)
                                .addGap(18, 18, 18)
                                .addComponent(BoutonAnnuler)))
                        .addGap(0, 69, Short.MAX_VALUE)))
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
                    .addComponent(LabelTypeBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LabelPavillonBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNomBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelLongueurBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(LabelImmatBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonConfirmer)
                    .addComponent(BoutonAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonConfirmerActionPerformed
        try {
            float lg = parseFloat (this.LabelLongueurBateau.getText());
            String Identification;
            Identification = LabelTypeBateau.getText();
            Identification += "/";
            Identification += LabelPavillonBateau.getText();
            Identification += "/";
            Identification += LabelNomBateau.getText ();
            Identification += "/";
            Identification += LabelLongueurBateau.getText ();
            Identification += "/";
            Identification += LabelImmatBateau.getText().toLowerCase();
            Phare.LabelBateauIdentifie.setText (Identification);
            Phare.BoutonAutorisationEntree.setEnabled(true);
            this.setVisible (false);
        }catch (NumberFormatException e){
            String msg;
            msg = "La longueur rentrée est invalide !";
            JOptionPane.showMessageDialog(this, msg, "Attention !", JOptionPane.INFORMATION_MESSAGE);            
        } 
    }//GEN-LAST:event_BoutonConfirmerActionPerformed

    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonAnnulerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAnnuler;
    private javax.swing.JButton BoutonConfirmer;
    private javax.swing.JTextField LabelImmatBateau;
    private javax.swing.JTextField LabelLongueurBateau;
    private javax.swing.JTextField LabelNomBateau;
    private javax.swing.JTextField LabelPavillonBateau;
    private javax.swing.JTextField LabelTypeBateau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
