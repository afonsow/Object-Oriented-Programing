
import java.util.*;
public class MensagemImagem extends Comunicação
{
    private int tamanhoBytes;
    private String formatoImagem;
    private int resoluçãoImagem;
    private double preco;
    public MensagemImagem(int o, int d,double preco, int tB, String formI, int resI)
    {
        super(o,d);
        this.tamanhoBytes = tB;
        this.formatoImagem = formI;
        this.resoluçãoImagem = resI;
        this.preco = preco;
    }
    
    public int getTamanhoBytes()
    {
        return this.tamanhoBytes;
    }
    
    public String getFormatoImagem()
    {
        return this.formatoImagem;
    }
    
    public int getResoluçãoImagem()
    {
        return this.resoluçãoImagem;
    }
    
    public double calcularPreco()
    {
        return this.preco;
    }
    
    public MensagemImagem clone()
    {
        MensagemImagem mi = new MensagemImagem(super.getOrigem(), super.getDestino(),this.preco, this.tamanhoBytes, this.formatoImagem, this.resoluçãoImagem);
        return mi;
    }

}
