package Dao;

import Models.Vendedor;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author joab
 */
public class ListaDeVendedores implements Serializable{
    
    /*
    ** Aplicando padrão de projeto Singleton:
    ** Isso nos permite criar uma unica instância de
    ** uma determinada classe  e  usá-la globalmente.
    */
    
    private static final ListaDeVendedores instancia = new ListaDeVendedores();
    private LinkedList<Vendedor> listaVendedores;
    
    public static ListaDeVendedores getInstance() {
        return instancia;
    }
    
    public LinkedList<Vendedor> getListaDeVendedor(){
        return this.listaVendedores;
    }
    
    private ListaDeVendedores() { // Construtor
        this.listaVendedores = new LinkedList<>();
        Vendedor admin = new Vendedor("Admin", "Admin");
        admin.setAdmin(true);
        this.listaVendedores.add(admin);
    }
            
    public Vendedor searchUserName(String nomeVendedor) {
        ListIterator<Vendedor> e = getListaDeVendedor().listIterator();
        Vendedor v;

        if (e != null){
          while (e.hasNext()) {
              v = e.next();
              if (v.getNome().toLowerCase().equals(nomeVendedor.trim().toLowerCase())) { return v; }
          }
      }
      return null;
  }
    
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

    return this.getListaDeVendedor().remove(vend);
  }

  boolean remover(int ID) {
    Vendedor vend;
    vend = searchUserID(ID);
    if (vend == null) {
      return false;
    }
    return this.getListaDeVendedor().remove(vend);
  }
  
  Vendedor searchUserID(int IDvendedor) {
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
