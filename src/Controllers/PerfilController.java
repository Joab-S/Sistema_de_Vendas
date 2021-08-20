package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.ListaDeVendedores;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Models.Vendedor;
/**
 * FXML Controller class
 *
 * @author samyra
 */
public class PerfilController implements Initializable {

    @FXML
    private TextField perfil_id;

    @FXML
    private Button perfil_atualizar;

    @FXML
    private TextField perfil_nome;

    @FXML
    private TextField perfil_email;

    @FXML
    private TextField perfil_senha;

    @FXML
    private TextField perfil_campos_adicionais;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Vendedor logado = ListaDeVendedores.getInstance().getVendedorLogado();
        if(logado != null){
            System.out.println(logado.getNome());
            Integer id = (Integer)logado.getID();
            /*
            perfil_id.setText(id.toString());
            perfil_nome.setText(logado.getNome());
            perfil_email.setText(logado.getEmail());
            perfil_senha.setText(logado.getSenha());
            */
        }
        
    }    
    
}
