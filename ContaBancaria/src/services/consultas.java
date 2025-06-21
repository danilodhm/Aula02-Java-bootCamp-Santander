package services;

import java.util.Scanner;
import valid.validateService;

public class consultas {
    private final static Scanner scanner = new Scanner(System.in);

    public static void ConsultarChequeEspecial() {
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextInt();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não locaizado!");
        }
        System.out.println("Cheque especial em uso: " + myconta.getUsoChequeEspecial());
        System.out.println("O total do seu cheque especial: " + myconta.getLimitChequeEspecial() + ".");
    }

    public static void ConsultarSaldo() {
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextInt();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não locaizado!");
        }
        var total = myconta.getSaldoConta() + myconta.getLimitChequeEspecial();
        System.out.println("Seu saldo atual: " + myconta.getSaldoConta() + "+" + myconta.getLimitChequeEspecial() + "(Cheque especial) = " + total + ".");
    }
}
