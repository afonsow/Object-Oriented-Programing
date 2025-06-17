
import java.util.*;
public class ChamadaNormal extends Comunicação
{
    private double duraçãoChamada;
    private double preco;
    public ChamadaNormal(int o, int d,double preco, double durC)
    {
        super(o,d);
        this.duraçãoChamada = durC;
        this.preco = preco;
    }
    
    public double getDuraçãoChamada()
    {
        return this.duraçãoChamada;
    }
    
    public double calcularPreco()
    {
        return this.preco*this.duraçãoChamada;
    }
    
    public ChamadaNormal clone()
    {
        ChamadaNormal cn = new ChamadaNormal(super.getOrigem(), super.getDestino(),this.preco, this.duraçãoChamada);
        return cn;
    }
    
    



}
