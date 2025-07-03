public record SaudeBemEstar(double valor) implements Produto {

    @Override
    public double calcular() {
        return valor * (1.5 / 100);
    }

}
