package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Models.Vendedor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.Main;

/**
 * FXML Controller class
 *
 * @author samyra
 */
public class CadastroVendedorController implements Initializable {
    
    @FXML
    private TextField nome_vendedor;

    @FXML
    private TextField usuario;

    @FXML
    private TextField email;

    @FXML
    private TextField senha;

    @FXML
    private Button cadastrado;
    
    @FXML
    private TextField senha_confirm;

    @FXML
    private Button cadastrar_vendedor;
    
    public boolean cadastrar_vendedor (ActionEvent e){
        Vendedor p = new Vendedor();
        if((senha.getText().compareTo(senha_confirm.getText()))==0){
            p.setSenha(senha.getText());
            p.setEmail(email.getText().strip());
            p.setNome(nome_vendedor.getText().strip());
            p.setSenha(senha.getText());
        
        }else{
            //Label avisando que o cadastro não foi bem sucedido
        }
        
        
        
        return true;
    }
    
    public void ja_cadastrado(ActionEvent e ){
        Main.mudar_tela("pagamento");
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
