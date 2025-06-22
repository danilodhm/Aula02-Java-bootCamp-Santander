package services;

import java.util.Scanner;
import valid.validateService;

public class consultas {
    private final static Scanner scanner = new Scanner(System.in);

    public static void ConsultarChequeEspecial() {
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextLong();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não localizado!");
        }
        System.out.println("O total do seu cheque especial: " + myconta.getLimitChequeEspecial() + ".");
    }

    public static void ConsultarUsoChequeEspecial() {
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextLong();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não localizado!");
        }
        if (myconta.getUsoChequeEspecial() == 0.0) {
            System.out.println("Você não está usando o cheque especial.");
            return;            
        }
        System.out.println("Cheque especial em uso: " + myconta.getUsoChequeEspecial());
    }

    public static void ConsultarSaldo() {
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextLong();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não localizado!");
            return;
        }
        var totalLiberadoCheque = validateService.validSaldoChequeEspecial(myconta.getUsoChequeEspecial(), myconta.getLimitChequeEspecial());
        var total = myconta.getSaldoConta() + totalLiberadoCheque;
        System.out.println("Seu saldo atual: " + myconta.getSaldoConta() + "+" + totalLiberadoCheque + "(Cheque especial) = " + String.format("%.2f", total) + ".");
    }
}
