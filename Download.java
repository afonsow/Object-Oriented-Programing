
import java.util.*;
public class Download extends Comunicação
{
    private int tamanhoBytes;
    private double duraçãoDownload;
    private double preco;
    
    public Download(int o, int d,double preco, int tB, double durD)
    {
        super(o,d);
        this.tamanhoBytes = tB;
        this.duraçãoDownload = durD;
        this.preco = preco;
    }
    
    public double getDuraçãoDownload()
    {
        return this.duraçãoDownload;
    }
    
    public int getTamanhoBytesDownload()
    {
        return this.tamanhoBytes;
    }
    
    public int getOrigemDownload()
    {
        return super.getOrigem();
    }
    
    public double calcularPreco()
    {
        return this.preco*this.duraçãoDownload;
    }

    
    public Download clone()
    {
        Download d = new Download(super.getOrigem(), super.getDestino(),this.preco,this.tamanhoBytes, this.duraçãoDownload);
        return d;
    }


    
}
