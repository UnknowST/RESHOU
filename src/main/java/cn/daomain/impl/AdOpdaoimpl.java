package cn.daomain.impl;

import cn.dao.*;
import cn.daomain.AdOpdao;
import cn.jdbcutils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class AdOpdaoimpl implements AdOpdao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> ReaderUser() {
        return template.query("select * from user",new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public int DeleteUser(String snum) {
        return template.update("delete from user where snum=? ",snum);
    }

    @Override
    public int InsertUser(User user) {
        return template.update("insert into user(id,username,name,phone,gender,mail,collage,password) values(?,?,?,?,?,?,?,?)",
                user.getid(),user.getUsername(),user.getName(),user.getPhone(),user.getGender(),user.getMail(),user.getCollage(),user.getPassword()
                );
    }

    @Override
    public User ReaderNum(String num) {
        return  template.queryForObject("select * from user where snum=?",new BeanPropertyRowMapper<User>(User.class),num);
    }

    @Override
    public int Adupuser(User user) {
        return template.update("update user set id=?,username=?,collage=?,gender=?,name=?,phone=?,mail=? where snum=?",user.getid(),user.getUsername(),
                user.getCollage(),user.getGender(),user.getName(),user.getPhone(),user.getMail(),user.getSnum());
    }

    @Override
    public Map<String, Object> lookmes() {
        Infor inf=new Infor();

        Replay rep=new Replay();
        Map map=new HashMap();
        List<Infor> list=new ArrayList<>();
        List<Replay> list1=new ArrayList<>();
        String sql="SELECT * FROM infor ";
        String sql1="SELECT * from replay where cid=? ";
        try {
           list=template.query(sql,new BeanPropertyRowMapper<Infor>(Infor.class));

        } catch (DataAccessException e) {
            list.add(null);
        }

            if (list .size()!=0 ) {
                for(Infor info:list){
                try {
                    rep=template.queryForObject(sql1,new BeanPropertyRowMapper<Replay>(Replay.class),info.getCid());
                    list1.add(rep);
                } catch (DataAccessException e) {
                    list1.add(null);
                }
                }
            }




        //map.put(inf,rep);
        map.put("Infor",list);
        map.put("Replay",list1);
        return map;
    }

    @Override
    public int DeletrInfor(String num) {
        int m=0;
        int n=template.update("delete from infor where cid=?",num);
        Replay rep=template.queryForObject("select * from replay where cid=?",new BeanPropertyRowMapper<Replay>(Replay.class),num);
        if(rep!=null){
            m=template.update("delete from replay where cid=?",num);

        }else m=1;

        if(n==1&&m==1) return 1;
        else return 0;

    }

    @Override
    public List<Bill> ReaderBill() {
        return template.query("select * from bill",new BeanPropertyRowMapper<Bill>(Bill.class));
    }

    @Override
    public Bill ReaderBillnum(String num) {
        return template.queryForObject("select * from bill where snum=?",new BeanPropertyRowMapper<Bill>(Bill.class),num);
    }

    @Override
    public int UpdateBill(Bill bill) {
        return template.update("update bill set cost=?,place=?,useing=? where snum=?",bill.getCost(),bill.getPlace(),bill.getUseing(),bill.getSnum());
    }

    @Override
    public int DeleteBill(String snum) {

        return template.update("delete from bill where snum=?",snum);
    }

    @Override
    public String SelectWorkerId() {
        return String.valueOf(template.queryForInt("select MAX(id) from worker"));
    }

    @Override
    public List<Worker> ReaderWork() {
        return template.query("select * from worker",new BeanPropertyRowMapper<Worker>(Worker.class));
    }

    @Override
    public int InsertWorker(Worker worker) {
        return template.update("insert into worker(id,password,name,gender,phone,mail,position) values(?,?,?,?,?,?,?)",
                worker.getid(),worker.getPassword(),worker.getName(),worker.getGender(),worker.getPhone(),worker.getMail(),worker.getPosition()
                );
    }
}
