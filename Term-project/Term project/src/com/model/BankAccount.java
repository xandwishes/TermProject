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
 * @author Nann
 */
public class BankAccount extends Search implements BankingSystem{
    
    private long acc_id;
    private String acc_name;
    private String fname;
    private String lname;
    private double balance;
    private String date;
    private String email;
    private String phone_num;
    private String id_no;
    private String address;
   
    
    
    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    public long getAcc_id() {
        return acc_id;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getId_no() {
        return id_no;
    }
    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void openAccount(String acc_name,String fname,String lname, double balance, String email, String phone_num,
                                      String id_no, String address) {

        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
        db.executeQuery(sqlcreateAccount(acc_name, balance, email, phone_num, id_no, address));
        db.executeQuery(sqlUpdateTransac(1, (int)balance, "OPA"));
     }

    public void deposit(long acc_id, int amount) {
        // Connect to database
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
       db.executeQuery(sqlUpdateTransac(acc_id, amount, "DEP"));
        db.executeQuery(sqlDeposit(acc_id, amount));
    }
    

    public void withdrawal(long acc_id, int amount) {
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
       db.executeQuery(sqlUpdateTransac(acc_id,amount,"WIT"));
        db.executeQuery(sqlWithdraw(acc_id, amount));

    }

  
}
