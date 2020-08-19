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
}
