package cn.service;

import cn.dao.User;
import cn.dao.Worker;

public interface LoginService {
    /**
     * 登陆检查
     * @param user
     * @return
     */
    User Userlogin(User user);
    Worker Workerlogin(Worker worker);
}
