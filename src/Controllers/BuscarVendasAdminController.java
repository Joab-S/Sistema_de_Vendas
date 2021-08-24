package Controllers;

import Dao.ListaDePedidos;
import Dao.ListaDeVendedores;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.Main;
import Models.Pedido;
import Models.Vendedor;
import java.util.ArrayList;
import java.util.ListIterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cecilia
 */
public class BuscarVendasAdminController implements Initializable {

    @FXML
    private TextField txtBusca;
    @FXML
    private Button button_pesquisar;
    @FXML
    private ToggleGroup pesquisa;
    @FXML
    private TableView<Pedido> tableView;
    @FXML
    private TableColumn<Pedido, Integer> colunaID;
    @FXML
    private TableColumn<Pedido, String> colunaNomeVendedor;
    @FXML
    private TableColumn<Pedido, String> colunaData;
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
    
    private ObservableList<Pedido> listObservable;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        System.out.println("teste1");
        colunaNomeVendedor.setCellValueFactory(new PropertyValueFactory<>("nomeVendedor"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataEHora"));
        
        ArrayList<Pedido> array_pedidos = new ArrayList<>(); 
        ListaDePedidos lp = ListaDePedidos.getInstance();
        ListIterator<Pedido> listaPedidos = lp.getListaDePedidos().listIterator();
        while(listaPedidos.hasNext()){
            Pedido x = listaPedidos.next();
            System.out.println(x.getID());
            System.out.println(x.getVendedor().getNome());
            System.out.println(x.getDataEHora());
            array_pedidos.add(x);
        }
        listObservable = FXCollections.observableArrayList(array_pedidos);
        tableView.setItems(listObservable);
    }    

    @FXML
    private void pesquisar_onAction(ActionEvent event) {
        if(txtBusca.getText().strip().isBlank()){
            System.out.println("Pesquisa vazia");
        }else{
            RadioButton radio = (RadioButton) pesquisa.getSelectedToggle();
            if(radio.getText().compareTo("ID") == 0){
                int ID = 0;
                try{
                    ID = Integer.parseInt(txtBusca.getText());
                    ListaDePedidos pedidos = ListaDePedidos.getInstance();
                    Pedido ped = pedidos.buscar_pedido(ID);
                    Vendedor vend = ListaDeVendedores.getInstance().getVendedorLogado();
                    if(ped == null){
                        System.out.println("Sem pedidos");
                    }else{
                        pedidos.setRef_produto(ped);
                        if(vend.isAdmin()){
                            try{
                                Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
                                Scene menu_vendas = new Scene(FXML_menu_vendas);
                                Main.setScene("menu_vendas", menu_vendas);
                                Main.mudar_tela("menu_vendas");
                            }catch(IOException e){
                                System.out.println("Não foi possível carregar a tela");
                            }                            
                        }else{
                            try{
                                Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
                                Scene menu_vendas = new Scene(FXML_menu_vendas);
                                Main.setScene("menu_vendas", menu_vendas);
                                Main.mudar_tela("menu_vendas");
                            }catch(IOException e){
                                System.out.println("Não foi possível carregar a tela");
                            }                            
                        }
                    }
                }catch(NumberFormatException e){
                    System.out.println("Não foi possível carregar a tela");
                }
            }else if(radio.getText().equals("data")){

                System.out.println("teste2");

                try{
                    //data = String.valueOf(txtBusca.getText());
                    String data = null;
                    ListaDePedidos pedidos = ListaDePedidos.getInstance();
                    Vendedor vend = ListaDeVendedores.getInstance().getVendedorLogado();               
                    Pedido ped = pedidos.buscar_pedido(data);
                    if (ped == null){
                        System.out.println("Sem data");
                    }else{
                        pedidos.setRef_produto(ped);
                        if(vend.isAdmin()){
                            try{
                                Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
                                Scene menu_vendas = new Scene(FXML_menu_vendas);
                                Main.setScene("menu_vendas", menu_vendas);
                                Main.mudar_tela("menu_vendas");
                            }catch(IOException e){
                                System.out.println("Não foi possível carregar a tela");
                            }
                        }else{
                            Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
                            Scene menu_vendas = new Scene(FXML_menu_vendas);
                            Main.setScene("menu_vendas", menu_vendas);
                            Main.mudar_tela("menu_vendas");                            
                        }
                    }
                }catch(IOException e){
                    System.out.println("Não foi possível carregar a tela");
                }     
                
            }else{
                ListaDePedidos pedidos = ListaDePedidos.getInstance();
                Vendedor vend = ListaDeVendedores.getInstance().getVendedorLogado();               
                Pedido ped = pedidos.buscar_venda(vend);
                if(ped == null){
                    System.out.println("Não há vendas com esse vendedor");
                }else{
                    pedidos.setRef_produto(ped);
                    if(vend.isAdmin()){
                        try{
                            pedidos.setRef_produto(ped);
                            Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
                            Scene menu_vendas = new Scene(FXML_menu_vendas);
                            Main.setScene("menu_vendas", menu_vendas);
                            Main.mudar_tela("menu_vendas");                        
                        }catch(IOException e){
                            System.out.println("Não foi possível carregar a tela");
                        }                        
                    }else{
                        try{
                            pedidos.setRef_produto(ped);
                            Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
                            Scene menu_vendas = new Scene(FXML_menu_vendas);
                            Main.setScene("menu_vendas", menu_vendas);
                            Main.mudar_tela("menu_vendas");                        
                        }catch(IOException e){
                            System.out.println("Não foi possível carregar a tela");
                        }                        
                    }

                }                
            }
        }
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
    private void menu_carrinho(ActionEvent event) {
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
    private void menu_user_perfil(ActionEvent event) {
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
    private void menu_user(ActionEvent event) {
    }
    
}
