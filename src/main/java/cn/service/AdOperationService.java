package cn.service;

import cn.dao.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    int InsertUser(User user);

    /**
     * 根据表单好查找用户信息
     * @param num
     * @return
     */
    User ReaderNum(String num);

    /**
     * 管理员更新用户信息
     * @param user
     * @return
     */
    int Adupuser(User user);

    /**
     * 读出所有的维修消息和工人回复消息
     * @return
     */
    Map<String,Object> lookmes();
}
