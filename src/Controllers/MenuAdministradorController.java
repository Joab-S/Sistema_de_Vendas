package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author samyra
 */
public class MenuAdministradorController implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    @FXML
    private Menu menu_carrinho;

    @FXML
    private Menu menu_usuario;

    @FXML
    private Menu botao_home;

    @FXML
    void ir_carrinho(ActionEvent event) {
        //Main.mudartela("menu_vendas");  
    }

    @FXML
    void ir_usuario(ActionEvent event) {
        System.out.println("TEste");
        Main.mudar_tela("perfil");  
    }
    /**
     * Initializes the controller class.
     * @throws java.lang.Exception
     */ 
    
    
    /**
     * @param args the command line arguments
     */
    

    
}
