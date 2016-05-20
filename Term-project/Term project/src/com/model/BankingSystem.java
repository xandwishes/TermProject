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
public interface BankingSystem {
    
    public void withdrawal(long acc_id, int amount);
    public void deposit(long acc_id, int amount);
    public void openAccount(String name, double balance,String email,
            String phone_num, String id_no, String address);
    
   
  //  public void closeaccount();
    
    
    
    
}
