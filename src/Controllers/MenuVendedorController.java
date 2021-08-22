package Controllers;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ListaDeProdutos;
import Models.Produto;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import main.Main;

/**
 * FXML Controller class
 *
 * @author cecilia
 */
public class MenuVendedorController implements Initializable {

    @FXML
    private Button buscarVendasButton;
    @FXML
    private Button novaVendaButton;
    @FXML
    private TextField busca_vendedor;
    @FXML
    private Button pesquisar_vendedor;
    @FXML
    private RadioButton rb_id;
    @FXML
    private ToggleGroup selecao_pesquisa;
    @FXML
    private RadioButton rb_nome;
    @FXML
    private Label label_aviso;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buscar_vendas_onAction(ActionEvent event) {
    }

    @FXML
    private void nova_venda_onAction(ActionEvent event) {
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        if (busca_vendedor.getText().trim().isBlank()){
            //label_aviso.setText("Campo de Pesquisa Vazio.");
        }else{
            RadioButton radio = (RadioButton) selecao_pesquisa.getSelectedToggle();
            if (radio.getText().compareTo("ID")==0){
                int ID=0;
                try{
                    ID = Integer.parseInt(busca_vendedor.getText());
                    ListaDeProdutos p = ListaDeProdutos.getInstance();
                    Produto prod = p.buscar(ID);
                    if(prod == null){
                        //label_aviso.setText("Não foi encontrado um produto com esse ID.");
                    }else{
                       p.setRefProduto(prod);
                       try{
                          Parent FXML_menu_produto_vendedor = FXMLLoader.load(getClass().getResource("../Views/MenuDeProdutosVendedor.fxml"));
                          Scene menu_produtos_vendedor = new Scene(FXML_menu_produto_vendedor);
                          Main.setScene("menu_produtos_vendedor",menu_produtos_vendedor );
                          Main.mudar_tela("menu_produtos_vendedor");
                       }catch(IOException e){
                           System.out.println("Não foi possivel carregar a tela.");
                       }
                       
                    }
                }catch(NumberFormatException e){
                    //label_aviso.setText("Não foi passado um número para a pesquisa no ID.");
                }
            }
            else{
                ListaDeProdutos p=ListaDeProdutos.getInstance();
                Produto prod=p.buscar(busca_vendedor.getText());
                if(prod==null){
                    //label_aviso.setText("Não foi encontrado um produto com esse Nome");
                }
                else{
                    p.setRefProduto(prod);
                    try{
                        Parent FXML_menu_produtos_vendedor = FXMLLoader.load(getClass().getResource("../Views/MenuDeProdutosVendedor.fxml"));
                        Scene menu_produtos_vendedor = new Scene(FXML_menu_produtos_vendedor);
                        Main.setScene("menu_produtos_vendedor",menu_produtos_vendedor );
                        Main.mudar_tela("menu_produtos_vendedor");
                    }catch(IOException e){
                        System.out.println("Não foi possivel carregar a tela.");
                    }
                }
            }
        }
    }

    @FXML
    private void menu_home(ActionEvent event) {
    }

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
    
}
