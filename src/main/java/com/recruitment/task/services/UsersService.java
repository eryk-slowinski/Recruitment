package com.recruitment.task.services;

import com.recruitment.task.globals.Globals;
import com.recruitment.task.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsersService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        for(User u : Globals.users){
            if(u.getUserName().equals(username)){
                user = u;
            }
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRoles());
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), Arrays.asList(authority));
    }
}
