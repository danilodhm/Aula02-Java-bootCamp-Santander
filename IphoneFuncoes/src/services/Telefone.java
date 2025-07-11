package services;

import java.util.Scanner;

import interfaces.NavegarInternet;


public class Telefone implements NavegarInternet {

    private static Scanner scanner = new Scanner(System.in);
    public static String getVideoUrl = "https://www.google.com";

    public static String getGetVideoUrl() {
        return Telefone.getVideoUrl;
    }

    public static void setGetVideoUrl(String getVideoUrl) {
        Telefone.getVideoUrl = getVideoUrl;
    }

    public static void menuTelefone() {
        
        do {
            System.out.println("Menu Navegadador:");
            System.out.println("1. Exibir Página");
            System.out.println("2. Adicionar Aba");
            System.out.println("3. Atualizar Página");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            Telefone telefone = new Telefone();
            switch (opcao) {
                case 1 -> telefone.exibirPagina();
                case 2 -> telefone.adicionarAba();
                case 3 -> telefone.atualizarPagina();
                case 4 -> {
                    System.out.println("Saindo do Navegador...");
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        } while (true);
    }

    @Override
    public void exibirPagina() {
        System.out.print("Digite a URL da página: ");
        String url = scanner.next();
        Telefone.getVideoUrl = url;
        if (!NavegadorInternet.isStarted()) {
            new Thread(() -> NavegadorInternet.addNewTab(url)).start();
            try { Thread.sleep(1000); } catch (InterruptedException e) {} // Dá tempo para o JavaFX iniciar
        }
        
        System.out.println("Exibindo página: " + url);
    }

    @Override
    public void adicionarAba() {
        System.out.println("Aba adicionada com sucesso.");
        this.exibirPagina();
    }

    @Override
    public void atualizarPagina() {
        System.out.print("Deseja inserir uma nova URL? Apenas digite: ");
        String url = scanner.next();
        NavegadorInternet.atualizarAbaSelecionada(url);
    }


}
