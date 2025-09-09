package com.lolreview.summonerreview.repository;

import com.lolreview.summonerreview.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
    void insertUser(User user);
}