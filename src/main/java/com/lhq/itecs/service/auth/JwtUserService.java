package com.lhq.itecs.service.auth;

import com.lhq.itecs.entity.auth.JwtUser;
import com.lhq.itecs.entity.user.Authority;
import com.lhq.itecs.entity.user.User;
import com.lhq.itecs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JwtUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        return JwtUserFactory.build(user);
    }

    public static class JwtUserFactory{
        public static JwtUser build(User user){
             return new JwtUser(user.getId(),user.getUsername(),user.getPassword(),user.getRole().getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
        }
    }
}
