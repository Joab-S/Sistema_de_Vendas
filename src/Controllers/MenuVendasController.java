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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML
    private TableView<ElementoPedido> carrinhoTable;
    @FXML
    private TableColumn<Produto, Integer> colunaID;
    @FXML
    private TableColumn<Produto, String> colunaProduto;
    @FXML
    private TableColumn<ElementoPedido, Integer> colunaQuantidade;
    @FXML
    private TableColumn<ElementoPedido, Double> colunaPreco;
    @FXML
    private TableColumn<ElementoPedido, Double> colunaSubtotal;
    
    
    private ListaDePedidos pedidos;
    private Pedido pedido;
    private Vendedor logado;
    private Produto prod;
    
    public MenuVendasController() {
        System.out.println("first");
        pedidos = ListaDePedidos.getInstance();
        pedido = new Pedido();
        logado = ListaDeVendedores.getInstance().getVendedorLogado();
        prod = null;
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void adicionar_produto_onAction(ActionEvent event) {
        if (idEnter.getText().isBlank() || produtoEnter.getText().isBlank() || precoEnter.getText().isBlank() || quantidadeEnter.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Não deixe campos vazios");
        }
        else 
        {
            
            if (pedido.inserirProduto(prod, Integer.parseInt(quantidadeEnter.getText()))) 
            {
            
            //colunaID.setCellValueFactory(new PropertyValueFactory<Produto,Integer>("ID"));
            //colunaProduto.setCellValueFactory(new PropertyValueFactory<Produto,String>("nome"));
            colunaQuantidade.setCellValueFactory(new PropertyValueFactory<ElementoPedido,Integer>("quant"));
            //colunaPreco.setCellValueFactory(new PropertyValueFactory<ElementoPedido, Double>("preco"));
            colunaSubtotal.setCellValueFactory(new PropertyValueFactory<ElementoPedido, Double>("total"));
        
        
            System.out.println("PRINTS");
            System.out.println(pedido);
            System.out.println(logado);
            System.out.println(prod);
            System.out.println(pedido);
            System.out.println("FIM");
        
            ObservableList<ElementoPedido> list;
        
            LinkedList <ElementoPedido>  p = pedido.getListaProdutos();
            System.out.println(p);
            ArrayList<ElementoPedido> array_pedidos = new ArrayList<>(); 
            ListIterator<ElementoPedido> lista_pedidos =p.listIterator();
            if (lista_pedidos != null)
            {
                while(lista_pedidos.hasNext())
                {
                    array_pedidos.add(lista_pedidos.next());
                }
                list = FXCollections.observableArrayList(array_pedidos);
       
                carrinhoTable.setItems(list);
                precoTotalLabel.setText(Double.toString(pedido.precoTotal()));
            }
            else { System.out.println("lista de pedidos nula"); }
            }
            else { System.out.println("Não é possível adicionar este produto"); }
        }
    }

    @FXML
    private void pesquisar_onAction(ActionEvent event) {
        ListaDeProdutos p = ListaDeProdutos.getInstance();
        if (idEnter.getText().isBlank() && produtoEnter.getText().isBlank())
        {
            precoEnter.setText("");           
            System.out.println("Informe um ID válido ou o nome de um Produto");
        }
        else if (!idEnter.getText().isBlank()){
            int ID = Integer.parseInt(idEnter.getText());      
            prod = p.buscar(ID);
            if(prod == null){
                System.out.println("Este produto não existe no sistema");
            }
            else{
            produtoEnter.setText(prod.getNome());
            }
        }
        else if (!produtoEnter.getText().isBlank()){
            prod = p.buscar(produtoEnter.getText());
            if(prod == null){
                System.out.println("Este produto não existe no sistema");
            }
            else{
            idEnter.setText(Integer.toString(prod.getID()));
            }
        }
        if(prod == null){
            //label_aviso.setText("Não foi encontrado um produto com esse ID.");
            System.out.println("Não foi encontrado um produto com esse ID");
        }else{
            p.setRefProduto(prod);
            precoEnter.setText(Double.toString(prod.get_preco()));
        }
    }

    @FXML
    private void cancelar_onAction(ActionEvent event) {
        System.out.println(pedido);
        pedido.cancelar_pedido();
        if (logado.isAdmin()){
            try{
                Parent tela = FXMLLoader.load(getClass().getResource("../Views/MenuAdministrador.fxml"));
                Scene menu = new Scene(tela);
                Main.setScene("menu_admin", menu);
                    Main.mudar_tela("menu_administrador");
                }catch(IOException e){
                    System.out.println("Não foi possivel carregar a tela.");
                }
            
        } else {
            try{
            Parent tela = FXMLLoader.load(getClass().getResource("../Views/MenuVendedor.fxml"));
                Scene menu = new Scene(tela);
                Main.setScene("menu_vendedor", menu);
                    Main.mudar_tela("menu_vendedor");
                }catch(IOException e){
                    System.out.println("Não foi possivel carregar a tela.");
                }
        }
        System.out.println("Cancelado");
        limparEntrada();
    }

    @FXML
    private void como_pagar_onAction(ActionEvent event) {
        Main.mudar_tela("pagamento");
    }

    @FXML
    private void finalizar_venda_onAction(ActionEvent event) {
        pedido.setVendedor(logado);
        pedido.finalizar_pedido(pedidos);
        if (logado.isAdmin()){
            Main.mudar_tela("menu_administrador");
        } else {
            Main.mudar_tela("menu_vendedor");
        }
        System.out.println("Finalizado");
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
