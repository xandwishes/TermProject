/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 *
 * @author zxcvbnm
 */
public class Use {
    
    public void alert(String title,String header,String context,Alert.AlertType alertType){
              Alert alert1 =      alert1 = new Alert(alertType);
                    alert1.setTitle(title);
                    alert1.setHeaderText(header);
                    alert1.setContentText(context);
                    alert1.show();
                   
    }
    
    
//     public Alert alert(String title,String context,Alert.AlertType alertType){
//             Alert alert1 =       alert1 = new Alert(alertType);
//                    alert1.setTitle(title);
//                    alert1.setHeaderText(null);
//                    alert1.setContentText(context);
//                    alert1.show();
//                    return alert1;
//    }
    
}
