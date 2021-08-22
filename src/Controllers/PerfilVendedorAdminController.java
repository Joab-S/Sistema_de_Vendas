package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author samyra
 */
public class PerfilVendedorAdminController implements Initializable {

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
    @FXML
    private TextField idEnter;
    @FXML
    private Button removerVendedorButton;
    @FXML
    private TextField nomeEnter;
    @FXML
    private TextField emailEnter;
    @FXML
    private TextField vendasEnter;
    @FXML
    private TextField senhaEnter;
    @FXML
    private Button atualizarDadosButton;
    @FXML
    private ImageView imagemAdmin;
    @FXML
    private TextField CampoAdicionalEnter;

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

    @FXML
    private void remover_vendedor_onAction(ActionEvent event) {
    }

    @FXML
    private void atualizar_dados_onAction(ActionEvent event) {
    }
    
}
