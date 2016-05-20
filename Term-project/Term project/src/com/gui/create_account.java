/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.model.BankAccount;

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
        malebutton = new javax.swing.JRadioButton();
        femalebutton = new javax.swing.JRadioButton();
        Gender = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        idtf = new javax.swing.JTextField();
        birthdateTF = new javax.swing.JTextField();
        Address = new javax.swing.JLabel();
        DoB = new javax.swing.JLabel();
        deposittf = new javax.swing.JTextField();
        Age = new javax.swing.JLabel();
        emailL = new javax.swing.JLabel();
        nametf = new javax.swing.JTextField();
        emailtf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addresstf = new javax.swing.JTextArea();
        DMYLB = new javax.swing.JLabel();
        career = new javax.swing.JLabel();
        revenuetf = new javax.swing.JTextField();
        careercb = new javax.swing.JComboBox();
        rpm = new javax.swing.JLabel();
        phonetf = new javax.swing.JTextField();
        phonenum = new javax.swing.JLabel();
        agetf = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        buttonNext = new javax.swing.JButton();

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

        malebutton.setText("Male");
        malebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(malebutton);
        malebutton.setBounds(540, 150, 60, 30);

        femalebutton.setText("Female");
        femalebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femalebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(femalebutton);
        femalebutton.setBounds(620, 150, 90, 30);

        Gender.setText("Gender");
        getContentPane().add(Gender);
        Gender.setBounds(420, 150, 50, 30);

        id.setText("Identity card number");
        getContentPane().add(id);
        id.setBounds(40, 150, 120, 30);
        getContentPane().add(idtf);
        idtf.setBounds(160, 150, 170, 30);
        getContentPane().add(birthdateTF);
        birthdateTF.setBounds(530, 200, 110, 30);

        Address.setText("Address :");
        getContentPane().add(Address);
        Address.setBounds(40, 300, 60, 100);

        DoB.setText("Date of birth");
        getContentPane().add(DoB);
        DoB.setBounds(420, 200, 80, 30);
        getContentPane().add(deposittf);
        deposittf.setBounds(530, 100, 170, 30);

        Age.setText("Age");
        getContentPane().add(Age);
        Age.setBounds(420, 250, 100, 30);

        emailL.setText("E-mail");
        getContentPane().add(emailL);
        emailL.setBounds(40, 250, 40, 30);

        nametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametfActionPerformed(evt);
            }
        });
        getContentPane().add(nametf);
        nametf.setBounds(160, 100, 170, 30);
        getContentPane().add(emailtf);
        emailtf.setBounds(160, 250, 170, 30);

        addresstf.setColumns(20);
        addresstf.setRows(5);
        jScrollPane2.setViewportView(addresstf);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(160, 300, 244, 84);

        DMYLB.setText("D / M / Y");
        getContentPane().add(DMYLB);
        DMYLB.setBounds(650, 200, 60, 30);

        career.setText("Career");
        getContentPane().add(career);
        career.setBounds(420, 300, 40, 30);
        getContentPane().add(revenuetf);
        revenuetf.setBounds(530, 350, 170, 30);

        careercb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please select", "Student", "Business", "Owner", "Commerce", "etc." }));
        getContentPane().add(careercb);
        careercb.setBounds(530, 300, 110, 30);

        rpm.setText("Revenue per month");
        getContentPane().add(rpm);
        rpm.setBounds(420, 350, 110, 30);
        getContentPane().add(phonetf);
        phonetf.setBounds(160, 200, 170, 30);

        phonenum.setText("Phone number");
        getContentPane().add(phonenum);
        phonenum.setBounds(40, 200, 90, 30);
        getContentPane().add(agetf);
        agetf.setBounds(530, 250, 170, 30);

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
        if(BankAccount.checkEmpty(nametf)){
               JOptionPane.showMessageDialog(null, "Fill name", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }else
        if(BankAccount.checkEmpty(idtf)){
              JOptionPane.showMessageDialog(null, "Fill Identity number", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }else{
           
            
            try{
                bankAccount.openAccount(nametf.getText(), Double.parseDouble(deposittf.getText()), emailtf.getText(),
                                        phonetf.getText(), idtf.getText(), addresstf.getText());
                JOptionPane.showMessageDialog(this,"Account Created");
                call.callDisplayApp();
                setVisible(false);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage(),"Alert",JOptionPane.ERROR_MESSAGE);
            }
            
                   
       }

    }//GEN-LAST:event_buttonNextActionPerformed

    private void nametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametfActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nametfActionPerformed

    private void malebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malebuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_malebuttonActionPerformed

    private void femalebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femalebuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femalebuttonActionPerformed

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
    private javax.swing.JLabel DMYLB;
    private javax.swing.JLabel Deposit;
    private javax.swing.JLabel DoB;
    private javax.swing.JLabel Gender;
    private javax.swing.JTextArea addresstf;
    private javax.swing.JTextField agetf;
    private javax.swing.JTextField birthdateTF;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel career;
    private javax.swing.JComboBox careercb;
    private javax.swing.JLabel createAcc;
    private javax.swing.JTextField deposittf;
    private javax.swing.JLabel emailL;
    private javax.swing.JTextField emailtf;
    private javax.swing.JRadioButton femalebutton;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idtf;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton malebutton;
    private javax.swing.JLabel namesur;
    private javax.swing.JTextField nametf;
    private javax.swing.JLabel phonenum;
    private javax.swing.JTextField phonetf;
    private javax.swing.JTextField revenuetf;
    private javax.swing.JLabel rpm;
    // End of variables declaration//GEN-END:variables

    

   
}
