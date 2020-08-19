package cn.web.filter;

import cn.dao.ResultInfo;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 完成登陆验证的过滤器
 */
@WebFilter("/*")

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        //ResultInfo inf=new ResultInfo();//记录转发消息
        //Gson gson=new Gson();//阿里巴巴的实体类转化为json数据工具
      //强制转换
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        //获取资源的请求路径
        String url=request.getRequestURI();
        //判断是否包含登陆相关的资源路径
        if(url.contains("/Login.html")||url.contains("/loginServlet")||url.contains("/Js/")||url.contains("/css/")||url.contains("/images/")
        ||url.contains("/checkCode")||url.contains("/Register")||url.contains("/operation/Register")
        ){
            //包含放行
           filterChain.doFilter(req,resp);
           //inf.setFlag(1);

        }else{
            //不包含，需要验证用户是否登陆
            Object user=request.getSession().getAttribute("user");
            if(user!=null){
                //登陆了
                filterChain.doFilter(req,resp);
              //  inf.setFlag(1);
            }else{
                //没登陆跳转
                //request.setAttribute("Login.html");
               // request.getRequestDispatcher("/Login.html").forward(request,resp);  //重定向 地址栏不变
               // inf.setFlag(0);
                //inf.setErrorMsg("您还没登陆,请登录!");
                //json话消息
               // response.setContentType("application/x-json;charset=utf-8");
                //response.getWriter().write(gson.toJson(inf));
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-type","text/html;charset=UTF-8");
               response.sendRedirect("Login.html?msg=您还没登录,请登录!");   //跳转 地址栏改变
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void destroy() {

    }
}
