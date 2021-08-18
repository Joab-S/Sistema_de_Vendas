package Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author cecilia
 */
public class PagamentoController implements Initializable {
    
    @FXML
    private RadioButton credito;
    
    @FXML
    private RadioButton debito;
    
    @FXML
    private RadioButton a_vista;
    
    @FXML
    private Button concluir;

    @FXML
    private Button cancelar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
