package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Dao.ListaDeProdutos;
import Models.Produto;
/**
 * FXML Controller class
 *
 * @author samyra
 */
public class MenuDeProdutosAdminController implements Initializable {
    
    @FXML
    private TextField prod_id;

    @FXML
    private TextField prod_nome;

    @FXML
    private TextField prod_tipo;

    @FXML
    private TextField prod_preco;

    @FXML
    private TextField prod_estoque;

    @FXML
    private TextField prod_descricao;
    
   
    @FXML
    void adicionar_carrinho(ActionEvent event) {

    }
    
    @FXML
    void remover_produto(ActionEvent event) {

    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Teste");
        Produto produto_ref = ListaDeProdutos.getInstance().getRefProduto();
       
        if(produto_ref !=null){
            
            prod_id.setText(Integer.toString(produto_ref.getID()));
            prod_nome.setText(produto_ref.getNome());
            prod_preco.setText(Double.toString(produto_ref.get_preco()));
            prod_estoque.setText(Integer.toString(produto_ref.getEstoque()));
            prod_descricao.setText(produto_ref.getDescricao());
            prod_tipo.setText(produto_ref.getTipo());
       }
       
    }    
    
    
}
