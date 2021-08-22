package Dao;

import Models.Serializador;
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
    private static Vendedor vend;
    private static Vendedor vendedor_ref;
    private static final ListaDeVendedores instancia = new ListaDeVendedores();
    private LinkedList<Vendedor> listaVendedores;
    
    public static ListaDeVendedores getInstance() {
        return instancia;
    }
    
    public LinkedList<Vendedor> getListaDeVendedor(){
        return this.listaVendedores;
    }
    // Contrutor carrega a lista se não houver então cria a lista vazia e seta o admin manualmente
    private ListaDeVendedores() { // Construtor
       
        this.listaVendedores = (LinkedList<Vendedor>)Serializador.carregar_dados("ListaVendedores.txt");
        if(this.listaVendedores==null){
            this.listaVendedores = new LinkedList<>();
            Vendedor admin = new Vendedor("Admin", "Admin");
            admin.setAdmin(true);
            admin.setID(0);
            admin.setEmail("Admin");
            this.listaVendedores.add(admin);
        }
        
    }        
    public Vendedor searchUserName(String nomeVendedor) {
        ListIterator<Vendedor> e = getListaDeVendedor().listIterator();
        Vendedor v;

        if (e != null){
          while (e.hasNext()) {
              v = e.next();
              if (v.getNome().toLowerCase().compareTo(nomeVendedor.trim().toLowerCase())==0) { return v; }
          }
      }
      return null;
  }
    
    public Vendedor searchUserEmail(String emailVendedor) {
        ListIterator<Vendedor> e = getListaDeVendedor().listIterator();
        Vendedor v;

        if (e != null){
          while (e.hasNext()) {
              v = e.next();
              System.out.println(v.getEmail());
              if (v.getEmail().toLowerCase().compareTo(emailVendedor.trim().toLowerCase())==0) { return v; }
          }
      }
      return null;
  }
    
  public void setVendedorLogado(Vendedor vend){
      this.vend = vend;
      
  }

    public static Vendedor getVendedor_ref() {
        return vendedor_ref;
    }

    public static void setVendedor_ref(Vendedor vendedor_ref) {
        ListaDeVendedores.vendedor_ref = vendedor_ref;
    }
  
  public Vendedor getVendedorLogado(){
      return this.vend;
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
    Vendedor vendedor;
    vendedor = searchUserID(ID);
    if (vendedor == null) {
      return false;
    }
    return this.getListaDeVendedor().remove(vendedor);
  }
  
  public Vendedor searchUserID(int IDvendedor) {
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