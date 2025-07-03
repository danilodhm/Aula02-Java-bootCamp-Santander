package models.users;

import java.util.ArrayList;

public class Usuario {
    
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    protected String nome;
    protected String login;
    protected String email;
    protected String senha;
    protected String isCargo;

    public Usuario(String nome, String login, String email, String senha, String isCargo) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.isCargo = "COMUM";
    }

    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public static Usuario getLogin(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIsCargo() {
        return isCargo;
    }

    public void setIsCargo(String isCargo) {
        this.isCargo = isCargo;
    }

}
