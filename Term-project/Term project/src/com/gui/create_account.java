/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.model.BankAccount;
import com.model.BankFunction;

import edu.sit.cs.db.CSDbDelegate;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nann
 */
public class create_account extends javax.swing.JFrame {
    BankAccount bankAccount = new BankAccount();
    /**
     * Creates new form create_account
     */
    public create_account() {
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

        createAcc = new javax.swing.JLabel();
        namesur = new javax.swing.JLabel();
        Deposit = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        deposittf = new javax.swing.JTextField();
        emailL = new javax.swing.JLabel();
        acc_name = new javax.swing.JTextField();
        emailtf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addresstf = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        buttonNext = new javax.swing.JButton();
        fname_ft = new javax.swing.JTextField();
        lname_tf = new javax.swing.JTextField();
        rpm = new javax.swing.JLabel();
        Age = new javax.swing.JLabel();
        phonenum = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        idtf = new javax.swing.JTextField();
        phonetf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        createAcc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createAcc.setText("Create account");
        getContentPane().add(createAcc);
        createAcc.setBounds(310, 20, 280, 60);

        namesur.setText("Name-Surname");
        getContentPane().add(namesur);
        namesur.setBounds(40, 100, 110, 30);

        Deposit.setText("Deposit");
        getContentPane().add(Deposit);
        Deposit.setBounds(420, 100, 60, 30);

        Address.setText("Address :");
        getContentPane().add(Address);
        Address.setBounds(40, 300, 60, 100);
        getContentPane().add(deposittf);
        deposittf.setBounds(530, 100, 170, 30);

        emailL.setText("E-mail");
        getContentPane().add(emailL);
        emailL.setBounds(40, 250, 40, 30);

        acc_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_nameActionPerformed(evt);
            }
        });
        getContentPane().add(acc_name);
        acc_name.setBounds(160, 100, 170, 30);
        getContentPane().add(emailtf);
        emailtf.setBounds(160, 250, 170, 30);

        addresstf.setColumns(20);
        addresstf.setRows(5);
        jScrollPane2.setViewportView(addresstf);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(160, 300, 166, 96);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton);
        cancelButton.setBounds(270, 410, 100, 60);

        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });
        getContentPane().add(buttonNext);
        buttonNext.setBounds(380, 410, 100, 60);
        getContentPane().add(fname_ft);
        fname_ft.setBounds(160, 150, 170, 30);
        getContentPane().add(lname_tf);
        lname_tf.setBounds(160, 200, 170, 30);

        rpm.setText("Last Name");
        getContentPane().add(rpm);
        rpm.setBounds(40, 200, 110, 30);

        Age.setText("Frist Name");
        getContentPane().add(Age);
        Age.setBounds(40, 150, 100, 30);

        phonenum.setText("Phone number");
        getContentPane().add(phonenum);
        phonenum.setBounds(400, 200, 90, 30);

        id.setText("Identity card number");
        getContentPane().add(id);
        id.setBounds(400, 150, 120, 30);
        getContentPane().add(idtf);
        idtf.setBounds(530, 150, 170, 30);
        getContentPane().add(phonetf);
        phonetf.setBounds(530, 200, 170, 30);

        setSize(new java.awt.Dimension(769, 567));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        
        if(!call.useConfirmDialog("cancel","Are you sure")){
            setVisible(true);
        }else{
            call.callDisplayApp();
            setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        if(BankFunction.checkEmpty(acc_name)){
               JOptionPane.showMessageDialog(null, "Fill name", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }else
        if(BankFunction.checkEmpty(idtf)){
              JOptionPane.showMessageDialog(null, "Fill Identity number", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }else{
           
            
            try{
                BankAccount.openAccount(acc_name.getText(), lname_tf.getText(), lname_tf.getText(), Double.parseDouble(deposittf.getText()), 
                emailtf.getText(), phonetf.getText(), idtf.getText(), addresstf.getText());
                JOptionPane.showMessageDialog(this,"Account Created");
                call.callDisplayApp();
                setVisible(false);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage(),"Alert",JOptionPane.ERROR_MESSAGE);
            }
            
                   
       }

    }//GEN-LAST:event_buttonNextActionPerformed

    private void acc_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_nameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_acc_nameActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new create_account().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JLabel Age;
    private javax.swing.JLabel Deposit;
    private javax.swing.JTextField acc_name;
    private javax.swing.JTextArea addresstf;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel createAcc;
    private javax.swing.JTextField deposittf;
    private javax.swing.JLabel emailL;
    private javax.swing.JTextField emailtf;
    private javax.swing.JTextField fname_ft;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idtf;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lname_tf;
    private javax.swing.JLabel namesur;
    private javax.swing.JLabel phonenum;
    private javax.swing.JTextField phonetf;
    private javax.swing.JLabel rpm;
    // End of variables declaration//GEN-END:variables

    

   
}
