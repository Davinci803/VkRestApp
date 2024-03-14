package org.app.service;

import org.app.config.UserDetailsImpl;
import org.app.data_base.entities.Clients;
import org.app.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientsDetailsService implements UserDetailsService {
    @Autowired
    private ClientsRepository clientsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Clients> client = clientsRepository.findByLogin(username);
        return client.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found"));
    }
}
