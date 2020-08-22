package cn.daomain;

import cn.dao.User;

import java.util.List;

public interface AdOpdao {

    List<User> ReaderUser();
    int DeleteUser(String snum);
    int InsertUser(User user);
    User ReaderNum(String num);
    int Adupuser(User user);
}
