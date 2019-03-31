package com.lhq.itecs.service.user;

import com.lhq.itecs.entity.auth.JwtUser;
import com.lhq.itecs.pojo.JwtAuthenticationResponse;
import com.lhq.itecs.repository.UserRepository;
import com.lhq.itecs.service.auth.JwtUserService;
import com.lhq.itecs.service.base.BaseService;
import com.lhq.itecs.utils.JwtTokenUtil;
import com.querydsl.core.BooleanBuilder;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Map;

@Service
public class UserService implements BaseService {

    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private JwtUserService jwtUserService;
    @Autowired
    private UserRepository userRepository;


    @Value("${jwt.header}")
    private String tokenHead;

    @Autowired
    public UserService(
            AuthenticationManager authenticationManager,
            JwtUserService userService,
            JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUserService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public Object get(Serializable serializable) {
        return null;
    }

    @Override
    public void delete(Serializable serializable) {

    }

    @Override
    public Object update(Serializable serializable, Object o) {
        return null;
    }

    @Override
    public Object add(Object o) {
        return null;
    }

    @Override
    public Map<String, Object> page(BooleanBuilder booleanBuilder, Integer page, Integer perPage) {
        return null;
    }

    /**
     * 实现用户的登录
     * */
    public JwtAuthenticationResponse login(String username, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //将我们的认证信息转换成对应的token 字符串
        JwtUser userDetails = (JwtUser) authentication.getPrincipal();
        val token = jwtTokenUtil.generateToken(userDetails);
        return new JwtAuthenticationResponse(userDetails.getId(), userDetails.getUsername(),token);
    }
}
