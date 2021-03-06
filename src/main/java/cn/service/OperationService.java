package cn.service;

import cn.dao.Bill;
import cn.dao.Infor;
import cn.dao.User;

import java.util.List;
import java.util.Map;

public interface OperationService {
    /**
     * 用户注册方法
     * @param user
     * @return
     */
    int Register (User user);

    /**
     * 根据账号查询维修申报记录
     * @param userid
     * @return
     */
    List<Infor> Seeinfor(String userid);

    /**
     * 根据infor序号查找对应的恢复信息
     * @param num
     * @return
     */
    Map<String,Object> lookmes(String num);

    /**
     * 用户给工人评分
     * @param fenshu
     * @return
     */
    int Pinfen(String fenshu,String num);

    /**
     * 根据序号删除信息表中的记录
     * @param num
     * @return
     */
    int DeleteInfor(String num);

    /**
     * 修改学生基本信息 包括用户名，邮件地址和手机号
     * @param id
     * @param username
     * @param email
     * @param phone
     * @return
     */
    int modifUser(String id, String username, String email, String phone) ;

    /**
     * 修改用户密码
     * @param id
     * @param password
     * @param password1
     * @return
     */
    int modifuserpass(String id, String password, String password1);

    /**
     * 根据工人id查找维修工单
     * @param workerid
     * @return
     */
    List<Infor> Lookinfor(String workerid);

    /**
     * 添加回复记录
     * @param num
     * @param userid
     * @param workerid
     * @param status
     * @return
     */
    int Reinfor(String num,String userid,String workerid,String status);

    /**
     * 工人查看分数 根据workerid
     * @param workerid
     * @return
     */
    Map<String,String> Lookfen(String workerid);

    /**
     * 工人修改基本信息
     * @param workerid
     * @param phone
     * @param mail
     * @return
     */
    int modifworker(String workerid,String phone,String mail);

    /**
     * 工人修改密码
     * @param workerid
     * @param password
     * @param password1
     * @return
     */
    int modifwps(String workerid,String password,String password1);

    /**
     * 查找当前账单号
     * @return
     */
    int BIllnum();

    /**
     * 插入报销单
     * @param bill
     * @return
     */
    int InsertBill(Bill bill);

    /**
     * 插入维修申报记录
     * @param infor
     * @return
     */
    int InsertInfor(Infor infor);

    /**
     * 用户更新维修申请
     * @param infor
     * @return
     */
    int UpdateInfor(Infor infor);
}
