package model;

public class Carro {

    private boolean statusMotor = false;

    private int velocimetro = 0;

    private boolean acelerandoOuDesacelarando = false;
    
    private String direcao = "reto";
    
    private int marcha = 0;
    
    public boolean isAcelerandoOuDesacelarando() {
        return acelerandoOuDesacelarando;
    }

    public void setAcelerandoOuDesacelarando(boolean acelerandoOuDesacelarando) {
        this.acelerandoOuDesacelarando = acelerandoOuDesacelarando;
    }

    public boolean isStatusMotor() {
        return statusMotor;
    }

    public void setStatusMotor(boolean statusMotor) {
        this.statusMotor = statusMotor;
    }

    public int getVelocimetro() {
        return velocimetro;
    }

    public void setVelocimetro(int velocimetro) {
        this.velocimetro = velocimetro;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    

}
