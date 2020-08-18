package cn.web.servlet;


import cn.dao.ResultInfo;
import cn.dao.User;
import cn.dao.Worker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/findUser/*")
public class Userinfor extends BaseServlet {
    public String findid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        Object user=request.getSession().getAttribute("user");
        User user1=new User();
        Worker worker=new Worker();
            String id=null;
            if(ResultInfo.num==1) {
                user1=(User)user;
                id=user1.getid();



            }
            else if(ResultInfo.num==2) {
                worker=(Worker) user;
                id=worker.getid();


            }
            else if(ResultInfo.num==3) {
               id="Admin";

            }
          return id;
        }

    public void infor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Object user=request.getSession().getAttribute("user");
        System.out.println("user"+user);
        writeValue(user,response);  //将用户信息序列化

    }




}
