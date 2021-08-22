package Models;

import java.util.LinkedList;
import java.io.Serializable;
import Dao.ListaDeVendedores;

public class Vendedor implements Serializable{
  private int ID;
  private String nome;
  private LinkedList <Pedido> vendas = new LinkedList<>();
  private String senha;
  private String email;
  private boolean isAdmin;
  private int total_vendas;
  private String ultima_venda;

  public Vendedor(){
    this("Sem nome", "Sem senha");
  }
  //Recebe nome e senha
  public Vendedor(String nome, String senha){
    this.ID=-1;
    this.nome=nome.trim();
    this.senha=senha;
    this.isAdmin = false;
    this.email = "";
    this.total_vendas =0;
    this.ultima_venda ="Sem Vendas.";
  }

    public int getTotal_vendas() {
        return total_vendas;
    }

    public String getUltima_venda() {
        return ultima_venda;
    }

    public void setUltima_venda(String ultima_venda) {
        this.ultima_venda = ultima_venda;
    }

    public void setTotal_vendas(int total_vendas) {
        this.total_vendas = total_vendas;
    }
    
    public void setEmail(String email){
          this.email=email;
    }
  
    public String getEmail(){
        return this.email;
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
        if(x.add(novoPedido)){
          this.total_vendas++;
          this.ultima_venda = this.getVendas().getLast().getDataEHora();
        } 
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