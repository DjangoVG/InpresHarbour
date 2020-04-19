package capitainerie;

import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import InpresHarbour.Equipage;
import InpresHarbour.Ponton;
import InpresHarbour.Quai;
import InpresHarbour.ShipWithoutIdentificationException;
import static java.lang.Float.parseFloat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static capitainerie.Capitainerie.TableBateaux;
import static capitainerie.Capitainerie.DTMBateaux;
import static capitainerie.Capitainerie.ListeBateauPeches;
import static capitainerie.Capitainerie.ListeBateauxPlaisances;
import static capitainerie.Capitainerie.ListePonton;
import static capitainerie.Capitainerie.ListeQuai;

public class InfosBateau extends javax.swing.JFrame {
    public static Equipage equipage;
    private final String TypeBateau;
    private final String NomBateau;
    private final String IdentifiantBateau;
    private final String PavillonBateau;
    private final float LongueurBateau;
    private String PortAttacheBateau;
    private float TonnageBateau;
    private boolean SubmersibleBateau;
    private final DefaultComboBoxModel DCMSubmersible;
    private String EnergieBateau;
    private String Supplement;
    private int Indice;
    
    public InfosBateau(ArrayList<BateauPlaisance> ListeBateauPlaisance, ArrayList<BateauPeche> ListeBateauPeche, ArrayList<Ponton> ListePonton, ArrayList<Quai> ListeQuai) {
        initComponents();
        
        Indice = -1;
        equipage = new Equipage ();
        IdentifiantBateau = (String) Capitainerie.TableBateaux.getValueAt(0, 0);
        NomBateau = (String) Capitainerie.TableBateaux.getValueAt(0, 1);
        LongueurBateau = (float) Capitainerie.TableBateaux.getValueAt(0, 2);
        PavillonBateau = (String) Capitainerie.TableBateaux.getValueAt(0, 3);
        String emplacement = (String) Capitainerie.TableBateaux.getValueAt(0, 4);
        TypeBateau = (String) Capitainerie.TableBateaux.getValueAt(0, 5);
        LabelEmplacement.setText(emplacement);
        LabelNomBateau.setText(NomBateau);
        LabelPavillon.setText(PavillonBateau);
        
        DCMSubmersible = new DefaultComboBoxModel();
        DCMSubmersible.addElement("Non");  
        DCMSubmersible.addElement("Oui"); 
        this.BoxSubmersible.setModel(DCMSubmersible); 
        
        if ("Plaisance".equals(TypeBateau)){
            this.LabelInfosSupplémentaires.setText("Permis : ");
        }
        else {
            this.LabelInfosSupplémentaires.setText("Type : ");
        }
        
        // ------------------------------------------------------
        
        for (BateauPlaisance Elem : ListeBateauPlaisance){
            String idListe = Elem.getIdentifiant();
            if (idListe.equals(IdentifiantBateau)){
                Indice = ListeBateauPlaisance.indexOf(Elem);
                LabelEmplacement.setText(Elem.getPortAttache());
                float ton = Elem.getTonnage();
                String t = Float.toString(ton);
                LabelTonnage.setText (t);
                LabelEnergie.setText(Elem.getEnergie());
                LabelInfosSupplémentaires.setText (Elem.getPermis());
                equipage = Elem.getEquipage();
            }            
        }        
        for (BateauPeche Elem : ListeBateauPeche){
            String idListe = Elem.getIdentifiant();
            if (idListe.equals(IdentifiantBateau)){
                Indice = ListeBateauPeche.indexOf(Elem);
                LabelEmplacement.setText(Elem.getPortAttache());
                float ton = Elem.getTonnage();
                String t = Float.toString(ton);
                LabelTonnage.setText (t);
                LabelEnergie.setText(Elem.getEnergie());
                LabelInfosSupplémentaires.setText (Elem.getType());
                equipage = Elem.getEquipage();
            }                 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabelEmplacement = new javax.swing.JTextField();
        LabelNomBateau = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LabelPavillon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LabelPort = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        LabelTonnage = new javax.swing.JTextField();
        BoutonEquipage = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        ListEquipage = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        BoutonOk = new javax.swing.JButton();
        BoutonAnnuler = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LabelEnergie = new javax.swing.JTextField();
        BoxSubmersible = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        LabelInfosSupplémentaires = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Affichage de toutes les informations sur le bateau");

        jLabel2.setText("Nom du bateau :");

        jLabel3.setText("Emplacement :");

        LabelEmplacement.setEnabled(false);

        LabelNomBateau.setEnabled(false);

        jLabel4.setText("Pavillon :");

        jLabel6.setText("Port d'attache :");

        jLabel7.setText("Tonnage :");

        BoutonEquipage.setText("Equipage");
        BoutonEquipage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonEquipageActionPerformed(evt);
            }
        });

        BoutonOk.setText("OK");
        BoutonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonOkActionPerformed(evt);
            }
        });

        BoutonAnnuler.setText("Annuler");
        BoutonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonAnnulerActionPerformed(evt);
            }
        });

        jLabel8.setText("Est submersible :");

        jLabel9.setText("Energie :");

        BoxSubmersible.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oui", "Non" }));

        jLabel10.setText("Infos. supplémentaires :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(BoutonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoutonAnnuler)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelEmplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelNomBateau, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(106, 106, 106)
                                .addComponent(LabelPavillon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelPort, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LabelTonnage, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BoxSubmersible, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LabelEnergie)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BoutonEquipage, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ListEquipage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addGap(19, 19, 19)
                        .addComponent(LabelInfosSupplémentaires)))
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
                    .addComponent(jLabel3)
                    .addComponent(LabelEmplacement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNomBateau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(LabelPavillon, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTonnage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(BoxSubmersible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(LabelEnergie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelInfosSupplémentaires, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonEquipage)
                    .addComponent(ListEquipage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonAnnuler)
                    .addComponent(BoutonOk))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonAnnulerActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonAnnulerActionPerformed

    private void BoutonEquipageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonEquipageActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new PublishEquipage(equipage).setVisible(true);
        });  
    }//GEN-LAST:event_BoutonEquipageActionPerformed

    private void BoutonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonOkActionPerformed
        try {
            TonnageBateau = parseFloat (LabelTonnage.getText());
            PortAttacheBateau = LabelPort.getText();
            String sub = (String) BoxSubmersible.getSelectedItem();
            SubmersibleBateau = !"Non".equals(sub);
            EnergieBateau = this.LabelEnergie.getText();
            Supplement = this.LabelInfosSupplémentaires.getText();
            if ("Plaisance".equals(TypeBateau))
            {
                try
                {
                    BateauPlaisance bpl = new BateauPlaisance (IdentifiantBateau, SubmersibleBateau, EnergieBateau, NomBateau, PortAttacheBateau, TonnageBateau, LongueurBateau, PavillonBateau, equipage, Supplement);
                    for (int j = 0; j < ListePonton.size(); j++)
                    {
                        Ponton p = ListePonton.get(j);
                        int cap = p.getCapacite ();
                        int tempA;
                        int reste = cap%2;
                        
                        if (reste != 0)
                            tempA = (cap/2)+1;
                        else
                            tempA = (cap/2);
                        
                        int k = 0;
                        ArrayList<BateauPlaisance> listA = p.getListeBateauCoté1();
                        ArrayList<BateauPlaisance> listB = p.getListeBateauCoté2();
                        for (int i=0; i < cap; i++)
                        {
                            if (i < tempA)
                            {
                                if (listA.get(i) != null)
                                {
                                    if (listA.get(i).getIdentifiant().equals(bpl.getIdentifiant()))
                                    {
                                        if (Indice == -1)
                                            ListeBateauxPlaisances.add(bpl);
                                        
                                        else 
                                        {
                                            ListeBateauxPlaisances.remove(Indice);
                                            ListeBateauxPlaisances.add(Indice, bpl);
                                        }
                                        if (Capitainerie.TableBateaux.getRowCount() >0)
                                            Capitainerie.TableBateaux.remove(0);
                                        ListePonton.get(j).modifierBateau(bpl, i, 1);                              
                                    }
                                }
                            }
                            else 
                            {
                                if (listB.get(k) != null)
                                {                            
                                    if (listB.get(k).getIdentifiant().equals(bpl.getIdentifiant()))
                                    {
                                        if (Indice == -1)
                                            ListeBateauxPlaisances.add(bpl);
                                        else
                                        {
                                            ListeBateauxPlaisances.remove(Indice);
                                            ListeBateauxPlaisances.add(Indice, bpl);
                                        }
                                        if (Capitainerie.DTMBateaux.getRowCount() >0) 
                                        {
                                            System.out.println("J'enleve une ligne");
                                             Capitainerie.DTMBateaux.removeRow(0);                                           
                                        }

                                        ListePonton.get(j).modifierBateau(bpl, k, 2);
                                    }
                                }
                                k++;
                            }
                        }
                    }                
                    Capitainerie.fichierLog.ecritLigne ("Le bateau " + IdentifiantBateau + " a bien été enregistré");
                    Capitainerie.fichierLog.ecritLigne ("Le bateau n'est plus en attente");                
                    setVisible (false); 
                } catch (ShipWithoutIdentificationException ex) {
                    Capitainerie.fichierLog.ecritLigne ("ShipWithoutIdentificationException : " + ex.getMessage());
                }

            }
            else
            {
                try 
                {
                    BateauPeche bpe = new BateauPeche (IdentifiantBateau, SubmersibleBateau, EnergieBateau, NomBateau, PortAttacheBateau, TonnageBateau, LongueurBateau, PavillonBateau, equipage, Supplement);
                    for (int j = 0; j < ListeQuai.size(); j++)
                    { // Boucle de création des lignes.
                        Quai q = ListeQuai.get(j);
                        ArrayList<BateauPeche> list = q.getListeBateau();
                        for (int i=0; i < q.getCapacite(); i++)
                        { // Boucle de création des colonnes.
                            if (list.get(i) != null) {
                                if (list.get(i).getIdentifiant().equals(bpe.getIdentifiant()))
                                {
                                    if (Indice == -1)
                                    {
                                        ListeBateauPeches.add(bpe);
                                    }
                                    else
                                    {
                                        ListeBateauPeches.remove(Indice);
                                        ListeBateauPeches.add(Indice, bpe);
                                    }               
                                    if (Capitainerie.DTMBateaux.getRowCount() >0) 
                                    {
                                        System.out.println("J'enleve une ligne");
                                        Capitainerie.DTMBateaux.removeRow(0);                                           
                                    }                              
                                    list.remove(i);
                                    list.add(i, bpe);
                                }
                            }
                        }
                    }        
                } catch (ShipWithoutIdentificationException ex) {
                    Capitainerie.fichierLog.ecritLigne ("ShipWithoutIdentificationException : " + ex.getMessage());
                }            
            }
            TableBateaux.setModel(DTMBateaux);
            if (TableBateaux.getRowCount() != 0)
                Capitainerie.BoutonBateauAmarré.setEnabled(true);  
            else
                Capitainerie.BoutonBateauAmarré.setEnabled(false);
            Capitainerie.fichierLog.ecritLigne ("Le bateau " + IdentifiantBateau + " a bien été enregistré");
            Capitainerie.fichierLog.ecritLigne ("Le bateau n'est plus en attente");                
            setVisible (false);            
            
        }
        catch (NumberFormatException e){
            String msg;
            msg = "Erreur : le tonnage doit être sur le format chiffre ! ";
            JOptionPane.showMessageDialog(this, msg, "Erreur de format", JOptionPane.INFORMATION_MESSAGE);            
        }         
    }//GEN-LAST:event_BoutonOkActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) { 
        this.setVisible(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonAnnuler;
    private javax.swing.JButton BoutonEquipage;
    private javax.swing.JButton BoutonOk;
    private javax.swing.JComboBox<String> BoxSubmersible;
    private javax.swing.JTextField LabelEmplacement;
    private javax.swing.JTextField LabelEnergie;
    private javax.swing.JTextField LabelInfosSupplémentaires;
    public static javax.swing.JTextField LabelNomBateau;
    private javax.swing.JLabel LabelPavillon;
    public static javax.swing.JTextField LabelPort;
    private javax.swing.JTextField LabelTonnage;
    public static javax.swing.JComboBox<String> ListEquipage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
