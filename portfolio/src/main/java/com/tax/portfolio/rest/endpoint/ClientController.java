package com.tax.portfolio.rest.endpoint;

import com.tax.portfolio.rest.data.Client;
import com.tax.portfolio.rest.data.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) throws UsernameAlreadyExistsException{
        if(clientRepository.findByUserName(client.getUserName()) != null){
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        //when logging in, we compare encoded version of request password with stored password
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }
}
