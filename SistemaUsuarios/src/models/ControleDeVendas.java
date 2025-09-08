package models;

import services.Functions;

public class ControleDeVendas {
    
    public static void ConsultarVendas(){
        System.out.println("\n============ Consulta de Vendas ============\n");
        if(Produto.produtos.isEmpty()) {
            System.out.println("Nenhum produto vendido até o momento.");
            System.out.println("\n============================================\n");
            Functions.AperteEnter();
            return;
        }
        for (Produto produto : Produto.produtos) {
            System.out.println("--------------------------------------------");
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Valor: R$" + produto.getPreco());
            System.out.println("Quantidade vendida: " + produto.getQuantidade());
            System.out.println("Data: " + produto.getDataVenda());
            System.out.println("Hora: " + produto.getHoraVenda());
            System.out.println("Vendedor: " + produto.getVendedor());
            System.out.println("--------------------------------------------\n");
        }
        System.out.println("\n================================================\n");   
        Functions.AperteEnter();
    }

    public static void GerarRelatorioFinanceiro() {
        System.out.println("\n============ Relatório Financeiro ============\n");
        if(Produto.produtos.isEmpty()) {
            System.out.println("Nenhum produto vendido até o momento.");
            System.out.println("\n============================================\n");
            Functions.AperteEnter();
            return;
        }
        System.out.println("Total de vendas: R$" + calcularTotalVendas());
        System.out.println("Total de produtos vendidos: " + calcularTotalProdutosVendidos());
        System.out.println("Total pago aos vendedores: R$" + calcularTotalComissao());
        System.out.println("Total de lucro para o Caixa: R$" + calcularLucroCaixa());
        System.out.println("\n================================================\n");
        Functions.AperteEnter();
    }
    
    public static double calcularTotalVendas() {
        double total = 0.0;
        for (Produto produto : Produto.produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }

    public static int calcularTotalProdutosVendidos() {
        int total = 0;
        for (Produto produto : Produto.produtos) {
            total += produto.getQuantidade();
        }
        return total;
    }

    public static Double calcularTotalComissao(){
        Double totalVendas = calcularTotalVendas();
        Double totalComissao = totalVendas * 0.4;
        return totalComissao;
    }

    public static Double calcularLucroCaixa() {
        return calcularTotalVendas() - calcularTotalComissao();
    }
}
