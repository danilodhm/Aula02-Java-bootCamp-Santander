public record Cultura(double valor) implements Produto {

    @Override
    public double calcular() {
        return valor * (4.0 / 100);
    }

}
