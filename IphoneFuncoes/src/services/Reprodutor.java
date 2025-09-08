package services;
import java.util.Scanner;

import interfaces.ReprodutorMusical;

public final class Reprodutor implements ReprodutorMusical {
    
    private static Scanner scanner = new Scanner(System.in);
    public static void menuReprodutor() {
        do{
            System.out.println("Menu Reprodutor Musical:");
            System.out.println("1. Tocar Música");
            System.out.println("2. Pausar Música");
            System.out.println("3. Selecionar Música");
            System.out.println("4. Sair");
    
            int opcao = scanner.nextInt();
            Reprodutor reprodutor = new Reprodutor();
            switch (opcao) {
                case 1 -> reprodutor.tocar();
                case 2 -> reprodutor.pausar();
                case 3 -> reprodutor.selecionarMusica();
                case 4 -> {
                    System.out.println("Saindo do Reprodutor Musical...");
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }while(true);
    }

    @Override
    public void tocar() {
        System.out.println("Reproduzindo musica...");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando musica...");
    }

    @Override
    public void selecionarMusica() {
        System.out.print("Digite o nome da música: ");
        String musica = scanner.nextLine();
        System.out.println("Musica selecionada: " + musica);
    }

}
