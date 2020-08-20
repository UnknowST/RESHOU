package cn.service;

import cn.dao.User;

import java.util.List;

public interface AdOperationService {
    /**
     * 读出用户信息记录
     * @return
     */
    List<User> ReaderUser();

    /**
     * 删除用户
     * @param snum
     * @return
     */
    int DeleteUser(String snum);
}
