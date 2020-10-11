package com.service;

import com.daomain.User;

import java.io.IOException;
import java.util.List;

public interface Userservice {
   public List<User> findall() ;
   public void save(User user);
}
