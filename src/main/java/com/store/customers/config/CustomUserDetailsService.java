package com.store.customers.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        if(username.equals("user"))
        {
            roles= Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new User("user","$2a$10$5VikX1NNQFL9f.N7Ta5wVuBL5HuPi7ro5Q3UZYGVOCURwiotGrVCS",roles);
        }
        throw new UsernameNotFoundException("User not found with the name "+ username);
    }
}
