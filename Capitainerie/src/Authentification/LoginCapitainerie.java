package Authentification;
import capitainerie.Capitainerie;

public class LoginCapitainerie extends javax.swing.JDialog {

    public VerificateurUsersPasswordHash Sub;
    private Capitainerie FenetreCapitainerie;
    public LoginCapitainerie(Capitainerie parent, boolean modal) {
        super(parent, modal);
        FenetreCapitainerie = parent;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FieldLogin = new javax.swing.JTextField();
        FieldPassword = new javax.swing.JPasswordField();
        BoutonConnexion = new javax.swing.JButton();
        BoutonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BateauPlaisanceLogin.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Panel d'identification de la Capitainerie");

        jLabel3.setText("Nom d'utilisateur :");

        jLabel4.setText("Mot de passe :");

        BoutonConnexion.setText("Se connecter");
        BoutonConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonConnexionActionPerformed(evt);
            }
        });

        BoutonReset.setText("Reset");
        BoutonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BoutonConnexion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BoutonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(FieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoutonConnexion)
                    .addComponent(BoutonReset))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonResetActionPerformed
        this.FieldLogin.setText("");
        this.FieldPassword.setText("");
    }//GEN-LAST:event_BoutonResetActionPerformed

    private void BoutonConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonConnexionActionPerformed
        String Login, Password;
        Login = FieldLogin.getText();
        Password = FieldPassword.getText();
        
        if (this.BoutonConnexion.getText().equalsIgnoreCase("Se connecter"))
        {
            try
            {
                this.Sub = new VerificateurUsersPasswordHash (Login, Password);
                if (!Sub.isValid(Password, Login))
                    throw new LoginException();
                else
                {
                    if (Sub.findPwd(Login, Password))
                    {
                        System.out.println ("Mot de passe trouvé");
                        FenetreCapitainerie.MenuLogout.setEnabled(true);
                        FenetreCapitainerie.BoutonLire.setEnabled(true);
                        FenetreCapitainerie.MenuAmarrage.setEnabled(true);
                        FenetreCapitainerie.MenuBateau.setEnabled(true);
                        FenetreCapitainerie.MenuPersonnel.setEnabled(true);
                        FenetreCapitainerie.MenuFichierLOG.setEnabled(true);
                        FenetreCapitainerie.MenuLogin.setEnabled(false);
                        FenetreCapitainerie.BoutonDemarrerServeur.setEnabled(true);
                        FenetreCapitainerie.MenuNewUser.setEnabled(true);
                        this.setVisible(false);
                    }        
                    else
                        throw new LoginException();
                }    
            }
            catch (LoginException e)
            {
            }   
        }
        else
        {
            this.Sub = new VerificateurUsersPasswordHash (Login, Password); 
            if (!Sub.isValid(Password, Login))
                System.out.println ("Mot de passe et/ou login non valide !!!");
            else
            {
                Sub.ajouterLogin (Login, Password); 
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_BoutonConnexionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BoutonConnexion;
    private javax.swing.JButton BoutonReset;
    private javax.swing.JTextField FieldLogin;
    private javax.swing.JPasswordField FieldPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
