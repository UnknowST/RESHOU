package com.mapper;

import com.daomain.User;

import java.util.List;

public interface Usermapper {
    List<User> findall();
    void save(User user);
}
