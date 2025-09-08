public record Vestuario(double valor) implements Produto {

    @Override
    public double calcular() {
        return valor * (2.5 / 100);
    }

}
