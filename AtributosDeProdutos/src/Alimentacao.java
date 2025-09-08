public record Alimentacao(double valor) implements Produto {

    @Override
    public double calcular() {
        return valor * (1.0 / 100);
    }

}
