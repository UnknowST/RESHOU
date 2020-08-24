package cn.service.impl;

import cn.dao.User;
import cn.daomain.AdOpdao;
import cn.daomain.impl.AdOpdaoimpl;
import cn.service.AdOperationService;

import java.util.List;
import java.util.Map;

public class AdOperationServiceimpl implements AdOperationService {
    AdOpdao addao=new AdOpdaoimpl();
    @Override
    public List<User> ReaderUser() {
        return addao.ReaderUser();
    }

    @Override
    public int DeleteUser(String snum) {
        return addao.DeleteUser(snum);
    }

    @Override
    public int InsertUser(User user) {
        return addao.InsertUser(user);
    }

    @Override
    public User ReaderNum(String num) {
        return addao.ReaderNum(num);
    }

    @Override
    public int Adupuser(User user) {
        return addao.Adupuser(user);
    }

    @Override
    public Map<String, Object> lookmes() {
        return addao.lookmes();
    }
}
