package cn.service.impl;

import cn.dao.User;
import cn.dao.Worker;
import cn.daomain.Logindao;
import cn.daomain.impl.Logindaoimpl;
import cn.service.LoginService;

public class LoginServiceimpl implements LoginService {
    private Logindao logindao=new Logindaoimpl();
    @Override
    public User Userlogin(User user) {
        return logindao.UserLogin(user);
    }

    @Override
    public Worker Workerlogin(Worker worker) {
        return logindao.WorkerLogin(worker);
    }
}
