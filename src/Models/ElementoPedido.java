package Models;

import java.io.Serializable;

public class ElementoPedido implements Serializable {
    private Produto produto;
    private int quant;
    private double total;
    private double preco;
    private int ID_produto;
    private String nome;
    
    public ElementoPedido(Produto p, int quant) {
        this.produto = p;
        this.quant = quant;
        setTotal(quant, p.get_preco());
        setNome(p);
        setPreco(p);
        setProd_ID(p);   
    }

    public ElementoPedido() {
        this(null, 0);
    }
    
    private void setPreco(Produto p){
        this.preco = p.get_preco();
    }
    
    private void setProd_ID(Produto p){
        this.ID_produto = p.getID();
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
        setPreco(produto);
        setProd_ID(produto);
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getQuant() {
        return quant;
    }
    
    public int getID_produto() {
        return ID_produto;
    }
    
    public double getPreco() {
        return preco;
    }
    
    private void setNome(Produto p){
        this.nome = p.getNome();
    }
    
    public String getNome() {
        return nome;
    }
    
    private void setTotal(int quantidade, double preco){
        this.total = quantidade * preco;
    }
    
    public double getTotal() {
        return this.total;
    }
}
