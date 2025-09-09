package services;
import java.util.Scanner;

import models.Produto;

public class EditarPerfil {

    private static Scanner scanner = new Scanner(System.in);
    
    public static void MenuEditarPerfil() {
        System.out.println("==== Bem-vindo ao menu de edição de perfil. ====");
        System.out.println();
        System.out.println("1. Editar nome");
        System.out.println("2. Editar email");
        System.out.println("3. Editar senha");
        System.out.println("4. Voltar ao menu principal");

        int option = scanner.nextInt();
        switch (option) {
            case 1 -> getNovoNome();
            case 2 -> getNovoEmail();
            case 3 -> getNovaSenha();
            case 4 -> {
                System.out.println("\n> Voltando ao menu principal...");
                return;
            }

        }

        System.out.println();
        System.out.println("===========================================");
    }

    
    private static void getNovoNome() {
        System.out.println("> Digite o novo nome:");
        scanner.nextLine(); 
        String novoNome = scanner.nextLine();
        Produto.produtos.forEach(produto -> {
            if (produto.getVendedor().equals(Login.getPerfilLogado().getNome())) {
                produto.setVendedor(novoNome);
            }
        });
        Login.getPerfilLogado().setNome(novoNome);
        System.out.println("\n> Nome atualizado para: " + novoNome);
    }
    
    private static void getNovoEmail() {
        System.out.println("> Digite o novo Email:");
        String novoEmail = scanner.next();
        Login.getPerfilLogado().setEmail(novoEmail);
        System.out.println("\n> Email atualizado para: " + novoEmail);
    }
    
    private static void getNovaSenha() {
        System.out.println("> Senha atual:");
        String atualSenha = scanner.next();
        if (!Login.getPerfilLogado().getSenha().equals(atualSenha)) {
            System.out.println("\n> Senha atual incorreta. Tente novamente.");
            getNovaSenha();
            return;
        }
        System.out.println("> Digite a nova senha:");
        String novaSenha = scanner.next();
        System.out.println("> Digite a senha novamente senha:");
        String RepetirSenha = scanner.next();
        if (!novaSenha.equals(RepetirSenha)) {
            System.out.println("\n> As senhas não coincidem. Tente novamente.");
            getNovaSenha();
            return;
        }
        Login.getPerfilLogado().setSenha(novaSenha);
        System.out.println("\n> Senha atualizada com sucesso!");
    }

}
