package com.sf.zachweb.mapper;

import com.sf.zachweb.model.User;

import java.util.List;

public interface UserMapper {
    void delete(Integer id);
    void insert(User record);
    User findOneById(Integer id);
    void update(User record);
    List<User> findAll();
}