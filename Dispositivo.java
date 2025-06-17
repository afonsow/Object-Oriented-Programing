
import java.util.*;
public abstract class Dispositivo
{
    private int numero;
    private String modoFuncionamento;
    private ArrayList<Comunicação> comunicações;

    public Dispositivo(int n, String mF)
    {
        this.numero = n;
        this.modoFuncionamento = mF;
        this.comunicações = new ArrayList<>();
    }
    
    public int getNumeroDispositivo()
    {
        return this.numero;
    }
    
    public String getModoFuncionamento()
    {
        return this.modoFuncionamento;
    }
    
     public ArrayList <Comunicação> getComunicações()
    {
        return this.comunicações;
    }
    
    public void addComunicações(Comunicação com) 
    {
        this.comunicações.add(com);
    }

    
    public void visualizarComunicação()
    {
        for(Comunicação com : this.comunicações)
        {
            System.out.println(com);
        }
    }
    
        public boolean criarComunicação(Dispositivo dispositivoOrigem, Dispositivo dispositivoDestino, Comunicação com) {
        String modo5G = "5G";
        String modo4G = "4G";
        
        if (com instanceof Download || com instanceof ChamadaVideo) {
            if (dispositivoOrigem.getModoFuncionamento().equals(modo5G) && dispositivoDestino.getModoFuncionamento().equals(modo5G)) {
                System.out.println("Comunicação realizada em 5G entre " + dispositivoOrigem.getNumeroDispositivo() + " e " + dispositivoDestino.getNumeroDispositivo());
                this.comunicações.add(com);
                return true;
            } 
            else 
            {
                System.out.println("A comunicação de download requer dispositivos em modo 5G.");
                return false;
            }
        } else {
            if (dispositivoOrigem.getModoFuncionamento().equals(modo4G) && dispositivoDestino.getModoFuncionamento().equals(modo4G)) {
                System.out.println("Comunicação realizada em 4G entre " + dispositivoOrigem.getNumeroDispositivo() + " e " + dispositivoDestino.getNumeroDispositivo());
                this.comunicações.add(com);
                return true;
            } 
            
            else if(dispositivoOrigem.getModoFuncionamento().equals(modo5G) && dispositivoDestino.getModoFuncionamento().equals(modo4G) || dispositivoOrigem.getModoFuncionamento().equals(modo4G) && dispositivoDestino.getModoFuncionamento().equals(modo5G))
            {
                System.out.println("Comunicação realizada entre " + dispositivoOrigem.getNumeroDispositivo() + " e " + dispositivoDestino.getNumeroDispositivo());
                this.comunicações.add(com);
                return true;
            }
            else {
                System.out.println("A comunicação não é possível ser realizada.");
                return false;
            }
        }
    }
    
    public ArrayList<Comunicação> listaComunicaçõesEnviadas(int numeroDispositivo)
    {
        ArrayList<Comunicação> temp = new ArrayList<>();
        
         for(Comunicação com : this.comunicações)
         {
            if(com.getOrigem() == numeroDispositivo)
            {
                temp.add(com);
            }
            
         }
        
        
        return temp;
    }
    
    public void visualizarComunicacoesEnviadas(int numeroDispositivo) {
        ArrayList<Comunicação> temp = listaComunicaçõesEnviadas(numeroDispositivo);
        if (temp.isEmpty()) {
            System.out.println("Nenhuma comunicação enviada pelo dispositivo.");
        } else {
            System.out.println("Comunicações Enviadas pelo Dispositivo:");
            for (Comunicação com : temp) {
                System.out.println("Tipo de Comunicação: " + com.getClass().getSimpleName());
                System.out.println("Origem: " + com.getOrigem());
                System.out.println("Destino: " + com.getDestino());
                System.out.println("------");
            }
        }
    }
    
    public ArrayList<Comunicação> listaComunicaçõesRecebidas(int numDispositivo)
    {
        ArrayList<Comunicação> temp = new ArrayList<>();
        
        for(Comunicação com : this.comunicações)
        {
            if(com.getDestino() == numDispositivo)
            {
                temp.add(com);
            }
        }
        
        return temp;
    }
    
    public void visualizarComunicacoesRecebidas(int numDispositivo) {
        ArrayList<Comunicação> temp = listaComunicaçõesRecebidas(numDispositivo);
        if (temp.isEmpty()) {
            System.out.println("Nenhuma comunicação recebida pelo dispositivo.");
        } else {
            System.out.println("Comunicações Recebidas pelo Dispositivo:");
            for (Comunicação com : temp) {
                System.out.println("Tipo de Comunicação: " + com.getClass().getSimpleName());
                System.out.println("Origem: " + com.getOrigem());
                System.out.println("Destino: " + com.getDestino());
                System.out.println("------");
            }
        }
    }
    
    public double calcularTotalBytesComunicacoes(double velocidadeTransmissaoByte) {
        double totalBytes = 0.0;

        for (Comunicação com : this.comunicações) {
            if (com instanceof Download) {
                totalBytes += ((Download) com).getTamanhoBytesDownload();
            } else if (com instanceof ChamadaVideo) {
                totalBytes += velocidadeTransmissaoByte * ((ChamadaVideo) com).getDurCV();
            } else if (com instanceof MensagemVideo) {
                totalBytes += velocidadeTransmissaoByte * ((MensagemVideo) com).getDuraçãoMensagemVideo();
            }
        }

        return totalBytes;
    }

    
    



    public abstract Dispositivo clone();
    
    

}
