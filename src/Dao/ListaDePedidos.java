/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Pedido;
import Models.Vendedor;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author joab
 */
public class ListaDePedidos implements Serializable {
    private LinkedList<Pedido> pedidos;

  ListaDePedidos() {
    this.pedidos = new LinkedList<Pedido>();
  }

  LinkedList<Pedido> getListaDePedidos() {
    return this.pedidos;
  }

  Pedido buscar_venda(Vendedor v) {
    ListIterator<Pedido> iterator = getListaDePedidos().listIterator();
    Pedido p;
    while (iterator.hasNext()) {
      p = iterator.next();
      if (p.getVendedor().getID() == v.getID()) {
        return p;
      }
    }
    return null;
  }

  // Esse metodo ainda não foi terminado

  Pedido buscar_pedido(String data) {

     try{
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

      ListIterator<Pedido> p = this.getListaDePedidos().listIterator(); 
      Date date1= dateFormat.parse(data); 
      Date date2;
      Pedido ped;
      ped =this.getListaDePedidos().getLast();
      date2 = dateFormat.parse(ped.getDataEHora());
      
      if(date1.compareTo(date2)>0){
        return null;
      }
      while (p.hasNext()) {
        ped = p.next();
        date2 = dateFormat.parse(ped.getDataEHora());
        if(date2.compareTo(date1)>=0){
          break;
        }  
      }

      if (date2.compareTo(date1)==0) {
         return ped; 
      }
      return null;
    } 
    catch (ParseException ex) {
      ex.printStackTrace();
    } 
    return null;
  }

  Pedido buscar_pedido(int ID) {
    ListIterator<Pedido> iterator = this.getListaDePedidos().listIterator();
    Pedido p;
    while (iterator.hasNext()) {
      p = iterator.next();
      if (p.getID() > ID) {
        return null;
      }
      if (p.getID() == ID) {
        return p;
      }
    }
    return null;
  }

  public boolean adicionar_pedido(Pedido p) {
    LinkedList<Pedido> x = this.getListaDePedidos();
    if (x.contains(p)) {
      return false;
    }
    if (!x.add(p)) {
      return false;
    }
    return true;
  }

  public boolean remover_pedido(Pedido pedido) {
    if (this.getListaDePedidos().remove(pedido)) {
      return true;
    }
    return false;

  }

  public boolean remover_pedido(int ID) {
    Pedido p;
    p = this.buscar_pedido(ID);
    if (p == null) {
      return false;
    }
    if (this.getListaDePedidos().remove(p)) {
      return false;
    }
    return true;
  }
    
}
