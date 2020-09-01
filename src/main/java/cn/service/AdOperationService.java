package cn.service;

import cn.dao.Bill;
import cn.dao.User;
import cn.dao.Worker;

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

    /**
     * 删除指定维修信息和回复信息
     * @param num
     * @return
     */
    int DeletrInfor(String num);

    /**
     * 读出所有的账单记录
     * @return
     */
    List<Bill> ReaderBill() ;

    /**
     * 读出指定单号的账单记录
     * @param num
     * @return
     */
    Bill ReaderBillnum(String num);

    /**
     * 管理员更新bill信息
     * @param bill
     * @return
     */
    int UpdateBill(Bill bill);

    /**
     * 管理员删除bill表的指定记录
     * @param snum
     * @return
     */
    int DeleteBill(String snum);

    /**
     * 查询当前工人的最后一个账号
     * @return
     */
    String SelectWorkerId();

    /**
     * 读出worker表中的记录
     * @return
     */
    List<Worker> ReaderWork();

    /**
     * 增加工人记录
     * @param worker
     * @return
     */
    int InsertWorker(Worker worker);


}
