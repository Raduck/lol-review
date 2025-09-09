package com.lolreview.summonerreview.controller;

import com.lolreview.summonerreview.dto.*;
import com.lolreview.summonerreview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResponse<UserLoginResponse> login(@RequestBody UserLoginRequest req) {
        String token = userService.login(req);
        return new ApiResponse<>(true, "로그인 성공", new UserLoginResponse(token, req.username()));
    }

    @PostMapping("/signup")
    public ApiResponse<Void> signup(@RequestBody UserSignupRequest req) {
        userService.signup(req);
        return new ApiResponse<>(true, "회원가입 성공", null);
    }
} 