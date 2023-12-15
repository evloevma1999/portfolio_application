package com.tax.portfolio.rest.service;

import com.tax.portfolio.rest.data.Client;
import com.tax.portfolio.rest.data.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String userName, String password) {
        Client client = clientRepository.findByUserName(userName);

        if (client != null) {
            // Use a password encoder to compare the provided password with the stored hashed password
            return passwordEncoder.matches(password, client.getPassword());
        }

        return false;
    }
}
