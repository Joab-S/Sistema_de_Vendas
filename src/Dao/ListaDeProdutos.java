/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Produto;
import Models.Serializador;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author thiag
 */
public class ListaDeProdutos implements Serializable {
    private static final ListaDeProdutos instancia = new ListaDeProdutos();
    private LinkedList<Produto> listaProdutos;

    public static ListaDeProdutos getInstance() {
        return instancia;
    }
    
    private ListaDeProdutos() { // Construtor
        this.listaProdutos = new LinkedList<>();
        listaProdutos=(LinkedList<Produto>)Serializador.carregar_dados("ListaProdutos.txt");
    }
    
    LinkedList<Produto> getListaDeProdutos() {
    return this.listaProdutos;
  }

  boolean adicionar(Produto produto) {
    // Verifica se o produto ja foi adicionado
    if (this.getListaDeProdutos().contains(produto)) {
      return false;
    }
    produto.getID();
    // Insere o produto
    if(!this.getListaDeProdutos().add(produto)){
      return false;
    }
    return true;
  }
  //Testado
  //Busca o porduto pelo ID
  Produto buscar(int ID) {
    //Verifica se o ID é válido
    if (ID < 0) {
      return null;
    }
    if (this.getListaDeProdutos().size() < 1) {
      System.out.println("Lista vazia");
      return null;
    }
    ListIterator<Produto> l = this.getListaDeProdutos().listIterator();
    Produto p;
    p = this.getListaDeProdutos().getLast();

    if (p.getID() < ID) {
      return null;
    }
    while (l.hasNext()) {
      p = l.next();
      if (p.getID() >= ID) {
        break;
      }
    }

    if (p.getID() == ID) {
      return p;
    } else {
      return null;
    }
  }

  boolean remover(int ID) {
    if (ID < 0) {
      return false;
    }
    if (this.getListaDeProdutos().size() < 1) {
      System.out.println("Lista vazia");
      return false;
    }
    ListIterator<Produto> l = this.getListaDeProdutos().listIterator();
    Produto p = this.getListaDeProdutos().getLast();

    if (p.getID() < ID) {
      return false;
    }
    while (l.hasNext()) {
      p = l.next();
      if (p.getID() >= ID) {
        break;
      }
    }

    if (p.getID() == ID) {
      if (this.getListaDeProdutos().remove(p)) {
        return true;
      }
    }
    return false;
  }
}
