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
   
    Use use = new Use();
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
    @FXML
    private Button interest_btn;
    @FXML
    private Pane interest_pane;
    @FXML
    private Label interest_last_balance_lb;
    @FXML
    private Label interest_last_balance_result_lb;
    @FXML
    private Label interest_lb;
    @FXML
    private Label interest_result_lb;
    @FXML
    private Label balance_lb;
    @FXML
    private Label balance_result_lb;
    
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
    @FXML
    private void interest(ActionEvent event) {
        hideAll();
        interest_pane.setVisible(true);
        
        interest_last_balance_lb.setText("Last balance : ");
        interest_last_balance_result_lb.setText((search_balance_tf.getText()));
        interest_lb.setText("Interest: ");
        interest_result_lb.setText(Double.toString(Double.parseDouble(search_balance_tf.getText())*0.1/100));
        balance_lb.setText("Balance: ");
        balance_result_lb.setText(Double.toString(Double.parseDouble(search_balance_tf.getText())+ (Double.parseDouble(search_balance_tf.getText())*0.1/100)));
    
    }
    public void hideAll(){
        search_pane.setVisible(false);
        new_pane.setVisible(false);
        depo_pane.setVisible(false);
        trans_pane.setVisible(false);
        state_pane.setVisible(false);
        with_pane.setVisible(false);
        interest_pane.setVisible(false);
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
        if(!checkEmpty(acc_num_tf)){
           
            Search acc = searchCustomer(Long.parseLong(acc_num_tf.getText()));
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
                setDataToTable(Long.parseLong(acc_num_tf.getText()));
            } else {
                use.alert("Information Dialog", null, "Please try again", Alert.AlertType.ERROR);
                }
        }
    }
    
    @FXML
    public void searchEnter(ActionEvent event) {
        search_acc(event);
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
                use.alert("Success", null, "Success", Alert.AlertType.INFORMATION);
                depo_value_tf.clear();
                updateBalance();
                setDataToTable(Long.parseLong(acc_num_tf.getText()));
            } else {
            }
        } else {
                use.alert("Erroneous", null,"Please try again", Alert.AlertType.ERROR);
               }
        }
    }
    @FXML
    public void a(ActionEvent event) throws IOException{
     depo_enter(event);
    }

    @FXML
    private void with_enter(ActionEvent event) throws IOException {
        if(!checkEmpty(with_value_tf)){
        if (Double.parseDouble(with_value_tf.getText()) > 0 && Double.parseDouble(with_value_tf.getText()) <= Double.parseDouble(with_balance_tf.getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Withdrawal");
            alert.setHeaderText(null);
            alert.setContentText(acc_name_tf.getText() + " deposit: " + Integer.parseInt(with_value_tf.getText()) + "?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 Search acc = searchCustomer(Long.parseLong(acc_num_tf.getText()));
                 if(Integer.parseInt(with_value_tf.getText()) <= acc.getBalance()){
                    withdrawal(Long.parseLong(acc_num_tf.getText()), Integer.parseInt(with_value_tf.getText()));
                    use.alert("Success", null, "Success", Alert.AlertType.INFORMATION);
                    with_value_tf.clear();
                    updateBalance();
                    setDataToTable(Long.parseLong(acc_num_tf.getText()));
                 }else{
                    use.alert("Erroneous", null, "Not enough balance!", Alert.AlertType.WARNING);
                    }
            } 
        } else {
            use.alert("Erroneous", null,"Please try again", Alert.AlertType.ERROR);
           }
        }
    }
    @FXML
    public void withKeyboard(ActionEvent event) throws IOException {
        with_enter(event);
    }

    @FXML
    private void search_trans_acc(ActionEvent event) {
        if(!checkEmpty(trans_acc_num_tf)){
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
                use.alert("Transfer error", id, "Please try again", Alert.AlertType.ERROR);
                }
        }
    }
    @FXML
    public void searchTranKeyboard(ActionEvent event) {
        search_trans_acc(event);
    }
    

    @FXML
    private void trans_thrid_acc(ActionEvent event) throws IOException {
        //For acc-to-acc
        if(!checkEmpty(acc_num_tf) && !checkEmpty(trans_acc_num_tf)){
        if (Integer.parseInt(trans_value_tf.getText()) >= 0) {
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
                    use.alert("Transaction Error!", null, acc_name_tf.getText() + " account's overdrawn", Alert.AlertType.ERROR);
                    
                } else {  //Transaction correctly then go to home(clear everythings)
                    deposit(Long.parseLong(trans_acc_num_tf.getText()), Integer.parseInt(trans_value_tf.getText()));
                    withdrawal(Long.parseLong(acc_num_tf.getText()), Integer.parseInt(trans_value_tf.getText()));
                    updateBalance();
                    setDataToTable(Long.parseLong(acc_num_tf.getText()));
//                    Stage stage = (Stage) trans_enter_btn.getScene().getWindow();
//                    Parent root = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
//                    Scene scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
                    use.alert("Success", null, "Success", Alert.AlertType.INFORMATION);
                    
                    trans_value_tf.clear();
                    //menu_tab.getSelectionModel().select(with_tab);
                    return;
                }
            }

        }
        }else 
            if(checkEmpty(acc_num_tf) && !checkEmpty(trans_acc_num_tf)){

        //For one acc(deposit to acc)
                if (Integer.parseInt(trans_value_tf.getText()) >= 0 ){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Transaction Complete");
                    alert.setHeaderText(null);
                    alert.setContentText(" Transaction to " + trans_acc_name_tf.getText() + ": " + Integer.parseInt(trans_value_tf.getText()) + "?");
                    //if-else for popup check message "ok button" or "cancel button" transaction
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) { //Click "ok button" > will go back to home(clear everythings)
                        deposit(Long.parseLong(trans_acc_num_tf.getText()), Integer.parseInt(trans_value_tf.getText()));
                        updateBalance();
                        setDataToTable(Long.parseLong(acc_num_tf.getText()));
                        use.alert("Success", null, "Success", Alert.AlertType.INFORMATION);
                        trans_value_tf.clear();
                    }

                } else {  // transaction wrong (<=0)
                        use.alert("Transaction Error!", null, acc_name_tf.getText() + " account's overdrawn", Alert.AlertType.ERROR);
                }
        }
    }
    
    @FXML
    public void tranKeyboard(ActionEvent event) throws IOException {
        trans_thrid_acc(event);
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
        if(!checkEmpty(new_acc_name_tf) && !checkEmpty(new_fname_tf) && !checkEmpty(new_lname_tf) && !checkEmpty(new_depo_tf) && !checkEmpty(new_email_tf)
                        && !checkEmpty(new_phone_tf) && !checkEmpty(new_identity_num_tf)){
            BankAccount acc = new BankAccount();
            openAccount(new_acc_name_tf.getText(), new_fname_tf.getText(), new_lname_tf.getText(), Double.parseDouble(new_depo_tf.getText()), 
                    new_email_tf.getText(), new_phone_tf.getText(), new_identity_num_tf.getText(), new_address_tf.getText());

            use.alert("Succes", null, "Success! Your account is created", Alert.AlertType.INFORMATION);

            Stage stage = (Stage) trans_enter_btn.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/com/view/Home.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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
