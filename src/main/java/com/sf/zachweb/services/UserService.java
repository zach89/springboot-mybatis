package com.sf.zachweb.services;

import com.sf.zachweb.model.User;

import java.util.List;

public interface UserService {
    List<User> lists();
    User queryById(Integer id);
    void create(User user);
    void remove(Integer id);
    void update(User user);
}
