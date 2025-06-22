package valid;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Conta;

public class validateService {

    private final static Scanner scanner = new Scanner(System.in);
    private static Double taxaBonusChequeEspecial = 500.0;
    
    public static ArrayList<Conta> contasCadastradas = new ArrayList<>();
    

    public static boolean acceptTermo() {
        var termo = scanner.next();

        if (termo.equalsIgnoreCase("N")) {
            return false;
        } else if (termo.equalsIgnoreCase("S")) {
            return true;
        } else {
            System.out.println("Opção inválida!");
            return false;
        }
    }

    public static Double validSaldoChequeEspecial(Double usoChequeEspecial, Double limitChequeEspecial){
        if (usoChequeEspecial >= limitChequeEspecial){
            return 0.0;
        }

        var totalDisponivel = limitChequeEspecial - usoChequeEspecial;
        return totalDisponivel;
    }

    public static Conta validConta(Long cpf){
        for(Conta myconta: contasCadastradas){
            if (myconta.getCpf() == (long) cpf) {
                return myconta;
            }
        }
        return null;
    }

    public static double validValor() {
        System.out.println("Digite o valor:");
        var saldo = scanner.nextDouble();
        if(saldo < 0){
            System.out.println("Não é permitido valores negativos.");
            return validValor();
        }
        return saldo;
    }
    
    public static Long validCpf(){
        try {
            System.out.println("Digite seu cpf:");
            var cpf = scanner.nextLong();
            System.out.println("Digite novamente seu cpf:");
            var cpf2 = scanner.nextLong();
            if(cpf != cpf2){
                System.out.println("O Cpf digitado não são iguais.");
                return validCpf();
            }
            return cpf;
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números para o CPF.");
            scanner.nextLine();
            return validCpf();
        }
    }

    public static Double coberturaChequeEspecial(Double saldo) {
        var bonusLiberado = 50.0;
        if(saldo <= taxaBonusChequeEspecial){
            System.out.println("Seu cheque especial foi definido para: " + bonusLiberado);
            return bonusLiberado;
        }
        bonusLiberado = saldo * 0.5;
        System.out.println("Seu cheque especial foi definido para: " + bonusLiberado);
        return saldo * 0.5;
    }
}
