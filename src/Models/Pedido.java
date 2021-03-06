package Models;

import Dao.ListaDePedidos;
import java.util.LinkedList;
import java.util.ListIterator;
//import java.time.LocalDateTime;
//import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Pedido implements Serializable{
  private int ID;
  public Double precoTotal;
  private String formaDePagamento;
  private String dataEHora;
  private Vendedor vendedor;
  private String nome;
  private LinkedList<ElementoPedido> ListaProdutos;
  private int parcelas;

  public Pedido(String formaDePagamento, Vendedor vendedor) {
    this.ID = -1;
    this.formaDePagamento = formaDePagamento;
    this.ListaProdutos = new LinkedList<ElementoPedido>();
    this.vendedor = vendedor;
  }

  private void setNome (Vendedor v){
        this.nome = v.getNome();
  }
  
  private String getNome (){
        return nome;
  }
  
  public void gerarID(ListaDePedidos l) {
    if (l == null) {
      return;
    }
    if (l.getListaDePedidos().size() < 1) {
      this.ID = 0;
      return;
    }
    int x;
    x = l.getListaDePedidos().getLast().getID();
    this.ID = x + 1;
  }

  public void setData() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    this.dataEHora = dateFormat.format(date);
  }

  public int getID() {
    return this.ID;
  }
  
  public void setdataEHora(String datahora) {
    this.dataEHora = datahora;
  }

  public LinkedList<ElementoPedido> getListaProdutos() {
    return this.ListaProdutos;
  }

  public String getDataEHora() {
    return this.dataEHora;
  }

  public void setVendedor(Vendedor v) {
    this.vendedor = v;
    setNome(v);
  }

  public Vendedor getVendedor() {
    return vendedor;
  }

  public void setParcelas(int parcelas) {
    this.parcelas = parcelas;
  }

  public int getParcelas() {
    return parcelas;
  }

  public void setFormaDePagamento(String tipoDePagamento) {
    this.formaDePagamento = tipoDePagamento;
  }

  public boolean verificarEstoque(Produto p, int quant) {
    return p.getEstoque() >= quant;
  }

  // Fazer o teste do estoque aqui
  public boolean inserirProduto(Produto p, int quant) {
    if ((p == null) || quant < 1) {
      return false;
    }
    if (!this.verificarEstoque(p, quant)) {
      return false;
    } else {
      ElementoPedido novo_no = new ElementoPedido(p, quant);
      if (!this.getListaProdutos().add(novo_no)) {
        return false;
      }
      p.setEstoque(p.getEstoque() - quant);
      return true;
    }
  }

  public ElementoPedido buscar_produto(Produto p) {
    ListIterator<ElementoPedido> l = this.getListaProdutos().listIterator();
    ElementoPedido elemento;
    if (p == null) {
      return null;
    }
    while (l.hasNext()) {
      elemento = l.next();
      if (elemento.getProduto().equals(p)) {
        return elemento;
      }
    }
    return null;
  }

  public boolean remover_produto(Produto p) {
    ElementoPedido e = this.buscar_produto(p);
    if (e == null) {
      return false;
    }
    e.getProduto().setEstoque(e.getQuant() + e.getProduto().getEstoque());
    this.getListaProdutos().remove(e);
    return true;
  }

  public void setPrecoTotal(ListIterator<ElementoPedido> lista){
    //ListIterator<ElementoPedido> lista = this.getListaProdutos().listIterator();
    if (lista != null){
        while (lista.hasNext()) {
            this.precoTotal += lista.next().getTotal();
        }
    }
    if (this.precoTotal == null) { this.precoTotal = 1000.0; }
  }
  
  public Double getPrecoTotal() {
    //setPrecoTotal();
    return precoTotal;
  }

  public boolean finalizar_pedido(ListaDePedidos l) {
    // ver se a lista n??o ta vazia atnes de finalizar
    this.gerarID(l);
    this.setData();
    if (l.adicionar_pedido(this)){
        this.vendedor.adicionarVenda(this);
        System.out.println("Venda adicinada ao vendedor");
    }
    else{
        System.out.println("Erro ao adicinar pedido");
        return false;
    }
    return true;
  }

  public void cancelar_pedido() {
    ListIterator<ElementoPedido> l = this.getListaProdutos().listIterator();
    ElementoPedido e;
    while (l.hasNext()) {
      e = l.next();
      e.getProduto().setEstoque(e.getProduto().getEstoque() + e.getQuant());
    }
  }
}