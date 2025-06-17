import java.util.*;
public abstract class Comunicação
{
    private int origem;
    private int destino;
   
    public Comunicação(int o, int d)
    {
        this.origem = o;
        this.destino = d;
    }
    
    public int getOrigem()
    {
        return this.origem;
    }
    
    public int getDestino()
    {
        return this.destino;
    }

    public abstract double calcularPreco();

    public abstract Comunicação clone();

}
