public class IngressoFamilia extends Ingresso {
    private int qtPessoas;

    public IngressoFamilia(double valor, String nomeFilme, String tipoAudio, int qtPessoas) {
        super(valor, nomeFilme, tipoAudio);
        this.qtPessoas = qtPessoas;
    }

    @Override
    public double getValorReal() {
        double valorFamilia = super.getValorReal();
        if (qtPessoas >= 3) {
            valorFamilia = (valorFamilia * qtPessoas) - (valorFamilia * 0.05);
            return valorFamilia;
        }
        valorFamilia = valorFamilia * qtPessoas;
        return valorFamilia;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Quantidade de Pessoas: " + qtPessoas);
        System.out.println("Valor do Ingresso Família: R$ " + String.format("%.2f", getValorReal()));
    }

}
