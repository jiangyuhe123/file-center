package com.ajavac.service.impl;

import com.ajavac.dao.LocalAuthRepository;
import com.ajavac.entity.LocalAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyp0596 on 07/03/2017.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LocalAuthRepository localAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LocalAuth localAuth = localAuthRepository.findOne(username);
        if(localAuth == null){
            throw new UsernameNotFoundException("not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(localAuth.getRole().name()));
        System.err.println("username is " + username + ", " + localAuth.getRole().name());
        return new org.springframework.security.core.userdetails.User(localAuth.getUsername(),
                localAuth.getPassword(), authorities);
    }
}
