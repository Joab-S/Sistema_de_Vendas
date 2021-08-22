package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.ListaDeVendedores;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Models.Vendedor;
import java.util.ArrayList;
import java.util.ListIterator;
import javafx.collections.FXCollections;

/**
 * FXML Controller class
 *
 * @author samyra
 */
public class BuscarVendedoresAdminController implements Initializable{

    @FXML
    private TextField txtBusca;

    @FXML
    private Button button_pesquisar;

    @FXML
    private ToggleGroup pesquisa;

    @FXML
    private TableView<Vendedor> table;

    @FXML
    private TableColumn<Vendedor, Integer> coluna_ID;

    @FXML
    private TableColumn<Vendedor, String> colunaNomeVendedor;

    @FXML
    private TableColumn<Vendedor, String> colunaUltimaVenda;

    @FXML
    private TableColumn<Vendedor, Integer> colunaTotalVendas;

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

    ObservableList<Vendedor> list;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */ 
    

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
       System.out.println("Teste colunas");
       coluna_ID.setCellValueFactory(new PropertyValueFactory<Vendedor,Integer>("ID"));
       System.out.println("Teste colunas");
       colunaNomeVendedor.setCellValueFactory(new PropertyValueFactory<Vendedor,String>("nome"));
       colunaTotalVendas.setCellValueFactory(new PropertyValueFactory<Vendedor,Integer>("total_vendas"));
       colunaUltimaVenda.setCellValueFactory(new PropertyValueFactory<Vendedor,String>("ultima_venda")); 
        
       ArrayList<Vendedor> array_vendedores = new ArrayList<>(); 
       ListaDeVendedores x = ListaDeVendedores.getInstance(); 
       ListIterator<Vendedor> lista_vendedores =x.getListaDeVendedor().listIterator();
       while(lista_vendedores.hasNext()){
           array_vendedores.add(lista_vendedores.next());
       }
       list = FXCollections.observableArrayList(array_vendedores);
       

       table.setItems(list);
       
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */ 
    

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
    void pesquisar_onAction(ActionEvent event) {

    }
    
}