package models;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Produto {

    public static ArrayList<Produto> produtos = new ArrayList<>();

    
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String vendedor;
    private LocalDate dataVenda;
    private LocalTime horaVenda;
    
    
    public Produto(String nome, String descricao, Double preco, Integer quantidade,
    String vendedor) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.vendedor = vendedor;
        this.dataVenda = LocalDate.now();
        this.horaVenda = LocalTime.now();
    }
    
    public LocalTime getHoraVenda() {
        return horaVenda;
    }
    
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public String getVendedor() {
        return vendedor;
    }


    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }



    

}
