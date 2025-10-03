package dhm.api_web.repository;

import dhm.api_web.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import dhm.api_web.handler.CampoObrigatorioException;

@Repository
public class UserRepository {
    // Simulando um "banco de dados" em memória
    private final List<Usuario> usuarios = new ArrayList<>();

    // Create ou Update
    public void save(Usuario usuario) {
        if (usuario.getLogin() == null)
            throw new CampoObrigatorioException("login");
        if (usuario.getSenha() == null)
            throw new CampoObrigatorioException("senha");
        
        if (usuario.getId() == null) {
            usuario.setId(usuarios.size() + 1); // gera id automático
            System.out.println("SAVE - Novo usuário salvo: " + usuario);
            usuarios.add(usuario);
        } else {
            System.out.println("UPDATE - Atualizando usuário: " + usuario);
            usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
            usuarios.add(usuario);
        }
    }

    // Delete
    public void deleteById(Integer id) {
        System.out.println(String.format("DELETE - Recebendo o id: %d para excluir", id));
        usuarios.removeIf(u -> u.getId().equals(id));
    }

    // Read (listar todos)
    public List<Usuario> findAll() {
        System.out.println("LIST - Listando os usuários do sistema");
        return new ArrayList<>(usuarios);
    }

    // Read (buscar por id)
    public Usuario findById(Integer id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Usuario findByLogin(String login) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }
}
