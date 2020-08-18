package cn.daomain;

import cn.dao.Infor;
import cn.dao.User;

import java.util.List;
import java.util.Map;

public interface Operationdao {

    int Register(User user);

    List<Infor> Seeinfor(String userid);

    Map<String,Object> lookmes(String mes);
    int Pinfen(String fenshu,String num);
    int DeleteInfor(String num);
    int modifUser(String id,String username,String email,String phone);
    int modifuserpass(String id,String password,String password1);
    List<Infor> Lookinfor(String workerid);
    int Reinfor(String num,String userid,String workerid,String status);
}
