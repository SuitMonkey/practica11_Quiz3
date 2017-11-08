package edu.pucmm.practica11_Quiz3.service;

import edu.pucmm.practica11_Quiz3.modelo.User;
import edu.pucmm.practica11_Quiz3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeguridadServices implements UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;

    //cualquier cosa...



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usuarioRepository.findByUsername(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//        for (Rol role : user.getRoles()) {
//            roles.add(new SimpleGrantedAuthority(role.getRole()));
//        }
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        roles.add(new SimpleGrantedAuthority("USER"));

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActive(), true, true, true, grantedAuthorities);
    }
}
