import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	// NOVO: adicionar conta
	public void adicionarConta(Conta conta) {
		contas.add(conta);
		System.out.println("Conta adicionada: " + conta.cliente.getNome() + " Nº " + conta.numero);
	}

	// NOVO: remover conta por número
	public void removerConta(int numero) {
		contas.removeIf(c -> c.numero == numero);
		System.out.println("Conta Nº " + numero + " removida.");
	}

	// NOVO: procurar conta por número
	public Conta procurarConta(int numero) {
		for (Conta c : contas) {
			if (c.numero == numero) {
				return c;
			}
		}
		System.out.println("Conta não encontrada: " + numero);
		return null;
	}

	public void relatorioGeral() {
		System.out.println("=== Relatório do Banco " + nome + " ===");
		double total = 0;
		for (Conta c : contas) {
			System.out.println("Cliente: " + c.cliente.getNome() + " | Conta: " + c.numero + " | Saldo: R$ " + c.saldo);
			total += c.saldo;
		}
		System.out.println("Saldo total do banco: R$ " + total);
	}
}
