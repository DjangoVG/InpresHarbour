package capitainerie;
import InpresHarbour.BateauPeche;
import InpresHarbour.BateauPlaisance;
import InpresHarbour.Equipage;
import InpresHarbour.Marin;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import static capitainerie.Capitainerie.ListeBateauxPlaisances;
import static capitainerie.Capitainerie.ListeBateauPeches;
import java.awt.Color;

public class InfosEquipage extends javax.swing.JFrame {
    private final DefaultTableModel DTMEquipage;

    public InfosEquipage(ArrayList<BateauPlaisance> ListeBateauPlaisances, ArrayList<BateauPeche> ListeBateauPeche) {
        initComponents();
        
        DTMEquipage = new DefaultTableModel ();
        DTMEquipage.addColumn("Identifiant");
        DTMEquipage.addColumn("Nom");
        DTMEquipage.addColumn("Prénom");
        DTMEquipage.addColumn("Date de naissance");
        DTMEquipage.addColumn("Fonction");   
        this.TableEquipage.setModel(DTMEquipage);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        LabelPavillon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LabelImmatriculation = new javax.swing.JTextField();
        LabelMessage = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        BoutonRechercher = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEquipage = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        BoutonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Affichage de toutes les informations sur l'équipage");

        jLabel2.setText("Pavillon :");

        jLabel3.setText("Immatriculation :");

        LabelMessage.setEnabled(false);

        BoutonRechercher.setText("Rechercher");
        BoutonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonRechercherActionPerformed(evt);
            }
        });

        TableEquipage.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableEquipage);

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
                    .addComponent(jSeparator2)
                    .addComponent(LabelMessage)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addComponent(LabelImmatriculation))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BoutonQuitter))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelPavillon))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(BoutonRechercher)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator3))
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
                    .addComponent(LabelPavillon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LabelImmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BoutonRechercher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonQuitter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonRechercherActionPerformed
        String id = this.LabelPavillon.getText().toUpperCase() + "_" + this.LabelImmatriculation.getText().toLowerCase();
        boolean trouve = false;
        for (BateauPlaisance Elem : ListeBateauxPlaisances){
            String idListe = Elem.getIdentifiant();
            if (idListe.equals(id)){
                this.LabelMessage.setText ("Le bateau a bien été trouvé dans la liste des bateaux de plaisance. ");
                this.LabelMessage.setSelectionColor(Color.green);
                trouve = true;
                Equipage equi = Elem.getEquipage();
                Marin cap = equi.getCapitaine();
                Vector ligne = new Vector();
                ligne.add(cap.getIdentifiant());
                ligne.add(cap.getNom());
                ligne.add(cap.getPrenom());
                ligne.add(cap.getDateNaissance().getDay() + "/" + cap.getDateNaissance().getMonth() + "/" + cap.getDateNaissance().getYear());
                ligne.add(cap.getFonction());
                DTMEquipage.addRow(ligne);

                if (equi.getSecond() != null){
                    Marin sec = equi.getSecond();
                    Vector ligneSec = new Vector();
                    ligneSec.add(sec.getIdentifiant());
                    ligneSec.add(sec.getNom());
                    ligneSec.add(sec.getPrenom());
                    ligneSec.add(sec.getDateNaissance().getDay() + "/" + sec.getDateNaissance().getMonth() + "/" + sec.getDateNaissance().getYear());                  
                    ligneSec.add(sec.getFonction());
                    DTMEquipage.addRow(ligneSec);  
                }
                
                if (equi.getListeMarin() != null){
                    for (Marin ElemMar : equi.getListeMarin()){
                        Vector ligneMarin = new Vector ();
                        ligneMarin.add(ElemMar.getIdentifiant());
                        ligneMarin.add(ElemMar.getNom());
                        ligneMarin.add(ElemMar.getPrenom());
                        ligneMarin.add(ElemMar.getDateNaissance().getDay() + "/" + ElemMar.getDateNaissance().getMonth() + "/" + ElemMar.getDateNaissance().getYear());
                        ligneMarin.add(ElemMar.getFonction());
                        DTMEquipage.addRow(ligneMarin);
                    }
                }
                this.TableEquipage.setModel(DTMEquipage);
            }
        }        
        for (BateauPeche Elem : ListeBateauPeches){
            String idListe = Elem.getIdentifiant();
            if (idListe.equals(id)){
                this.LabelMessage.setText ("Le bateau a bien été trouvé dans la liste des bateaux de plaisance. ");
                this.LabelMessage.setSelectionColor(Color.green);
                trouve = true;
                Equipage equi = Elem.getEquipage();
                Marin cap = equi.getCapitaine();
                Vector ligne = new Vector();
                ligne.add(cap.getIdentifiant());
                ligne.add(cap.getNom());
                ligne.add(cap.getPrenom());
                ligne.add(cap.getDateNaissance().getDay() + "/" + cap.getDateNaissance().getMonth() + "/" + cap.getDateNaissance().getYear());
                ligne.add(cap.getFonction());
                DTMEquipage.addRow(ligne);
                
                Marin sec = equi.getSecond();
                Vector ligneSec = new Vector();
                ligneSec.add(sec.getIdentifiant());
                ligneSec.add(sec.getNom());
                ligneSec.add(sec.getPrenom());
                ligneSec.add(sec.getDateNaissance().getDay() + "/" + sec.getDateNaissance().getMonth() + "/" + sec.getDateNaissance().getYear());
                ligneSec.add(sec.getFonction());
                DTMEquipage.addRow(ligneSec);                 
                
                if (equi.getListeMarin() != null){
                    for (Marin ElemMar : equi.getListeMarin()){
                        Vector ligneMarin = new Vector ();
                        ligneMarin.add(ElemMar.getIdentifiant());
                        ligneMarin.add(ElemMar.getNom());
                        ligneMarin.add(ElemMar.getPrenom());
                        ligneMarin.add(ElemMar.getDateNaissance().getDay() + "/" + ElemMar.getDateNaissance().getMonth() + "/" + ElemMar.getDateNaissance().getYear());
                        ligneMarin.add(ElemMar.getFonction());
                        DTMEquipage.addRow(ligneMarin);
                    }
                }
                this.TableEquipage.setModel(DTMEquipage);
            }
        }
        if (!trouve)
        {
            this.LabelMessage.setText ("Le bateau " + id + "n'a pas été trouvé.");
            this.LabelMessage.setSelectionColor(Color.red);
        }
            
        
    }//GEN-LAST:event_BoutonRechercherActionPerformed

    private void BoutonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonQuitterActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BoutonQuitterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonQuitter;
    private javax.swing.JButton BoutonRechercher;
    private javax.swing.JTextField LabelImmatriculation;
    private javax.swing.JTextField LabelMessage;
    private javax.swing.JTextField LabelPavillon;
    private javax.swing.JTable TableEquipage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
