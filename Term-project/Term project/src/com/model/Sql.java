/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;


/**
 *
 * @author zxcvbnm
 */
public class Sql extends BankFunction{
    
   public String sqlSearchEmp(String user, String pass){
       return "SELECT * FROM BANK_OFFICER WHERE USERNAME = ('"+user+"') AND PASSWORD = ('"+pass+"')";
   }
   
   public String sqlsearchTransac(long acc_id){
    return "SELECT * FROM BANK_TRANSACTION b JOIN BANK_ACCOUNT ba ON ba.acc_id = b.acc_id WHERE ba.acc_id =  ('"+acc_id+"')";
   }
   
   public String sqlSearchCustomer(long acc_id){
       return "SELECT * FROM BANK_ACCOUNT WHERE acc_id = ('" + acc_id + "')";
   }
   
   public String sqlcreateAccount(String name, double balance,String email,String phone_num, String id_no, String address){
       return "INSERT INTO "
                + "BANK_ACCOUNT(acc_id,acc_name,balance,date,gender,email,phone_num,id_no,revenue_month,career,age,birthdate,address)"
                + "VALUES ('" + System.currentTimeMillis() + "','" + name + "','" + balance + "','" + new java.sql.Date(System.currentTimeMillis())
                + "','" + email + "','" + phone_num + "','" + id_no + "','" + address + "')";
   }
   
   public String sqlDeposit(long acc_id, int amount){
       return "UPDATE BANK_ACCOUNT SET balance = (balance + " + amount + ") WHERE acc_id = ('" + acc_id + "')";
   }
   
   
   public String sqlWithdraw(long acc_id, int amount){
       return  "UPDATE BANK_ACCOUNT SET balance = (balance -" + amount + ")WHERE acc_id = ('" + acc_id + "')";
   }
   
   
   public String sqlUpdateTransac(long acc_id, int amount,String code){
       if(code.toLowerCase().matches("wid")||code.toLowerCase().matches("wit")){
       return "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) +
                    "'," + amount + "," + acc_id + ","+(getBalanceNow(acc_id)-amount)+
        ")";
       }else
           if(code.toLowerCase().matches("dep")){
               return "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) + "'," + amount + "," + acc_id + ","+(amount+getBalanceNow(acc_id))+
        ")";
           }
       else
               if(code.toLowerCase().matches("opa")||code.toLowerCase().matches("ope")){
                return "INSERT INTO BANK_TRANSACTION (code,staff_id,date,amount,acc_id,balance)"
                + " VALUES ('" + code + "','1234','" + new java.sql.Date(System.currentTimeMillis()) + "'," + amount + "," + System.currentTimeMillis() + ","+amount+
        ")";
               }
       return "Failed";
   }
   
   
   
   
   
}
