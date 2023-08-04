package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public User updateById(User obj, Integer id) {
        // Pegar a referência do Objeto que irá atualizar pelo seu ID:
        User entity = repository.getReferenceById(id);

        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        // Salvar o objeto novo em cima do objeto antigo
        return repository.save(entity);
    }

}
