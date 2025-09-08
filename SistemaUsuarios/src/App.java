import models.users.Usuario;
import services.Cadastro;
import services.MenuEntrada;
public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println(usuarios);
        
        Cadastro.cadastrarUsuario("TEste", "Teste", "Teste", "Teste", "GERENTE");
        Cadastro.cadastrarUsuario("João", "joao123", "teste", "senha123", "VENDEDOR");
        Cadastro.cadastrarUsuario("Maria", "maria456", "teste", "senha456", "ATENDENTE");
        Cadastro.cadastrarUsuario("Pedro", "pedro789", "teste", "senha789", "COMUM");
        System.out.println("Usuários cadastrados: " + Usuario.usuarios.get(0).getIsCargo());

        MenuEntrada.Iniciar();

    }

    
}
