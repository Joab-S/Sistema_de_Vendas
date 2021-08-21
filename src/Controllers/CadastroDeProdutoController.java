package Controllers;

import Models.Produto;
import Dao.ListaDeProdutos;
import Models.Serializador;
import UseCases.EnviarImagem;
import UseCases.ManipularImagem;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;

/**
 * FXML Controller class
 *
 * @author joab
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
    private Button cadastrar_produto;
    @FXML
    private Label label_aviso;
    @FXML
    private Button cancelar;
    @FXML
    private Button escolher_imagem = null;
    @FXML
    private ImageView imagem;
    
    EnviarImagem imagemClass = new EnviarImagem();
    BufferedImage imagem_escolhida;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public boolean cadastrar_produto(ActionEvent e){
        
        label_aviso.setText("");  
        if(nome_produto.getText().isBlank() || preco_produto.getText().isBlank() || tipo_produto.getText().isBlank() || estoque.getText().isBlank() || descricao.getText().isBlank() || imagem.getImage() == null){
            label_aviso.setText("Preencha todos os campos.");        
        }else{
            Produto p = new Produto();
            p.setDescricao(descricao.getText());
            p.setPreco(Double.parseDouble(preco_produto.getText()));
            p.setNome(nome_produto.getText());
            p.setTipo(tipo_produto.getText());
            p.setEstoque(Integer.parseInt(estoque.getText()));
            p.setImagem(ManipularImagem.getImgBytes(imagem_escolhida));
            
            //Executar essa parte apos criar a lista de pordutos no Dao
            ListaDeProdutos l = ListaDeProdutos.getInstance();
            if(l.adicionar(p)){
                System.out.println("ID " + p.getID());
                Serializador.salvar_dados(l.getListaDeProdutos(), "ListaProdutos.txt");
                
                imagemClass.salvarImagem(p.getNome());
                
                limparEntradas();
                Main.mudar_tela("menu_administrador");
            }else{
                label_aviso.setText("Produto não Cadastrado.");
            }  
        }
        return true;
    }
    
    @FXML
    public void cancelar(ActionEvent e){
        limparEntradas();
        Main.mudar_tela("menu_administrador");
    }

    @FXML
    private void escolher_Imagem_onAction(ActionEvent event) {
        imagem_escolhida = imagemClass.escolherImagem();
        if(imagem_escolhida != null){
            imagem.setImage(ManipularImagem.Buffer_to_Image(imagem_escolhida));
        }
    }
    
    private void limparEntradas(){
    nome_produto.setText("");
    preco_produto.setText("");
    tipo_produto.setText("");
    estoque.setText("");
    descricao.setText("");
    label_aviso.setText("");
    imagem.setImage(null);
    }
}
