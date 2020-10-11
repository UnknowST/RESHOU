package com.service.impl;

import com.daomain.User;
import com.mapper.Usermapper;
import com.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserserviceImpl implements Userservice {
    @Autowired
    private Usermapper usermapper;

    @Override
    public List<User> findall() {

        return usermapper.findall();

    }

    @Override
    public void save(User user) {
        usermapper.save(user);
    }
}
