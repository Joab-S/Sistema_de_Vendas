package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ListaDeProdutos;
import main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import Models.Produto;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author samyra
 */
public class MenuAdministradorController implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    @FXML
    private Menu menu_carrinho;

    @FXML
    private Menu menu_usuario;

    @FXML
    private Menu botao_home;

    @FXML
    private TextField busca_admin;

    @FXML
    private ToggleGroup selecao_pesquisa;

    @FXML
    private Label label_aviso;


    @FXML
    void pesquisar(ActionEvent event) {
        if (busca_admin.getText().trim().isBlank()){
            label_aviso.setText("Campo de Pesquisa Vazio.");
        }else{
            RadioButton radio = (RadioButton) selecao_pesquisa.getSelectedToggle();
            if (radio.getText().compareTo("ID")==0){
                int ID=0;
                try{
                    ID = Integer.parseInt(busca_admin.getText());
                    ListaDeProdutos p = ListaDeProdutos.getInstance();
                    Produto prod = p.buscar(ID);
                    if(prod == null){
                        label_aviso.setText("Não foi encontrado um produto com esse ID.");
                    }else{
                       p.setRefProduto(prod);
                       try{
                          //Gambiarra de ultima hora
                          Parent FXML_menu_produtos_admin = FXMLLoader.load(getClass().getResource("../Views/MenuDeProdutosAdmin.fxml"));
                          Scene menu_produtos_admin = new Scene(FXML_menu_produtos_admin);
                          Main.setScene("menu_produtos_admin",menu_produtos_admin );
                          Main.mudar_tela("menu_produtos_admin");
                       }catch(IOException e){
                           System.out.println("Não foi possivel carregar a tela.");
                       }
                       
                    }
                }catch(NumberFormatException e){
                    label_aviso.setText("Não foi passado um número para a pesquisa no ID.");
                }
            }
            else{
                ListaDeProdutos p=ListaDeProdutos.getInstance();
                Produto prod=p.buscar(busca_admin.getText());
                if(prod==null){
                    label_aviso.setText("Não foi encontrado um produto com esse Nome");
                }
                else{
                    p.setRefProduto(prod);
                    try{
                        //Gambiarra de ultima hora
                        Parent FXML_menu_produtos_admin = FXMLLoader.load(getClass().getResource("../Views/MenuDeProdutosAdmin.fxml"));
                        Scene menu_produtos_admin = new Scene(FXML_menu_produtos_admin);
                        Main.setScene("menu_produtos_admin",menu_produtos_admin );
                        Main.mudar_tela("menu_produtos_admin");
                    }catch(IOException e){
                        System.out.println("Não foi possivel carregar a tela.");
                    }
                }
            }
        }
    }

    @FXML
    void ir_carrinho(ActionEvent event) {
        //Main.mudartela("menu_vendas");  
    }

    @FXML
    void ir_usuario(ActionEvent event) {
        try{
            //Gambiarra de ultima hora
            Parent FXML_perfil_vendedor_admin = FXMLLoader.load(getClass().getResource("../Views/PerfilVendedorAdmin.fxml"));
            Scene perfil_vendedor_admin = new Scene(FXML_perfil_vendedor_admin);
            Main.setScene("perfil_vendedor_admin",perfil_vendedor_admin );
            Main.mudar_tela("perfil_vendedor_admin");
            }catch(IOException e){
                System.out.println("Não foi possivel carregar a tela.");
            }
    }
    
    
    @FXML
    void ir_vend_cadastro(ActionEvent event) {
        Main.mudar_tela("cadastro_vendedor");
    }
    
    @FXML
    void ir_prod_cad(ActionEvent event) {
        Main.mudar_tela("cadastro_produto");
    }
    /**
     * Initializes the controller class.
     * @throws java.lang.Exception
     */ 
    
    
    /**
     * @param args the command line arguments
     */
    

    
}
