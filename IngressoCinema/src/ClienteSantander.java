public class ClienteSantander extends Ingresso {

    public ClienteSantander(double valor, String nomeFilme, String tipoAudio) {
        super(valor, nomeFilme, tipoAudio);
    }

    @Override
    public double getValorReal() {
        return valor * 0.5;
    }

    @Override
    public void exibirDetalhes(){
        System.out.println("Filme: " + nomeFilme);
        System.out.println("Tipo de Áudio: " + tipoAudio);
        System.out.println("Valor do Ingresso Cliente Santander: R$ " + String.format("%.2f", getValorReal()));
    }

}
