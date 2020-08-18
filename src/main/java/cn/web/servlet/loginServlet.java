package cn.web.servlet;

import cn.dao.ResultInfo;
import cn.dao.User;
import cn.dao.Worker;
import cn.daomain.impl.Logindaoimpl;
import cn.service.LoginService;
import cn.service.impl.LoginServiceimpl;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    User user =new User();
    Worker worker =new Worker();
    LoginService checklogin=new LoginServiceimpl();
    ResultInfo info=new ResultInfo();
  /*  @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        //验证校验
        //信息记录
        Gson gson=new Gson();//阿里巴巴的实体类转化为json数据工具
        String check = req.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //登陆失败
            info.setFlag(0);
            info.setErrorMsg("验证码错误");
        }
        else {
            //1.获取用户名和密码数据
            Map<String, String[]> map = req.getParameterMap();
            //获取身份信息 i=1为学生 2为工人 3为管理员
            int i = Integer.parseInt(req.getParameter("shenfen"));


            if(i==1){

                System.out.println(i);
                if (i == 1) {
                    //2.封装用户对象
                    User user=new User();
                    try {
                        BeanUtils.populate(user, map);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                   User u1=checklogin.Userlogin(user);
                    //4.判断学生对象是否为null
                    if (u1 == null) {
                        //用户名密码或错误
                        info.setFlag(0);
                        info.setErrorMsg("用户名或密码错误");
                    } else {
                        info.num=i;
                        info.setData(i);
                        info.setFlag(1);//登录成功标记
                        req.getSession().setAttribute("user", u1);//对象放进缓存
                    }
                }}
            if (i == 2) {
                //2.封装工人对象

                try {
                    BeanUtils.populate(worker, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                Worker w1 = checklogin.Workerlogin(worker);
                //4.判断教师对象是否为null
                if (w1== null) {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                } else {
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);//登录成功标记
                    req.getSession().setAttribute("user", w1);//对象放进缓存
                }
            }
            if (i == 3) {
                //2.封装管理员对象
                String id=req.getParameter("id");
                String password=req.getParameter("password");

                if (id.equals("admin")==true&&password.equals("12345")==true) {
                    //账号密码正确
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);
                } else {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                }
            }
        }
        //json格式返回数据
        resp.setContentType("application/x-json;charset=utf-8");
        resp.getWriter().write(gson.toJson(info));
        System.out.println(gson.toJson(info));
        System.out.println("re"+" "+ResultInfo.num);
        System.out.println("info"+" "+info.num);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        //验证校验
        //信息记录
        Gson gson=new Gson();//阿里巴巴的实体类转化为json数据工具
        String check = req.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //登陆失败
            info.setFlag(0);
            info.setErrorMsg("验证码错误");
        }
        else {
            //1.获取用户名和密码数据
            Map<String, String[]> map = req.getParameterMap();
            //获取身份信息 i=1为学生 2为工人 3为管理员
            int i = Integer.parseInt(req.getParameter("shenfen"));


            if(i==1){

                System.out.println(i);
                if (i == 1) {
                    //2.封装用户对象
                    User user=new User();
                    try {
                        BeanUtils.populate(user, map);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    User u1=checklogin.Userlogin(user);
                    //4.判断学生对象是否为null
                    if (u1 == null) {
                        //用户名密码或错误
                        info.setFlag(0);
                        info.setErrorMsg("用户名或密码错误");
                    } else {
                        info.num=i;
                        info.setData(i);
                        info.setFlag(1);//登录成功标记
                        req.getSession().setAttribute("user", u1);//对象放进缓存
                    }
                }}
            if (i == 2) {
                //2.封装工人对象

                try {
                    BeanUtils.populate(worker, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                Worker w1 = checklogin.Workerlogin(worker);
                //4.判断教师对象是否为null
                if (w1== null) {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                } else {
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);//登录成功标记
                    req.getSession().setAttribute("user", w1);//对象放进缓存
                }
            }
            if (i == 3) {
                //2.封装管理员对象
                String id=req.getParameter("id");
                String password=req.getParameter("password");

                if (id.equals("admin")==true&&password.equals("12345")==true) {
                    //账号密码正确
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);
                } else {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                }
            }
        }
        //json格式返回数据
        resp.setContentType("application/x-json;charset=utf-8");
        resp.getWriter().write(gson.toJson(info));
        System.out.println(gson.toJson(info));
        System.out.println("re"+" "+ResultInfo.num);
        System.out.println("info"+" "+info.num);

    }
*/
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service");
        //验证校验
        //信息记录
        Gson gson=new Gson();//阿里巴巴的实体类转化为json数据工具
        String check = req.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //登陆失败
            info.setFlag(0);
            info.setErrorMsg("验证码错误");
        }
        else {
            //1.获取用户名和密码数据
            Map<String, String[]> map = req.getParameterMap();
            //获取身份信息 i=1为学生 2为工人 3为管理员
            int i = Integer.parseInt(req.getParameter("shenfen"));


            if(i==1){

                System.out.println(i);
                if (i == 1) {
                    //2.封装用户对象
                    User user=new User();
                    try {
                        BeanUtils.populate(user, map);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                    User u1=checklogin.Userlogin(user);
                    //4.判断学生对象是否为null
                    if (u1 == null) {
                        //用户名密码或错误
                        info.setFlag(0);
                        info.setErrorMsg("用户名或密码错误");
                    } else {
                        info.num=i;
                        info.setData(i);
                        info.setFlag(1);//登录成功标记
                        req.getSession().setAttribute("user", u1);//对象放进缓存
                    }
                }}
            if (i == 2) {
                //2.封装工人对象

                try {
                    BeanUtils.populate(worker, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                Worker w1 = checklogin.Workerlogin(worker);
                //4.判断教师对象是否为null
                if (w1== null) {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                } else {
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);//登录成功标记
                    req.getSession().setAttribute("user", w1);//对象放进缓存
                }
            }
            if (i == 3) {
                //2.封装管理员对象
                String id=req.getParameter("id");
                String password=req.getParameter("password");

                if (id.equals("admin")==true&&password.equals("12345")==true) {
                    //账号密码正确
                    info.num=i;
                    info.setData(i);
                    info.setFlag(1);
                } else {
                    //用户名密码或错误
                    info.setFlag(0);
                    info.setErrorMsg("用户名或密码错误");
                }
            }
        }
        //json格式返回数据
        resp.setContentType("application/x-json;charset=utf-8");
        resp.getWriter().write(gson.toJson(info));
       /* System.out.println(gson.toJson(info));
        System.out.println("re"+" "+ResultInfo.num);
        System.out.println("info"+" "+info.num);*/

    }
}
