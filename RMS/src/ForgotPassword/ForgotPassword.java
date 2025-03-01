/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ForgotPassword;
import database.DatabaseConnection;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class ForgotPassword extends javax.swing.JFrame {

    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblRegistration = new javax.swing.JLabel();
        txtResetPasswordUsername = new javax.swing.JTextField();
        txtResetPassword1 = new javax.swing.JPasswordField();
        lblGoBack = new javax.swing.JLabel();
        btnResetPassword = new javax.swing.JButton();
        lblSecurityQuestion = new javax.swing.JLabel();
        txtSecurityQuestion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtResetPassword2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlLogin.setBackground(new java.awt.Color(204, 204, 255));
        pnlLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        lblRegistration.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblRegistration.setText("Reset Password");

        txtResetPasswordUsername.setText("Username");
        txtResetPasswordUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtResetPasswordUsernameMouseClicked(evt);
            }
        });
        txtResetPasswordUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResetPasswordUsernameActionPerformed(evt);
            }
        });

        txtResetPassword1.setText("Password");
        txtResetPassword1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtResetPassword1MouseClicked(evt);
            }
        });
        txtResetPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResetPassword1ActionPerformed(evt);
            }
        });

        lblGoBack.setText("Go Back");
        lblGoBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGoBackMouseClicked(evt);
            }
        });

        btnResetPassword.setText("Reset Password");
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        lblSecurityQuestion.setText("What is your dog name?");

        txtSecurityQuestion.setText("Example: Tommy.");
        txtSecurityQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSecurityQuestionMouseClicked(evt);
            }
        });
        txtSecurityQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecurityQuestionActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter your username:");

        jLabel2.setText("Enter your new password:");

        jLabel3.setText("Retype Password:");

        txtResetPassword2.setText("Password");
        txtResetPassword2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtResetPassword2MouseClicked(evt);
            }
        });
        txtResetPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResetPassword2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGoBack)
                .addGap(23, 23, 23))
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtResetPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblSecurityQuestion)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResetPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResetPasswordUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnResetPassword))
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(lblRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addComponent(txtResetPasswordUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtResetPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtResetPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSecurityQuestion))
                .addGap(18, 18, 18)
                .addComponent(btnResetPassword)
                .addGap(17, 17, 17)
                .addComponent(lblGoBack)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtResetPasswordUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResetPasswordUsernameMouseClicked
        // TODO add your handling code here:
        txtResetPasswordUsername.setText("");
    }//GEN-LAST:event_txtResetPasswordUsernameMouseClicked

    private void txtResetPasswordUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResetPasswordUsernameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtResetPasswordUsernameActionPerformed

    private void txtResetPassword1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResetPassword1MouseClicked
        // TODO add your handling code here:
        txtResetPassword1.setText("");
    }//GEN-LAST:event_txtResetPassword1MouseClicked

    private void txtResetPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResetPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResetPassword1ActionPerformed

    private void lblGoBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoBackMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblGoBackMouseClicked

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        // TODO add your handling code here:
        String username = txtResetPasswordUsername.getText();
        String password1 = txtResetPassword1.getText();
        String password2 = txtResetPassword2.getText();
        String securityQtn = txtSecurityQuestion.getText();
        
        if (password1.equals(password2)){
            boolean updated = DatabaseConnection.updatePassword(username, securityQtn, password1);
            if (updated==true){
                JOptionPane.showMessageDialog(this, "password updated succesfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "passwor dupdate failed", "Failure", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "password doesnot match", "Failure", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void txtSecurityQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSecurityQuestionMouseClicked
        // TODO add your handling code here:
        txtSecurityQuestion.setText("");
    }//GEN-LAST:event_txtSecurityQuestionMouseClicked

    private void txtSecurityQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecurityQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecurityQuestionActionPerformed

    private void txtResetPassword2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResetPassword2MouseClicked
        // TODO add your handling code here:
        txtResetPassword2.setText("");
    }//GEN-LAST:event_txtResetPassword2MouseClicked

    private void txtResetPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResetPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResetPassword2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblGoBack;
    private javax.swing.JLabel lblRegistration;
    private javax.swing.JLabel lblSecurityQuestion;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtResetPassword1;
    private javax.swing.JPasswordField txtResetPassword2;
    private javax.swing.JTextField txtResetPasswordUsername;
    private javax.swing.JTextField txtSecurityQuestion;
    // End of variables declaration//GEN-END:variables
}
