package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.ListaDeVendedores;
import Models.Serializador;
import Models.Vendedor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

/**
 * FXML Controller class
 *
 * @author samyra
 */
public class CadastroVendedorController implements Initializable {
    
    @FXML
    private TextField nome_vendedor;
    @FXML
    private TextField email;
    @FXML
    private TextField senha;
    @FXML
    private Label label_aviso;
    @FXML
    private TextField senha_confirm;
    @FXML
    private Button cadastrar_vendedor;
    @FXML
    private Button cancelar;
    
    @FXML
    public boolean cadastrar_vendedor (ActionEvent e){
        label_aviso.setText("");
        if(nome_vendedor.getText().isBlank() || senha.getText().isBlank() || senha_confirm.getText().isBlank() || email.getText().isBlank()){
            label_aviso.setText("Preencha todos os campos.");
        }else{
            if((senha.getText().compareTo(senha_confirm.getText()))==0){
                ListaDeVendedores x = ListaDeVendedores.getInstance();
                if(x.searchUserName(nome_vendedor.getText().strip())!=null){
                    label_aviso.setText("Ja existe um vendedor com esse nome.");
                }else if(x.searchUserEmail(email.getText().strip())!=null){
                    label_aviso.setText("Ja existe um vendedor com esse email.");
                    System.out.println("Teste email");
                }else{
                Vendedor p = new Vendedor();
                p.setSenha(senha.getText());
                p.setEmail(email.getText().strip());
                p.setNome(nome_vendedor.getText().strip());
                p.setSenha(senha.getText());
                if(x.adicionar(p)){
                    System.out.println("Id"+p.getID());
                }else{
                    label_aviso.setText("Não foi possível cadastrar.");
                }
                limparEntradas();
                Serializador.salvar_dados(x.getListaDeVendedor(),"ListaVendedores.txt");
                Main.mudar_tela("menu_administrador");
                }
            }else{
                label_aviso.setText("O cadastro não foi bem sucedido.");
            }
        }
        
        return true;
    }
    
    @FXML
    public void cancelar(ActionEvent e ){
        limparEntradas();
        Main.mudar_tela("menu_administrador");
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void limparEntradas(){
        nome_vendedor.setText("");
        email.setText("");
        senha.setText("");
        senha_confirm.setText("");
        label_aviso.setText("");
        //imagem.setImage(null);
    
    }
}
