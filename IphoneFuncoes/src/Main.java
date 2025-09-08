import java.util.Scanner;

import services.Reprodutor;
import services.Telefone;
import services.Chamadas;

public class Main  {


        private static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
                do{
                        System.out.println("Bem-vindo ao Iphone Funcoes!");
                        System.out.println("1. Reprodutor Musical");
                        System.out.println("2. Aparelho Telefonico");
                        System.out.println("3. Navegador de Internet");
                        System.out.println("4. Sair");
                        System.out.print("Escolha uma opcao: ");
                        
                        int opcao = scanner.nextInt();
                        
                        switch(opcao) {
                                case 1 -> Reprodutor.menuReprodutor();
                                case 2 -> Chamadas.menuChamadas();
                                case 3 -> Telefone.menuTelefone();
                                case 4 -> System.out.println("Saindo...");
                                default -> System.out.println("Opcao invalida, tente novamente.");
                        }
                }while (true);
        }

}
