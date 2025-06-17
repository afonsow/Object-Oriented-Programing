
import java.util.*;
public class Conta
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int codigo;
    ArrayList <Dispositivo> dispositivos;
    

    public Conta(int c)
    {
        this.codigo = c;
        this.dispositivos = new ArrayList <Dispositivo> ();
        
    }
    
    public int getCodigoConta()
    {
        return this.codigo;
    }
    
    public ArrayList <Dispositivo> getDispositivos()
    {
        return this.dispositivos;
    }
    
    public void addDispositivos(Dispositivo d)
    {
        if(d instanceof Oldies && d.getModoFuncionamento().equals("5G"))
        {
            System.out.println("O dispositivo Oldies só funciona em modo 4G.");
        }
        else if(!d.getModoFuncionamento().equals("5G") && !d.getModoFuncionamento().equals("4G"))
        {
            System.out.println("O dispositivo só funciona em 4G ou 5G");
        }
        else
        {
           this.dispositivos.add(d);
        }
    }

    
    public void visualizarListaDispositivos(int numeroConta) 
    {
      System.out.println("Lista de Dispositivos:");

       for (Dispositivo d : this.dispositivos) 
       {
        System.out.println("Número do Dispositivo: " + d.getNumeroDispositivo());
        System.out.println("Modo de Funcionamento: " + d.getModoFuncionamento());
        System.out.println("------");
       }
    }

    
      public void listarDispositivos5G(int numeroConta) 
    {
        System.out.println("Lista de Dispositivos em Modo 5G:");
          
            for (Dispositivo dispositivo : this.getDispositivos()) 
            {
                if (dispositivo.getModoFuncionamento().equals("5G")) 
                {
                    System.out.println("Número do Dispositivo: " + dispositivo.getNumeroDispositivo());
                }
            }
          
    }
    
    
    

}
