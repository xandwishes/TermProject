/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.control.TextField;


/**
 *
 * @author zxcvbnm
 */
public class BankFunction{
    
   
            
    public double getBalanceNow(long acc_id) {
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
        double balance = 0;
        String sql = "SELECT balance FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";

        ArrayList<HashMap> data = db.queryRows(sql);

        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                HashMap std = data.get(i);

                balance = Double.parseDouble((String) std.get("balance"));
            }
        }
        return balance;
    }
    public boolean isCode(String g){
      for(int i =0;i<g.length();i++){
          if(g.equals("'")){
              return true;
          }
      }
      return false;
       
    }
    
    public static boolean checkEmpty(TextField j){
     return  j.getText().length()<=0;
    }
}
