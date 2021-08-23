package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.ListaDeVendedores;
import Models.Serializador;
import Models.Vendedor;
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
import javafx.scene.image.ImageView;
import main.Main;

/**
 * FXML Controller class
 *
 * @author samyra
 */
public class PerfilVendedorAdminController implements Initializable {

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
    @FXML
    private Button removerVendedorButton;
    @FXML
    private TextField idEnter;
    @FXML
    private TextField nomeEnter;
    @FXML
    private TextField emailEnter;
    @FXML
    private TextField vendasEnter;
    @FXML
    private TextField senhaEnter;
    @FXML
    private Button atualizarDadosButton;
    @FXML
    private ImageView imagemAdmin;
    @FXML
    private TextField CampoAdicionalEnter;
    @FXML
    private Label LabelAvisoNome;
    @FXML
    private Label LabelAvisoEmail;
    @FXML
    private Label labelAvisoBranco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Vendedor logado = ListaDeVendedores.getInstance().getVendedor_ref();
        
        if(logado != null){
            idEnter.setText(Integer.toString(logado.getID()));
            nomeEnter.setText(logado.getNome());
            emailEnter.setText(logado.getEmail());
            senhaEnter.setText(logado.getSenha());
            CampoAdicionalEnter.setText(logado.getDescricao());
            vendasEnter.setText(Integer.toString(logado.getTotal_vendas()));
        }
    }

    @FXML
    private void remover_vendedor_onAction(ActionEvent event) {
        ListaDeVendedores vendedores = ListaDeVendedores.getInstance();
        if(!(vendedores.getVendedor_ref().isAdmin())){
            if(vendedores.remover(vendedores.getVendedor_ref())){
                System.out.println("Foi removido");
                Serializador.salvar_dados(vendedores.getListaDeVendedor(),"ListaVendedores.txt");
                Main.mudar_tela("menu_administrador");
            }else{
                labelAvisoBranco.setText("Não foi possivel remover o vendedor.");
            }
        }
                
    }

    @FXML
    private void atualizar_dados_onAction(ActionEvent event) {
        this.limparLabels();
        if(nomeEnter.getText().isBlank() || emailEnter.getText().isBlank()|| senhaEnter.getText().isBlank()){
           labelAvisoBranco.setText("Há campos em branco.");
        }else{
            ListaDeVendedores vendedores = ListaDeVendedores.getInstance();
            if(vendedores.searchUserName(nomeEnter.getText())==null || vendedores.searchUserName(nomeEnter.getText())==vendedores.getVendedor_ref() ){
                if(vendedores.searchUserName(emailEnter.getText())==null || vendedores.searchUserName(emailEnter.getText())==vendedores.getVendedor_ref()){
                    Vendedor vendedor_atualizado = vendedores.getVendedor_ref();
                    vendedor_atualizado.setNome(nomeEnter.getText());
                    vendedor_atualizado.setEmail(emailEnter.getText());
                    vendedor_atualizado.setSenha(senhaEnter.getText());
                    vendedor_atualizado.setDescricao(CampoAdicionalEnter.getText());
                    this.limparLabels();
                    Main.mudar_tela("menu_administrador");
                }else{
                    LabelAvisoEmail.setText("Já há vendedor com esse email.");
                }
                
            }else{
                LabelAvisoNome.setText("Já há vendedor com esse nome.");
            }
        }
    
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
    
    public void limparLabels(){
        LabelAvisoNome.setText("");
        LabelAvisoEmail.setText("");
        labelAvisoBranco.setText("");
    }
    
}
