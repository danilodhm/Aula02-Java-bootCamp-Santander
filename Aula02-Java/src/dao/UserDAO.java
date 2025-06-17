package dao;

import java.util.ArrayList;
import java.util.List;

import exception.UserNotFoundException;
import model.UserModel;

public class UserDAO {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model){
        model.setId(nextId++);
        models.add(model);
        return model;        
    }

    public UserModel update(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public UserModel delete(final UserModel model){
        var toDelete = findById(model.getId());
        models.remove(toDelete);
        return model;
    }
    
    
    public UserModel findById(final long id){
        var message = String.format("Não existe usuário com o id %s cadastrado", id);
        return models.stream()
            .filter(u -> u.getId() == id)
            .findFirst()
            .orElseThrow(() -> new UserNotFoundException(message));
    }

    public List<UserModel> findAll(){
        return models;
    }



}
