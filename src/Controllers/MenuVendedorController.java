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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    private TextField busca_admin;
    @FXML
    private Button pesquisar_admin;
    @FXML
    private RadioButton rb_id;
    @FXML
    private ToggleGroup selecao_pesquisa;
    @FXML
    private RadioButton rb_nome;

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
    }
    
}
