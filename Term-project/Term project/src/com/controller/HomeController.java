/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.BankAccount;
import com.model.Search;
import com.model.Statement;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nann
 */
public class HomeController extends BankAccount implements Initializable {
   
    @FXML
    private TextField trans_name_tf;
    @FXML
    private Button new_acc_btn;
    @FXML
    private Button search_acc_main_btn;
    @FXML
    private Button depo_btn;
    @FXML
    private Button with_btn;
    @FXML
    private Button trans_btn;
    @FXML
    private Button state_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private Pane search_acc;
    @FXML
    private Pane depo_pane;
    @FXML
    private Font x1;
    @FXML
    private TextField depo_value_tf;
    @FXML
    private TextField depo_balance_tf;
    @FXML
    private Button depo_enter_btn;
    @FXML
    private Font x2;
    @FXML
    private Pane with_pane;
    @FXML
    private TextField with_value_tf;
    @FXML
    private TextField with_balance_tf;
    @FXML
    private Button with_enter_btn;
    @FXML
    private Pane trans_pane;
    @FXML
    private TextField trans_acc_name_tf;
    @FXML
    private TextField trans_acc_num_tf;
    @FXML
    private TextField trans_value_tf;
    private TextField trans_acc_balance_tf;
    @FXML
    private Button trans_enter_btn;
    @FXML
    private Button trans_clear_btn;
    @FXML
    private Pane state_pane;
    @FXML
    private Pane new_pane;
    @FXML
    private Font x3;
    @FXML
    private TextField new_acc_name_tf;
    @FXML
    private TextField new_fname_tf;
    @FXML
    private TextField new_lname_tf;
    @FXML
    private TextField new_identity_num_tf;
    @FXML
    private TextField new_phone_tf;
    @FXML
    private TextField new_email_tf;
    @FXML
    private TextField new_depo_tf;
    @FXML
    private TextArea new_address_tf;
    @FXML
    private Button new_create_btn;
    @FXML
    private Button new_cancel_btn;
    @FXML
    private Pane search_pane;
    @FXML
    private Label search_acc_lb;
    @FXML
    private Label acc_num_lb;
    @FXML
    private Label acc_name_lb;
    @FXML
    private Label name_lb;
    @FXML
    private Label id_lb;
    @FXML
    private TextField acc_num_tf;
    @FXML
    private TextField acc_name_tf;
    @FXML
    private TextField name_tf;
    @FXML
    private TextField identity_tf;
    @FXML
    private Button search_btn;
    @FXML
    private Button clear_btn;
    @FXML
    private TableColumn<Statement, String> column_date;
    @FXML
    private TableColumn<Statement, String> column_code;
    @FXML
    private TableColumn<Statement, String> column_balance;
    @FXML
    private TableColumn<Statement, String> column_amount;
    @FXML
    private TableColumn<Statement, String> column_staffId;
    @FXML
    private TableView<Statement> statement_table;
    private ObservableList<Statement> statementData = FXCollections.observableArrayList();
    @FXML
    private TextField search_balance_tf;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        column_date.setCellValueFactory(new PropertyValueFactory<Statement, String>("column_date"));
        column_code.setCellValueFactory(new PropertyValueFactory<Statement, String>("column_code"));
        column_balance.setCellValueFactory(new PropertyValueFactory<Statement, String>("column_balance"));
        column_amount.setCellValueFactory(new PropertyValueFactory<Statement, String>("column_amount"));
        column_staffId.setCellValueFactory(new PropertyValueFactory<Statement, String>("column_staffId"));
    }
    private void setDataToTable(long id){
       List<Search> list = searchByID(id);
       for(Search b : list){
           statementData.add(new Statement(b.getDate(), b.getCode(), b.getBalance()+"", b.getAmount()+"", b.getStaff_id()));
       }
       statement_table.setItems(statementData);
    }
    
    @FXML
    private void search(ActionEvent event) {
        hideAll();
        search_pane.setVisible(true);
    }
    @FXML
    private void new_acc(ActionEvent event) {
        hideAll();
        new_pane.setVisible(true);
    }
    @FXML
    private void deposit(ActionEvent event) {
        hideAll();
        depo_pane.setVisible(true);
    }

    @FXML
    private void withdrawal(ActionEvent event) {
        hideAll();
        with_pane.setVisible(true);
    }

    @FXML
    private void transfer(ActionEvent event) {
        hideAll();
        trans_pane.setVisible(true);
    }

    @FXML
    private void statement(ActionEvent event) {
        hideAll();
        state_pane.setVisible(true);
    }
    public void hideAll(){
        search_pane.setVisible(false);
        new_pane.setVisible(false);
        depo_pane.setVisible(false);
        trans_pane.setVisible(false);
        state_pane.setVisible(false);
        with_pane.setVisible(false);
    }
    
    @FXML
    private void logout(ActionEvent event) throws IOException {
        Stage stage = (Stage) logout_btn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/view/Login_employee.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clear_search(ActionEvent event) {
        acc_num_tf.clear();
        acc_name_tf.clear();
        name_tf.clear();
        search_balance_tf.clear();
        identity_tf.clear();
        depo_value_tf.clear();
        with_value_tf.clear();
        with_balance_tf.clear();
        depo_balance_tf.clear();
        depo_value_tf.setDisable(true);
        with_value_tf.setDisable(true);
    }
    
    @FXML
    private void search_acc(ActionEvent event) {
        String id = acc_num_tf.getText();
        if (id == null || id.equals("")) {
            id = "0";
        }
        Search acc = searchCustomer(Long.parseLong(id));
        if (acc != null) {
            acc_name_tf.setText(acc.getAcc_name());
            name_tf.setText(acc.getAcc_name());
            identity_tf.setText(acc.getId_no());
            search_balance_tf.setText(Double.toString(acc.getBalance()));
            depo_balance_tf.setText(Double.toString(acc.getBalance()));
            with_balance_tf.setText(Double.toString(acc.getBalance()));
            depo_value_tf.setDisable(false);
            with_value_tf.setDisable(false);
            updateBalance();
            setDataToTable(Long.parseLong(id));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
    }
    
    private void updateBalance(){
         Search acc = searchCustomer(Long.parseLong(acc_num_tf.getText()));
         search_balance_tf.setText(Double.toString(acc.getBalance()));
         depo_balance_tf.setText(Double.toString(acc.getBalance()));
         with_balance_tf.setText(Double.toString(acc.getBalance()));
    }
    
    @FXML
    private void depo_enter(ActionEvent event) throws IOException {
        if(!checkEmpty(depo_value_tf)){
        if (Integer.parseInt(depo_value_tf.getText()) > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Deposit");
            alert.setHeaderText(null);
            alert.setContentText(acc_name_tf.getText() + " deposit: " + Integer.parseInt(depo_value_tf.getText()) + "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                deposit(Long.parseLong(acc_num_tf.getText()), Integer.parseInt(depo_value_tf.getText()));
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Success");
                    alert1.show();
                    depo_value_tf.clear();
                    updateBalance();
            } else {
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erroneous");
            alert.setHeaderText(null);
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
        }
    }

    @FXML
    private void with_enter(ActionEvent event) throws IOException {
        if (Integer.parseInt(with_value_tf.getText()) > 0 || !with_value_tf.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Withdrawal");
            alert.setHeaderText(null);
            alert.setContentText(acc_name_tf.getText() + " deposit: " + Integer.parseInt(with_value_tf.getText()) + "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 Search acc = searchCustomer(Long.parseLong(acc_num_tf.getText()));
                 if(Integer.parseInt(with_value_tf.getText()) < acc.getBalance()){
                    withdrawal(Long.parseLong(acc_num_tf.getText()), Integer.parseInt(with_value_tf.getText()));
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Success");
                    alert1.show();
                    with_value_tf.clear();
                    updateBalance();
                 }else{
                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
                    alert1.setTitle("Erroneous");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Not enough balance!");
                    alert1.show();
                 }
            } 
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erroneous");
            alert.setHeaderText(null);
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
    }

    @FXML
    private void search_trans_acc(ActionEvent event) {
        String trans_id = trans_acc_num_tf.getText();// Get id for trans
        String id = acc_num_tf.getText();//normal id

        if (trans_id == null || trans_id.equals("")) {
            trans_id = "0";
        }
        if (id == null || id.equals("")) {
            id = "0";
        }

        Search trans_acc = searchCustomer(Long.parseLong(trans_id));
        Search acc = searchCustomer(Long.parseLong(id));

        if (trans_acc != null && acc == null) {
            trans_acc_name_tf.setText(trans_acc.getAcc_name());
            trans_name_tf.setText(trans_acc.getAcc_name());
            trans_value_tf.setDisable(false);
        } else if (trans_acc != null && acc != null) {
            trans_acc_name_tf.setText(trans_acc.getAcc_name());
            trans_acc_name_tf.setText(trans_acc.getAcc_name());
            trans_value_tf.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Transfer error");
            alert.setHeaderText(null);
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
    
    }

    @FXML
    private void trans_thrid_acc(ActionEvent event) throws IOException {
        //For acc-to-acc
        if (Integer.parseInt(trans_value_tf.getText()) >= 0 && acc_num_tf.getText() != null && !acc_num_tf.getText().equals("") && trans_acc_num_tf.getText() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Transaction Complete");
            alert.setHeaderText(null);
            alert.setContentText(acc_name_tf.getText() + " transaction to " + trans_acc_name_tf.getText() + ": " + Integer.parseInt(trans_value_tf.getText()) + "?");
            //if-else for popup check message "ok button" or "cancel button" transaction
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {     //Click "ok button" > will go back to home(clear everythings)
                Search acc = searchCustomer(Long.parseLong(acc_num_tf.getText()));

                //For balance of "acc_num_tf"(acc give to trans_acc) 
                //Not enough to transaction to "trans_acc_num_tf"(trans_acc get from acc)
                //And will go back to edit "trans_value_tf"
                if (Integer.parseInt(trans_value_tf.getText()) > acc.getBalance()) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Transaction Error!");
                    alert1.setHeaderText(null);
                    alert1.setContentText(acc_name_tf.getText() + " account's overdrawn");
                    alert1.showAndWait();
                } else {  //Transaction correctly then go to home(clear everythings)
                    deposit(Long.parseLong(trans_acc_num_tf.getText()), Integer.parseInt(trans_value_tf.getText()));
                    withdrawal(Long.parseLong(acc_num_tf.getText()), Integer.parseInt(trans_value_tf.getText()));
//                    Stage stage = (Stage) trans_enter_btn.getScene().getWindow();
//                    Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
//                    Scene scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Success");
                    trans_value_tf.clear();
                    //menu_tab.getSelectionModel().select(with_tab);
                    return;
                }
            }

        }

        //For one acc(deposit to acc)
        if (Integer.parseInt(trans_value_tf.getText()) >= 0 && acc_num_tf.getText().equals("") && trans_acc_num_tf.getText() != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Transaction Complete");
            alert.setHeaderText(null);
            alert.setContentText(" Transaction to " + trans_acc_name_tf.getText() + ": " + Integer.parseInt(trans_value_tf.getText()) + "?");
            //if-else for popup check message "ok button" or "cancel button" transaction
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) { //Click "ok button" > will go back to home(clear everythings)
                deposit(Long.parseLong(trans_acc_num_tf.getText()), Integer.parseInt(trans_value_tf.getText()));
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Success");
                alert1.setHeaderText(null);
                alert1.setContentText("Success");
                trans_value_tf.clear();
            }

        } else {  // transaction wrong (<=0)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Transaction Error!");
            alert.setHeaderText(null);
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
    }

    @FXML
    private void clear_trans(ActionEvent event) {
        trans_name_tf.clear();
        trans_value_tf.clear();
        trans_acc_name_tf.clear();
        trans_acc_num_tf.clear();
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
        
        BankAccount acc = new BankAccount();
        openAccount(new_acc_name_tf.getText(), new_fname_tf.getText(), new_lname_tf.getText(), Double.parseDouble(new_depo_tf.getText()), 
                new_email_tf.getText(), new_phone_tf.getText(), new_identity_num_tf.getText(), new_address_tf.getText());
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
	alert1.setTitle("Succes");
	alert1.setHeaderText(null);
	alert1.setContentText("Success! Your account is created");
	alert1.show();
        
        Stage stage = (Stage) trans_enter_btn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/view/Home.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) new_cancel_btn.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/view/Home.fxml"));
        Scene scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
    }


    
}
