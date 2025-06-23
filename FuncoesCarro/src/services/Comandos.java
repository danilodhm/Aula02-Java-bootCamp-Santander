package services;

import java.util.Scanner;

import model.Carro;

public class Comandos {
    public static Carro carro = new Carro();

    public static void ligarMotor(){
        if (carro.isStatusMotor()){
            System.out.println("Carro já está ligado.");
            return;
        }

        carro.setStatusMotor(true);
        System.out.println("Carro ligado.");
    }

    public static void desligarMotor(){
        if (!carro.isStatusMotor()){
            System.out.println("Carro já está desligado.");
            return;
        }

        if (carro.getMarcha() > 0) {
            System.out.println("Você precisa deixar a marcha no neutro para desligar.");
            return;
        }

        carro.setStatusMotor(false);
        System.out.println("Carro desligado.");
    }
    
    public static void acelerar() {
        if (!carro.isStatusMotor()) {
            System.out.println("O carro precisa estar ligado.");
            return;
        }

        int velocidade = carro.getVelocimetro();
        if (velocidade >= 120) {
            System.out.println("O carro já está na velocidade máxima.");
            return;
        }

        carro.setAcelerandoOuDesacelarando(true);

        int novaVelocidade = velocidade + 1;
        int marchaRecomendada = obterMarchaRecomendada(novaVelocidade);

        if (carro.getMarcha() != marchaRecomendada) {
            System.out.printf("Você precisa engatar a %s marcha.%n", marchaRecomendada);
            return;
        }

        carro.setVelocimetro(novaVelocidade);
        System.out.println("Acelerando... " + novaVelocidade + "Km");
    }

    public static void desacelerar() {
        if (!carro.isStatusMotor()) {
            System.out.println("O carro precisa estar ligado.");
            return;
        }

        int velocidade = carro.getVelocimetro();
        if (velocidade <= 0) {
            System.out.println("O carro já está parado em 0Km.");
            return;
        }

        carro.setAcelerandoOuDesacelarando(false);

        int novaVelocidade = velocidade - 1;
        int marchaRecomendada = obterMarchaRecomendada(novaVelocidade);

        if (carro.getMarcha() != marchaRecomendada) {
            System.out.printf("Você precisa reduzir para a %s marcha.%n", marchaRecomendada);
            return;
        }

        carro.setVelocimetro(novaVelocidade);
        System.out.println("Desacelerando... " + novaVelocidade + "Km");
    }

    private static int obterMarchaRecomendada(int velocidade) {
        if (velocidade == 0) return 1;
        if (velocidade <= 21) return 1;
        if (velocidade <= 41) return 2;
        if (velocidade <= 61) return 3;
        if (velocidade <= 81) return 4;
        if (velocidade <= 101) return 5;
        return 6;
    }

    public static void marcha() {
        if (!carro.isStatusMotor()) {
            System.out.println("O carro precisa estar ligado.");
            return;
        }

        int velocidade = carro.getVelocimetro();
        int novaMarcha = calcularMarcha(velocidade, carro.isAcelerandoOuDesacelarando());

        if (novaMarcha != carro.getMarcha()) {
            carro.setMarcha(novaMarcha);
            if (novaMarcha == 0) {
                System.out.println("Você engatou o neutro.");
            } else if (novaMarcha == -1) {
                System.out.println("Você engatou a ré.");
            } else {
                System.out.printf("Você engatou a %dª marcha.%n", novaMarcha);
            }
        } else {
            System.out.printf("A marcha já está correta: %d.%n", novaMarcha);
        }
    }


    private static int calcularMarcha(int velocidade, boolean acelerando) {
        if (velocidade == 0) {

            if (carro.getMarcha() == -1 || carro.getMarcha() == 1) {
                return 0;
            }
            return 1; 
        }

        if (velocidade <= 20) {
            return acelerando ? 1 : 0;
        } else if (velocidade <= 40) {
            return acelerando ? 2 : 1;
        } else if (velocidade <= 60) {
            return acelerando ? 3 : 2;
        } else if (velocidade <= 80) {
            return acelerando ? 4 : 3;
        } else if (velocidade <= 100) {
            return acelerando ? 5 : 4;
        } else {
            return acelerando ? 6 : 5;
        }
    }

    public static void direcao() {
        if (!carro.isStatusMotor()) {
            System.out.println("O carro precisa estar ligado para manobrar a direção.");
            return;
        }

        System.out.println("Para onde deseja virar?");
        System.out.println("[1] Esquerda");
        System.out.println("[2] Direita");
        System.out.println("[3] Continuar reto");
        System.out.println("[4] Retornar (fazer um retorno)");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Você virou à esquerda.");
                carro.setDirecao("Esquerda");
                break;
            case 2:
                System.out.println("Você virou à direita.");
                carro.setDirecao("Direita");
                break;
            case 3:
                System.out.println("Você seguiu em frente.");
                carro.setDirecao("Reto");
                break;
            case 4:
                System.out.println("Você fez um retorno.");
                carro.setDirecao("Retorno");
                break;
            default:
                System.out.println("Opção inválida. A direção permanece: " + carro.getDirecao());
                break;
        }
        scanner.close();
    }

    
}
