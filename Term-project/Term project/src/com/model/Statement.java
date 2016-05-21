/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Nann
 */
public class Statement {

    private final SimpleStringProperty column_date;
    private final SimpleStringProperty column_code;
    private final SimpleStringProperty column_balance;
    private final SimpleStringProperty column_amount;
    private final SimpleStringProperty column_staffId;

    public Statement(String column_date, String column_code, String column_balance, String column_amount, String column_staffId) {
        this.column_date = new SimpleStringProperty(column_date);
        this.column_code = new SimpleStringProperty(column_code);
        this.column_balance = new SimpleStringProperty(column_balance);
        this.column_amount = new SimpleStringProperty(column_amount);
        this.column_staffId = new SimpleStringProperty(column_staffId);
    }

    public String getColumn_date() {
        return column_date.get();
    }

    public String getColumn_code() {
        return column_code.get();
    }

    public String getColumn_balance() {
        return column_balance.get();
    }

    public String getColumn_amount() {
        return column_amount.get();
    }

    public String getColumn_staffId() {
        return column_staffId.get();
    }
    
    
    
    

}
