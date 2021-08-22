package Models;

import java.io.Serializable;

public class ElementoPedido implements Serializable {
    private Produto produto;
    private int quant;
    private double total;

    ElementoPedido(Produto p, int quant) {
        this.produto = p;
        this.quant = quant;
        setTotal(quant, p.get_preco());
    }

    ElementoPedido() {
        this(null, 0);
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
    
    private void setTotal(int quantidade, double preco){
        this.total = quantidade * preco;
    }
    
    public double getTotal() {
        return this.total;
    }
}
