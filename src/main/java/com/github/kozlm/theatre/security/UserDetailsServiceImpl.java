package com.github.kozlm.theatre.security;

import com.github.kozlm.theatre.model.client.Client;
import com.github.kozlm.theatre.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(username).orElse(null);
        if (username.equals("admin"))
            return new User(username, "$2a$10$xanbZ9/rqwvz01rBcaReQegk5v3WpXSYjis/GjReiA3cYO20xXk1W",
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        else if (client != null)
            return new User(username, client.getPassword(),
                    List.of(new SimpleGrantedAuthority("ROLE_CLIENT")));
        else throw new UsernameNotFoundException("Username '" + username + "' not found!");
    }
}
