package Models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListaDeVendedores implements Serializable{
  LinkedList<Vendedor> listaVendedores;

  public ListaDeVendedores() {
    this.listaVendedores = new LinkedList<Vendedor>();
  }

  LinkedList<Vendedor> getListaDeVendedor() {
    return this.listaVendedores;
  }

  // Verificar contains nos testes
  public boolean adicionar(Vendedor vend) {
    if (vend == null) {
      return false;
    }

    if (this.getListaDeVendedor().contains(vend)) {
      return false;
    }
    vend.gerarID(this);
    if (!this.getListaDeVendedor().add(vend)) {
      System.out.println("Não foi possivel adicionar o vendedor.");
      return false;
    }
    return true;
  }

  public boolean remover(Vendedor vend) {
    if (vend == null) {
      return false;
    }

    if (!this.getListaDeVendedor().contains(vend)) {
      return false;
    }

    if (!this.getListaDeVendedor().remove(vend)) {
      return false;
    }
    return true;
  }

  boolean remover(int ID) {
    Vendedor vend;
    vend = buscar(ID);
    if (vend == null) {
      return false;
    }
    if (!this.getListaDeVendedor().remove(vend)) {
      return false;
    }
    return true;
  }

  // Fazer para letras maiusculas e minusculas
  Vendedor buscar(String nomeVendedor) {
    ListIterator<Vendedor> e = this.getListaDeVendedor().listIterator();
    Vendedor v;

    while (e.hasNext()) {
      v = e.next();
      if (v.getNome().toLowerCase().equals(nomeVendedor.trim().toLowerCase()) == true) {
        return v;
      }
    }
    return null;
  }

  Vendedor buscar(int IDvendedor) {
    if (IDvendedor < 0) {
      return null;
    }
    if (this.getListaDeVendedor().size() < 1) {
      System.out.println("Lista vazia");
      return null;
    }

    ListIterator<Vendedor> l = this.getListaDeVendedor().listIterator();
    Vendedor v;
    v = getListaDeVendedor().getLast();
    if (v.getID() < IDvendedor) {
      return null;
    }
    while (l.hasNext()) {
      v = l.next();
      if (v.getID() >= IDvendedor) {
        break;
      }
    }
    if (v.getID() == IDvendedor) {
      return v;
    } else {
      return null;
    }
  }
}