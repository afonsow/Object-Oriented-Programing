import java.util.*;

public class TouChim 
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private ArrayList<Cliente> listaClientes;

    public TouChim()
    {
        this.listaClientes = new ArrayList <Cliente> ();
    }

    
    public ArrayList <Cliente> getListaClientes()
    {
        return this.listaClientes;
    }
    
    public void addCliente(int numeroCliente, String nomeCliente)
    {
        Cliente novoCliente = new Cliente(numeroCliente, nomeCliente);
        this.listaClientes.add(novoCliente);
        System.out.println("Cliente adicionado com sucesso!");
    }
    
    public void verListaClientes()
    {
        for(Cliente c : this.listaClientes)
        {
            System.out.println("Código: " + c.getCodigoCliente() + " Nome: " +c.getNomeCliente());
        }
    }
    
    public Cliente encontrarClientePorCodigo(int codigoCliente) {
        for (Cliente cliente : this.listaClientes) {
            if (cliente.getCodigoCliente() == codigoCliente) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public void adicionarContaCliente(int numeroConta, int codigoCliente) {

        // Adicionar conta ao cliente escolhido
        Cliente clienteEncontrado = this.encontrarClientePorCodigo(codigoCliente);

        if (clienteEncontrado != null) {
            Conta novaConta = new Conta(numeroConta);
            clienteEncontrado.addContas(novaConta);
            System.out.println("Conta adicionada com sucesso para o cliente " + clienteEncontrado.getNomeCliente());
        } else {
            System.out.println("Cliente não encontrado.");
        }

    }
    
     public ArrayList<Conta> listarContasCliente(int numeroCliente) 
    {
      ArrayList<Conta> contasAssociadas = new ArrayList<>();

      for (Cliente cli : this.listaClientes) {
        if (cli.getCodigoCliente()== numeroCliente) {
            for (Conta conta : cli.getContas()) {
                contasAssociadas.add(conta);
            }
        }
      }

      return contasAssociadas;
    }
    
     public void visualizarContasAssociadas(int numeroCliente) {
        ArrayList<Conta> contasAssociadas = this.listarContasCliente(numeroCliente);

        if (contasAssociadas.isEmpty()) {
            System.out.println("Cliente não tem contas associadas ou não existe.");
        } else {
            System.out.println("Contas associadas ao cliente de número " + numeroCliente + ":");

            for (Conta conta : contasAssociadas) {
                System.out.println("Número da Conta: " + conta.getCodigoConta());
                System.out.println("------");
            }
        }
    }
    
     public Conta encontrarContaPorNumero(int numeroConta) {
      for (Cliente cliente : this.listaClientes) {
        for (Conta conta : cliente.getContas()) {
            if (conta.getCodigoConta() == numeroConta) {
                return conta;
            }
        }
      }
      return null; // Retorna null se a conta não for encontrada
    }
    
    public void associarDispositivoAConta(Dispositivo dispositivo, int numeroConta) {
        // Encontrar a conta com o número especificado
        Conta contaEncontrada = this.encontrarContaPorNumero(numeroConta);
    
        if (contaEncontrada != null) {
            // Chamar o método addDispositivos para realizar a verificação
            contaEncontrada.addDispositivos(dispositivo);
        } else {
            System.out.println("Conta não encontrada.");
        }
        
        if(dispositivo.getModoFuncionamento().equals("5G") || dispositivo.getModoFuncionamento().equals("4G"))
        {
            if (dispositivo instanceof Tablet) {
                System.out.println("Dispositivo associado do tipo: Tablet");
            } else if (dispositivo instanceof Telemóveis) {
                System.out.println("Dispositivo associado do tipo: Telemoveis");
            } else if (dispositivo instanceof Oldies && dispositivo.getModoFuncionamento().equals("5G")) {
                System.out.println("Não é possivel adicionar o dispositivo");
            } else if (dispositivo instanceof Oldies) {
                System.out.println("Dispositivo associado do tipo: Oldies");
            }
        }
        
        else
        {
            System.out.println("Não é possivel adicionar o dispositivo.");
        }
            
        
    }

    
    public void visualizarListaDispositivos(int numeroConta) 
    {
        Conta contaEncontrada = this.encontrarContaPorNumero(numeroConta);
    
        if (contaEncontrada != null) {
            contaEncontrada.visualizarListaDispositivos(numeroConta);
        } else {
            System.out.println("Conta não encontrada.");
        }
   }

   public void listarDispositivos5G(int numeroConta) 
   {
        Conta contaEncontrada = this.encontrarContaPorNumero(numeroConta);
    
        if (contaEncontrada != null) {
            contaEncontrada.listarDispositivos5G(numeroConta);
        } else {
            System.out.println("Conta não encontrada.");
        }
   }
   
      public Dispositivo encontrarDispositivoPorNumero(int numeroDispositivo) 
    {
       for(Cliente cliente : this.listaClientes)
       {
           for(Conta conta : cliente.getContas())
           {
               for(Dispositivo dispositivo : conta.getDispositivos())
               {
                   if(dispositivo.getNumeroDispositivo() == numeroDispositivo)
                   {
                       return dispositivo;
                   }
               }
           }
       }
    
       return null;  // Retorna null se o dispositivo não for encontrado
    }
    
       public void realizarComunicacaoEntreDoisDispositivos(int numeroDispositivo1, int numeroDispositivo2, Comunicação com) {
        Dispositivo dispositivoOrigem = encontrarDispositivoPorNumero(numeroDispositivo1);
        Dispositivo dispositivoDestino = encontrarDispositivoPorNumero(numeroDispositivo2);
    
        if (dispositivoOrigem != null && dispositivoDestino != null) {
            dispositivoOrigem.criarComunicação(dispositivoOrigem, dispositivoDestino, com);
            dispositivoDestino.criarComunicação(dispositivoOrigem,dispositivoDestino, com);
        } else {
            System.out.println("Dispositivos não encontrados.");
        }
    }

   
   public void visualizarComunicacoesEnviadasPorDispositivo(int numeroDispositivo) {
        Dispositivo dispositivo = this.encontrarDispositivoPorNumero(numeroDispositivo);
    
        if (dispositivo == null) {
            System.out.println("Dispositivo não encontrado.");
        } else {
            dispositivo.visualizarComunicacoesEnviadas(numeroDispositivo);
        }
   }
   
   public void visualizarComunicacoesRecebidasPorDispositivo(int numDispositivo) {
        Dispositivo dispositivo = this.encontrarDispositivoPorNumero(numDispositivo);
    
        if (dispositivo == null) {
            System.out.println("Dispositivo não encontrado.");
        } else {
            dispositivo.visualizarComunicacoesRecebidas(numDispositivo);
        }
    }
    
    
    
      public void emitirFaturaDetalhada(double taxaIva, int codigoConta) {
        boolean contaEncontrada = false;
    
        for (Cliente cli : this.listaClientes) {
            for (Conta conta : cli.getContas()) {
                if (conta.getCodigoConta() == codigoConta) {
                    contaEncontrada = true;
                    System.out.println("Fatura para Conta Número: " + codigoConta);
    
                    for (Dispositivo dispositivo : conta.getDispositivos()) {
                        System.out.println("Fatura para Dispositivo " + dispositivo.getNumeroDispositivo() + ":");
    
                        double totalDispositivo = 0.0;
    
                        for (Comunicação com : dispositivo.listaComunicaçõesEnviadas(dispositivo.getNumeroDispositivo())) {
                            double custoComunicacao = com.calcularPreco();
    
                            // Adicionar o custo ao total do dispositivo
                            totalDispositivo += custoComunicacao;
    
                            // Exibir detalhes da comunicação na fatura
                            System.out.println("Tipo de Comunicação: " + com.getClass().getSimpleName());
                            System.out.println("Custo: " + custoComunicacao);
                        }
    
                        // Exibir total do dispositivo
                        System.out.println("Total para Dispositivo " + dispositivo.getNumeroDispositivo() + ": " + totalDispositivo);
                        System.out.println("------");
                    }
                }
            }
        }
    
        if (!contaEncontrada) {
            System.out.println("Conta não encontrada.");
        }
    }
    
    private ArrayList<Comunicação> buscarComunicacoesEntreDispositivos(Dispositivo dispositivoOrigem, Dispositivo dispositivoDestino) {
        ArrayList<Comunicação> comunicacoes = new ArrayList<>();
    
        for (Comunicação com : dispositivoOrigem.getComunicações()) {
            int origem = com.getOrigem();
            int destino = com.getDestino();
    
            if (destino == dispositivoDestino.getNumeroDispositivo()) {
                comunicacoes.add(com);
            }
        }
    
        return comunicacoes;
    }


    
        public ArrayList<Comunicação> []comunicaçõesEntreDoisDispositivos(int numeroDispositivo1, int numeroDispositivo2) {
        Dispositivo dispositivoOrigem = encontrarDispositivoPorNumero(numeroDispositivo1);
        Dispositivo dispositivoDestino = encontrarDispositivoPorNumero(numeroDispositivo2);
        
        ArrayList<Comunicação> comunicacoesDePara = new ArrayList<>();
        ArrayList<Comunicação> comunicacoesParaDe = new ArrayList<>();
        
        ArrayList<Comunicação> resultados[] = new ArrayList[2];
    
        if (dispositivoOrigem != null && dispositivoDestino != null) {
            comunicacoesDePara = buscarComunicacoesEntreDispositivos(dispositivoOrigem, dispositivoDestino);
            comunicacoesParaDe = buscarComunicacoesEntreDispositivos(dispositivoDestino, dispositivoOrigem);
        } else {
            System.out.println("Dispositivos não encontrados.");
        }
        
         resultados[0] = comunicacoesDePara;
         resultados[1] = comunicacoesParaDe;
    
        return resultados;
    }
    
    
    public void visualizarComunicacoesEntreDoisDispositivos(int numeroDispositivo1, int numeroDispositivo2) {
        ArrayList<Comunicação>[] resultados = comunicaçõesEntreDoisDispositivos(numeroDispositivo1, numeroDispositivo2);
        System.out.println("Comunicações de Dispositivo " + numeroDispositivo1 + " para " + numeroDispositivo2 + ":");
        for (Comunicação com : resultados[0]) {
            System.out.println("Tipo de Comunicação: " + com.getClass().getSimpleName());
            System.out.println("Origem: " + com.getOrigem());
            System.out.println("Destino: " + com.getDestino());
            System.out.println("------");
        }

        System.out.println("Comunicações de Dispositivo " + numeroDispositivo2 + " para " + numeroDispositivo1 + ":");
        for (Comunicação com : resultados[1]) {
            System.out.println("Tipo de Comunicação: " + com.getClass().getSimpleName());
            System.out.println("Origem: " + com.getOrigem());
            System.out.println("Destino: " + com.getDestino());
            System.out.println("------");
        }
    }

    

    
    public ArrayList<Comunicação> listaVelocidadeTransmissaoByte(double velocidadeTransmissaoByte)
    {
        ArrayList<Comunicação> temp = new ArrayList<>();
        double totalBytes = 0.0;
       
          for(Cliente cli : this.listaClientes)
        {
            for(Conta conta : cli.getContas())
            {
                for(Dispositivo dispositivo : conta.getDispositivos())
                {
                    for(Comunicação com : dispositivo.getComunicações())
                    {
                        
                        if(com instanceof Download)
                        {
                           System.out.println();
                           double bytesDownload = ((Download) com).getTamanhoBytesDownload();
                           temp.add(com);
                           System.out.println("Total de Bytes Download: " + bytesDownload);
                           System.out.println();
                        }
                        
                        else if(com instanceof ChamadaVideo)
                        {
                            System.out.println();
                            double bytesChamadaVideo = velocidadeTransmissaoByte * ((ChamadaVideo) com).getDurCV();
                            temp.add(com);
                            System.out.println("Total de Bytes ChamadaVideo: " + bytesChamadaVideo);
                            System.out.println();
                        }
                        
                        else if(com instanceof MensagemVideo)
                        {
                            System.out.println();
                            double bytesMensagemVideo = velocidadeTransmissaoByte * ((MensagemVideo) com).getDuraçãoMensagemVideo();
                            temp.add(com);
                            System.out.println("Total de Bytes MensagemVideo: " + bytesMensagemVideo);
                            System.out.println();
                        }
                        
                        else
                        {
                            System.out.println("Não é possivel fazer esta operação.");
                        }
                       
        
                    }
                }
            }
        } 
        
        
        return temp;   
    }
    
    
    public void visualizarListaVelocidadeTransmissaoByte(double velocidadeTransmissaoByte, int numeroDispositivo1, int numeroDispositivo2) {
      System.out.println("Comunicação entre Dispositivo " + numeroDispositivo1 + " e Dispositivo " + numeroDispositivo2);
      System.out.println("Velocidade de transmissão: " + velocidadeTransmissaoByte);
    
      ArrayList<Comunicação> comunicacoes = this.listaVelocidadeTransmissaoByte(velocidadeTransmissaoByte);
    
      for (Comunicação com : comunicacoes) {
        System.out.println("Tipo de comunicação: " + com.getClass().getSimpleName());
        System.out.println("------");
      }
   }

  


}

