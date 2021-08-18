/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;

/**
 * FXML Controller class
 *
 * @author joab
 */
public class LoginController implements Initializable {

    @FXML
    private Button fazerCadastroButton;
    @FXML
    private PasswordField enterUserPassword;
    @FXML
    private TextField enterUserName;
    @FXML
    private Button fazerLoginButton;
    @FXML
    private Label loginMessageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fazerLoginAction(ActionEvent event) {
        loginMessageLabel.setText("Credenciais Incorretas");
    }

    @FXML
    private void fazerCadastroAction(ActionEvent event) {
        Main.mudar_tela("cadastro_vendedor");
    }
    
}
