
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.model.BankAccount;
import com.model.BankOfficer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Nann
 */
public class Login_empController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField username_tf;
    @FXML
    private Label login_lb;
    @FXML
    private PasswordField password_tf;
    @FXML
    private Button login_btn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void login(ActionEvent event) throws IOException {
       //Go to another page
        BankOfficer emp_acc = BankOfficer.searchEmp(username_tf.getText(), password_tf.getText());
        
        if(emp_acc != null){
            Stage stage = (Stage) username_tf.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Try again");
            alert.showAndWait();
        }
    }
    
}
