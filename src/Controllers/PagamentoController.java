package Controllers;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import main.Main;

/**
 * FXML Controller class
 *
 * @author cecilia
 */
public class PagamentoController implements Initializable {
    
    @FXML
    private Button confirmarButton;
    @FXML
    private RadioButton creditoRadioButton;
    @FXML
    private RadioButton debitoRadioButton;
    @FXML
    private RadioButton aVistaRadioButton;
    @FXML
    private Button cancelarButton;
    @FXML
    private ToggleGroup forma_de_pagamento;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmar_onAction(ActionEvent event) {
        RadioButton radio = (RadioButton) forma_de_pagamento.getSelectedToggle();
            if (radio.getText().compareTo("Crédito")==0){
                Main.set_pagamento("crédito");
            }
            else if (radio.getText().compareTo("Débito")==0){
                Main.set_pagamento("débito");
            }
            else if (radio.getText().compareTo("À Vista")==0){
                Main.set_pagamento("à vista");
            }
            Main.mudar_tela("menu_vendas");
            System.out.println(Main.get_pagamento());
    }

    @FXML
    private void credito_onAction(ActionEvent event) {
    }

    @FXML
    private void debito_onAction(ActionEvent event) {
    }

    @FXML
    private void a_vista_onAction(ActionEvent event) {
    }

    @FXML
    private void cancelar_onAction(ActionEvent event) {
        Main.mudar_tela(Main.get_tela_anterior());
    }
    
}