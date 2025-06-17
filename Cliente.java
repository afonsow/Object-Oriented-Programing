
import java.util.*;
public class Cliente {
    private int codigo;
    private String nome;
    private ArrayList<Conta> contas;

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }
    
    public int getCodigoCliente()
    {
        return this.codigo;
    }
    
    public String getNomeCliente()
    {
        return this.nome;
    }
    
    public ArrayList<Conta> getContas()
    {
        return this.contas;
    }
    
    public void addContas(Conta conta)
    {
        this.contas.add(conta);
    }
    
    
    
    
  
    
   
}