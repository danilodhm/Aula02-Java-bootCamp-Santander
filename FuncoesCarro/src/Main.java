import java.util.InputMismatchException;
import java.util.Scanner;
import services.Comandos;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        System.out.println("Iniciando sistema do veiculo.");

        StartMenu();
    }

    private static void StartMenu() {

        try {
            var options = -1;

            do {
                System.out.println("=====================================");
                System.out.println("1- Ligar carro.");
                System.out.println("2- Desligar carro.");
                System.out.println("3- Acelerar.");
                System.out.println("4- Reduzir.");
                System.out.println("5- Direcao.");
                System.out.println("6- Trocar marcha.");
                System.out.println("7- Velocidade atual.");
                System.out.println("0 - Sair.");
                options = scanner.nextInt();
                System.out.println("=====================================");
                switch (options) {
                    case 0 -> System.exit(0);
                    case 1 -> Comandos.ligarMotor();
                    case 2 -> Comandos.desligarMotor();
                    case 3 -> Comandos.acelerar();
                    case 4 -> Comandos.desacelerar();
                    case 5 -> Comandos.direcao();
                    case 6 -> Comandos.marcha();
                    case 7 -> {
                        System.out.println("Velocidade atual é: "+Comandos.carro.getVelocimetro()+"Km.");
                    }
                    default -> {
                        System.out.println("Valor invalido.");
                    }
                        
                }

            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números para acessar o menu.");
            scanner.nextLine();
            StartMenu();
        }
    }
}
