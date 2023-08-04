package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        User u = service.findById(id);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = service.insert(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
        user = service.updateById(user, id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
