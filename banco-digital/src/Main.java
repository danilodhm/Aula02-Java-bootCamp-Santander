import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Banco CHAMA♨️");

        while (true) {
            System.out.println("\n=== MENU BANCO " + banco.getNome() + " ===");
            System.out.println("1 - Criar Cliente e Conta Corrente");
            System.out.println("2 - Criar Cliente e Conta Poupança");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Extrato Detalhado");
            System.out.println("7 - Relatório Geral do Banco");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCC = sc.nextLine();
                    Cliente clienteCC = new Cliente();
                    clienteCC.setNome(nomeCC);
                    Conta cc = new ContaCorrente(clienteCC);
                    banco.adicionarConta(cc);
                    break;

                case 2:
                    System.out.print("Nome do cliente: ");
                    String nomeCP = sc.nextLine();
                    Cliente clienteCP = new Cliente();
                    clienteCP.setNome(nomeCP);
                    Conta cp = new ContaPoupanca(clienteCP);
                    banco.adicionarConta(cp);
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    int numDep = sc.nextInt();
                    System.out.print("Valor depósito: ");
                    double valDep = sc.nextDouble();
                    Conta contaDep = banco.procurarConta(numDep);
                    if (contaDep != null) contaDep.depositar(valDep);
                    break;

                case 4:
                    System.out.print("Número da conta: ");
                    int numSaq = sc.nextInt();
                    System.out.print("Valor saque: ");
                    double valSaq = sc.nextDouble();
                    Conta contaSaq = banco.procurarConta(numSaq);
                    if (contaSaq != null) contaSaq.sacar(valSaq);
                    break;

                case 5:
                    System.out.print("Número da conta origem: ");
                    int numOrigem = sc.nextInt();
                    System.out.print("Número da conta destino: ");
                    int numDestino = sc.nextInt();
                    System.out.print("Valor transferência: ");
                    double valTransf = sc.nextDouble();

                    Conta origem = banco.procurarConta(numOrigem);
                    Conta destino = banco.procurarConta(numDestino);

                    if (origem != null && destino != null) {
                        origem.transferir(valTransf, destino);
                    }
                    break;

                case 6:
                    System.out.print("Número da conta: ");
                    int numExtrato = sc.nextInt();
                    Conta contaExtrato = banco.procurarConta(numExtrato);
                    if (contaExtrato != null) contaExtrato.imprimirExtratoDetalhado();
                    break;

                case 7:
                    banco.relatorioGeral();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
