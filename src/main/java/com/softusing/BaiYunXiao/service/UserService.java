package com.softusing.BaiYunXiao.service;

import com.softusing.BaiYunXiao.entity.User;
import com.softusing.BaiYunXiao.mapperIterfac.UserMapper;
import com.softusing.BaiYunXiao.mapperIterfac.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserMapper userMapper;
    public int save(User user){
        return userMapper.insert(user);
    }
}
