package com.lolreview.summonerreview.service;

import com.lolreview.summonerreview.dto.UserLoginRequest;
import com.lolreview.summonerreview.dto.UserSignupRequest;

public interface UserService {
    String login(UserLoginRequest request);
    void signup(UserSignupRequest request);
} 