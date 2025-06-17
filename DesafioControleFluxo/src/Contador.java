import java.util.Scanner;

import exceptions.ParametrosInvalidosException;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro:");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro:");
		int parametroDois = terminal.nextInt();
		
		try {
			contar(parametroUm, parametroDois);
		}catch (ParametrosInvalidosException ex) {
            System.out.println(ex.getMessage());
		}

        terminal.close();
		
	}

	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {

        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }
		int contagem = parametroDois - parametroUm;
        System.err.println("Realizando a subtração do número: " + parametroDois + " - " + parametroUm + " e o resultado é: " + contagem);
        System.out.println("Iniciando contagem:");
        for (int i = 1; i <= contagem; i++) {
            System.out.println(i);
        }
	}
}