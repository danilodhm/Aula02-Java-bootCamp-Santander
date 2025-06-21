import java.util.Scanner;

import model.Conta;
import valid.validateService;
import services.consultas;
import services.deposito;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        System.out.println("Seja bem vindo a sua Conta Bancaria.\n");

        var option = -1;

        do {
            System.out.println("====================================");
            System.out.println("0- Cadastrar Conta.");
            System.out.println("1- Consultar Saldo.");
            System.out.println("2- Consultar Cheque Especial.");
            System.out.println("3- Depositar Dinheiro.");
            System.out.println("4- Sacar Dinheiro.");
            System.out.println("5- Pagar Boleto.");
            System.out.println("6- Uso Cheque Especial");
            System.out.println("7- Sair");
            option = scanner.nextInt();
            System.out.println("====================================");
            switch (option) {
                case 0 -> CadastrarConta();
                case 1 -> consultas.ConsultarSaldo();
                case 2 -> consultas.ConsultarChequeEspecial();
                case 3 -> deposito.depositar();
            }

        }while (true);
    }
    
    public static void CadastrarConta(){
        System.out.println(" Sistema de Cadastro de Conta.");
        System.out.println("Digite seu nome:");
        var nome = scanner.next();
        var cpf = validateService.validCpf();
        var saldo = validateService.validSaldo();
        var limitChequeEspecial = validateService.coberturaChequeEspecial(saldo);
        var conta = new Conta();
        conta.setNome(nome);
        conta.setCpf(cpf);
        conta.setSaldoConta(saldo);
        conta.setLimitChequeEspecial(limitChequeEspecial);
        conta.setUsoChequeEspecial(0.0);

        validateService.contasCadastradas.add(conta);

        System.out.println("\n\nConta Cadastrada com sucesso.");
        
    }

}
