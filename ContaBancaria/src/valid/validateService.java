package valid;

import java.util.ArrayList;
import java.util.Scanner;
import model.Conta;

public class validateService {

    private final static Scanner scanner = new Scanner(System.in);
    private static Double taxaBonusChequeEspecial = 500.0;
    
    public static ArrayList<Conta> contasCadastradas = new ArrayList<>();
    

    public static Conta validConta(Integer cpf){
        for(Conta myconta: contasCadastradas){
            if (myconta.getCpf() == cpf) {
                return myconta;
            }
        }
        return null;
    }

    public static Double validDeposito(){
        System.out.println("Digite o valor para deposito:");
        var valor = scanner.nextDouble();
        if(valor < 0){
            System.out.println("O valor não pode ser negativo.");
            return null;
        }
        return valor;
    }

    public static double validSaldo() {
        System.out.println("Digite o quanto deseja depositar:");
        var saldo = scanner.nextDouble();
        if(saldo < 0){
            System.out.println("Não é permitido valores negativos.");
            return validSaldo();
        }
        return saldo;
    }
    
    public static int validCpf(){
        System.out.println("Digite seu cpf:");
        var cpf = scanner.nextInt();
        System.out.println("Digite novamente seu cpf:");
        var cpf2 = scanner.nextInt();
        if(cpf != cpf2){
            System.out.println("O Cpf digitado não são iguais.");
            return validCpf();
        }
        return cpf;
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
