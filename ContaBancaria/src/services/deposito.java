package services;

import java.util.Scanner;

import valid.validateService;

public class deposito {

    private final static Scanner scanner = new Scanner(System.in);

    public static void depositar(){
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextLong();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não localizado!");
            return;
        }
        var deposito = validateService.validValor();
        
        var mysaldo = myconta.getSaldoConta();
        var total = mysaldo + deposito;
        myconta.setSaldoConta(total);
    }

    
}
