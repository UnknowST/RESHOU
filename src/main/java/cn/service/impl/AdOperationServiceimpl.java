package cn.service.impl;

import cn.dao.User;
import cn.daomain.AdOpdao;
import cn.daomain.impl.AdOpdaoimpl;
import cn.service.AdOperationService;

import java.util.List;

public class AdOperationServiceimpl implements AdOperationService {
    AdOpdao addao=new AdOpdaoimpl();
    @Override
    public List<User> ReaderUser() {
        return addao.ReaderUser();
    }
}
