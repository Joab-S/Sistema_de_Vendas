/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main; 
import Dao.ListaDeVendedores;
import Dao.ListaDeProdutos;
import Models.Serializador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Gabriel Magalhães
 */
public class Main extends Application {
    
    private static Stage stage;
    private static Scene cadastro_produto;
    private static Scene Login;
    private static Scene cadastro_vendedor;
    private static Scene buscar_venda_admin;
    private static Scene buscar_vendedores_admin;
    private static Scene menu_administrador;
    private static Scene menu_produtos_admin;
    private static Scene menu_produtos_vendedor;
    private static Scene menu_vendas;
    private static Scene menu_vendedor;
    private static Scene pagamento;
    private static Scene perfil;
    private static Scene perfil_vendedor_admin;
    
    @Override
    public void start(Stage primarystage) throws Exception{
        stage = primarystage;
        
        /*
        Importante !!!!!!!!!
        A gente setou todas telas no codigo 
        Mas precisa cofigurar o controller e atribuir as funções dosbotões no fxml
        Telas Funcionais Cadastro de produto e vendedor
        Verificar o cadastro de vendedor para ter um exemplo de como fazero controller
        Assistam os videos da natalia
        */
        
        //System.out.println(getClass().getResource("../Views/CadastroDeProduto.fxml"));
        //System.out.println(getClass().getResource("../Views/CadastroDeProduto.fxml"));
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/CadastroDeProduto.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../Views/CadastroDeProduto.fxml"));
        Parent FXML_cadastro_produto = FXMLLoader.load(getClass().getResource("../Views/CadastroDeProduto.fxml"));
        cadastro_produto = new Scene(FXML_cadastro_produto);
        /*
        Parent FXML_busca_venda_admin = FXMLLoader.load(getClass().getResource("../Views/BuscarVendasAdmin.fxml"));
        buscar_venda_admin = new Scene(FXML_busca_venda_admin);

        
        Parent FXML_buscar_vendedores_admin = FXMLLoader.load(getClass().getResource("../Views/BuscarVendedoresAdmin.fxml"));
        buscar_vendedores_admin = new Scene(FXML_buscar_vendedores_admin);
        */
        Parent FXML_menu_administrador = FXMLLoader.load(getClass().getResource("../Views/MenuAdministrador.fxml"));
        menu_administrador = new Scene(FXML_menu_administrador);
        
        Parent FXML_menu_produtos_admin = FXMLLoader.load(getClass().getResource("../Views/MenuDeProdutosAdmin.fxml"));
        menu_produtos_admin = new Scene(FXML_menu_produtos_admin);
        /*
        Parent FXML_menu_produto_vendedor = FXMLLoader.load(getClass().getResource("../Views/MenuDeProdutosVendedor.fxml"));
        menu_produtos_vendedor = new Scene(FXML_menu_produto_vendedor);
        
        Parent FXML_menu_vendas = FXMLLoader.load(getClass().getResource("../Views/MenuVendas.fxml"));
        menu_vendas = new Scene(FXML_menu_vendas);
        */
        Parent FXML_menu_vendedor = FXMLLoader.load(getClass().getResource("../Views/MenuVendedor.fxml"));
        menu_vendedor = new Scene(FXML_menu_vendedor);
        
        Parent FXML_pagamento = FXMLLoader.load(getClass().getResource("../Views/Pagamento.fxml"));
        pagamento = new Scene(FXML_pagamento);
        
        Parent FXML_perfil = FXMLLoader.load(getClass().getResource("../Views/Perfil.fxml"));
        perfil = new Scene(FXML_perfil);
        /*
        Parent FXML_perfil_vendedor_admin = FXMLLoader.load(getClass().getResource("../Views/PefilVendedorAdmin.fxml"));
        perfil_vendedor_admin = new Scene(FXML_perfil_vendedor_admin);
        */
        Parent FXML_login = FXMLLoader.load(getClass().getResource("../Views/Login.fxml"));
        Login = new Scene(FXML_login);
        
        Parent FXML_cadastro_vendedor = FXMLLoader.load(getClass().getResource("../Views/CadastroVendedor.fxml"));
        cadastro_vendedor = new Scene(FXML_cadastro_vendedor);
        
        primarystage.setScene(Login);
        primarystage.show();            
    }
    
    public static void mudar_tela(String nome_tela){
        switch(nome_tela){
            case "login":
                stage.setScene(Login);
                break;
            case "cadastro_produto":
                stage.setScene(cadastro_produto);
                break;
            case "cadastro_vendedor":
                stage.setScene(cadastro_vendedor);
                break;
            case "menu_produtos_admin":
                stage.setScene(menu_produtos_admin);
                break;                
                /*
            case "buscar_vendas_admin":
                stage.setScene(buscar_venda_admin);
                break;
            case "buscar_vendedores_admin":
                stage.setScene(buscar_vendedores_admin);
                break; */
            case "menu_administrador":
                stage.setScene(menu_administrador);
                break;/*

            case "menu_produtos_vendedor":
                stage.setScene(menu_produtos_vendedor);
                break;
            case "menu_vendas":
                stage.setScene(menu_vendas);
                break;
            */
            case "menu_vendedor":
                stage.setScene(menu_vendedor);
                break;
            case "pagamento":
                stage.setScene(pagamento);
                break;
            case "perfil":
                stage.setScene(perfil);
                break;
            case "perfil_vendedor_admin":
                stage.setScene(perfil);
                break;
        }
        
    }
    
    public static void main(String [] args){

        launch(args);
        //Ao final da execução do programa todas as listas devem ser salvas em seus respectivos arquivos
        Serializador.salvar_dados(ListaDeVendedores.getInstance().getListaDeVendedor(),"ListaVendedores.txt");
        Serializador.salvar_dados(ListaDeProdutos.getInstance().getListaDeProdutos(),"ListaProdutos.txt");
    }
    
    public static void setScene(String nome_tela, Scene nova_cena){
        switch(nome_tela){
            case "menu_produtos_admin":
                menu_produtos_admin = nova_cena;
                break;                
                /*
            case "buscar_vendas_admin":
                stage.setScene(buscar_venda_admin);
                break;
            case "buscar_vendedores_admin":
                stage.setScene(buscar_vendedores_admin);
                break; */
            case "menu_produtos_vendedor":
                menu_produtos_vendedor = nova_cena;
                break;
            case "menu_vendas":
                menu_vendas = nova_cena;
                break;
            case "perfil":
                perfil =nova_cena;
                break;
            case "perfil_vendedor_admin":
                stage.setScene(perfil);
                break;
        }
    }
}
