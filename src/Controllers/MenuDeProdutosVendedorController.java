package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.ListaDeProdutos;
import Dao.ListaDeVendedores;
import Models.Produto;
import UseCases.ManipularImagem;
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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;

/**
 * FXML Controller class
 *
 * @author joab
 */
public class MenuDeProdutosVendedorController implements Initializable {

    @FXML
    private TextField idEnter;
    @FXML
    private TextField nomeEnter;
    @FXML
    private TextField tipoEnter;
    @FXML
    private TextField precoEnter;
    @FXML
    private TextField estoqueEnter;
    @FXML
    private ImageView imagemProduto;
    @FXML
    private Button adicionarCarrinhoButton;
    @FXML
    private Button cancelarButton;
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
    private TextField descricaoEnter;
    @FXML
    private Label descricaoLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Produto produto_ref = ListaDeProdutos.getInstance().getRefProduto();
       
        if(produto_ref !=null){
            
            idEnter.setText(Integer.toString(produto_ref.getID()));
            nomeEnter.setText(produto_ref.getNome());
            precoEnter.setText(Double.toString(produto_ref.get_preco()));
            estoqueEnter.setText(Integer.toString(produto_ref.getEstoque()));
            descricaoEnter.setText(produto_ref.getDescricao());
            tipoEnter.setText(produto_ref.getTipo());
            
            Image imagem = ManipularImagem.exibiImagemLabel(produto_ref.getImagem());
            
            imagemProduto.setImage(imagem);
       }
    }

    @FXML
    private void adicionar_carrinho_onAction(ActionEvent event) {
    }

    @FXML
    private void cancelar_onAction(ActionEvent event) {
    }

    @FXML
    private void menu_user(ActionEvent event) {
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
    
}
