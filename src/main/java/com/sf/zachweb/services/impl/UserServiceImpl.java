package com.sf.zachweb.services.impl;
import com.sf.zachweb.mapper.UserMapper;
import com.sf.zachweb.model.User;
import com.sf.zachweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> lists() {
        return userMapper.findAll();
    }

    @Override
    public User queryById(Integer id) {
        return userMapper.findOneById(id);
    }

    @Override
    public void create(User user) {
        userMapper.insert(user);
    }

    @Override
    public void remove(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
