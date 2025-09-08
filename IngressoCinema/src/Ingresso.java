public class Ingresso {


    protected double valor;
    protected String nomeFilme;
    protected String tipoAudio; // "Dublado" ou "Legendado"

    public Ingresso(double valor, String nomeFilme, String tipoAudio) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.tipoAudio = tipoAudio;
    }

    public double getValorReal() {
        return valor;
    }

    public void exibirDetalhes() {
        System.out.println("Filme: " + nomeFilme);
        System.out.println("Tipo de Áudio: " + tipoAudio);
        System.out.println("Valor do Ingresso: R$ " + String.format("%.2f", getValorReal()));
    }

    

}
