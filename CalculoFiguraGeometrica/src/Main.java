public class Main {
    public static void main(String[] args) throws Exception {
        

        do{
            System.out.println("Calculadora de área de figuras geométricas");
            System.out.println("1. Círculo");
            System.out.println("2. Quadrado");
            System.out.println("3. Retângulo");
            System.out.println("4. Sair");

            int choice = Integer.parseInt(System.console().readLine("Escolha uma opção: "));

            switch (choice) {
                case 1 -> {
                    double radius = Double.parseDouble(System.console().readLine("Digite o raio do círculo: "));
                    Circle circle = new Circle(radius);
                    System.out.printf("Área do círculo: %.2f%n", circle.getArea());
                }
                    
                case 2 -> {
                    int side = Integer.parseInt(System.console().readLine("Digite o lado do quadrado: "));
                    Square square = new Square(side);
                    System.out.printf("Área do quadrado: %.2f%n", square.getArea());
                }
                    
                case 3 -> {
                    double height = Double.parseDouble(System.console().readLine("Digite a altura do retângulo: "));
                    double base = Double.parseDouble(System.console().readLine("Digite a base do retângulo: "));
                    Rectangle rectangle = new Rectangle(height, base);
                    System.out.printf("Área do retângulo: %.2f%n", rectangle.getArea());
                }
                    
                case 4 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
                
            }
        }while (true);


    }
}
