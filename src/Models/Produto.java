package Models;

import java.io.Serializable;
import Dao.ListaDeProdutos;
import java.awt.image.BufferedImage;

public class Produto implements Serializable{
  //Atributos
  private int ID;
  private int estoque;
  private String nome;
  private String tipo;
  private String descricao;
  private double preco;
  public byte[] imagem;
  
  //Metodos gets e sets
  public Produto(){
    this("Sem nome","Sem tipo","Sem descricao",0,0);
  }
  public Produto(String nome, String tipo, String descricao, double preco, int estoque){
    this.setEstoque(estoque);
    this.setNome(nome);
    this.setTipo(tipo);
    this.setDescricao(descricao);
    this.setPreco(preco);

  }

  
  public void gerarID(ListaDeProdutos p){
    if(p==null){
      System.out.println("Lista de produtos nulos.");
      return;
    }
    if(p.getListaDeProdutos().size()<1){
      this.ID=0;
      return;
    }
    //ListIterator <Produto> e= p.getListaDeProdutos().listIterator();
    int x;
    x=p.getListaDeProdutos().getLast().getID();
    this.ID= x+1;
  }

  public int getID(){
    return this.ID;
  }

  public void setNome(String nome){
    this.nome = nome;
  }
  public String getNome(){
    return this.nome;
  }
  //Verificar preço negativo
  public void setPreco(double preco){

    this.preco = preco;
  }

  public double get_preco(){
    return this.preco;
  }

  public void alterar_preco(double novo_preco){
    this.preco = novo_preco;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }

  public String getDescricao(){
    return this.descricao;
  }

  public void setTipo(String tipo){
    this.tipo = tipo;
  }

  public String getTipo(){
    return this.tipo;
  }

  public void setEstoque(int estoque){
    this.estoque = estoque;
  }

  public int getEstoque(){
    return this.estoque;
  }
  
  public void alterarEstoque(int novo_estoque){
    this.estoque = novo_estoque;
  }
  
  public void setImagem(byte[] imagem){
    this.imagem = imagem;
  }
  
  public byte[]  getImagem(){
    return this.imagem;
  }
  
  @Override
  public boolean equals(Object o){
    Produto p;
    
    if(this == o){
      return true;
    }
    if(!(o instanceof Produto)){
      return false;
    }
    p = (Produto)o;
    if((this.getNome().toLowerCase().trim().compareTo(p.getNome().toLowerCase().trim())==0)&& (this.getTipo().toLowerCase().trim().compareTo(p.getTipo().toLowerCase().trim())==0)){
      return true;
    }
    return false;
  }
}
