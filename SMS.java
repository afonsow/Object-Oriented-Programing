
import java.util.*;
public class SMS extends Comunicação
{
    private int tamanhoMensagem;
    private String texto;
    private double preco;
    public SMS(int o, int d,double preco, int tM, String t)
    {
        super(o,d);
        this.tamanhoMensagem = tM;
        this.texto = t;
        this.preco = preco;
    }
    
    public int getTamanhoMensagem()
    {
        return this.tamanhoMensagem;
    }
    
    public String getTextoSMS()
    {
        return this.texto;
    }
    
   public double calcularPreco()
    {
        return this.preco;
    }
    
    public SMS clone()
    {
        SMS sms = new SMS(super.getOrigem(), super.getDestino(),this.preco, this.tamanhoMensagem, this.texto);
        return sms;
    }

}
