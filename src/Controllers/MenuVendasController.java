package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author samyra
 */
public class MenuVendasController implements Initializable {

    @FXML
    private Menu menuCarrinho;
    @FXML
    private Menu menuUser;
    @FXML
    private MenuItem menuUserPerfil;
    @FXML
    private MenuItem menuUserSair;
    @FXML
    private Menu menuHome;
    @FXML
    private TableView<?> produtosAddCarrinhoTV;
    @FXML
    private TextField idEnter;
    @FXML
    private TextField Enter;
    @FXML
    private TextField preco;
    @FXML
    private Button adicionarProdutoButton;
    @FXML
    private TextField quantidadeEnter;
    @FXML
    private Button pesquisarButton;
    @FXML
    private Button cancelarButton;
    @FXML
    private Button selecionarPagamentoButton;
    @FXML
    private Button finalizarButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
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
    private void menu_home(ActionEvent event) {
    }

    @FXML
    private void adicionar_produto_onAction(ActionEvent event) {
    }

    @FXML
    private void pesquisar_onAction(ActionEvent event) {
    }

    @FXML
    private void cancelar_onAction(ActionEvent event) {
    }

    @FXML
    private void como_pagar_onAction(ActionEvent event) {
    }

    @FXML
    private void finalizar_venda_onAction(ActionEvent event) {
    }

    /**
     * Initializes the controller class.
     * @throws java.lang.Exception
     */   
    
    
    /**
     * @param args the command line arguments
     */
}    
