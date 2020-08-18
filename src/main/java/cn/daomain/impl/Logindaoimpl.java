package cn.daomain.impl;

import cn.dao.User;
import cn.dao.Worker;
import cn.daomain.Logindao;
import cn.jdbcutils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;

public class Logindaoimpl implements Logindao {
    private  JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User UserLogin(User user) {
        User user1=null;
        try {
            String sql="select * from user where id=? and password=?";
            user1= template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user.getid(),user.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user1;
    }

    @Override
    public Worker WorkerLogin(Worker worker) {
        Worker worker1=null;

        String sql= null;
        try {
            sql = "select * from worker where id=? and password=?";
            worker1= template.queryForObject(sql,new BeanPropertyRowMapper<Worker>(Worker.class),worker.getid(),worker.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return worker1;
    }


}
