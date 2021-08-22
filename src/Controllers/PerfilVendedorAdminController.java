package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.ListaDeVendedores;
import Models.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.image.ImageView;
import main.Main;

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
        
        Vendedor logado = ListaDeVendedores.getInstance().getVendedor_ref();
        
        if(logado != null){
            idEnter.setText(Integer.toString(logado.getID()));
            nomeEnter.setText(logado.getNome());
            emailEnter.setText(logado.getEmail());
            senhaEnter.setText(logado.getSenha());
        }
    }

    @FXML
    private void remover_vendedor_onAction(ActionEvent event) {
    }

    @FXML
    private void atualizar_dados_onAction(ActionEvent event) {
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
            Parent FXML_perfil_vendedor_admin = FXMLLoader.load(getClass().getResource("../Views/PerfilVendedorAdmin.fxml"));
            Scene perfil_vendedor_admin = new Scene(FXML_perfil_vendedor_admin);
            Main.setScene("perfil_vendedor_admin",perfil_vendedor_admin );
            Main.mudar_tela("perfil_vendedor_admin");
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
        Main.mudar_tela("menu_administrador");
    }
    
    @FXML
    private void menu_user(ActionEvent event) {
    }
    
}
