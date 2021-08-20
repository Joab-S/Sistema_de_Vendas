package Models;

import java.util.LinkedList;
import java.io.Serializable;
import Dao.ListaDeVendedores;

public class Vendedor implements Serializable{
  private int ID;
  private String nome;
  private LinkedList <Pedido> vendas = new LinkedList<>();
  private String senha;
  private String nome_usuario;
  private String email;
  private boolean isAdmin;

  public Vendedor(){
    this("Sem nome", "Sem senha");
  }
  //Recebe nome e senha
  public Vendedor(String nome, String senha){
    this.ID=-1;
    this.nome=nome.trim();
    this.senha=senha;
    this.isAdmin = false;
  }

  public void setEmail(String email){
      this.email=email;
  }
  
  public String getEmail(){
      return this.email;
  }
  
  public void setUsuario(String user){
      this.nome_usuario = user;
  }
  
  public String getUsario(){
      return this.nome_usuario;
  }
  
  public void setSenha(String senha) {
      this.senha = senha;
  }
  
  public void setID(int i){
      this.ID = i;
  }
  
  public String getSenha() {
      return this.senha;
  }
  public void gerarID(ListaDeVendedores p){
    if(p==null){
      return;
    }
    if(p.getListaDeVendedor().size()<1){
      this.ID = 0;
      return;
    }
    int x;
    x =p.getListaDeVendedor().getLast().getID();
    this.ID= x+1;

  }

  public int getID(){
    return this.ID;
  }

  public void setNome(String nome){
    this.nome=nome.trim();
  }

  public String getNome(){
    return this.nome;
  }

  public LinkedList<Pedido> getVendas(){
    return this.vendas;
  }
  
  public void setAdmin(boolean admin){
      this.isAdmin = admin;
  }
  
  public boolean isAdmin(){
      return this.isAdmin;
  }

  public void adicionarVenda(Pedido novoPedido){
    LinkedList<Pedido> x = this.getVendas();
    if(!x.contains(novoPedido)){
      x.add(novoPedido);
    }
  }
  public boolean equals(Object o){
    Vendedor v;
    if(this == o){
      return true;
    }
    if(!(o instanceof Vendedor)){
      return false;
    }
    v = (Vendedor)o;
    return this.getID() == v.getID();
  }
}