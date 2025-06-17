
import java.util.*;
public class MensagemVideo extends Comunicação
{
    private int resoluçãoVideo;
    private String formatoVideo;
    private double duração;
    private double preco;
    public MensagemVideo(int o, int d,double preco, int resV, String formV, double dur)
    {
        super(o,d);
        this.resoluçãoVideo = resV;
        this.formatoVideo = formV;
        this.duração = dur;
        this.preco = preco;
    }
    
    public int getResoluçãoVideo()
    {
        return this.resoluçãoVideo;
    }
    
    public String getFormatoVideo()
    {
        return this.formatoVideo;
    }
    
    public double getDuraçãoMensagemVideo()
    {
        return this.duração;
    }
    
    public double calcularPreco()
    {
        return this.preco*this.duração;
    }
    
    public MensagemVideo clone()
    {
        MensagemVideo mv = new MensagemVideo(super.getOrigem(), super.getDestino(),this.preco, this.resoluçãoVideo, this.formatoVideo, this.duração);
        return mv;
    }
    

    
}
