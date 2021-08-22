package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ListaDeVendedores;
import java.io.IOException;
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
import main.Main;


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
    
    @FXML
    void menu_carrinho(ActionEvent event) {
        try{
            Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
            Scene menu_vendas = new Scene(FXML_menu_vendas);
            Main.setScene("menu_vendas", menu_vendas );
            Main.mudar_tela("menu_vendas");
            }catch(IOException e){
                System.out.println("Não foi possivel carregar a tela.");
            }
    }

    @FXML
    void menu_user_perfil(ActionEvent event) {
        try{
            ListaDeVendedores vendedor = ListaDeVendedores.getInstance();
            if (vendedor.getVendedorLogado().isAdmin()){
                Parent FXML_perfil_vendedor_admin = FXMLLoader.load(getClass().getResource("../Views/PerfilVendedorAdmin.fxml"));
                Scene perfil_vendedor_admin = new Scene(FXML_perfil_vendedor_admin);
                Main.setScene("perfil_vendedor_admin",perfil_vendedor_admin );
                Main.mudar_tela("perfil_vendedor_admin");
            } else{
                Parent FXML_perfil_vendedor = FXMLLoader.load(getClass().getResource("../Views/Perfil.fxml"));
                Scene perfil = new Scene(FXML_perfil_vendedor);
                Main.setScene("perfil",perfil );
                Main.mudar_tela("perfil");}
        }catch(IOException e){
            System.out.println("Não foi possivel carregar a tela.");
        }
    }

    @FXML
    private void menu_user_sair(ActionEvent event) {
        ListaDeVendedores vendedor = ListaDeVendedores.getInstance();
        vendedor.setVendedorLogado(null);
        Main.mudar_tela("login");
    }
    
    @FXML
    private void menu_home(ActionEvent event) {
        ListaDeVendedores vendedor = ListaDeVendedores.getInstance();
        if (vendedor.getVendedorLogado().isAdmin()){
            Main.mudar_tela("menu_administrador");
        }
        else{
            Main.mudar_tela("menu_vendedor");
        }
    }

    @FXML
    private void menu_user(ActionEvent event) {
    }
    
    /**
     * Initializes the controller class.
     * @throws java.lang.Exception
     */   
    
    
    /**
     * @param args the command line arguments
     */
}    
