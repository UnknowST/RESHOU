package Test;

import cn.dao.Infor;
import cn.dao.User;
import cn.jdbcutils.JDBCUtils;
import cn.service.AdOperationService;
import cn.service.LoginService;
import cn.service.OperationService;
import cn.service.impl.AdOperationServiceimpl;
import cn.service.impl.LoginServiceimpl;
import cn.service.impl.OperationServiceimpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jdbcTest {
    @Test
    public  void jdbctest(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    String sql="select * from user";
    List<User> list=template.query(sql,new BeanPropertyRowMapper<User>(User.class));

    for(User u1:list){
        System.out.println(u1.getid()+" "+u1.getName());
    }}
    @Test
    public void loginTest(){
        User user =new User();
        user.setid("183130");
        user.setPassword("Qxs123");
        LoginService login=new LoginServiceimpl();
        if(login.Userlogin(user)!=null) System.out.println("登陆成功");
        else System.out.println("登陆失败");
    }

    @Test
    public void seachuser(){
        User user=new User();
        user.setid("1853130");
        user.setPassword("Qxs123");
        LoginService login=new LoginServiceimpl();
        user=login.Userlogin(user);
        if(user!=null) System.out.println(user.getCreatedate());
        else System.out.println("登陆失败");
    }

    /**
     * Message 测试
     */
    @Test
    public void MesTest(){

        OperationService ops=new  OperationServiceimpl();
        String num= "38";
        Map<String,Object> map=new HashMap<>();
        map=ops.lookmes(num);
        System.out.println(map.get("Infor"));
        ObjectMapper mapper = new ObjectMapper();




    }
    @Test
    public void Lookinfor_all() {
        AdOperationService ado=new AdOperationServiceimpl();
        Map<String,Object> map=new HashMap<>();
        map=ado.lookmes();

        Gson gson=new Gson();
        System.out.println(gson.toJson(map));

    }
    @Test
    public void SelectId(){
        AdOperationService ado=new AdOperationServiceimpl();
        Map<String,Integer> map=new HashMap<>();
        String id=ado.SelectWorkerId();
        int newid=Integer.parseInt(id);
        newid+=1;
        map.put("id",newid);

        Gson gson=new Gson();
        System.out.println(gson.toJson(map));
    }
}
