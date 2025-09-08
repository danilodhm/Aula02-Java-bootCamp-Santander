package model;

import valid.validateService;

public class Conta {

    private String nome;
    private Long cpf;
    private double saldoConta = 0;
    private double limitChequeEspecial = 0;
    private double usoChequeEspecial = 0;

    public double getLimitChequeEspecial() {
        return limitChequeEspecial;
    }
    public void setLimitChequeEspecial(double limitChequeEspecial) {
        this.limitChequeEspecial = limitChequeEspecial;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public double getSaldoConta() {
        return saldoConta;
    }
    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
        System.out.println("Seu saldo foi atualizado com sucesso.");
        var totalLiberadoCheque = validateService.validSaldoChequeEspecial(getUsoChequeEspecial(), getLimitChequeEspecial());
        var total = getSaldoConta() + totalLiberadoCheque;
        System.out.println("Seu saldo atual: " + getSaldoConta() + "+" + totalLiberadoCheque + "(Cheque especial) = " + String.format("%.2f", total) + ".");
    }
    public double getUsoChequeEspecial() {
        return usoChequeEspecial;
    }
    public void setUsoChequeEspecial(double usoChequeEspecial) {
        this.usoChequeEspecial = usoChequeEspecial;
    }
    @Override
    public String toString() {
        return "Conta [nome=" + nome + ", cpf=" + cpf + ", saldoConta=" + saldoConta + ", limitChequeEspecial="
                + limitChequeEspecial + ", usoChequeEspecial=" + usoChequeEspecial + "]";
    }
}
