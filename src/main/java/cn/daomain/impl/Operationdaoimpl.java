package cn.daomain.impl;

import cn.dao.*;
import cn.daomain.Operationdao;
import cn.jdbcutils.JDBCUtils;
import com.sun.javafx.collections.MappingChange;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sound.sampled.Line;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Operationdaoimpl implements Operationdao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int Register(User user) {
       String sql="insert into user(sid,password,name,collage,phone,gender,mail,username) value(?,?,?,?,?,?,?,?)";
        return template.update(sql,user.getid(),user.getPassword(),user.getName(),user.getCollage(),user.getPhone(),user.getGender(),user.getMail(),user.getUsername());
    }

    @Override
    public List<Infor> Seeinfor(String userid) {
        String sql="select * from infor where userid=?";
        return template.query(sql,new BeanPropertyRowMapper<Infor>(Infor.class),userid);
    }

    @Override
    public Map<String,Object> lookmes(String num) {
        Infor inf=new Infor();

       Replay rep=new Replay();
       Map map=new HashMap();
        List list = new ArrayList();
        List list1 = new ArrayList();
        String sql="SELECT * FROM infor WHERE cid=? ";
        String sql1="SELECT * from replay where cid=? ";
        try {
            inf =template.queryForObject(sql,new BeanPropertyRowMapper<Infor>(Infor.class),num);
            list.add(inf);
        } catch (DataAccessException e) {
            inf=null;
        }
        try {


            rep=template.queryForObject(sql1,new BeanPropertyRowMapper<Replay>(Replay.class),num);
            list1.add(rep);
        } catch (DataAccessException e) {
            rep=null;
        }

        //map.put(inf,rep);
        map.put("Infor",inf);
        map.put("Replay",rep);
       return map;

    }

    @Override
    public int Pinfen(String fenshu,String num) {
        String sql="update infor set evaluate=? where cid=?";
        int n=template.update(sql,fenshu,num);
        return n;
    }

    @Override
    public int DeleteInfor(String num) {

        return template.update("delete from infor where cid=?",num);
    }

    @Override
    public int modifUser(String id, String username, String email, String phone) {
        return template.update("update user set username=?,mail=?,phone=? where id=?",username,email,phone,id);
    }

    @Override
    public int modifuserpass(String id, String password, String password1) {
        return template.update("update user set password=? where id=? and password=?",password1,id,password);
    }

    @Override
    public List<Infor> Lookinfor(String workerid) {
        return template.query("select * from infor where workerid=? order by createdate desc",new BeanPropertyRowMapper<Infor>(Infor.class),workerid);
    }

    @Override
    public int Reinfor(String num, String userid, String workerid, String status) {
        int n,m;
        n =template.update("insert into replay (cid,sid,renum,detail) values(?,?,?,?)",num,userid,workerid,status);
        m =template.update("update infor set state=? where num=?",num,status);
        if(n==1&&m==1) return 1;
        else  return 0;
    }
}
