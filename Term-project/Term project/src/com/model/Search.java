/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import edu.sit.cs.db.CSDbDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author zxcvbnm
 */
public class Search {
    private String acc_name;
    private long acc_id;
    private String trans_id;
    private String code;
    private String staff_id;
    private String date;
    private double amount;
    private double balance;
    private String username;
    private String password;
    private String emp_name;
    private int emp_id;
    private String gender;
    private String email;
    private String phone_num;
    private String id_no;
    private String revenue_month;
    private String career;
    private int age;
    private String birthdate;
    private String address;
    

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }
    public void setAcc_id(long acc_id) {
        this.acc_id = acc_id;
    }
    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getAcc_name() {
        return acc_name;
    }
    public long getAcc_id() {
        return acc_id;
    }
    public String getTrans_id() {
        return trans_id;
    }
    public String getCode() {
        return code;
    }
    public String getStaff_id() {
        return staff_id;
    }
    public String getDate() {
        return date;
    }
    public double getAmount() {
        return amount;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmp_name() {
        return emp_name;
    }
    public int getEmp_id() {
        return emp_id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }
    public void setEamp_id(int emp_id) {
        this.emp_id = emp_id;
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
    
    
    public static List<Search> searchByID(long acc_id){
        // Connect to database
         List<Search> list = null;
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
        String sql_search  = "SELECT * FROM BANK_TRANSACTION b JOIN BANK_ACCOUNT ba ON ba.acc_id = b.acc_id WHERE ba.acc_id =  ('"+acc_id+"')";
       
        ArrayList<HashMap> data= db.queryRows(sql_search);
        
        Search ba = null;

        if(data!=null && data.size()>0){
           if(list==null) 
               list = new ArrayList<Search>();
        for(int i = 0;i<data.size();i++){
            HashMap std = data.get(i);
            ba = new Search();
             
            ba.setAcc_id(Long.parseLong((String) std.get("acc_id")));
            ba.setCode((String)std.get("code"));
            ba.setTrans_id((String)std.get("trans_id"));
            ba.setStaff_id((String)std.get("staff_id"));
            ba.setAmount(Double.parseDouble((String) std.get("amount")));
            ba.setDate((String)std.get("date"));
            ba.setBalance(Double.parseDouble((String)std.get("balance")));
            
            list.add(ba);
        }
        }
        return list;
    }
    public static Search searchEmp(String user, String pass){
        // Connect to database
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());
        
        String sql_searchEmp  = "SELECT * FROM BANK_OFFICER WHERE USERNAME = ('"+user+"') AND PASSWORD = ('"+pass+"')";
        
        ArrayList<HashMap> data= db.queryRows(sql_searchEmp);
        Search bo = null;

        if(data!=null && data.size()>0){
            bo = new Search();
        for(int i = 0;i<data.size();i++){
            HashMap std = data.get(i);
            
            bo.setEamp_id(Integer.parseInt((String) std.get("EMP_ID")));
            bo.setEmp_name((String)std.get("EMP_NAME"));
            bo.setUsername((String)std.get("USERNAME"));
            bo.setPassword((String) std.get("PASSWORD"));
        }
        }
        return bo;
    }
    public static Search searchCustomer(long acc_id) {
        // Connect to database
        CSDbDelegate db = new CSDbDelegate("csprog-in.sit.kmutt.ac.th", "3306", "CSC105_G3", "csc105_2014", "csc105");
        System.out.println(db.connect());

        String sql_search = "SELECT * FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";

        ArrayList<HashMap> data = db.queryRows(sql_search);
        Search ba = null;

        if (data != null && data.size() > 0) {
            ba = new Search();
            for (int i = 0; i < data.size(); i++) {
                HashMap std = data.get(i);

                ba.setAcc_name((String) std.get("acc_name"));
                ba.setAcc_id(Long.parseLong((String) std.get("acc_id")));
                ba.setAddress((String) std.get("address"));
                ba.setBalance(Double.parseDouble((String) std.get("balance")));
                ba.setDate((String) std.get("date"));
                ba.setId_no((String) std.get("id_no"));
                ba.setCareer((String) std.get("career"));
                ba.setAge(Integer.parseInt((String) std.get("age")));
                ba.setBirthdate((String) std.get("birthdate"));
                ba.setEmail((String) std.get("email"));
                ba.setGender((String) std.get("gender"));
                ba.setPhone_num((String) std.get("phone_num"));
                ba.setRevenue_month((String) std.get("revenue_month"));

            }
        }
        return ba;
        
//       
    }
}
