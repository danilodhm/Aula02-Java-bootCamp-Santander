package models.users;

import java.util.Scanner;

import models.ControleDeVendas;
import models.Produto;
import services.EditarPerfil;
import services.Functions;
import services.Login;

public class Atendente extends Usuario {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean StatusCaixa = false;

    
    public Atendente(String nome, String login, String email, String senha, String isCargo) {
        super(nome, login, email, senha, isCargo);
        this.isCargo = "ATENDENTE";
    }
    
    public static void MenuAtendente() {
        
        do{
            System.out.println("\n==== Bem-vindo ao menu do Atendente. ====\n");
            System.out.println("> Usuário: " + Login.getPerfilLogado().getNome());
            System.out.println("> Cargo: " + Login.getPerfilLogado().getIsCargo());
            System.out.println("> Email: " + Login.getPerfilLogado().getEmail());
            System.out.println("\n========================================\n");
            System.out.println("=========== [Menu Atendente] ===========\n");
            System.out.println("1- Receber Pagamento.");
            System.out.println("2- Consultar Vendas.");
            System.out.println("3- Abrir Caixa.");
            System.out.println("4- Fechar Caixa.");
            System.out.println("5- Editar Perfil.");
            System.out.println("6- Logoff.");
            Integer options = scanner.nextInt();
            switch (options) {
                case 1 -> ReceberPagamento();
                case 2 -> ControleDeVendas.ConsultarVendas();
                case 3 -> AbrirCaixa();
                case 4 -> FecharCaixa();
                case 5 -> EditarPerfil.MenuEditarPerfil();
                case 6 -> Login.Logoff();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }while (Login.getPerfilLogado() != null && Login.getPerfilLogado().getIsCargo().equals("ATENDENTE"));        
    }

    private static void AbrirCaixa() {
        System.out.println("\n ============= Status Caixa =============\n");
        if (StatusCaixa) {
            System.out.println("\n> Caixa já está aberto!");
        } else {
            System.out.println("\n> Caixa aberto com sucesso!");
            StatusCaixa = true;
            // Produto.produtos.clear();
        }
        System.out.println("\n========================================\n");
        Functions.AperteEnter();
    }

    private static void FecharCaixa() {
        System.out.println("\n ============= Status Caixa =============\n");
        if (!StatusCaixa) {
            System.out.println("\n> Caixa já está fechado!");
        } else {
            System.out.println("\n> Caixa fechado com sucesso!");
            StatusCaixa = false;
        }
        System.out.println("\n========================================\n");
        Functions.AperteEnter();
    }
    
    private static void ReceberPagamento() {
        System.out.println("\n ============= Pagamentos Recebidos =============\n");
        if (Produto.produtos.isEmpty()) {
            System.out.println("\n> Não há vendas para receber pagamento.\n");
            System.out.println("\n========================================\n");
            Functions.AperteEnter();
            return;
        }
        System.out.println("\n> Pagamento recebido com sucesso!\n");
        System.out.println("> Incio do Caixa: " + Produto.produtos.getFirst().getDataVenda() + " às " + Produto.produtos.getFirst().getHoraVenda());
        System.out.println("> Total recebido: " + ControleDeVendas.calcularTotalVendas());
        System.out.println("> Total pago Comissão : " + ControleDeVendas.calcularTotalComissao());
        System.out.println("> Total de lucro para o Caixa: " + ControleDeVendas.calcularLucroCaixa());
        if (!isStatusCaixa()) {
            System.out.println("> Caixa fechado: " + Produto.produtos.getLast().getDataVenda() + " às " + Produto.produtos.getLast().getHoraVenda());            
        }

        System.out.println("\n========================================\n");
        Functions.AperteEnter();
    }
    
    // Atendente não tem privilégios administrativos
    @Override
    public String getIsCargo() {
        return isCargo;
    }
    
    public static boolean isStatusCaixa() {
        return StatusCaixa;
    }
    
    public static void setStatusCaixa(boolean statusCaixa) {
        StatusCaixa = statusCaixa;
    }
}
