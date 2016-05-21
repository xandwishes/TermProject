/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;


import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextField;
/**
 *
 * @author Nann
 */
public class BankAccount implements BankingSystem{
    
    private long acc_id;
    private String acc_name;
    private double balance;
    private String date;
    private String gender;
    private String email;
    private String phone_num;
    private String id_no;
    private String revenue_month;
    private String career;
    private int age;
    private String birthdate;
    private String address;
    BankAccount bankAccount;
    Sql sql = new Sql();
    CSDbDelegate db;
    
   
    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setRevenue_month(String revenue_month) {
        this.revenue_month = revenue_month;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getGender() {
        return gender;
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

    public String getRevenue_month() {
        return revenue_month;
    }

    public String getCareer() {
        return career;
    }

    public int getAge() {
        return age;
    }

    public String getBirthdate() {
        return birthdate;
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
   

    public void openAccount(String name, double balance, String email,String phone_num, String id_no,String address) {
//        db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
//        System.out.println(db.connect());
        db.executeQuery(sql.sqlcreateAccount(name, balance, email, phone_num, id_no, address));
        db.executeQuery(sql.sqlUpdateTransac(1, (int)balance, "opa"));
    }

    public void deposit(long acc_id, int amount) {
//        db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
//        System.out.println(db.connect());
        db.executeQuery(sql.sqlDeposit(acc_id, amount));
        db.executeQuery(sql.sqlUpdateTransac(acc_id, amount, "dep"));
    }

    public void withdrawal(long acc_id, int amount) {
        db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
        db.executeQuery(sql.sqlWithdraw(acc_id, amount));
        
        db.executeQuery(sql.sqlUpdateTransac(acc_id,amount,"wit"));
    }
    
     

}
