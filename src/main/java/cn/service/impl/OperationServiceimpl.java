package cn.service.impl;

import cn.dao.*;
import cn.daomain.Operationdao;
import cn.daomain.impl.Operationdaoimpl;
import cn.service.OperationService;

import java.util.List;
import java.util.Map;

public class OperationServiceimpl implements OperationService {
    private Operationdao opdao=new Operationdaoimpl();
    @Override
    public int Register(User user) {
        return opdao.Register(user);
    }

    @Override
    public List<Infor> Seeinfor(String userid) {
        return opdao.Seeinfor(userid);
    }

    @Override
    public Map<String,Object> lookmes(String num) {
        return opdao.lookmes(num);
    }

    @Override
    public int Pinfen(String fenshu,String num) {
        return opdao.Pinfen(fenshu,num);
    }

    @Override
    public int DeleteInfor(String num) {
        return opdao.DeleteInfor(num);
    }

    @Override
    public int modifUser(String id, String username, String email, String phone) {
        return opdao.modifUser(id,username,email,phone);
    }

    @Override
    public int modifuserpass(String id, String password, String password1) {
        return opdao.modifuserpass(id,password,password1);
    }

    @Override
    public List<Infor> Lookinfor(String workerid) {
        return opdao.Lookinfor(workerid);
    }

    @Override
    public int Reinfor(String num, String userid, String workerid, String status) {
        return opdao.Reinfor(num,userid,workerid,status);
    }

    @Override
    public Map<String, String> Lookfen(String workerid) {
        return opdao.Lookfen(workerid);
    }

    @Override
    public int modifworker(String workerid, String phone, String mail) {
        return opdao.modifworker(workerid,phone,mail);
    }

    @Override
    public int modifwps(String workerid, String password, String password1) {
        return opdao.modifwps(workerid,password,password1);
    }


}
