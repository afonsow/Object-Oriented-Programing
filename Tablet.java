
import java.util.*;
public class Tablet extends Dispositivo
{
    private int capacidadeMemoria;
    private ArrayList<String> contactos;

    public Tablet(int n, String mF, int cP)
    {
        super(n,mF);
        this.capacidadeMemoria = cP;
        this.contactos = new ArrayList<>();
    }
    
    public int getCapacidadeMemoria()
    {
        return this.capacidadeMemoria;
    }
    
    public ArrayList<String> getContactos()
    {
        ArrayList<String> temp = new ArrayList<>();
        
        for(String s : this.contactos)
        {
            temp.add(s);
            
        }
        
        return temp;
    }
    
    public void addContacto(String s)
    {
        this.contactos.add(s);
    }
    
    public Tablet clone()
    {
        Tablet tablet = new Tablet(super.getNumeroDispositivo(), super.getModoFuncionamento(), this.getCapacidadeMemoria());
        
        for(String s : this.contactos)
        {
            tablet.addContacto(s);
        }
        
        for(Comunicação com : super.getComunicações())
        {
            tablet.addComunicações(com);
        }
        
        return tablet;
    }
    

    
 
    
    

}
