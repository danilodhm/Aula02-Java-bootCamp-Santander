package services;

import java.util.Scanner;

import valid.validateService;

public class saque {

    private final static Scanner scanner = new Scanner(System.in);
    
    public static void sacar(){
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextLong();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não localizado!");
            return;
        }
        var saque = validateService.validValor();
        
        var mysaldo = myconta.getSaldoConta();
        if(mysaldo < saque){
            var usoChequeEspecial = validateService.validSaldoChequeEspecial(myconta.getUsoChequeEspecial(), myconta.getLimitChequeEspecial());
            var saldoExtra = mysaldo + usoChequeEspecial;
            if(saldoExtra < saque){
                System.out.println("Saldo insuficiente.");
                var totalLiberadoCheque = validateService.validSaldoChequeEspecial(myconta.getUsoChequeEspecial(), myconta.getLimitChequeEspecial());
                var total = myconta.getSaldoConta() + totalLiberadoCheque;
                System.out.println("Seu saldo atual: " + myconta.getSaldoConta() + "+" + totalLiberadoCheque + "(Cheque especial) = " + String.format("%.2f", total) + ".");
                return;
            }

            System.out.println("Seu saldo é abaixo do valor de saque, deseja usar o cheque especial? (S/N)");
            var accept = validateService.acceptTermo();
            if (!accept){
                return;
            }

            var valorUtlizado = mysaldo - saque;
            valorUtlizado = Math.abs(valorUtlizado);
            var getUsoCheque = myconta.getUsoChequeEspecial();
            valorUtlizado = valorUtlizado + Math.abs(getUsoCheque);
            myconta.setUsoChequeEspecial(valorUtlizado);
            System.out.println("Seu saque de " + saque + " foi realizado com sucesso.");
            myconta.setSaldoConta(0);
            return;
        }
        var total = mysaldo - saque;
        System.out.println("Seu saque de " + saque + " foi realizado com sucesso.");
        myconta.setSaldoConta(total);
    }

}
