import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
    protected List<Transacao> historico;
	

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
        this.historico = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
        historico.add(new Transacao("SAQUE", valor));
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
        historico.add(new Transacao("DEPÓSITO", valor));
		System.out.println("✅ Depósito realizado: R$ " + valor);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
        historico.add(new Transacao("TRANSFERÊNCIA", valor));
	}

    // NOVO MÉTODO
    public void imprimirExtratoDetalhado() {
        System.out.println("=== Extrato Detalhado ===");
		System.out.println("Cliente: " + cliente.getNome());
		System.out.println("Agência: " + agencia);
		System.out.println("Conta: " + numero);

        for (Transacao t : historico) {
            System.out.println(t);
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public static int getAgenciaPadrao() {
        return AGENCIA_PADRAO;
    }

    public static int getSEQUENCIAL() {
        return SEQUENCIAL;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Transacao> getHistorico() {
        return historico;
    }
}
