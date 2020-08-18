package cn.daomain;

import cn.dao.User;
import cn.dao.Worker;

public interface Logindao {
    /**
     * 用户登陆检查
     * @param user
     * @return
     */
    public User UserLogin(User user);

    /**
     * 工人登陆检查
     * @param worker
     * @return
     */
    public Worker WorkerLogin(Worker worker);
}
