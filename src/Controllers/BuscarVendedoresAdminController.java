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
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import javafx.collections.FXCollections;
import javafx.scene.control.RadioButton;
import main.Main;

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
        if ((txtBusca.getText().strip().isBlank())){
            //abel_aviso.setText("Campo de Pesquisa Vazio.");
        }else{
            RadioButton radio = (RadioButton) pesquisa.getSelectedToggle();
            if (radio.getText().compareTo("ID")==0){
                int ID=0;
                try{
                    ID = Integer.parseInt(txtBusca.getText());
                    ListaDeVendedores p = ListaDeVendedores.getInstance();
                    Vendedor vend = p.searchUserID(ID);
                    if(vend == null){
                        //label_aviso.setText("Não foi encontrado um produto com esse ID.");
                    }else{
                       p.setVendedor_ref(vend);
                       if(vend.isAdmin()){
                            try{
                                Parent FXML_perfil = FXMLLoader.load(getClass().getResource("../Views/Perfil.fxml"));
                                Scene perfil = new Scene(FXML_perfil);
                                Main.setScene("perfil",perfil );
                                //limparEntradas();
                                Main.mudar_tela("perfil");
                            }catch(IOException e){
                                System.out.println("Não foi possivel carregar a tela.");
                            }
                       }else{
                           try{
                                Parent FXML_perfil_vendedor_admin = FXMLLoader.load(getClass().getResource("../Views/PerfilVendedorAdmin.fxml"));
                                Scene perfil_vendedor_admin = new Scene(FXML_perfil_vendedor_admin);
                                Main.setScene("perfil_vendedor_admin",perfil_vendedor_admin );
                                //limparEntradas();
                                Main.mudar_tela("perfil_vendedor_admin");
                            }catch(IOException e){
                                System.out.println("Não foi possivel carregar a tela.");
                            }
                        }
                    }
                }catch(NumberFormatException e){
                    //label_aviso.setText("Não foi passado um número para a pesquisa no ID.");
                }
            }
            else{
                ListaDeVendedores p=ListaDeVendedores.getInstance();
                Vendedor vend=p.searchUserName(txtBusca.getText());
                if(vend==null){
                    //label_aviso.setText("Não foi encontrado um produto com esse Nome");
                }
                else{
                    p.setVendedor_ref(vend);
                    if(vend.isAdmin()){
                        try{
                            Parent FXML_perfil = FXMLLoader.load(getClass().getResource("../Views/Perfil.fxml"));
                            Scene perfil = new Scene(FXML_perfil);
                            Main.setScene("perfil",perfil );
                                //limparEntradas();
                            Main.mudar_tela("perfil");
                        }catch(IOException e){
                            System.out.println("Não foi possivel carregar a tela.");
                        }
                    }else{
                        try{
                            Parent FXML_perfil_vendedor_admin = FXMLLoader.load(getClass().getResource("../Views/PerfilVendedorAdmin.fxml"));
                            Scene perfil_vendedor_admin = new Scene(FXML_perfil_vendedor_admin);
                            Main.setScene("perfil_vendedor_admin",perfil_vendedor_admin );
                            //limparEntradas();
                            Main.mudar_tela("perfil_vendedor_admin");
                        }catch(IOException e){
                            System.out.println("Não foi possivel carregar a tela.");
                        }
                    }   
                }
            }
        }
    }
}
    
 