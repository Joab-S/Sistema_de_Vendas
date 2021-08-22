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
import javafx.scene.control.TextField;
import Dao.ListaDeProdutos;
import Dao.ListaDeVendedores;
import Models.Produto;
import UseCases.ManipularImagem;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
/**
 * FXML Controller class
 *
 * @author samyra
 */
public class MenuDeProdutosAdminController implements Initializable {
    
    @FXML
    private TextField prod_id;

    @FXML
    private TextField prod_nome;

    @FXML
    private TextField prod_tipo;

    @FXML
    private TextField prod_preco;

    @FXML
    private TextField prod_estoque;

    @FXML
    private TextField prod_descricao;
    
    @FXML
    private Label label_aviso_remocao;
    
    @FXML
    private ImageView imagemProduto;
    @FXML
    private Button remover_produto;
    @FXML
    private Button adicionar_carrinho;
    @FXML
    private Button atualizarProdutoButton;
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
    void adicionar_carrinho(ActionEvent event) {

    }
    
    @FXML
    void remover_produto(ActionEvent event) {
        
        ListaDeProdutos lista = ListaDeProdutos.getInstance();
        Produto prod_ref = lista.getRefProduto();
        if(lista.remover(prod_ref.getID())){
            Main.mudar_tela("menu_administrador");
        }else{
            label_aviso_remocao.setText("Não foi possivel remover o produto.");
        }
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Teste");
        Produto produto_ref = ListaDeProdutos.getInstance().getRefProduto();
       
        if(produto_ref !=null){
            
            prod_id.setText(Integer.toString(produto_ref.getID()));
            prod_nome.setText(produto_ref.getNome());
            prod_preco.setText(Double.toString(produto_ref.get_preco()));
            prod_estoque.setText(Integer.toString(produto_ref.getEstoque()));
            prod_descricao.setText(produto_ref.getDescricao());
            prod_tipo.setText(produto_ref.getTipo());
            
            Image imagem = ManipularImagem.exibiImagemLabel(produto_ref.getImagem());
            
            imagemProduto.setImage(imagem);
       }
       
    }    

    @FXML
    private void atualizar_produto_onAction(ActionEvent event) {
    }

    @FXML
    private void cancelar_onAction(ActionEvent event) {
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
