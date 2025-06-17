import java.util.*;
public class Oldies extends Dispositivo
{
  
    
    public Oldies(int n, String mF)
    {
        super(n,mF);
    }
    
   
    
    public Oldies clone()
    {
        Oldies o = new Oldies(super.getNumeroDispositivo(), super.getModoFuncionamento());
        
        for(Comunicação com : super.getComunicações())
        {
            o.addComunicações(com);
        }
        return o;
    }
    
    

}
