package com.lolreview.summonerreview.service;

import com.lolreview.summonerreview.dto.UserLoginRequest;
import com.lolreview.summonerreview.dto.UserSignupRequest;
import com.lolreview.summonerreview.entity.User;
import com.lolreview.summonerreview.repository.UserMapper;
import com.lolreview.summonerreview.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String login(UserLoginRequest request) {
        User user = userMapper.findByUsername(request.username());
        if (user == null || !passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        return jwtUtil.generateToken(user.getUsername());
    }

    @Override
    public void signup(UserSignupRequest request) {
        if (userMapper.findByUsername(request.username()) != null) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setEmail(request.email());
        user.setRole("USER");
        userMapper.insertUser(user);
    }
} 