package Controllers;
import Models.Produto;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Dao.ListaDeProdutos;
import Models.Serializador;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;


/**
 * FXML Controller class
 *
 * @author samyra
 */
public class CadastroDeProdutoController implements Initializable {

    @FXML
    private TextField nome_produto;

    @FXML
    private TextField preco_produto;

    @FXML
    private TextField tipo_produto;

    @FXML
    private TextField estoque;

    @FXML
    private TextField descricao;
    
    @FXML
    private Button cadastrado;

    @FXML
    private Button cadastrar_produto;
    
    @FXML
    private Label label_aviso;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public boolean cadastrar_produto(ActionEvent e){
        
        if(nome_produto.getText().isBlank() || preco_produto.getText().isBlank() || tipo_produto.getText().isBlank() || estoque.getText().isBlank() || descricao.getText().isBlank()){
            label_aviso.setText("Preencha todos os campos.");        
        }else{
            Produto p = new Produto();
            p.setDescricao(descricao.getText());
            p.setPreco(Double.parseDouble(preco_produto.getText()));
            p.setNome(nome_produto.getText());
            p.setTipo(tipo_produto.getText());
            p.setEstoque(Integer.parseInt(estoque.getText()));
            
            //Executar essa parte apos criar a lista de pordutos no Dao
            ListaDeProdutos l = ListaDeProdutos.getInstance();
            if(l.adicionar(p)){
                System.out.println("ID "+p.getID());
                Serializador.salvar_dados(l.getListaDeProdutos(),"ListaProdutos.txt");
                Main.mudar_tela("menu_administrador");
            }else{
                label_aviso.setText("Produto não Cadastrado.");
            }
            
            
              
        }
        return true;
        
    }
    
    public void cancelar(ActionEvent e){
        Main.mudar_tela("menu_administrador");
    }
    
}
