package Controllers;
import Models.Produto;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public boolean cadastrar_produto(ActionEvent e){
        Produto p = new Produto();
        p.setDescricao(descricao.getText());
        p.setPreco(Double.parseDouble(preco_produto.getText()));
        p.setNome(nome_produto.getText());
        p.setTipo(tipo_produto.getText());
        p.setEstoque(Integer.parseInt(estoque.getText()));
        System.out.println(p.getNome());
        return true;
    }
    
    public void ja_cadastrado(ActionEvent e){
        Main.mudar_tela("cadastro_vendedor");
    }
    
}
