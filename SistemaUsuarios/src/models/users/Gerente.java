package models.users;
import services.EditarPerfil;
import services.Functions;
import services.Login;
import models.ControleDeVendas;

import java.util.Scanner;


public class Gerente extends Usuario {
    
    private static Scanner scanner = new Scanner(System.in);
    public Gerente(String nome, String login, String email, String senha, String isCargo) {
        super(nome, login, email, senha, isCargo);
        this.isCargo = "GERENTE";
    }

    

    public static void MenuGerente(){
        do{
            System.out.println("==== Bem-vindo ao menu do Gerente. ====\n");
            System.out.println("Usuário: " + Login.getPerfilLogado().getNome());
            System.out.println("Cargo: " + Login.getPerfilLogado().getIsCargo());
            System.out.println("Email: " + Login.getPerfilLogado().getEmail());
            System.out.println("\n========================================");

            System.out.println();
            System.out.println("=========== [Menu Gerente] ============\n");
            System.out.println("1- Gerar Relatório.");
            System.out.println("2- Consultar Vendas.");
            System.out.println("3- Alterar Dados.");
            System.out.println("4- Alterar Cargo.");
            System.out.println("5- Logoff.");
            
            Integer options = scanner.nextInt();
            switch (options) {
                case 1 -> ControleDeVendas.GerarRelatorioFinanceiro();
                case 2 -> ControleDeVendas.ConsultarVendas();
                case 3 -> EditarPerfil.MenuEditarPerfil();
                case 4 -> AlterarCargo();
                case 5 -> Login.Logoff();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        }while (Login.getPerfilLogado() != null && Login.getPerfilLogado().getIsCargo().equals("GERENTE"));

    }

    public static void AlterarCargo() {
        System.out.println("\n==== Alterar Cargo de Usuário ====\n");
        System.out.println("Informe o login do usuário:");
        String login = scanner.next();
        Usuario usuario = Usuario.getLogin(login);
        
        if (usuario != null) {
            System.out.println("Usuário " + usuario.getNome() + " encontrado.");
            System.out.println("Informe o novo cargo (GERENTE, VENDEDOR, ATENDENTE, COMUM):");
            String novoCargo = scanner.next().toUpperCase();
            usuario.setIsCargo(novoCargo);
            System.out.println("Cargo alterado com sucesso para: " + novoCargo);
        } else {
            System.out.println("Usuário não encontrado.");
        }
        System.out.println("\n========================================\n");
        Functions.AperteEnter();
    }

    @Override
    public String getIsCargo() {
        return isCargo;
    }

}
