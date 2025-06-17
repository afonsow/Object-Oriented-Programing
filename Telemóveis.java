
import java.util.*;
public class Telemóveis extends Dispositivo
{
    private ArrayList<String> contactos;
    
    public Telemóveis(int n, String mF)
    {
        super(n,mF);
        this.contactos = new ArrayList <String> ();
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
    
    public Telemóveis clone()
    {
        Telemóveis t = new Telemóveis(super.getNumeroDispositivo(), super.getModoFuncionamento());
       
        for(String s : this.contactos)
        {
            t.addContacto(s);
        }
        
        for(Comunicação com : super.getComunicações())
        {
            t.addComunicações(com);
        }
        
        return t;
    }
    


    
}
