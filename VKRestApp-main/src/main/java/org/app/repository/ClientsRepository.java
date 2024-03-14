package org.app.repository;

import org.app.data_base.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ClientsRepository extends JpaRepository<Clients, Integer> {
    Optional<Clients> findByLogin(String login);
}
