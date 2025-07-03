package models.users;

import java.util.Scanner;

import models.Produto;
import services.EditarPerfil;
import services.Functions;
import services.Login;

public class Vendedor extends Usuario {

    private static Scanner scanner = new Scanner(System.in);

    public Vendedor(String nome, String login, String email, String senha, String isCargo) {
        super(nome, login, email, senha, isCargo);
        this.isCargo = "VENDEDOR";
    }

    public static void MenuVendedor() {
        
        do {
            System.out.println("==== Bem-vindo ao menu do Vendedor. ====\n");
            System.out.println("> Usuário: " + Login.getPerfilLogado().getNome());
            System.out.println("> Cargo: " + Login.getPerfilLogado().getIsCargo());
            System.out.println(">Email: " + Login.getPerfilLogado().getEmail());
            System.out.println("\n========================================\n");
            System.out.println("> Relatório de Vendas:");
            CalculoVendas();
            System.out.println();
            System.out.println("\n=========== [Menu Vendedor] ===========\n");
            System.out.println("1- Consultar Minhas Vendas.");
            System.out.println("2- Realizar Venda.");
            System.out.println("3- Alterar Dados.");
            System.out.println("4- Logoff.");

            Integer options = scanner.nextInt();
            switch (options) {
                case 1 -> MyVendas();
                case 2 -> Vender();
                case 3 -> EditarPerfil.MenuEditarPerfil();
                case 4 -> Login.Logoff();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }while (Login.getPerfilLogado() != null && Login.getPerfilLogado().getIsCargo().equals("VENDEDOR"));

    }

    private static void CalculoVendas() {
        Double totalVendas = 0.0;
        Integer quantidade = 0;
        for (Produto produto : Produto.produtos) {
            if (produto.getVendedor().equals(Login.getPerfilLogado().getNome())) {
                quantidade += produto.getQuantidade();
                totalVendas += (produto.getPreco() * produto.getQuantidade()) * 0.4;
            }
        }
        System.out.println("Total de produtos vendidos: " + quantidade);
        System.out.println("Total de vendas comissionadas : R$" + totalVendas);
    }

    private static void MyVendas() {
        Double totalVendas = 0.0;
        Integer quantidade = 0;
        System.out.println("\n============ Minhas Vendas ============\n");
        
        if(Produto.produtos.isEmpty()) {
            System.out.println("Nenhum produto vendido.\n");
            Functions.AperteEnter();
            return;
        }
        for (Produto produto : Produto.produtos) {
            if (produto.getVendedor().equals(Login.getPerfilLogado().getNome())) {
                System.out.println("\n-----------------------------------------");
                System.out.println("Produto: " + produto.getNome() +
                "\nDescrição: " + produto.getDescricao() +
                "\nValor: R$" + produto.getPreco() + 
                "\nQuantidade: " + produto.getQuantidade() +
                "\nData: " + produto.getDataVenda() +
                "\nHora: " + produto.getHoraVenda() +
                "\nVendedor: " + produto.getVendedor());
            }
            totalVendas += (produto.getPreco() * produto.getQuantidade()); 
            quantidade += produto.getQuantidade();
            System.out.println("-----------------------------------------");
        }

        System.out.println("\nTotal de produtos vendidos: " + quantidade);
        System.out.println("Total de vendas: R$" + totalVendas);
        System.out.println("Valor a receber: R$" + (totalVendas * 0.4));
        System.out.println("\n========================================\n");
        Functions.AperteEnter();
    }

    public static void Vender(){
        System.out.println("\n============ Realizando Venda ============\n");
        if(!Atendente.isStatusCaixa()) {
            System.out.println("\n> O caixa está fechado! O Atendente precisa abrir o Caixa para iniciar as vendas.");
            System.out.println("\n========================================\n");
            Functions.AperteEnter();
            return;
        }
        System.out.println("> Informe o produto vendido:");
        System.out.println("> Nome do Produto:");
        String nomeProduto = scanner.next();
        scanner.nextLine();
        System.out.println("> Descrição do Produto e Venda:");
        String descricaoProduto = scanner.nextLine();
        System.out.println("> Valor do Produto:");
        Double valorProduto = scanner.nextDouble();
        System.out.println("> Quantidade há ser vendida:");
        Integer quantidadeProduto = scanner.nextInt();
        String vendedor = Login.getPerfilLogado().getNome();

        Produto.produtos.add(new Produto(nomeProduto, descricaoProduto, valorProduto, quantidadeProduto, vendedor));
        System.out.println("\n> Venda realizada com sucesso!");
        System.out.println("\n========================================\n");
        Functions.AperteEnter();
    }

    @Override
    public String getIsCargo(){
        return isCargo;
    }
}
