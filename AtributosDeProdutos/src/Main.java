public class Main {
    public static void main(String[] args) throws Exception {
        
        do{
            System.out.println("Sistema de Cálculo de Impostos");
            System.out.println("1. Alimentação");
            System.out.println("2. Saúde e Bem-Estar");
            System.out.println("3. Vestuário");
            System.out.println("4. Cultura");
            System.out.println("5. Sair");

            int opcao = Integer.parseInt(System.console().readLine("Escolha uma opção: "));
            if (opcao == 5) {
                System.out.println("Saindo do sistema...");
                break;
            }

            double valor = Double.parseDouble(System.console().readLine("Digite o valor do produto: "));

            Produto imposto = switch (opcao) {
                case 1 -> new Alimentacao(valor);
                case 2 -> new SaudeBemEstar(valor);
                case 3 -> new Vestuario(valor);
                case 4 -> new Cultura(valor);
                default -> throw new IllegalArgumentException("Opção inválida.");
            };

            double resultado = imposto.calcular();
            System.out.printf("O imposto calculado é: %.2f%n", resultado);
        }while (true);
    }
}
