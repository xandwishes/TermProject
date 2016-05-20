/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author zxcvbnm
 */
public class ConnectDB {
    public CSDbDelegate db;
    public ConnectDB(){
        db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
    }
    
    public void executeQuery(String s){
       db.connect();
       db.executeQuery(s);
       db.disconnect();
     
    }
    
   
    public ArrayList<HashMap> queryRows(String s){
        return db.queryRows(s);
        
    }
    
    
}
