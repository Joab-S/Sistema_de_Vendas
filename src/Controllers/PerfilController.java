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
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import main.Main;
/**
 * FXML Controller class
 *
 * @author samyra
 */
public class PerfilController implements Initializable {

    @FXML
    private TextField perfil_id;

    @FXML
    private TextField perfil_nome;

    @FXML
    private TextField perfil_email;

    @FXML
    private TextField perfil_senha;

    @FXML
    private TextField perfil_campos_adicionais;
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
    private Button atualizarDadosButton;
    @FXML
    private TextField vendasText;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Vendedor logado = ListaDeVendedores.getInstance().getVendedorLogado();
        if(logado != null){
            System.out.println(logado.getNome());
            perfil_id.setText(Integer.toString(logado.getID()));
            perfil_nome.setText(logado.getNome());
            perfil_email.setText(logado.getEmail());
            perfil_senha.setText(logado.getSenha());
        }
        
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
            Parent FXML_perfil_vendedor = FXMLLoader.load(getClass().getResource("../Views/Perfil.fxml"));
            Scene perfil = new Scene(FXML_perfil_vendedor);
            Main.setScene("perfil",perfil );
            Main.mudar_tela("perfil");
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
        Main.mudar_tela("menu_vendedor");
    }
    
    @FXML
    private void menu_user(ActionEvent event) {
    }
}
