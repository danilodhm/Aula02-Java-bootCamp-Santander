package services;

import java.util.Scanner;
// import app.App; // Removed incorrect import
// import App; // Use this if App is in the default package
// Or, if App is in another package, use the correct package name, e.g.:
// import app.App; // Removed because the package 'app' cannot be resolved. Add the correct import if needed, e.g.:
// import yourpackage.App; // Uncomment and replace 'yourpackage' with the actual package name where App.java is located.

import models.users.Atendente;
import models.users.Comum;
import models.users.Gerente;
import models.users.Usuario;
import models.users.Vendedor;

public class Login {

    static Scanner scanner = new Scanner(System.in);

    private static Usuario perfilLogado = null;

    public static Usuario getPerfilLogado() {
        return perfilLogado;
    }

    public static void setPerfilLogado(Usuario perfilLogado) {
        Login.perfilLogado = perfilLogado;
    }

    public static Object logar() {
        System.out.println();
        System.out.println("========== LOGIN ==========");
        System.out.println();

        System.out.println("> Digite seu login:");
        String login = scanner.nextLine();
        System.out.println("> Digite sua senha:");
        String senha = scanner.nextLine();

        if (login == null || senha == null) {
            System.out.println("Login e senha devem ser preenchidos.");
            return logar();
        }

        for (models.users.Usuario usuario : models.users.Usuario.usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                setPerfilLogado(usuario);
                System.out.println();
                System.out.println("> Login realizado com sucesso!");
                String cargo = usuario.getIsCargo();
                switch (cargo) {
                    case "GERENTE"-> {
                        System.out.println("> Perfil de Gerente carregado.\n");
                        Gerente.MenuGerente();
                    }
                    case "VENDEDOR"-> {
                        System.out.println("Perfil de Vendedor carregado.\n");
                        Vendedor.MenuVendedor();                        
                    }
                    case "ATENDENTE"-> {
                        System.out.println("Perfil de Atendente carregado.\n");
                        Atendente.MenuAtendente();                        
                    }
                    case "COMUM"-> {
                        System.out.println("Perfil de Usuário Comum carregado.\n");
                        Comum.MenuComum();
                    }
                    default -> System.out.println("Cargo desconhecido.\n");
                }
                System.out.println();
                System.out.println("===========================================");
                System.out.println();
                return true;
            }
        }

        System.out.println("\n> Login ou senha incorretos.\n");
        return logar();
    }

    public static void Logoff(){
        perfilLogado = null;
        System.out.println("\n> Você foi desconectado com sucesso.");
        System.out.println("============================================\n");
        MenuEntrada.Iniciar();
    }

}
