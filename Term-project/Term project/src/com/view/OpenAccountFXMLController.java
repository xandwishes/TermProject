/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nann
 */
public class OpenAccountFXMLController implements Initializable {

    @FXML
    private Label new_acc_lb;
    @FXML
    private Font x1;
    @FXML
    private Label new_first_lb;
    @FXML
    private Label new_last_lb;
    @FXML
    private Label new_identify_lb;
    @FXML
    private Label new_phone_lb;
    @FXML
    private Label new_email_lb;
    @FXML
    private Label new_address_lb;
    @FXML
    private Label new_deposit_lb;
    @FXML
    private TextField new_first_tf;
    @FXML
    private TextField new_last_tf;
    @FXML
    private TextField new_identify_tf;
    @FXML
    private TextField new_phone_tf;
    @FXML
    private TextField new_email_tf;
    @FXML
    private TextField new_deposit_tf;
    @FXML
    private TextArea new_address_ta;
    @FXML
    private Button new_enter_btn;
    @FXML
    private Label new_acc_name_lb;
    @FXML
    private TextField new_acc_name_tf;
    @FXML
    private Button new_cancel_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void register(ActionEvent event) throws IOException {

        Stage stage = (Stage) new_enter_btn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    private void cancel(ActionEvent event) throws IOException {

        Stage stage = (Stage) new_cancel_btn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
}
