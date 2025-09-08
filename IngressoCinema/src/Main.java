public class Main {
    public static void main(String[] args) throws Exception {
   
        Ingresso ingresso = new Ingresso(20.0, "Filme Exemplo", "Dublado");
        MeiaEntrada meiaEntrada = new MeiaEntrada(ingresso.getValorReal(), ingresso.nomeFilme, ingresso.tipoAudio);
        ClienteSantander clienteSantander = new ClienteSantander(ingresso.getValorReal(), ingresso.nomeFilme, ingresso.tipoAudio);
        IngressoFamilia ingressoFamilia = new IngressoFamilia(ingresso.getValorReal(), ingresso.nomeFilme, ingresso.tipoAudio, 5);

        System.out.println("Detalhes do Ingresso:");
        System.out.println("Ingresso normal:");
        ingresso.exibirDetalhes();
        System.out.println();
        System.out.println("Meia Entrada:");
        meiaEntrada.exibirDetalhes();
        System.out.println();
        System.out.println("Cliente Santander:");
        clienteSantander.exibirDetalhes();
        System.out.println();
        System.out.println("Ingresso Família:");
        ingressoFamilia.exibirDetalhes();
        System.out.println();


    }
}
