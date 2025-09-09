package services;

import java.util.Scanner;

import valid.validateService;

public class boleto {
    private final static Scanner scanner = new Scanner(System.in);

    public static void pagar(){
        System.out.println("Digite seu CPF:");
        var cpf = scanner.nextLong();
        var myconta = validateService.validConta(cpf);
        if (myconta == null) {
            System.out.println("CPF não localizado!");
            return;
        }
        var getUsoChequeEspecial = myconta.getUsoChequeEspecial();
        if(getUsoChequeEspecial == 0.0){
            System.out.println("Não há boletos para você pagar.");
            return;
        }

        var faturaTotal = getUsoChequeEspecial + (getUsoChequeEspecial * 0.2);
        System.out.println("Fatura atual: R$" + faturaTotal);
        
        System.out.println("Deseja pagar a fatura para liberar o limite ? (S/N)");
        var accept = validateService.acceptTermo();
        if(!accept){
            return;
        }

        var saldoConta = myconta.getSaldoConta();
        if(faturaTotal > saldoConta){
            System.out.println("Você não tem saldo suficiente.");
            System.out.println("Saldo atual: R$" + saldoConta);
            return;
        }

        var total = saldoConta - faturaTotal;
        myconta.setSaldoConta(total);
        myconta.setUsoChequeEspecial(0);

        var ajustLimitChequeEspecial = validateService.coberturaChequeEspecial(total);
        myconta.setLimitChequeEspecial(ajustLimitChequeEspecial);


        System.out.println("Fatura paga com sucesso.");
        System.out.println("Cheque especial liberado.");
        return;
   
    }
}
