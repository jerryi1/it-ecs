package com.lhq.itecs.controller.auth;

import com.lhq.itecs.archtechture.response.RestResponse;
import com.lhq.itecs.service.auth.JwtUserService;
import com.lhq.itecs.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtUserController {
    @Autowired
    private UserService userService;

    //用户的登录功能
    @RequestMapping("/login")
    public RestResponse<?> login(@RequestParam("username") String username,@RequestParam("password") String password){
        return RestResponse.success(userService.login(username,password));
    }
}
