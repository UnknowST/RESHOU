package cn.daomain.impl;

import cn.dao.User;
import cn.daomain.AdOpdao;
import cn.jdbcutils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
}
