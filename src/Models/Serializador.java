package Models;

import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Serializador implements Serializable {
    
    public static boolean salvar_dados(Object lista,String nome_arq){

        try{
            ObjectOutputStream saida = new ObjectOutputStream( new FileOutputStream(nome_arq));
            saida.writeObject(lista);
            saida.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    
    /*
    public static void salvar_dados(Object lista,String nome_arq) throws IOException{

        
        FileWriter p = new FileWriter(nome_arq);
        PrintWriter x = new PrintWriter(p);
        x.print(lista);
        x.close();
            //ObjectOutputStream saida =new ObjectOutputStream(p);
            
            //saida.writeObject(lista);
            //saida.close();
          
        
    }
    */
    public static Object carregar_dados(String nome_arq){

        try{
            Object i;
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nome_arq));
            i =entrada.readObject();
            entrada.close();
            return i;
        }catch(FileNotFoundException e){
            System.out.println("Arquivo nao encontrado.");
            return null;
        }catch(ClassNotFoundException e){
            System.out.println("Classe nao encontrada.");
            return null;
        }catch(IOException e){
            System.out.println("Erro na entrada ou saida de dados");
            return null;
        }
    }
}
