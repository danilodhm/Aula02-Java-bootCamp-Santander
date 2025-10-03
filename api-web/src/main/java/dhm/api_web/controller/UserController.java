package dhm.api_web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dhm.api_web.model.Usuario;
import dhm.api_web.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/listUsers")
    public String listUser() {
        return repository.findAll().toString();
    }

    @GetMapping("/user/{login}")
    public String getUserByUsername(@PathVariable("login") String username) {
        return repository.findByLogin(username).toString();
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Usuario usuario) {
        repository.save(usuario);
        return "Usuário adicionado";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return "Usuário deletado" + id;
    }
}
