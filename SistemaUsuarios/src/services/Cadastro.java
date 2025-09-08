package services;

import java.util.Scanner;

import models.users.Atendente;
import models.users.Gerente;
import models.users.Usuario;
import models.users.Vendedor;

public class Cadastro {

    private static String nome;
    private static String login;
    private static String email;
    private static String senha;
    private static String isCargo;

    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarUsuario() {
        System.out.println("\n========== CADASTRO DE USUÁRIO ==========\n");
        System.out.println("> Informe o seu Nome Completo:");
        nome = scanner.nextLine();
        System.out.println("> Informe o seu Login:");
        login = scanner.nextLine();
        if(Usuario.usuarios.stream().anyMatch(u -> u.getLogin().equals(login))) {
            System.out.println("Este login já está em uso. Por favor, escolha outro.");
            cadastrarUsuario();
        }
        System.out.println("> Informe o seu Email:");
        email = scanner.nextLine();
        System.out.println("> Informe a sua Senha:");
        senha = scanner.nextLine();
        System.out.println("> Informe novamente a Senha:");
        String senha2 = scanner.nextLine();
        if (!senha.equals(senha2)) {
            System.out.println("As senhas não coincidem. Tente novamente.");
            cadastrarUsuario();
        }
        isCargo = "COMUM";

        
        if (nome == null || login == null || email == null || senha == null) {
            System.out.println("Todos os campos devem ser preenchidos.");
            return;
        }

        geraCadastro();
    }

    public static void cadastrarUsuario(String nome, String login, String email, String senha, String isCargo) {
        Cadastro.nome = nome;
        Cadastro.login = login;
        Cadastro.email = email;
        Cadastro.senha = senha;
        Cadastro.isCargo = isCargo;
        geraCadastro();
    }

    private static void geraCadastro() {
        switch (isCargo) {
            case "GERENTE" -> {
                Usuario.usuarios.add(new Gerente(nome, login, email, senha, isCargo));
                System.out.println("\n>Usuário adminstrador " + nome + " cadastrado com sucesso.");
            }
            case "VENDEDOR" -> {
                Usuario.usuarios.add(new Vendedor(nome, login, email, senha, isCargo));
                System.out.println("\n>Usuário vendedor " + nome + " cadastrado com sucesso.");
            }
            case "ATENDENTE" -> {
                Usuario.usuarios.add(new Atendente(nome, login, email, senha, isCargo));
                System.out.println("\n>Usuário atendente " + nome + " cadastrado com sucesso.");
            }
            case "COMUM" -> {
                Usuario.usuarios.add(new Usuario(nome, login, email, senha, isCargo));
                System.out.println("\n>Usuário " + nome + " cadastrado com sucesso.");
            }
            default -> {
                System.out.println("\n>Cargo inválido. Por favor, escolha entre GERENTE, VENDEDOR, ATENDENTE ou COMUM.");
            }

        }
        System.out.println("\n========================================\n");
    }
}
