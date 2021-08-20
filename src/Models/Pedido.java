package Models;

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
  private int formaDePagamento;
  private String dataEHora;
  private Vendedor vendedor;
  private LinkedList<ElementoPedido> ListaProdutos;
  private int parcelas;
  // Rever o tipo de estrutura que a gnt vai usar

  public Pedido() {
    this(0, null);
  }

  public Pedido(int formaDePagamento, Vendedor vendedor) {
    this.ID = -1;
    this.formaDePagamento = formaDePagamento;
    this.ListaProdutos = new LinkedList<ElementoPedido>();
    this.vendedor = vendedor;
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
    return;
  }

  private void setData() {
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
  }

  public Vendedor getVendedor() {
    return this.vendedor;
  }

  public void setParcelas(int parcelas) {
    this.parcelas = parcelas;
  }

  public int getParcelas() {
    return parcelas;
  }

  public void setFormaDePagamento(int tipoDePagamento) {
    this.formaDePagamento = tipoDePagamento;
  }

  public boolean verificarEstoque(Produto p, int quant) {
    if (p.getEstoque() < quant) {
      return false;
    }
    return true;
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

  public double precoTotal() {
    ListIterator<ElementoPedido> lista = this.getListaProdutos().listIterator();
    double precoTotal = 0;
    while (lista.hasNext()) {
      ElementoPedido p = lista.next();
      precoTotal += (p.getProduto().get_preco()) * p.getQuant();
    }
    return precoTotal;
  }

  public boolean finalizar_pedido(ListaDePedidos l) {
    this.gerarID(l);
    this.setData();
    if (!l.adicionar_pedido(this)) {
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