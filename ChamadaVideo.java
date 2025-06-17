
import java.util.*;
public class ChamadaVideo extends Comunicação
{
    private double duraçãoChamadaVideo;
    private int resoluçãoChamadaVideo;
    private double preco;
    public ChamadaVideo(int o, int d,double preco, double durCV, int resCV)
    {
        super(o,d);
        this.duraçãoChamadaVideo = durCV;
        this.resoluçãoChamadaVideo = resCV;
        this.preco = preco;
    }
    
    public double getDurCV()
    {
        return this.duraçãoChamadaVideo;
    }
    
    public int getResCV()
    {
        return this.resoluçãoChamadaVideo;
    }
    
     public double calcularPreco()
    {
        return this.preco*this.duraçãoChamadaVideo;
    }
    
    public ChamadaVideo clone()
    {
        ChamadaVideo cv = new ChamadaVideo(super.getOrigem(), super.getDestino(),this.preco, this.duraçãoChamadaVideo, this.resoluçãoChamadaVideo);
        return cv;
    }

   
}
