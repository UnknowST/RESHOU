package cn.daomain.impl;

import cn.dao.*;
import cn.daomain.Operationdao;
import cn.jdbcutils.JDBCUtils;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public Map<String, String> Lookfen(String workerid) {
        //查询累计得分
        String sql="select sum(evaluate) from infor where workerid=?";
        //查询最高分
        String sql1="select max(evaluate) from infor where workerid=?";
        //查询最低分
        String sql2="select min(evaluate) from infor where workerid=?";
        //计数参与评分的人数
        String sql3="SELECT COUNT(cid) FROM infor WHERE workerid=? AND evaluate<>0";
        //jdbc查询返回string 类型
        String sum=template.queryForObject(sql,String.class,workerid);
        String max=template.queryForObject(sql1,String.class,workerid);
        String min=template.queryForObject(sql2,String.class,workerid);
        String num=template.queryForObject(sql3,String.class,workerid);
        //计算平均分
        String eval=String.valueOf(Double.valueOf(sum)/Double.valueOf(num));
        //更新工人的累计得分
        int n=template.update("update worker set sum_eval=? where id=?",eval,workerid);
        //构造map集合
        Map map1=new HashMap();

        //判断是否更新成功
        if(n==1) {
            map1.put("max",max);
            map1.put("min",min);
            map1.put("num",num);
            map1.put("eval",eval);
        }else
            return map1;

        return map1;


    }

    @Override
    public int modifworker(String workerid, String phone, String mail) {
        return template.update("update worker set phone=?,mail=? where id=?",phone,mail,workerid);
    }

    @Override
    public int modifwps(String workerid, String password, String password1) {
        return template.update("update worker set password=? where id=? and password=?" ,password1,workerid,password);
    }

    @Override
    public int Billnum() {
        return template.queryForInt("SELECT MAX(num) FROM bill  ");
    }

    @Override
    public int InsertBill(Bill bill) {
     int n=template.update("insert into bill(num,cost,place,useing,createtime,workerid) values(?,?,?,?,?,?)",bill.getNum(),bill.getCost(),bill.getPlace(),bill.getUseing(),bill.getCreatetime(),bill.getWorkerid());
    return n;
    }

    @Override
    public int InsertInfor(Infor infor) {

        return template.update("insert into infor(userid,place,equip,detail,imagepath) values(?,?,?,?,?)",infor.getUserid(),infor.getPlace(),infor.getEquip(),infor.getDetail(),infor.getImagepath());
    }

    @Override
    public int UpdateInfor(Infor infor) {
        DateFormat df3 = new SimpleDateFormat("yyy:MM:dd HH:mm:ss");
        return template.update("insert into infor(place,equip,detail,imagepath,createdate) values(?,?,?,?,?) where cid=?",
            infor.getPlace(),infor.getEquip(),infor.getDetail(),infor.getImagepath(),df3.format( new Date()),infor.getCid()
                );
    }

}
