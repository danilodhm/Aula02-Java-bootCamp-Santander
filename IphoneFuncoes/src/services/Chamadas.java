package services;

import java.util.Scanner;

import interfaces.AparelhoTelefonico;

public class Chamadas implements AparelhoTelefonico {

    private static Scanner scanner = new Scanner(System.in);

    public static void menuChamadas(){
        do{
            System.out.println("Menu Chamadas:");
            System.out.println("1. Ligar");
            System.out.println("2. Atender");
            System.out.println("3. Desligar");
            System.out.println("4. Iniciar Correio de Voz");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            Chamadas chamadas = new Chamadas();

            switch(opcao) {
                case 1-> {
                    System.out.print("Digite o número para ligar ");
                    String numero = scanner.next();
                    chamadas.ligar(numero);
                }
                case 2 -> chamadas.atender();
                case 3 -> chamadas.desligar();
                case 4 -> chamadas.iniciarCorreioVoz();
                case 5 -> {System.out.println("Saindo..."); return;}
                default-> System.out.println("Opção inválida, tente novamente.");
            }
        }while (true);
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para " + numero + "...");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo a chamada...");
    }

    @Override
    public void desligar() {
        System.out.println("Desligando a chamada...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz...");
    }

}
