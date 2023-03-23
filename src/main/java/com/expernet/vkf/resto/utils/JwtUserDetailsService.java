package com.expernet.vkf.resto.utils;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.equalsIgnoreCase("vkf")){
            //password au format BCRYPT
            return new User("vkf",
                    "1234",
                    new ArrayList<>());

        }
        else{
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }
    }
}