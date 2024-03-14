package org.app.data_base;
import jakarta.persistence.*;
import org.app.data_base.entities.Clients;
import org.app.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBase {
    @Autowired
    private ClientsRepository repository;
    @Autowired
//    @Qualifier("tokenGenerator")
    private PasswordEncoder encoder;
    public void addUser(Clients client) {
//        client.setPassword(encoder.encode(client.getLogin() + ":" + client.getPassword()));
        client.setPassword(encoder.encode(client.getPassword()));
        repository.save(client);
    }
    public void deleteUser(String login) {
        repository.delete(repository.findByLogin(login).orElseThrow());
    }
}
