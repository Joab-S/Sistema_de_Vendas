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
import Dao.ListaDeVendedores;
import Models.Vendedor;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author joab
 */
public class LoginController implements Initializable {

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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    private boolean validateLogin(String user, String password, Vendedor vendedor){ 
        if (null != vendedor){
            return (vendedor.getNome().equals(user) && vendedor.getSenha().equals(password));  
        }
        return false;       
    }

    @FXML
    private void fazerLoginAction(ActionEvent event) {
        if(!enterUserName.getText().isBlank() && !enterUserPassword.getText().isBlank()) {
            ListaDeVendedores vendedores = ListaDeVendedores.getInstance();
            Vendedor vendedor = vendedores.getInstance().searchUserName(enterUserName.getText());
        
            if(validateLogin(enterUserName.getText(), enterUserPassword.getText(), vendedor)) {
                //Mantem a referencia para o vendedor logado
                //Verificar se está funcionando globalmente
                vendedores.setVendedorLogado(vendedor);
                if (vendedor.isAdmin()){
                    Main.mudar_tela("menu_administrador");
                }
                else{
                    Main.mudar_tela("menu_vendedor");
                }
                limparEntrada();
            }
            else{
                loginMessageLabel.setText("Credenciais Incorretas.");
            }
        }
        else{
            loginMessageLabel.setText("Informe as credenciais.");
        }

    }
    
    private void limparEntrada(){
        enterUserPassword.setText("");
        enterUserName.setText("");
        loginMessageLabel.setText("");
    }
}
