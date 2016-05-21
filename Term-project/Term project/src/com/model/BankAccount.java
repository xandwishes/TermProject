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
public class BankAccount {
    
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
    Sql sql = new Sql();
    
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
        db.executeQuery(sql.sqlcreateAccount(acc_name, balance, email, phone_num, id_no, address));
        db.executeQuery(sql.sqlUpdateTransac(1, (int)balance, "opa"));

//        long id = System.currentTimeMillis();
//
//        String sql_openAccount = "INSERT INTO "
//                + "BANK_ACCOUNT(acc_id,acc_name,fname,lname,balance,date,email,phone_num,id_no,address)"
//                + "VALUES ('" + id + "','"+acc_name+"','" + fname + "','"+ lname + "','" + balance + "','" + new java.sql.Date(System.currentTimeMillis())
//                +  "','" + email + "','" + phone_num + "','" + id_no + "','" + address + "')";
//
//        String code = "OPA";
//        String sql_transaction = "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
//                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) + "'," + balance + "," + id + ","+balance+
//        ")";
       
    }

    public void deposit(long acc_id, int amount) {
        // Connect to database
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
//        String code = "DPS";
//        String sql_depositvalue = "UPDATE BANK_ACCOUNT SET balance = (balance + " + amount + ") WHERE acc_id = ('" + acc_id + "')";
//        String sql_transaction = "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
//                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) + "'," + amount + "," + acc_id + ","+(amount+getBalanceNow(acc_id))+
//        ")";
       db.executeQuery(sql.sqlDeposit(acc_id, amount));
       db.executeQuery(sql.sqlUpdateTransac(acc_id, amount, "dep"));
    }
    public static double getBalanceNow(long acc_id) {
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

    public static void withdrawal(long acc_id, int amount) {
        // Connect to database
        System.out.println("Widrawal");
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
        String code = "WID";
        String sql_depositvalue = "UPDATE BANK_ACCOUNT SET balance = (balance -" + amount + ")WHERE acc_id = ('" + acc_id + "')";

        String sql_transaction = "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) +
                    "'," + amount + "," + acc_id + ","+(getBalanceNow(acc_id)-amount)+
        ")";
        db.executeQuery(sql_depositvalue);
        db.executeQuery(sql_transaction);

    }

    public static BankAccount search(long acc_id) {
        // Connect to database
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());

        String sql_search = "SELECT * FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";

        ArrayList<HashMap> data = db.queryRows(sql_search);
        BankAccount ba = null;

        if (data != null && data.size() > 0) {
            ba = new BankAccount();
            for (int i = 0; i < data.size(); i++) {
                HashMap std = data.get(i);

                ba.setAcc_name((String) std.get("acc_name"));
                ba.setAcc_id(Long.parseLong((String) std.get("acc_id")));
                ba.setAddress((String) std.get("address"));
                ba.setBalance(Double.parseDouble((String) std.get("balance")));
                ba.setDate((String) std.get("date"));
                ba.setId_no((String) std.get("id_no"));
                ba.setEmail((String) std.get("email"));
                ba.setPhone_num((String) std.get("phone_num"));
                ba.setFname((String) std.get("fname"));
                ba.setLname((String) std.get("lname"));
            }
        }
        return ba;
    }

//    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
//        System.out.println(new java.sql.Date(System.currentTimeMillis()));
//        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
//        System.out.println(db.connect());
//
//    }

}
