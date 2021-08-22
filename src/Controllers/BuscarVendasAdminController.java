package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author samyra
 */
public class BuscarVendasAdminController implements Initializable {

    @FXML
    private TextField txtBusca;
    @FXML
    private Button button_pesquisar;
    @FXML
    private ToggleGroup pesquisa;
    @FXML
    private Menu menuHome;
    @FXML
    private Menu menuCarrinho;
    @FXML
    private Menu menuUser;
    @FXML
    private MenuItem menuUserPerfil;
    @FXML
    private MenuItem menuUserSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void menu_home(ActionEvent event) {
    }

    @FXML
    private void menu_carrinho(ActionEvent event) {
    }

    @FXML
    private void menu_user_perfil(ActionEvent event) {
    }

    @FXML
    private void menu_user_sair(ActionEvent event) {
    }

    @FXML
    private void menu_user(ActionEvent event) {
    }
    
}
