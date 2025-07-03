package models.users;

import java.util.Scanner;

import services.EditarPerfil;
import services.Login;

public class Comum extends Usuario {

    private static Scanner scanner = new Scanner(System.in);

    public Comum(String nome, String login, String email, String senha, String isCargo) {
        super(nome, login, email, senha, isCargo);
        this.isCargo = "COMUM";
    }

    public static void MenuComum() {
        do {
            System.out.println("==== Bem-vindo ao menu do Usuário Comum. ====");
            System.out.println("Usuário: " + Login.getPerfilLogado().getNome());
            System.out.println("Cargo: " + Login.getPerfilLogado().getIsCargo());
            System.out.println("Email: " + Login.getPerfilLogado().getEmail());
            System.out.println("\n========================================\n");
            System.out.println("> Aguarde até que o Gerente aprove sua conta.");
            System.out.println("\n=========== [Menu Comum] ===========\n");
            System.out.println("1- Alterar Dados.");
            System.out.println("2- Logoff.");
            Integer options = scanner.nextInt();
            switch (options) {
                case 1 -> EditarPerfil.MenuEditarPerfil();
                case 2 -> Login.Logoff();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }while (Login.getPerfilLogado() != null && Login.getPerfilLogado().getIsCargo().equals("COMUM"));
            
    }

    @Override
    public String getIsCargo() {
        return isCargo;
    }

}
