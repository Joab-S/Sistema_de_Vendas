package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ListaDePedidos;
import Dao.ListaDeProdutos;
import Dao.ListaDeVendedores;
import Models.ElementoPedido;
import Models.Pedido;
import Models.Produto;
import Models.Vendedor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
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
    private TextField produtoEnter;
    @FXML
    private TextField precoEnter;
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
    @FXML
    private Label precoTotalLabel;
    
    private ListaDePedidos pedidos = ListaDePedidos.getInstance();
    private Pedido pedido = new Pedido();
    private Vendedor vendedor_logado = ListaDeVendedores.getInstance().getVendedorLogado();
    private Produto prod = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    private void adicionar_produto_onAction(ActionEvent event) {
        //pedido.inserirProduto(produtoEnter.getText(), quantidadeEnter.getText());
        if (precoEnter.getText().isBlank() || quantidadeEnter.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Informe produto e quantidade válidos");
        }
        else {
            pedido.inserirProduto(prod, Integer.parseInt(quantidadeEnter.getText()));
        }
    }

    @FXML
    private void pesquisar_onAction(ActionEvent event) {
        ListaDeProdutos p = ListaDeProdutos.getInstance();
        if (idEnter.getText().isBlank() && produtoEnter.getText().isBlank())
        {
            precoEnter.setText("");
            JOptionPane.showMessageDialog(null, "Informe um ID válido ou o nome de um Produto");
        }
        else if (!idEnter.getText().isBlank()){
            int ID = Integer.parseInt(idEnter.getText());      
            prod = p.buscar(ID);
            produtoEnter.setText(prod.getNome());
        }
        else if (!produtoEnter.getText().isBlank()){
            prod = p.buscar(produtoEnter.getText());
            String id = Integer.toString(prod.getID());
            idEnter.setText(id);
        }
        if(prod == null){
            //label_aviso.setText("Não foi encontrado um produto com esse ID.");
            JOptionPane.showMessageDialog(null, "Não foi encontrado um produto com esse ID");
        }else{
            p.setRefProduto(prod);
            precoEnter.setText(Double.toString(prod.get_preco()));
        }
    }

    @FXML
    private void cancelar_onAction(ActionEvent event) {
        pedido.cancelar_pedido();
        if (vendedor_logado.isAdmin()){
            Main.mudar_tela("menu_administrador");
        } else {
            Main.mudar_tela("menu_vendedor");
        }
        limparEntrada();
    }

    @FXML
    private void como_pagar_onAction(ActionEvent event) {
        Main.mudar_tela("pagamento");
    }

    @FXML
    private void finalizar_venda_onAction(ActionEvent event) {
        
        pedido.finalizar_pedido(pedidos);
        if (vendedor_logado.isAdmin()){
            Main.mudar_tela("menu_administrador");
        } else {
            Main.mudar_tela("menu_vendedor");
        }
        limparEntrada();
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
            String caminho = "";
            if (vendedor.getVendedorLogado().isAdmin()){ caminho = "../Views/PerfilVendedorAdmin.fxml"; }
            else{ caminho = "../Views/Perfil.fxml"; }
            
            Parent FXML_perfil = FXMLLoader.load(getClass().getResource(caminho));
            Scene perfil = new Scene(FXML_perfil);
            Main.setScene("perfil", perfil);
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

    private void limparEntrada() {
        
    }
    
    /**
     * Initializes the controller class.
     * @throws java.lang.Exception
     */   
    
    
    /**
     * @param args the command line arguments
     */
}    
