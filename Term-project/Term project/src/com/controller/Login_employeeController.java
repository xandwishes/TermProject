/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Search;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nann
 */
public class Login_employeeController implements Initializable {
    Search search = new Search();
    @FXML
    private TextField login_user_tf;
    @FXML
    private PasswordField login_pass_tf;
    @FXML
    private Button login_enter_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
        Search emp_acc = search.searchEmp(login_user_tf.getText(), login_pass_tf.getText());
        if(emp_acc != null){
            Stage stage = (Stage) login_user_tf.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/com/view/Home.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Try again");
            alert.showAndWait();
        }
    }
    
}
