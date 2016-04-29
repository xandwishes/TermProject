/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

/**
 *
 * @author zxcvbnm
 */
public class call {
    
    public static void callDisplayApp(){
     displayApp dis = new displayApp();
     dis.setVisible(true);
     
    }
    
    public static void callDeposit(){
     deposit depo = new deposit();
     depo.setVisible(true);
    }
    
    public static void callCreateAccount(){
     create_account ca = new create_account();
     ca.setVisible(true);
    }
    
    public static void callInterest(){
     interest inter = new interest();
     inter.setVisible(true);
    }
    
    public static void callStatementPrintout(){
     statement_printout state = new statement_printout();
     state.setVisible(true);
    }
    
    public static void callTransferAccount(){
     transfer_account trans = new transfer_account();
     trans.setVisible(true);
    }
   
    public static void callTransferNot(){
     transfer_not trans = new transfer_not();
     trans.setVisible(true);
    }
    
    public static void callWithDrawal(){
     withDrawal with = new withDrawal();
     with.setVisible(true);
    }
    
    public static void callEmpLogin(){
    emp_login emp = new emp_login();
    emp.setVisible(true);
    }
}
