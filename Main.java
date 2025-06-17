import java.util.*;
import java.util.Scanner;

public class Main
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public static void main(String [] args){
        TouChim sistema = new TouChim();
        Scanner scanner = new Scanner(System.in);

      

        int opcao;

        do {
            exibirMenu();
            System.out.println();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            int codigoCliente = 0;
            int numeroConta = 0;
            int numeroDispositivo = 0;
            int numDispositivoOrigem = 0;
            int numDispositivoDestino = 0;
            int numDispositivo1 = 0;
            int numDispositivo2 = 0; 
            

            switch (opcao) {
                case 1:
                    System.out.println();
                    System.out.println("Digite as informações do cliente:");
                    System.out.println();
                    System.out.print("Número do Cliente: ");
                    codigoCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.println();
                    sistema.addCliente(codigoCliente, nomeCliente);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    sistema.verListaClientes();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Adicionar Conta:");
                    System.out.println();
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextInt();
                    System.out.println();
                    System.out.println("Adicione a conta ao cliente que pretende: ");
                    System.out.println();
                    System.out.print("Digite o código do cliente: ");
                    codigoCliente = scanner.nextInt();
                    System.out.println();
                    sistema.adicionarContaCliente(numeroConta, codigoCliente);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.print("Digite o número do cliente: ");
                    codigoCliente = scanner.nextInt();
                    System.out.println();
                    sistema.visualizarContasAssociadas(codigoCliente);
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Adicionar Dispositivo:");
                    System.out.println();
                    System.out.print("Digite o numero do dispositivo:");
                    numeroDispositivo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Modo de Funcionamento: ");
                    String modoFuncionamento = scanner.nextLine();
                    System.out.println();
                    System.out.println("Escolha o tipo de dispositivo:");
                    System.out.println("1. Tablet");
                    System.out.println("2. Telemoveis");
                    System.out.println("3. Oldies");
                    int escolhaTipo = scanner.nextInt();
                    Dispositivo dispositivo;
                    
                    switch (escolhaTipo) {
                  case 1:
                     System.out.println();
                     System.out.print("Digite a capacidade de memoria:");
                     int capacidadeMemoria = scanner.nextInt();
                     dispositivo = new Tablet(numeroDispositivo, modoFuncionamento, capacidadeMemoria);
                     System.out.println();
                     break;
                  case 2:
                     System.out.println();
                     dispositivo = new Telemóveis(numeroDispositivo, modoFuncionamento);
                     System.out.println();
                     break;
                  case 3:
                     System.out.println();
                     dispositivo = new Oldies(numeroDispositivo, modoFuncionamento);
                     System.out.println();
                     break;
                     default:
                     System.out.println();
                     System.out.println("Opção inválida.");
                     System.out.println();
                     return;
                }
                    System.out.println();
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextInt();
                    System.out.println();
                    sistema.associarDispositivoAConta(dispositivo, numeroConta);
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextInt();
                    System.out.println();
                    sistema.visualizarListaDispositivos(numeroConta);
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    System.out.print("Digite o número da conta: ");
                    numeroConta = scanner.nextInt();
                    System.out.println();
                    sistema.listarDispositivos5G(numeroConta);
                    System.out.println();
                    break;
                case 8:
                    System.out.println();
                    System.out.print("Digite o numero do dispositivo de origem:");
                    numDispositivoOrigem = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Digite o numero do dispositivo de destino:");
                    numDispositivoDestino = scanner.nextInt();
                    System.out.println();
                    System.out.println("Escolha o tipo de comunicação:");
                    System.out.println("1. Download");
                    System.out.println("2. MensagemImagem");
                    System.out.println("3. SMS");
                    System.out.println("4. MensagemVideo");
                    System.out.println("5. ChamadaNormal");
                    System.out.println("6. ChamadaVideo");
                    int escolhaTipoComunicação = scanner.nextInt();
                    Comunicação com;

                    switch (escolhaTipoComunicação) {
                  case 1:
                     System.out.println();
                     System.out.print("Digite o tamanho de bytes:");
                     int tamanhoBytes = scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Digite a duração do download:");
                     double duracaoDownload = scanner.nextDouble();
                     System.out.println();
                     com = new Download(numDispositivoOrigem, numDispositivoDestino, 16, tamanhoBytes, duracaoDownload);
                     System.out.println();
                     break;
                  case 2:
                     System.out.println();
                     System.out.print("Digite o tamanho de bytes:");
                     int tamanhoByte = scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Digite o formato de imagem:");
                     String formatoImagem = scanner.nextLine();
                     scanner.nextLine();
                     System.out.print("Digite a resolução da imagem:");
                     int resolucaoImagem = scanner.nextInt();
                     System.out.println();
                     com = new MensagemImagem(numDispositivoOrigem, numDispositivoDestino,22, tamanhoByte, formatoImagem, resolucaoImagem);
                     System.out.println();
                     break;
                  case 3:
                     System.out.println();
                     System.out.print("Digite o tamanho da mensagem:");
                     int tamanhoMensagem = scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Digite o texto:");
                     String texto = scanner.nextLine();
                     System.out.println();
                     com = new SMS(numDispositivoOrigem, numDispositivoDestino,18, tamanhoMensagem, texto);
                     System.out.println();
                     break;
                  case 4:
                     System.out.println();
                     System.out.print("Digite a resolução do video:");
                     int resolucaoVideo = scanner.nextInt();
                     scanner.nextLine();
                     System.out.print("Digite o formato do video:");
                     String formatoVideo = scanner.nextLine();
                     scanner.nextLine();
                     System.out.print("Digite a duração do video:");
                     double duracaoVideo = scanner.nextDouble();
                     System.out.println();
                     com = new MensagemVideo(numDispositivoOrigem, numDispositivoDestino,13, resolucaoVideo, formatoVideo, duracaoVideo);
                     System.out.println();
                     break;
                  case 5:
                     System.out.println();
                     System.out.print("Digite a duração da chamada");
                     double duracaoChamada = scanner.nextDouble();
                     System.out.println();
                     com = new ChamadaNormal(numDispositivoOrigem, numDispositivoDestino,14, duracaoChamada);
                     System.out.println();
                     break;
                  case 6:
                     System.out.print("Digite a duração da chamada de video:");
                     double duracaoChamadaVideo = scanner.nextDouble();
                     scanner.nextLine();
                     System.out.print("Digite a resolução da chamada de video:");
                     int resolucaoChamadaVideo = scanner.nextInt();
                     System.out.println();
                     com = new ChamadaVideo(numDispositivoOrigem, numDispositivoDestino,23, duracaoChamadaVideo, resolucaoChamadaVideo);
                     System.out.println();
                     break;
                     default:
                     System.out.println("Opção inválida.");
                     return;
                }
                    numDispositivo1 = numDispositivoOrigem;
                    numDispositivo2 = numDispositivoDestino;
                    System.out.println();
                    sistema.realizarComunicacaoEntreDoisDispositivos(numDispositivo1, numDispositivo2, com);
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    System.out.print("Digite o número do dispositivo: ");
                    numeroDispositivo = scanner.nextInt();
                    System.out.println();
                    sistema.visualizarComunicacoesEnviadasPorDispositivo(numeroDispositivo);
                    System.out.println();
                    break;
                case 10:
                    System.out.println();
                    System.out.print("Digite o número do dispositivo: ");
                    numeroDispositivo = scanner.nextInt();
                    System.out.println();
                    sistema.visualizarComunicacoesRecebidasPorDispositivo(numeroDispositivo);
                    System.out.println();
                    break;
                case 11:
                    System.out.println();
                    System.out.print("Digite o código da conta:");
                    numeroConta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a taxa do iva:");
                    double taxaIva = scanner.nextDouble();
                    System.out.println();
                    sistema.emitirFaturaDetalhada(taxaIva, numeroConta);
                    System.out.println();
                    break;
                case 12:
                    System.out.println();
                    System.out.print("Digite a velocidade de transmissão em bytes por segundo: ");
                    double velocidadeTransmissaoByte = scanner.nextDouble();
                    System.out.println();

                    System.out.print("Digite o número do primeiro dispositivo: ");
                    numDispositivo1 = scanner.nextInt();

                    System.out.print("Digite o número do segundo dispositivo: ");
                    numDispositivo2 = scanner.nextInt();
                   
                    System.out.println();

                    sistema.visualizarListaVelocidadeTransmissaoByte(velocidadeTransmissaoByte, numDispositivo1, numDispositivo2);
                    System.out.println();
                    break;
                   
                case 13:
                   System.out.println();
                   System.out.print("Digite o número do primeiro dispositivo: ");
                   numDispositivo1 = scanner.nextInt();

                   System.out.print("Digite o número do segundo dispositivo: ");
                   numDispositivo2 = scanner.nextInt();
                   
                   System.out.println();

                   sistema.visualizarComunicacoesEntreDoisDispositivos(numDispositivo1, numDispositivo2);
                   System.out.println();
                   break;
                
                case 14:
                    System.out.println();
                    System.out.println("Terminou o programa");
                    break;
                
                    default:
                     System.out.println();
                     System.out.println("Opção inválida. Tente novamente.");
                     System.out.println();
                     break;
            }

        } while (opcao != 14);
        
        
    
    }
    
    public static void exibirMenu() 
    {
        System.out.println("========== Menu ==========");
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Visualizar lista de Clientes");
        System.out.println("3. Adicionar conta e associar a um cliente");
        System.out.println("4. Visualizar lista de contas associadas a um cliente");
        System.out.println("5. Adicionar Dispositivo a uma conta");
        System.out.println("6. Visualizar lista de dispositivos da conta:");
        System.out.println("7. Visualizar lista de dispositivos 5G:");
        System.out.println("8. Realizar comunicação entre dois dispositivos ");
        System.out.println("9. Visualizar lista de comunicações Enviadas ");
        System.out.println("10. Visualizar lista de comunicações Recebidas ");
        System.out.println("11. Emitir fatura discriminada de uma conta");
        System.out.println("12. Visualizar lista de velocidade de transmissão de bytes");
        System.out.println("13. Visualizar listas de comunicações entre dois dispositivos");
        System.out.println("14. Sair");
    }
}