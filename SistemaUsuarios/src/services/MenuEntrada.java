package services;

import java.util.Scanner;

public class MenuEntrada {

    private static Scanner scanner = new Scanner(System.in);

    public static void Iniciar(){
        System.out.println("\n==== Seja bem vindo ao Sitema de Vendas! ====\n");
        Integer options = 0;
        do {
            System.out.println("1- Login");
            System.out.println("2- Cadastro");
            System.out.println("3- Sair");
            options = scanner.nextInt();
            switch (options) {
                case 1 -> Login.logar();
                case 2 -> Cadastro.cadastrarUsuario();
                case 3 -> System.exit(0);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        }while (options != 1);
    }
}
