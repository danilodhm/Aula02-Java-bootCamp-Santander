public class ContaPoupanca extends Conta {

    private static final double TAXA_RENDIMENTO = 0.01; // 1% ao aplicar

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void aplicarRendimento() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        historico.add(new Transacao("RENDIMENTO", rendimento));
        System.out.println("💰 Rendimento aplicado: R$ " + rendimento);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirExtratoDetalhado();
    }
}
