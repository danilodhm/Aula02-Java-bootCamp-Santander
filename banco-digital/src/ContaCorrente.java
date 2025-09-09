import java.time.LocalDate;

public class ContaCorrente extends Conta {

    private static final double LIMITE_DIARIO = 500.0; // limite de saque por dia
    private double totalSacadoHoje = 0;
    private LocalDate ultimaData = LocalDate.now();

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        LocalDate hoje = LocalDate.now();

        // Se mudou o dia, reseta o total sacado
        if (!hoje.equals(ultimaData)) {
            totalSacadoHoje = 0;
            ultimaData = hoje;
        }

        // Verifica o limite
        if (totalSacadoHoje + valor > LIMITE_DIARIO) {
            System.out.println("❌ Saque negado. Limite diário de R$ " + LIMITE_DIARIO + " atingido.");
        } else {
            super.sacar(valor);
            totalSacadoHoje += valor;
            System.out.println("✅ Saque realizado de R$ " + valor + ". Total sacado hoje: R$ " + totalSacadoHoje);
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtratoDetalhado();
    }
}
