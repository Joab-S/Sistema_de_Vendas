package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Dao.ListaDeProdutos;
import Models.Produto;
import UseCases.ManipularImagem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author joab
 */
public class MenuDeProdutosVendedorController implements Initializable {

    @FXML
    private TextField idEnter;
    @FXML
    private TextField nomeEnter;
    @FXML
    private TextField tipoEnter;
    @FXML
    private TextField precoEnter;
    @FXML
    private TextField estoqueEnter;
    @FXML
    private TextField descricaoEnter;
    @FXML
    private ImageView imagemProduto;
    @FXML
    private Button adicionarCarrinhoButton;
    @FXML
    private Button cancelarButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Produto produto_ref = ListaDeProdutos.getInstance().getRefProduto();
       
        if(produto_ref !=null){
            
            idEnter.setText(Integer.toString(produto_ref.getID()));
            nomeEnter.setText(produto_ref.getNome());
            precoEnter.setText(Double.toString(produto_ref.get_preco()));
            estoqueEnter.setText(Integer.toString(produto_ref.getEstoque()));
            descricaoEnter.setText(produto_ref.getDescricao());
            tipoEnter.setText(produto_ref.getTipo());
            
            Image imagem = ManipularImagem.exibiImagemLabel(produto_ref.getImagem());
            
            imagemProduto.setImage(imagem);
       }
    }

    @FXML
    private void adicionar_carrinho_onAction(ActionEvent event) {
    }

    @FXML
    private void cancelar_onAction(ActionEvent event) {
    }
}
